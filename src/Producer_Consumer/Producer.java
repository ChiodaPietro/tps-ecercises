package Producer_Consumer;

public class Producer  extends  Thread{
    private SharedResource resource;
    public Producer(SharedResource resource){
        this.resource=resource;
    }
    public void run(){
        while(true) {
            resource.setValue();
        }
    }
}
