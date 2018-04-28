package com.sda.hotel;

import java.util.ArrayList;
import java.util.List;

public class Room {
    public enum RoomType {
        SINGLE,
        DOUBLE
    }

    private int roomNumber;
    private List<Reservation> reservation;
    private RoomType roomType;

    public Room(int roomNumber, RoomType roomType) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.reservation = new ArrayList<>();
    }
}