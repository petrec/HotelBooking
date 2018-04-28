package com.sda.hotel;
import java.util.Calendar;

public class Reservation {

    private Calendar checkIn, checkOut;
    private Client client;

    public Reservation(Calendar checkIn, Calendar checkOut, Client client){
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.client = client;
    }

    public Calendar getCheckIn() {
        return checkIn;
    }

    public Calendar getCheckOut() {
        return checkOut;
    }

    public Client getClient() {
        return client;
    }
}