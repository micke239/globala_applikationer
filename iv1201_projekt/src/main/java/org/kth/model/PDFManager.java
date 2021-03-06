/**
 * Mikael Nilsson
 * Johan Schedin Jigland
 * Nikolai Padyukov
 * Arkitektur och design av globala applikationer, IV1201
 * 
 * 2011-03-02
 *
 * This software is provided 'as-is', without any express or implied
 * warranty.  In no event will the authors be held liable for any damages
 * arising from the use of this software.
 *
 * Permission is granted to anyone to use this software for any purpose,
 * including commercial applications, and to alter it and redistribute it
 * freely, subject to the following restrictions:
 *
 * 1. The origin of this software must not be misrepresented; you must not
 *    claim that you wrote the original software. If you use this software
 *    in a product, an acknowledgment in the product documentation would be
 *    appreciated but is not required.
 * 2. Altered source versions must be plainly marked as such, and must not be
 *    misrepresented as being the original software.
 * 3. This notice may not be removed or altered from any source distribution.
 */

package org.kth.model;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.util.Date;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.kth.DTO.EntityCompetenceDTO;
import org.kth.DTO.EntityTimePeriodDTO;
import org.kth.DTO.FullJobapplicationDTO;

/**
 * Used to create a pdf version of the job application report
 * 
 * this class contains no ties to the spring / jsf framework
 * Uses iText for pdf creation
 * 
 * @author Johan Schedin Jigland
 */
public class PDFManager
{
	private Font catFont = new Font(Font.FontFamily.HELVETICA, 22,
			Font.BOLD, BaseColor.BLACK);
	private Font subFont = new Font(Font.FontFamily.HELVETICA, 16,
			Font.BOLD);
	private Font smallBold = new Font(Font.FontFamily.HELVETICA, 12,
			Font.BOLD);
         
        private FullJobapplicationDTO data;
        
        private static final Logger logger = Logger.getLogger(PDFManager.class);
        
        /**
         * One and only constructor, will use the data provided when creating the pdf
         * @param data 
         */
        public PDFManager(FullJobapplicationDTO data)
        {
            this.data = data;
        }
        
        /**
         * Creatse the pdf from tyhe data provided in the constructor and
         * return it as an array of bytes
         * 
         * @return a byte array consisting of the pdf document data
         * (To be written to file/sent over the net by an outputStream)
         */
	public byte[] createPdf()
        {
            ByteArrayOutputStream outputStream = null;
            try {
		Document document = new Document();
                outputStream = new ByteArrayOutputStream();
			PdfWriter.getInstance(document, outputStream);
			document.open();
			addMetaData(document);
			addTitlePage(document);
			addContent(document);
			document.close();
		} catch (Exception e) {
			logger.log(Level.FATAL, e.toString() +" "+ e.getMessage());
		}
            return outputStream.toByteArray();
	}

	private void addMetaData(Document document) {
		document.addTitle("Application: " + data.getFirstName() + data.getLastName());
		document.addSubject("Using iText");
		document.addKeywords("Application, PDF, Job");
		document.addAuthor("System");
		document.addCreator("Pear Softworks");
	}

        /**
         * Creates the first title page
         * @param document
         * @throws DocumentException 
         */
	private void addTitlePage(Document document)
			throws DocumentException {
		Paragraph preface = new Paragraph();
		addEmptyLine(preface, 2);
		preface.add(new Paragraph("Application: " + data.getFirstName() + data.getLastName(), catFont));
		addEmptyLine(preface, 5);
		preface.add(new Paragraph(
				"Report generated by: " + System.getProperty("user.name") + ", " + new Date(), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				smallBold));

		document.add(preface);
		document.newPage();
	}

        /**
         * Add content to the titlepage
         * @param document
         * @throws DocumentException 
         */
	private  void addContent(Document document) throws DocumentException {
		Anchor anchor = new Anchor("Application", catFont);
		anchor.setName("Contact details");

		Chapter catPart = new Chapter(new Paragraph(anchor), 1);

		Paragraph subPara = new Paragraph("Contact Details", subFont);
		Section subCatPart = catPart.addSection(subPara);
		subCatPart.add(new Paragraph("First Name: " + this.data.getFirstName()));
                subCatPart.add(new Paragraph("Last Name: " + this.data.getLastName()));
                subCatPart.add(new Paragraph("Email: " + this.data.getEmail()));
                
                addEmptyLine(subPara, 1);
                

		subPara = new Paragraph("Time and availability", subFont);
		subCatPart = catPart.addSection(subPara);
                
                addEmptyLine(subPara,1);
                
		Paragraph paraDate = new Paragraph("Date of Registration: " + this.data.getDateOfRegistration());
                subCatPart.add(paraDate);
                
                addEmptyLine(paraDate,2);
                
		createTimePeriodsTable(subCatPart);
                
                subPara = new Paragraph("Competences", subFont);
		subCatPart = catPart.addSection(subPara);
                
                addEmptyLine(subPara, 2);

                createCompetenceTable(subCatPart);
                
		document.add(catPart);
	}

        /**
         * Creates a table for displaying the time periods
         * @param subCatPart
         * @throws BadElementException 
         */
	private void createTimePeriodsTable(Section subCatPart)throws BadElementException {
		PdfPTable table = new PdfPTable(3);

                PdfPCell c0 = new PdfPCell(new Phrase("#"));
		c0.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c0);

		PdfPCell c1 = new PdfPCell(new Phrase("Start Date"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("End Date"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		table.setHeaderRows(1);
                
                java.util.List<EntityTimePeriodDTO> timePeriods = this.data.getTimePeriods();
                int i = 1;
                for (EntityTimePeriodDTO t : timePeriods)
                {
                    table.addCell(Integer.toString(i));
                    i++;
                    table.addCell(t.getStartDateString());
                    table.addCell(t.getEndDateString());
                }
		subCatPart.add(table);
	}
        
        /**
         * Creates a table displaying the competences
         * @param subCatPart
         * @throws BadElementException 
         */
        private void createCompetenceTable(Section subCatPart)
                throws BadElementException {
        PdfPTable table = new PdfPTable(4);
        
        PdfPCell c0 = new PdfPCell(new Phrase("#"));
        c0.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c0);

        PdfPCell c1 = new PdfPCell(new Phrase("Category"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("# Months"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Comment"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        table.setHeaderRows(1);

        java.util.List<EntityCompetenceDTO> timePeriods = this.data.getLocaleCompetenceList();
        int i = 1;
        for (EntityCompetenceDTO t : timePeriods)
        {
            table.addCell(Integer.toString(i));
            i++;
            table.addCell(t.getCategoryName());
            table.addCell(t.getNumberOfMonths().toString());
            table.addCell(t.getComment());
        }
        subCatPart.add(table);
}

        /**
         * Adds a number of empty liens to a paragraph
         * @param paragraph The paragraph to add lines to
         * @param number The number of lines to add.
         */
	private void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
        }
}

