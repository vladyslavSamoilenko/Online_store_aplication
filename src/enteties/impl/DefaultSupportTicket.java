package enteties.impl;

import RequestsAndPriority.Priority;
import RequestsAndPriority.RequestType;
import enteties.SupportTicket;

public class DefaultSupportTicket implements SupportTicket {

    private Priority priority;
    private static int sequentialNumber = 1;
    private RequestType requestType;

    public DefaultSupportTicket() {
        sequentialNumber++;
        priority = Priority.LOW;
    }

    public DefaultSupportTicket(RequestType requestType) {

        this.requestType = requestType;

        if(requestType.equals(RequestType.ORDER_IS_NOT_RECEIVED) || requestType.equals(RequestType.ACCOUNT_IS_HACKED) ||requestType.equals(RequestType.CAN_NOT_COMPLETE_PURCHASE)){
            priority = Priority.HIGH;
        }else if (requestType.equals(RequestType.COOPERATION) ||requestType.equals(RequestType.ACCOUNT_IS_BLOCKED) ||requestType.equals(RequestType.CAN_NOT_LOGIN)){
            priority = Priority.MEDIUM;
        }else if(requestType.equals(RequestType.OTHER) ||requestType.equals(RequestType.CHANGE_ACCOUNT_DETAIL)){
            priority = Priority.LOW;
        }

        sequentialNumber++;
    }

    @Override
    public Priority getPriority() {
        return priority;
    }

    @Override
    public int getSequentialNumber() {
        return sequentialNumber;
    }

    @Override
    public RequestType getRequestType() {
        return requestType;
    }
}
