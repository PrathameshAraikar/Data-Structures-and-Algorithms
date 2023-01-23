package Queue_Deque;

import java.util.*;

public class CircularTour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] petrol = new int[n];
        int[] distance = new int[n];

        for (int i = 0; i < n; i++)
            petrol[i] = sc.nextInt();

        for (int i = 0; i < n; i++)
            distance[i] = sc.nextInt();

        int currentPetrol = 0, prevPetrol = 0, start = 0;
        for (int i = 0; i < n; i++) {
            currentPetrol += (petrol[i] - distance[i]);
            if (currentPetrol < 0) {
                prevPetrol += currentPetrol;
                start = i + 1;
                currentPetrol = 0;
            }
        }

        if (currentPetrol + prevPetrol >= 0)
            System.out.println("Start at: " + (start + 1));
        else
            System.out.println("-1");

        sc.close();
    }
}