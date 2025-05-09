package org.example;

import java.util.LinkedList;
import java.util.Queue;

class FestivalGate {
    private final Queue<TicketType> ticketQueue = new LinkedList<>();

    public Queue<TicketType> getValidTickets() {
        return ticketQueue;
    }
}
