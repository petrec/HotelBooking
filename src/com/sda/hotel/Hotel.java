package com.sda.hotel;

import java.util.HashMap;
import java.util.Map;

public class Hotel {
    private String hotelName;
    private Map<Integer, Room> roomsList;
    private Integer hotelRoomCapacity;

    public Hotel(String hotelName, int hotelRoomCapacity) {
        this.hotelName = hotelName;
        this.roomsList = new HashMap<>();
        this.hotelRoomCapacity = hotelRoomCapacity;
    }

    public boolean addRoom(Room room){
        int tempRoomNumber;
        for(int i=0; i<this.roomsList.size(); i++){
            tempRoomNumber=this.roomsList.get(i).getRoomNumber();
            if(tempRoomNumber==room.getRoomNumber() || tempRoomNumber>hotelRoomCapacity){
                return false;
            }
        }
        this.roomsList.put(room.getRoomNumber(), room);
        return true;
    }

    public Room getRoomByNumber(int number){
        return this.roomsList.get(number);
    }
}
