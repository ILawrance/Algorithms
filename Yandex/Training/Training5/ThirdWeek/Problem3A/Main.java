package YandexTren.Training5.ThirdWeek.Problem3A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        int countPeople = Integer.parseInt(scan.readLine());

        if (countPeople == 1) {
            scan.readLine();
            String[] namesSongs = scan.readLine().split(" ");
            Arrays.sort(namesSongs);
            System.out.println(namesSongs.length);
            System.out.println(String.join(" ", namesSongs));
            return;
        }

        Set<String> sharedSongs = new HashSet<>();
        Set<String> personSongs;
        for (int i = 0; i < countPeople; i ++) {
            scan.readLine();
            String[] likePersonSongs = scan.readLine().split(" ");
            personSongs = new HashSet<>(Arrays.asList(likePersonSongs));
            if (i == 0) {
                sharedSongs.addAll(personSongs);
            }
            else {
                sharedSongs.retainAll(personSongs);
            }
        }

        String[] forSortSharedSongs = sharedSongs.toArray(new String[0]);
        Arrays.sort(forSortSharedSongs);
        System.out.println(sharedSongs.size());
        System.out.println(String.join(" ", forSortSharedSongs));
    }
}