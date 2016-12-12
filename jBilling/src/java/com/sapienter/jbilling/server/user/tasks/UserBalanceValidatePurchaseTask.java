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

package com.sapienter.jbilling.server.user.tasks;

import com.sapienter.jbilling.server.item.db.ItemDTO;
import com.sapienter.jbilling.server.item.PricingField;
import com.sapienter.jbilling.server.pluggableTask.PluggableTask;
import com.sapienter.jbilling.server.pluggableTask.TaskException;
import com.sapienter.jbilling.server.user.ValidatePurchaseWS;
import com.sapienter.jbilling.server.user.db.CustomerDTO;
import com.sapienter.jbilling.server.util.Constants;

import java.math.BigDecimal;
import java.util.List;

/**
 * Pluggable task determines result for validatePurchase API method 
 * according to the user's dynamic balance.
 */
public class UserBalanceValidatePurchaseTask extends PluggableTask 
        implements IValidatePurchaseTask {

    public ValidatePurchaseWS validate(CustomerDTO customer, List<ItemDTO> items, List<BigDecimal> amounts, 
                                       ValidatePurchaseWS result, List<List<PricingField>> fields) throws TaskException {

        if (!result.getAuthorized()) {
            return result;
        }

        BigDecimal amount = BigDecimal.ZERO;
        for (BigDecimal a : amounts) {
            amount = amount.add(a);
        }

        // avoid divide by zero exception
        if (amount.compareTo(BigDecimal.ZERO) == 0) {
            result.setQuantity(new BigDecimal(Integer.MAX_VALUE));
            return result;
        }

        // get the parent customer that pays, if it exists
        while (customer.getParent() != null
                && (customer.getInvoiceChild() == null || customer.getInvoiceChild() == 0)) {
            // go up one level
            customer =  customer.getParent();
        }
        BigDecimal quantity = customer.getCreditLimit().add(customer.getDynamicBalance()).divide(amount,Constants.BIGDECIMAL_SCALE, Constants.BIGDECIMAL_ROUND);
        if (quantity.compareTo(BigDecimal.ZERO) <= 0)
        result.setAuthorized(false);

        result.setQuantity(quantity);
        return result;
    }
}
