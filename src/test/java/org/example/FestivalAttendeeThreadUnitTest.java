package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FestivalAttendeeThreadUnitTest {

    @Test
    void run() throws InterruptedException {
        final TicketType ticketType = TicketType.randomTicket();
        final FestivalGate gate = new FestivalGate();
        final FestivalAttendeeThread attendeeThread = new FestivalAttendeeThread(ticketType, gate);

        attendeeThread.start();
        Thread.sleep(2000);
        attendeeThread.interrupt();


        assertFalse(gate.getValidTickets().isEmpty());
        assertEquals(ticketType, gate.getValidTickets().poll());
    }

    @Test
    void getTicketType() {

        assertEquals(TicketType.FULL, new FestivalAttendeeThread(TicketType.FULL, new FestivalGate()).getTicketType());

    }

    @Test
    void getGate() {

        assertNotNull(new FestivalAttendeeThread(TicketType.randomTicket(), new FestivalGate()).getGate());
    }
}