package services.impl;

import enteties.SupportTicket;
import enteties.impl.CustomSupportTicketsComparator;
import services.HelpDeskFacade;

import java.util.*;

public class DefaultHelpDeskFacade implements HelpDeskFacade {
    PriorityQueue <SupportTicket> supportTicketsQueue = new PriorityQueue<>(new CustomSupportTicketsComparator());

    @Override
    public void addNewSupportTicket(SupportTicket supportTicket) {
        supportTicketsQueue.add(supportTicket);
    }

    @Override
    public SupportTicket getNextSupportTicket() {
        return supportTicketsQueue.poll();
    }

    @Override
    public int getNumberOfTickets() {
        return supportTicketsQueue.size();
    }
}
