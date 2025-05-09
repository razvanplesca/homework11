package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        FestivalGate gate = new FestivalGate();
        FestivalAttendeeThread attendeeThread = new FestivalAttendeeThread(TicketType.randomTicket(), gate);
        attendeeThread.start();
        FestivalStatisticsThread statisticsThread = new FestivalStatisticsThread(gate);
        statisticsThread.start();


    }
}