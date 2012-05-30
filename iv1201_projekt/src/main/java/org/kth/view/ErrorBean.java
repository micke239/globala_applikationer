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
package org.kth.view;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.apache.log4j.Logger;

/**
 * This is the error bean, which retrieves the message of the exception that was
 *  thrown, and logs it.
 * 
 * @author Mikael Nilsson
 */
@Named(value = "errorbean")
@RequestScoped
public class ErrorBean {
    private static final Logger logger = Logger.getLogger(JobSeekerBean.class);
    
    /**
     * Returns the message of the exception that was last thrown.
     * @return The message of the latest exception.
     */
    public String getExceptionMessage() {
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestMap = context.getExternalContext().getRequestMap();
        Throwable ex = (Throwable) requestMap.get("javax.servlet.error.exception");
        
        StringWriter writer = new StringWriter();
        PrintWriter pw = new PrintWriter(writer);
        
        ex.printStackTrace(pw);
        
        logger.error(writer.toString());

        return ex.getMessage();
    }
}
