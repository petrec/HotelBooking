package com.sda.hotel;

public class Hotel {
    private String hotelName;
    private ArrayList<Room> roomsList;
    private Integer hotelRoomCapacity;

    public Hotel(String hotelName, int hotelRoomCapacity) {
        this.hotelName = hotelName;
        this.roomsList = new ArrayList<Room>(hotelRoomCapacity);
        this.hotelRoomCapacity = hotelRoomCapacity;
    }

}
