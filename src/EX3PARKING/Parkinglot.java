package EX3PARKING;

import java.util.Vector;

public class Parkinglot   {
    public  Vector<Car> cars;
    private String name;
    private boolean open;

    public Parkinglot(String name, boolean open) {
        this.name = name;
        this.open=open;
        cars = new Vector<>(5);
    }

    public  boolean addCar(Car car) {
        //noinspection SynchronizeOnNonFinalField
        synchronized (cars) {
            if (open) {


                System.out.println("adding " + car.getTag());

                if (cars.size() == cars.capacity()) {
                    System.out.println("not added " + car.getTag());
                    return false;
                }
                System.out.println("added car");
                cars.add(car);
                car.setTime_in(System.currentTimeMillis());
                return true;
            }else {
                return false;
            }
        }
    }

    public void removeCar(Car car) {
        synchronized (cars) {
            if(open) {
                cars.remove(car);
                System.out.println("removed car " + car.getTag());
            }else{
                System.out.println("the parking lot is closed");
            }
        }
    }
    public synchronized void remove_all_cars(){
        for(Car car:cars){
            System.out.println(cars.remove(car));
        }
    }

    public boolean getState(){
        return open;
    }
    public void changeState(){
        this.open=!open;
    }
}
