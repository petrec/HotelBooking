package com.sda.hotel;
import java.util.Calendar;
import java.util.Objects;

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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(checkIn, that.checkIn) &&
                Objects.equals(checkOut, that.checkOut) &&
                Objects.equals(client, that.client);
    }

    @Override
    public int hashCode() {

        return Objects.hash(checkIn, checkOut, client);
    }
}