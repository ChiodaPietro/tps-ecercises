package EX3PARKING;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Parkinglot parkinglot = new Parkinglot("assurdo");
        Main main = new Main();
        main.CarsWaitingOutside();

        Car c1 = new Car();
        c1.start();
        Car c2 = new Car();
        c2.start();
        Car c3 = new Car();
        c3.start();
        Car c4 = new Car();
        c4.start();
        Car c5 = new Car();
        c5.start();
        Car c6 = new Car();
        c6.start();
        Car c7 = new Car();
        c7.start();
        Car c8 = new Car();
        c8.start();
        Car c9 = new Car();
        c9.start();
        Car c10 = new Car();
        c10.start();
        c1.join();
        c2.join();
        c3.join();
        c4.join();
        c5.join();
        c6.join();
        c7.join();
        c8.join();
        c9.join();
        c10.join();

    }

    public void CarsWaitingOutside() {
        while (Parkinglot.cars.size() != 0) {
            try {
                Thread.sleep(20000);
                notifyAll();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
