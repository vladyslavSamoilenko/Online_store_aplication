package enteties.impl;

import enteties.SupportTicket;

import java.util.Comparator;

public class CustomSupportTicketsComparator implements Comparator<SupportTicket> {
    @Override
    public int compare(SupportTicket o1, SupportTicket o2) {
        if (o2.getPriority().compareTo(o1.getPriority()) == 0){
            return o2.getSequentialNumber() - o1.getSequentialNumber();
        }
        return o2.getPriority().compareTo(o1.getPriority());
    }
}
