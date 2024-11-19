package SoftProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class _6Task {
    // Словарь для хранения расстояний между городами
    static Map<String, Map<String, Integer>> distances = new HashMap<>();
    static int maxDistance = 0;
    static List<String> longestRoute = new ArrayList<>();

    public static void main(String[] args) {
        initializeDistances(); // Инициализация словаря расстояний

        Set<String> cities = distances.keySet();

        // Проходимся по всем городам, начиная маршрут с каждого
        for (String startCity : cities) {
            Set<String> visited = new HashSet<>();
            visited.add(startCity);
            findLongestRoute(startCity, visited, 0);
        }

        // Выводим результат
        System.out.println("Самый длинный маршрут: " + String.join(" -> ", longestRoute));
        System.out.println("Длина маршрута: " + maxDistance);
    }

    private static void initializeDistances() {
        addDistance("Faerun", "Norrath", 129);
        addDistance("Faerun", "Tristram", 58);
        addDistance("Faerun", "AlphaCentauri", 13);
        addDistance("Faerun", "Arbre", 24);
        addDistance("Faerun", "Snowdin", 60);
        addDistance("Faerun", "Tambi", 71);
        addDistance("Faerun", "Straylight", 67);
        addDistance("Norrath", "Tristram", 142);
        addDistance("Norrath", "AlphaCentauri", 15);
        addDistance("Norrath", "Arbre", 135);
        addDistance("Norrath", "Snowdin", 75);
        addDistance("Norrath", "Tambi", 82);
        addDistance("Norrath", "Straylight", 54);
        addDistance("Tristram", "AlphaCentauri", 118);
        addDistance("Tristram", "Arbre", 122);
        addDistance("Tristram", "Snowdin", 103);
        addDistance("Tristram", "Tambi", 49);
        addDistance("Tristram", "Straylight", 97);
        addDistance("AlphaCentauri", "Arbre", 116);
        addDistance("AlphaCentauri", "Snowdin", 12);
        addDistance("AlphaCentauri", "Tambi", 18);
        addDistance("AlphaCentauri", "Straylight", 91);
        addDistance("Arbre", "Snowdin", 129);
        addDistance("Arbre", "Tambi", 53);
        addDistance("Arbre", "Straylight", 40);
        addDistance("Snowdin", "Tambi", 15);
        addDistance("Snowdin", "Straylight", 99);
        addDistance("Tambi", "Straylight", 70);
    }

    private static void addDistance(String city1, String city2, int distance) {
        distances.putIfAbsent(city1, new HashMap<>());
        distances.putIfAbsent(city2, new HashMap<>());
        distances.get(city1).put(city2, distance);
        distances.get(city2).put(city1, distance);
    }

    // Метод для поиска самого длинного маршрута
    private static void findLongestRoute(String currentCity, Set<String> visited, int currentDistance) {
        if (visited.size() == distances.size()) {
            // Проверяем, является ли текущий маршрут самым длинным
            if (currentDistance > maxDistance) {
                maxDistance = currentDistance;
                longestRoute = new ArrayList<>(visited);
            }
            return;
        }

        // Рекурсивный обход всех соседей текущего города
        for (String neighbor : distances.get(currentCity).keySet()) {
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                findLongestRoute(neighbor, visited, currentDistance + distances.get(currentCity).get(neighbor));
                visited.remove(neighbor); // Откат для поиска других маршрутов
            }
        }
    }
}
