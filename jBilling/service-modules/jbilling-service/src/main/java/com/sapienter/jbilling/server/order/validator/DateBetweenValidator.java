/*
 * JBILLING CONFIDENTIAL
 * _____________________
 *
 * [2003] - [2012] Enterprise jBilling Software Ltd.
 * All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of Enterprise jBilling Software.
 * The intellectual and technical concepts contained
 * herein are proprietary to Enterprise jBilling Software
 * and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden.
 */

package com.sapienter.jbilling.server.order.validator;

import com.sapienter.jbilling.common.FormatLogger;
import org.apache.log4j.Logger;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;

/**
 * DateBetweenValidator
 *
 * @author Juan Vidal
 * @since 03/01/2012
 */
public class DateBetweenValidator implements ConstraintValidator<DateBetween, Date> {

    private static final FormatLogger LOG = new FormatLogger(Logger.getLogger(DateBetweenValidator.class));

    private String startDate;
    private String endDate;

    public void initialize(final DateBetween dateRange) {
        if(dateRange!=null){
            startDate = dateRange.start();
            endDate = dateRange.end();
        }
    }

    public boolean isValid(Date date, ConstraintValidatorContext constraintValidatorContext) {
        try {
            if(date==null||date.toString()=="")
            {
                return true;
            }
            DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("MM/dd/yyyy");
            Date startDate = dateTimeFormatter.parseDateTime(this.startDate).toDate();
            Date endDate = dateTimeFormatter.parseDateTime(this.endDate).toDate();

            return startDate.before(date) && endDate.after(date);

        } catch (NullPointerException e) {
            LOG.debug("Date is null.");
        } catch (ClassCastException e) {
            LOG.debug("Property does not contain a java.util.Date object.");
        } catch (IllegalArgumentException e) {
            LOG.debug("Error while parsing the date.");
        }

        return false;
    }
}
