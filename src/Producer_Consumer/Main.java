package Producer_Consumer;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SharedResource resource =new SharedResource();
        Consumer consumer=new Consumer(resource, true, "LOWER");
        Consumer consumer1=new Consumer(resource, false, "HIGHER");
        Producer producer=new Producer(resource);
        consumer.start();
        consumer1.start();
        producer.start();
        consumer.join();
        consumer1.join();
        producer.join();
    }
}
