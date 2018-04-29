package com.sda.hotel;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {

        Calendar dataIn = Utils.setCalendar(2019, 02, 20);
        Calendar dataOut = Utils.setCalendar(2019, 02,23);
        Client client1 = new Client("Vasile", "abc1");
        Reservation rez1 = new Reservation(dataIn, dataOut, client1);
        Room room1 = new Room(1, Room.RoomType.SINGLE);

        System.out.println(room1.addReservation(rez1));
        dataIn = Utils.setCalendar(2019, 02, 24);
        dataOut = Utils.setCalendar(2019, 02,26);
        rez1 = new Reservation(dataIn, dataOut, client1);
        System.out.println(room1.addReservation(rez1));

        room1.printReservationsBy(Utils.setCalendar(2019, 02, 27));
        Client client2 = new Client("Ion", "abc2");
        room1.printReservationsBy(client2);

    }
}
