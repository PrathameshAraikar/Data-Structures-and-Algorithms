package DAA_Assignments;
 
import java.util.concurrent.Semaphore;

public class DiningPhilosopher {

    static int N = 5; // number of philosophers
    static int THINKING = 2;
    static int HUNGRY = 1;
    static int EATING = 0;
    static int LEFT(int i) { return (i + N - 1) % N; }
    static int RIGHT(int i) { return (i + 1) % N; }
    static int[] philosopher = new int[N];
    static Semaphore mutex = new Semaphore(1);
    static Semaphore[] forks = new Semaphore[N];

    static {
        for(int i = 0; i < N; i++) {
            forks[i] = new Semaphore(0);
        }
    }

    public static void canPhilosopherEat(int i) throws InterruptedException {
        if(philosopher[i] == HUNGRY && philosopher[LEFT(i)] != EATING && philosopher[RIGHT(i)] != EATING) {
            philosopher[i] = EATING;
            Thread.sleep(2000);
            System.out.println("Philosopher " + (i + 1) + " takes fork " + (LEFT(i) + 1) + " and " + (i + 1));
            System.out.println("Philosopher " + (i + 1) + " is Eating");
            forks[i].release();
        }
    }

    public static void takeFork(int i) throws InterruptedException{
        mutex.acquire();
        philosopher[i] = HUNGRY;
        System.out.println("Philosopher " + (i + 1) + " is hungry");
        canPhilosopherEat(i);
        mutex.release();
        forks[i].acquire();
        Thread.sleep(1000);
    }

    public static void putFork(int i) throws InterruptedException { 
        mutex.acquire();
        philosopher[i] = THINKING;                                                                                                                                                                          
        System.out.println("Philosopher " + (i + 1) + " putting fork " + (LEFT(i) + 1) + " and " + (i + 1) + " down");
        System.out.println("Philosopher " + (i + 1) + " is thinking");
        canPhilosopherEat(LEFT(i));
        canPhilosopherEat(RIGHT(i));
        mutex.release();
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[N];
        for (int i = 0; i < N; i++) {
            final int index = i;
            threads[i] = new Thread(() -> {
                while (true) {
                    try {
                        Thread.sleep(1000);
                        takeFork(index);
                        putFork(index);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            threads[i].start();
            System.out.println("Philosopher " + (i + 1) + " is thinking");
        }
        
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}