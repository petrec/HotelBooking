package com.sda.hotel;

public class Room {
    private enum RoomType {
        SINGLE,
        DOUBLE;
    }

    private int roomNumber;
    private List<Reservation> reservation;
    private RoomType roomType;

    public Room(int roomNumber, RoomType roomType) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.reservation = new ArrayList<Reservation>();
    }
}