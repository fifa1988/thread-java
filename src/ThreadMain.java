import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ThreadMain {

    public static void main(String[] args) throws InterruptedException{
    	List<String> lista =  new ArrayList<String>();
    	List<String> lista2 =  new ArrayList<String>();
    	List<String> lista3 =  new ArrayList<String>();
    	List<String> lista4 =  new ArrayList<String>();
	    ThreadSearch thread1 = new ThreadSearch(LocalDateTime.of(2022, 7, 25, 0, 0, 00), LocalDateTime.of(2022, 7, 25, 0, 5, 59, 999), lista);
	    ThreadSearch thread2 = new ThreadSearch(LocalDateTime.of(2022, 7, 25, 6, 0, 00), LocalDateTime.of(2022, 7, 25, 0, 11, 59, 999), lista2);
	    ThreadSearch thread3 = new ThreadSearch(LocalDateTime.of(2022, 7, 25, 12, 0, 00), LocalDateTime.of(2022, 7, 25, 0, 17, 59, 999), lista3);
	    ThreadSearch thread4 = new ThreadSearch(LocalDateTime.of(2022, 7, 25, 18, 0, 00), LocalDateTime.of(2022, 7, 25, 0, 23, 59, 999), lista4);
	    
	    thread1.start();
	    thread2.start();
	    thread3.start();
	    thread4.start();
	    
	    sync(thread1, "thread1");
	    sync(thread2, "thread2");
	    sync(thread3, "thread3");
	    sync(thread4, "thread4");
	
	    System.out.println(lista);
	    System.out.println(lista2);
	    System.out.println(lista3);
	    System.out.println(lista4);
	    
    }
    
    public void quebraData() {
    	
    }
    
    public static void sync(ThreadSearch thread, String threadAtual) throws InterruptedException {
    	synchronized (thread) {
	        while (!thread.finished) {
	            System.out.println("Waiting for "+ threadAtual +" to complete...");
	            thread.wait();
	        }
	        System.out.println(threadAtual+ " has completed. ");
	    }
    }
}
