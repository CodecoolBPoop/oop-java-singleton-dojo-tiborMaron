package com.codecool.singletonDojo;

import java.time.LocalTime;

public class Printer {

    private int id; // ID of the printer. Unique.
    private LocalTime busyEndTime;

    public Printer(int id) {
        this.id = id;
    }

    // Prints out the given String
    public void print(String toPrint) {
        // Its not needed to actually print with a printer in this exercise
        System.out.println("Printer " + id + " is printing.");
        busyEndTime = LocalTime.now().plusSeconds(5);
    }

    // Returns true if the printer is ready to print now.
    public boolean isAvailable() {
        return LocalTime.now().isAfter(busyEndTime);
    }
}
