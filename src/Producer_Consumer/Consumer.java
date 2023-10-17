package Producer_Consumer;

public class Consumer extends Thread {
    SharedResource resource;
    boolean higher_lower;

    public Consumer(SharedResource resource, boolean higher_lower, String name) {
        super(name);
        this.resource = resource;
        this.higher_lower = higher_lower;
    }

    public void run() {

        while (true) {
            System.out.println(getName() + "  value: " + resource.getValue(higher_lower));
        }
    }
}
