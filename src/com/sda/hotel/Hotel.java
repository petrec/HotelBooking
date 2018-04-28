package com.sda.hotel;

import java.util.ArrayList;

public class Hotel {
    private String hotelName;
    private ArrayList<Room> roomsList;
    private Integer hotelRoomCapacity;

    public Hotel(String hotelName, int hotelRoomCapacity) {
        this.hotelName = hotelName;
        this.roomsList = new ArrayList<>(hotelRoomCapacity);
        this.hotelRoomCapacity = hotelRoomCapacity;
    }

}
