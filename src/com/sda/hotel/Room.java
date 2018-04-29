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

    public int getRoomNumber() {
        return roomNumber;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public boolean addReservation(Reservation rez){
        if(!checkAvailability(rez)){
            return false;
        }
        else{
            this.reservation.add(rez);
            return true;
        }
    }
    
    public boolean checkAvailability(Reservation rez){
        for(Reservation r : this.reservation){
            if(rez.getCheckIn().equals(r.getCheckIn()) && rez.getCheckOut().equals(r.getCheckOut())) {
                return false;
            }
            else if(rez.getCheckIn().equals(r.getCheckOut()) && rez.getCheckOut().equals(r.getCheckIn())){
                return false;
            }
            else if(rez.getCheckIn().after(r.getCheckIn()) && rez.getCheckIn().before(r.getCheckOut())){
                return false;
            }
            else if(rez.getCheckOut().after(r.getCheckIn()) && rez.getCheckOut().before(r.getCheckOut())){
                return false;
            }
            else if(rez.getCheckIn().before(r.getCheckIn()) && rez.getCheckOut().after(r.getCheckOut())){
                return false;
            }
        }
        return true;
    }

    public void cancelReservation(Reservation reservation){
        if(!checkAvailability(reservation)){
            this.reservation.remove(reservation);
        }
    }
}