package org.example;

import lombok.Data;

@Data
class FestivalAttendeeThread extends Thread{
    private final TicketType ticketType;
    private final FestivalGate gate;

    public FestivalAttendeeThread(TicketType ticketType, FestivalGate gate) {
        this.ticketType = ticketType;
        this.gate = gate;
    }


    @Override
    public void run() {
        while (true) {
            gate.getValidTickets().add(ticketType);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
