package com.codecool.singletonDojo;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Printer {
    private static int counter = 0;
    private static List<Printer> instances = new ArrayList<>();

    private int id;
    private LocalTime busyEndTime;

    private Printer(int id) {
        this.id = id;
    }

    static Printer getInstance() {
        if (counter < 10) {
            Printer instance = new Printer(counter++);
            instances.add(instance);
            return instance;
        } else {
            for (Printer instance : instances) {
                if (instance.isAvailable()) return instance;
            }
        }
        return instances.get(new Random().nextInt(instances.size()));
    }

    void print(String toPrint) {
        System.out.println("Printer " + id + " is printing: " + toPrint);
        busyEndTime = LocalTime.now().plusSeconds(5);
    }

    private boolean isAvailable() {
        return LocalTime.now().isAfter(busyEndTime);
    }
}
