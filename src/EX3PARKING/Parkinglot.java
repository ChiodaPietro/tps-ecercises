package EX3PARKING;

import java.util.Vector;

public class Parkinglot   {
    public static Vector<Car> cars;
    private String name;

    public Parkinglot(String name) {
        this.name = name;
        cars = new Vector<>(5);
    }

    public static boolean addCar(Car car) {
        //noinspection SynchronizeOnNonFinalField
        synchronized (cars) {
            System.out.println("adding");
            if (cars.size() == cars.capacity()) {
                System.out.println("not added " + car.getTag());
                return false;
            }
            System.out.println("added car");
            cars.add(car);
            car.setTime_in(System.currentTimeMillis());
            return true;
        }
    }

    public static void removeCar(Car car) {
        synchronized (cars) {
            cars.remove(car);
            System.out.println("removed car "+ car.getTag());
        }
    }
}
