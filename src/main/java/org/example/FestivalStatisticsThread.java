package org.example;

import lombok.Data;

import java.util.Random;

@Data
class FestivalStatisticsThread extends Thread {

    private FestivalGate gate;

    private int fullTickets;
    private int fullVipTickets;
    private int freePassTickets;
    private int oneDayTickets;
    private int oneDayVipTickets;

    FestivalStatisticsThread(FestivalGate gate) {

        this.gate = gate;
        fullTickets = new Random().nextInt(100);
        fullVipTickets = new Random().nextInt(100);
        freePassTickets = new Random().nextInt(100);
        oneDayTickets = new Random().nextInt(100);
        oneDayVipTickets = new Random().nextInt(100);
    }


    @Override
    public void run() {
        while (true) {
            calculateTickets();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    int getTotalTickets() {
        return fullTickets + fullVipTickets + freePassTickets + oneDayTickets + oneDayVipTickets;
    }

    private void calculateTickets() {
        System.out.println("Total tickets: " + getTotalTickets());
        System.out.println("Full tickets: " + fullTickets);
        fullTickets += new Random().nextInt(100);
        System.out.println("Full VIP tickets: " + fullVipTickets);
        fullVipTickets += new Random().nextInt(100);
        System.out.println("Free pass tickets: " + freePassTickets);
        freePassTickets += new Random().nextInt(100);
        System.out.println("One day tickets: " + oneDayTickets);
        oneDayTickets += new Random().nextInt(100);
        System.out.println("One day VIP tickets: " + oneDayVipTickets);
        oneDayVipTickets += new Random().nextInt(100);
        System.out.println("---------------------------------------");
    }


}
