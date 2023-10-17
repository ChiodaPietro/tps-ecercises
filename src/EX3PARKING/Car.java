package EX3PARKING;

import java.util.UUID;

public class Car extends Thread {
    private String tag;
    private long time_in;
    private Parkinglot parkinglot;

    public Car(Parkinglot parkinglot) {
        tag = UUID.randomUUID().toString();
        this.parkinglot=parkinglot;
    }

    public String getTag() {
        return tag;
    }

    public void run() {
        boolean exit = false;
        while (!exit) {
            if (parkinglot.addCar(this)) {
                exit = true;
            } else {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        parkinglot.removeCar(this);

    }

    public void setTime_in(long timeIn) {
        this.time_in = time_in;
    }

    public long getTime_in() {
        return time_in;
    }
}
