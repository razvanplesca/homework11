package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

class FestivalStatisticsThreadUnitTest {
    @Test
    void shouldCalculateTickets() throws InterruptedException {
        FestivalGate gate = new FestivalGate();
        FestivalStatisticsThread statisticsThread = new FestivalStatisticsThread(gate);

        statisticsThread.start();
        Thread.sleep(6000);

        statisticsThread.interrupt();
        statisticsThread.join(1000);


        assertTrue(statisticsThread.getFullTickets() >= 0);
        assertTrue(statisticsThread.getFullVipTickets() >= 0);
        assertTrue(statisticsThread.getFreePassTickets() >= 0);
        assertTrue(statisticsThread.getOneDayTickets() >= 0);
        assertTrue(statisticsThread.getOneDayVipTickets() >= 0);
    }

    @Test
    void getTotalTickets_shouldReturnCorrectSum() {
        FestivalGate gate = new FestivalGate();
        FestivalStatisticsThread thread = new FestivalStatisticsThread(gate);

        int expectedTotal = thread.getFullTickets() +
                thread.getFullVipTickets() +
                thread.getFreePassTickets() +
                thread.getOneDayTickets() +
                thread.getOneDayVipTickets();

        assertEquals(expectedTotal, thread.getTotalTickets());
    }

    @Test
    void getGate() {
        FestivalGate gate = new FestivalGate();
        FestivalStatisticsThread thread = new FestivalStatisticsThread(gate);
        assertEquals(gate, thread.getGate());
    }
}