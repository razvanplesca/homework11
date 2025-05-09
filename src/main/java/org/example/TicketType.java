package org.example;

import java.util.Random;

public enum TicketType {
    FULL,
    FULLVIP,
    FREEPASS,
    ONEDAY,
    ONEDAYVIP;

    private static final Random RANDOM = new Random();


    public static TicketType randomTicket() {
        return values()[getRandomIndex()];
    }

    private static int getRandomIndex() {
        return RANDOM.nextInt(values().length);
    }

}
