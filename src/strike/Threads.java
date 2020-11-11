package strike;

public class Threads {
	 
public static class Erster_Thread extends Thread {
    public void run() {
        System.out.println("Hier ist Thread 1!");
        System.out.println("Zahlen von 1 - 50:");
        System.out.println("Es geht los:");
        for (int i = 1; i <= 50; i++) {
            System.out.println(i);
	}
    }
}
 
public static class Zweiter_Thread extends Thread {
    public void run() {
        System.out.println("Hier ist Thread 2!");
        System.out.println("Das ABC:");
        for (int i = 1; i <= 26; i++) {
            System.out.println("ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(i-1));
        }
    }
}
 
public static void main(String[] args) {
    Thread e = new Erster_Thread();
    Thread z = new Zweiter_Thread();
    e.start();
    z.start();
}
 
}
