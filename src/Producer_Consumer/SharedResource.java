package Producer_Consumer;

public class SharedResource {
    private int value;

    public SharedResource() {
        value=0;
    }

    public synchronized int getValue(boolean smaller_than_6) {
        while(value>=6 &&smaller_than_6||value<6&&!smaller_than_6||value==0){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        int temp=value;
        value=0;
        notifyAll();
        return temp;
    }

    public synchronized void setValue() {
        if (value>0){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        value = (int) (1 + (Math.random() * 10));
        notifyAll();
    }

}
