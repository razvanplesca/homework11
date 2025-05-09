package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FestivalGateUnitTest {

    private final FestivalGate festivalGate = new FestivalGate();

    @Test
    void getValidTickets() {

        festivalGate.getValidTickets().add(TicketType.ONEDAYVIP);
        festivalGate.getValidTickets().add(TicketType.ONEDAY);
        assertEquals(2, festivalGate.getValidTickets().size(), "The ticket queue should contain exactly 2 tickets.");
        assertTrue(festivalGate.getValidTickets().contains(TicketType.ONEDAYVIP));
        assertTrue(festivalGate.getValidTickets().contains(TicketType.ONEDAY));
    }

    @Test
    void getValidTickets_NullQueue() {

        assertNotNull(festivalGate.getValidTickets(), "The ticket queue should not be null.");
        assertTrue(festivalGate.getValidTickets().isEmpty(), "The ticket queue should initially be empty.");
    }

    @Test
    void getValidTickets_Concurrency() {

        Thread thread1 = new Thread(() -> festivalGate.getValidTickets().add(TicketType.FREEPASS));
        Thread thread2 = new Thread(() -> festivalGate.getValidTickets().add(TicketType.FULL));

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        assertTrue(festivalGate.getValidTickets().size() == 2, "The ticket queue should contain 2 tickets in a concurrent execution.");
    }
}