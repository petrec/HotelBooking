package com.sda.hotel;

import java.util.ArrayList;
import java.util.Calendar;
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

    public void printReservationsBy(Client client) {
        boolean existingClient = false;
        System.out.println("Reservations by client (" + client.getName() +"): ");
        System.out.println("RoomNo" + "\tClient" + "\tCheck-in" + "\tCheck-out");
        for (Reservation r : this.reservation) {
            if (r.getClient().getName().equalsIgnoreCase(client.getName())) {
                System.out.println(this.roomNumber + "\t\t" + r.getClient().toString() + "\t" +
                        r.getCheckIn().get(Calendar.DAY_OF_MONTH) + "." + r.getCheckIn().get(Calendar.MONTH) + "." + r.getCheckIn().get(Calendar.YEAR) +
                        "\t" + r.getCheckOut().get(Calendar.DAY_OF_MONTH) + "." + r.getCheckOut().get(Calendar.MONTH) + "." + r.getCheckOut().get(Calendar.YEAR));
                existingClient = true;
            }
        }
        if (!existingClient) {
            System.out.println("Client not found!");
        }
    }

    public void printReservationsBy(Calendar date) {
        boolean isAvailable = true;
        System.out.println("Reservations for room #" + this.getRoomNumber() + " by " + date.get(Calendar.DAY_OF_MONTH) +"."
                + date.get(Calendar.MONTH) + "." + date.get(Calendar.YEAR) +": ");
        System.out.println("RoomNo" + "\tClient" + "\tCheck-in" + "\tCheck-out");
        for (Reservation r : this.reservation) {
            if (r.getCheckIn().equals(date) || r.getCheckOut().equals(date)) {
                isAvailable = false;
                System.out.println(this.roomNumber + "\t\t" + r.getClient().toString() + "\t" +
                        r.getCheckIn().get(Calendar.DAY_OF_MONTH) + "." + r.getCheckIn().get(Calendar.MONTH) + "." + r.getCheckIn().get(Calendar.YEAR) +
                        "\t" + r.getCheckOut().get(Calendar.DAY_OF_MONTH) + "." + r.getCheckOut().get(Calendar.MONTH) + "." + r.getCheckOut().get(Calendar.YEAR));
            } else if (r.getCheckIn().equals(date) && r.getCheckOut().equals(date)) {
                isAvailable = false;
                System.out.println(this.roomNumber + "\t\t" + r.getClient().toString() + "\t" +
                        r.getCheckIn().get(Calendar.DAY_OF_MONTH) + "." + r.getCheckIn().get(Calendar.MONTH) + "." + r.getCheckIn().get(Calendar.YEAR) +
                        "\t" + r.getCheckOut().get(Calendar.DAY_OF_MONTH) + "." + r.getCheckOut().get(Calendar.MONTH) + "." + r.getCheckOut().get(Calendar.YEAR));
            } else if (r.getCheckIn().after(date) && r.getCheckIn().before(date)) {
                isAvailable = false;
                System.out.println(this.roomNumber + "\t\t" + r.getClient().toString() + "\t" +
                        r.getCheckIn().get(Calendar.DAY_OF_MONTH) + "." + r.getCheckIn().get(Calendar.MONTH) + "." + r.getCheckIn().get(Calendar.YEAR) +
                        "\t" + r.getCheckOut().get(Calendar.DAY_OF_MONTH) + "." + r.getCheckOut().get(Calendar.MONTH) + "." + r.getCheckOut().get(Calendar.YEAR));
            } else if (r.getCheckOut().after(date) && r.getCheckOut().before(date)) {
                isAvailable = false;
                System.out.println(this.roomNumber + "\t\t" + r.getClient().toString() + "\t" +
                        r.getCheckIn().get(Calendar.DAY_OF_MONTH) + "." + r.getCheckIn().get(Calendar.MONTH) + "." + r.getCheckIn().get(Calendar.YEAR) +
                        "\t" + r.getCheckOut().get(Calendar.DAY_OF_MONTH) + "." + r.getCheckOut().get(Calendar.MONTH) + "." + r.getCheckOut().get(Calendar.YEAR));

            } else if (r.getCheckIn().before(date) && r.getCheckOut().after(date)) {
                isAvailable = false;
                System.out.println(this.roomNumber + "\t\t" + r.getClient().toString() + "\t" +
                        r.getCheckIn().get(Calendar.DAY_OF_MONTH) + "." + r.getCheckIn().get(Calendar.MONTH) + "." + r.getCheckIn().get(Calendar.YEAR) +
                        "\t" + r.getCheckOut().get(Calendar.DAY_OF_MONTH) + "." + r.getCheckOut().get(Calendar.MONTH) + "." + r.getCheckOut().get(Calendar.YEAR));
            }
        }
        if (isAvailable)
            System.out.println(this.roomNumber + "\t is available");
    }

    public void changeReservation(Reservation reservationOld, Reservation reservationNew) {
        this.reservation.remove(reservationOld);
        if (checkAvailability(reservationNew)) {
            this.reservation.add(reservationNew);
        } else this.reservation.add(reservationOld);
    }
    public void cancelReservation(Reservation reservation){
        if(!checkAvailability(reservation)){
            this.reservation.remove(reservation);
        }
    }
}