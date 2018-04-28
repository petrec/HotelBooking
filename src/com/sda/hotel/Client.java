package com.sda.hotel;

public class Client {

    private String name;
    private String cod;

    public Client(String name, String cod) {
        this.name = name;
        this.cod = cod;
    }

    public String getName() {
        return name;
    }

    public String getCod() {
        return cod;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
