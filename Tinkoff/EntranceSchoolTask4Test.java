package Tinkoff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class EntranceSchoolTask4Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int countProcesses = Integer.parseInt(br.readLine().trim());

        // Инициализация списка зависимостей
        ArrayList<ArrayList<Integer>> listOfDepends = new ArrayList<>();
        for (int i = 0; i < countProcesses; i++) {
            String line = br.readLine().trim();
            ArrayList<Integer> depends = new ArrayList<>();
            if (!line.isEmpty()) {
                String[] splitArr = line.split(" ");
                for (String s : splitArr) {
                    depends.add(Integer.parseInt(s));
                }
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
            time[i] = 0; // Инициализация времени
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
        // Начальные процессы без зависимостей (их можно начать сразу)
        for (int i = 1; i <= countProcesses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                time[i] = 1; // Время завершения процесса без зависимостей
            }
        }

        // Топологическая сортировка и обновление времени
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph.get(node)) {
                // Обновляем время завершения соседа
                time[neighbor] = Math.max(time[neighbor], time[node] + 1);
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // Печать графа и степеней входящих рёбер для отладки
        System.out.println("Graph:");
        for (int i = 1; i <= countProcesses; i++) {
            System.out.println("Process " + i + " depends on: " + graph.get(i));
        }
        System.out.println("In-degrees:");
        for (int i = 1; i <= countProcesses; i++) {
            System.out.println("Process " + i + ": " + inDegree[i]);
        }
        System.out.println("Times for each process:");
        for (int i = 1; i <= countProcesses; i++) {
            System.out.println("Process " + i + ": " + time[i]);
        }

        // Возвращаем время завершения процесса с номером 1
        return time[1];
    }
}
