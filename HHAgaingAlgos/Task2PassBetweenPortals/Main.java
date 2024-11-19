// Задачка на поиск ближайшего пути по островам и материкам

package HHAgaing.Task2PassBetweenPortals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] testIslands = new int[]{1, 2, 2, 8, 7, 2, 5, 7};
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        reader.close();
        int[] islands = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            islands[i] = Integer.parseInt(input[i]);
        }
        System.out.println(solution(islands));
    }

    public static int solution(int[] islands){
        HashMap<Integer, ArrayList<Integer>> continentsIslandsMap = new HashMap<>();
        for (int i = 0; i < islands.length; i++) {
            if (continentsIslandsMap.containsKey(islands[i])) {
                continentsIslandsMap.get(islands[i]).add(i);
            }
            else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                continentsIslandsMap.put(islands[i], list);
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[] visitedIslands = new boolean[islands.length];
        queue.add(new int[]{0, 0});
        visitedIslands[0] = true;

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int currentIsland = current[0];
            int currentSteps = current[1];

            if (current[0] == islands.length - 1) return currentSteps;

            int[] leftAndRightIslands = new int[]{currentIsland -1, currentIsland + 1};
            for (int island : leftAndRightIslands) {
                if (island >= 0 && island <= islands.length - 1 && !visitedIslands[island]) {
                    visitedIslands[island] = true;
                    queue.add(new int[]{island, currentSteps + 1});
                }
            }

            ArrayList<Integer> islandsOnOneContinent = continentsIslandsMap.get(islands[currentIsland]);
            if (islandsOnOneContinent != null) {
                for (Integer island : islandsOnOneContinent) {
                    if (!visitedIslands[island]) {
                        visitedIslands[island] = true;
                        queue.add(new int[]{island, currentSteps + 1});
                    }
                }
                islandsOnOneContinent.clear();
            }
        }
        return 0;
    }
}
