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

package org.kth.validation;

import java.lang.annotation.*;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * This annotation is for validation of a list of dateavailabilities. It checks 
 *  so that the dates given are valid. <br />
 * The from-date may not be larger than the to-date, and the dates must be real 
 *  dates, e.g. February 30th will not be valid.<br />
 * For validation implementation, see <class>DateAvailabilitiesValidator</class>.
 * 
 * @author Mikael Nilsson
 */

@Constraint(validatedBy = DateAvailabilitiesValidator.class)
@Documented
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DateAvailabilities {
    String message() default "{invalid_dates}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
