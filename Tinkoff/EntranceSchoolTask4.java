package Tinkoff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class EntranceSchoolTask4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int countProcesses = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> listOfDepends = new ArrayList<>();
        for (int i = 0; i < countProcesses; i++) {
            String line = br.readLine();
            String[] splitArr = line.split(" ");
            ArrayList<Integer> depends = new ArrayList<>();
            for (String s : splitArr) {
                depends.add(Integer.parseInt(s));
            }
            listOfDepends.add(depends);
        }
        br.close();
        int result = minCompletionTime(countProcesses, listOfDepends);
        System.out.println(result);
    }

    public static int minCompletionTime(int countProcesses, ArrayList<ArrayList<Integer>> listOfDepends) {
        // Граф представленный в виде списка смежности

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[countProcesses + 1];
        int[] time = new int[countProcesses + 1];

        // Инициализация графа и времени
        for (int i = 0; i <= countProcesses; i++) {
            graph.add(new ArrayList<>());
            time[i] = 0;
        }

        // Заполнение графа и инкрементация степеней входящих рёбер
        for (int i = 0; i < listOfDepends.size(); i++) {
            int process = i + 1;
            ArrayList<Integer> deps = listOfDepends.get(i);
            for (int dep : deps) {
                graph.get(dep).add(process);
                inDegree[process]++;
            }
        }

        // Очередь для топологической сортировки
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= countProcesses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                time[i] = 1;
            }
        }

        // Топологическая сортировка
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph.get(node)) {
                time[neighbor] = Math.max(time[neighbor], time[node] + 1);
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        return time[1];
    }
}


