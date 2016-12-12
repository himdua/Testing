package com.sapienter.jbilling.server.order.mocks;

import com.sapienter.jbilling.common.SessionInternalError;
import com.sapienter.jbilling.server.mediation.JbillingMediationRecord;
import com.sapienter.jbilling.server.order.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by andres on 16/10/15.
 */
public class OrderMockService implements OrderService {
    @Override
    public OrderWS getCurrentOrder(Integer userId, Date date) throws SessionInternalError {
        OrderWS currentOrderMock = null;
        if(userId.equals(new Integer(1))) {
            currentOrderMock = new OrderWS();
            currentOrderMock.setId(new Integer(1));
        }
        return currentOrderMock;
    }

    @Override
    public List<OrderWS> lastOrders(Integer userId, int numberOfOrdersToRetrieve) {
        return null;
    }

    @Override
    public List<OrderChangeStatusWS> getOrderChangeStatusesForCompany() {
        OrderChangeStatusWS orderChangeStatusWS = new OrderChangeStatusWS();
        orderChangeStatusWS.setApplyToOrder(ApplyToOrder.YES);
        orderChangeStatusWS.setId(1);
        List<OrderChangeStatusWS> orderChangeStatusWSList = new ArrayList<>();
        orderChangeStatusWSList.add(orderChangeStatusWS);
        return orderChangeStatusWSList;
    }

    @Override
    public List<OrderChangeTypeWS> getOrderChangeTypesForCompany() {
        OrderChangeTypeWS orderChangeTypeWS = new OrderChangeTypeWS();
        orderChangeTypeWS.setDefaultType(true);
        orderChangeTypeWS.setId(1);
        List<OrderChangeTypeWS> OrderChangeTypeWSList = new ArrayList<>();
        OrderChangeTypeWSList.add(orderChangeTypeWS);
        return OrderChangeTypeWSList;
    }

    @Override
    public MediationEventResult addMediationEvent(JbillingMediationRecord jmr) {
        return new MediationEventResult();
    }

    @Override
    public void undoMediation(UUID processId) {
        //TODO Empty implementation
    }

}
