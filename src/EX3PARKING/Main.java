package EX3PARKING;

public class Main extends Thread{
    public Parkinglot parkinglot;
    public Main(String name){
        super(name);
    }
    public static void main(String[] args) throws InterruptedException {
        Parkinglot parkinglot = new Parkinglot("assurdo", true);
        Main main = new Main("Thread main made by me");
        main.parkinglot=parkinglot;
        main.start();


        while (parkinglot.getState()) {
            new Car(parkinglot).start();
            Thread.sleep((int) (500 + Math.random() * 1000));
        }

        parkinglot.remove_all_cars();
    }



    public void run(){
        try {
            Thread.sleep(5000);
            parkinglot.changeState();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
