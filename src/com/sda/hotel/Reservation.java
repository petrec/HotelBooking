package com.sda.hotel;
import java.util.Date;

public class Reservation {

    private Date checkIn, checkOut;
    private Client client;

    public Reservation(Date checkIn, Date checkOut, Client client){
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.client = client;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public Client getClient() {
        return client;
    }
}