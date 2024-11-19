package YandexTren.Training5.ThirdWeek.Problem3G;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
      //  BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader scan = new BufferedReader(new FileReader("D:\\zSOFT\\IntelliJ Projects\\SomeAlgorithms\\src\\YandexTren\\Trening5\\ThirdWeek\\Problem3G\\input.txt"));

        int countDots = Integer.parseInt(scan.readLine());
        LinkedHashMap<Integer[], List<Integer[]>> sqrCords = new LinkedHashMap<>();
        Dictionary<Integer, List<List<Integer[]>>> countDotsAndCords = new Hashtable<>();
        LinkedHashMap<Integer, List<Integer[]>> minDotsNeeded = new LinkedHashMap<>();

        for (int i = 0; i < countDots; i++) {
            String[] temp = scan.readLine().split(" ");
            Integer[] cords = new Integer[2];
            cords[0] = Integer.parseInt(temp[0]); cords[1] = Integer.parseInt(temp[1]);
            if (sqrCords.isEmpty()) {
                List<Integer[]> list = new LinkedList<>();
                List<List<Integer[]>>  dotsAndCords = new LinkedList<>();
                list.add(cords);
                sqrCords.put(cords, list);
                dotsAndCords.add(list);
                countDotsAndCords.put(3, dotsAndCords);
                minDotsNeeded.put(3, list);
            }
            else {
                for (Map.Entry<Integer[], List<Integer[]>> elem: sqrCords.entrySet()) {
                  if(Objects.equals(elem.getKey()[0], cords[0]) || Objects.equals(elem.getKey()[1], cords[1])
                          || Math.abs(cords[0]-elem.getKey()[0]) == Math.abs(cords[1] - elem.getKey()[1]))  {
                      List<Integer[]> list = sqrCords.get(elem.getKey());
                      list.add(cords);
                      sqrCords.put(elem.getKey(), list);
                  }
                }
                List<Integer[]> list = new LinkedList<>();
                list.add(cords);
                sqrCords.put(cords, list);
            }
        }
        // Раскидали координаты по словарю ключ - координаты, значения - список массивов координат

        int dotsNeeded;

        PlacesForDots placesForDots = new PlacesForDots();
        for(Map.Entry<Integer[], List<Integer[]>> element: sqrCords.entrySet()) {
            List<Integer[]> list = new LinkedList<>(element.getValue());
            for (Integer[] cords: list) {
                placesForDots.setCordsBaza(cords);
                for (Integer[] cordsForSqr: list) {
                    if (cords == cordsForSqr) {
                        continue;
                    }
                    placesForDots.addPlaceForDot(cordsForSqr);
                }
                dotsNeeded = 4 - placesForDots.getPlaces().size();

                if (dotsNeeded == 0) {
                    List<Integer[]> listCords = new LinkedList<>(placesForDots.getPlaces().values());
                    minDotsNeeded.put(dotsNeeded, listCords);
                }
                else if (dotsNeeded == 1) {
                    List<Integer[]> listCords = new LinkedList<>(placesForDots.getPlaces().values());
                    minDotsNeeded.put(dotsNeeded, listCords);
                }
                else if (dotsNeeded == 2) {
                    List<Integer[]> listCords = new LinkedList<>(placesForDots.getPlaces().values());
                    minDotsNeeded.put(dotsNeeded, listCords);
                }
                placesForDots.clearPlaces();
                placesForDots.clearCordsBaza();
                placesForDots.clearTypeOfFotSet();
            }
        }
        Integer[] minDotsCountNeeded = minDotsNeeded.keySet().toArray(new Integer[0]);
        int minDots = minDotsCountNeeded[0];
        for (Integer integer : minDotsCountNeeded) {
            if (integer < minDots) minDots = integer;
        }
        List<Integer[]> listForBuildSqr = new LinkedList<>(minDotsNeeded.get(minDots)); // Из этого строить квадрат
        PlacesForDots placesForDots2 = new PlacesForDots();
        placesForDots2.setCordsBaza(listForBuildSqr.iterator().next());
        Set<Integer> allPossiblePlaces = new HashSet<>();
        allPossiblePlaces.add(-1);
        allPossiblePlaces.add(1);
        allPossiblePlaces.add(2);
        allPossiblePlaces.add(3);
        for (Integer[] cords: listForBuildSqr) {
            placesForDots2.addPlaceForDot(cords);
        }
        Set<Integer> takenPlaces = new HashSet<>(placesForDots2.getTypeOfFitSet());
        allPossiblePlaces.removeAll(takenPlaces);
        // -1 - База
        // 1 - Нужно совпадение по Х
        // 2 - Нужно совпадение по У
        // 3 - Нужно совпадение по Диагонали
        Integer[] neededPlaces = allPossiblePlaces.toArray(new Integer[0]);
        List<Integer[]> ansList = new LinkedList<>();
        while (listForBuildSqr.size() !=4) {
            if (listForBuildSqr.size() == 3) {
                if (neededPlaces[0] == 3) {
                    Integer[] diagonalCords = new Integer[2];
                    diagonalCords[0] = placesForDots2.getPlaces().get(1)[1];
                    diagonalCords[1] = placesForDots2.getPlaces().get(2)[0];
                    listForBuildSqr.add(diagonalCords);
                    ansList.add(diagonalCords);
                }
                else if (neededPlaces[0] == 2) {
                    Integer[] diagonalCords = new Integer[2];
                    diagonalCords[0] = placesForDots2.getPlaces().get(-1)[0];
                    diagonalCords[1] = placesForDots2.getPlaces().get(3)[1];
                    listForBuildSqr.add(diagonalCords);
                    ansList.add(diagonalCords);
                }
                else {
                    Integer[] diagonalCords = new Integer[2];
                    diagonalCords[0] = placesForDots2.getPlaces().get(-1)[1];
                    diagonalCords[1] = placesForDots2.getPlaces().get(3)[0];
                    listForBuildSqr.add(diagonalCords);
                    ansList.add(diagonalCords);
                }
            }
            else if (listForBuildSqr.size() == 2) {

            }
            else { // Случай если никто не помогает составить квадрат
                Integer[] addCords = {placesForDots2.getPlaces().get(-1)[0] + 1, placesForDots2.getPlaces().get(-1)[1]}; // по Х
                listForBuildSqr.add(addCords);
                ansList.add(addCords);
                Integer[] addCords2 = { placesForDots2.getPlaces().get(-1)[0], placesForDots2.getPlaces().get(-1)[1] + 1}; // по Y
                listForBuildSqr.add(addCords);
                ansList.add(addCords2);
                Integer[] addCords3 = {placesForDots2.getPlaces().get(-1)[0] + 1, placesForDots2.getPlaces().get(-1)[1] + 1}; // по диагонали
                listForBuildSqr.add(addCords);
                ansList.add(addCords3);
            }


        }
        System.out.println(minDots);
        for (Integer[] cords: ansList) {
            System.out.println(cords[0] + " " + cords[1]);
        }
    }
    public static class PlacesForDots {
        private final LinkedHashMap<Integer, Integer[]> places = new LinkedHashMap<>();
        private final Set<Integer> typeOfFitSet = new HashSet<>();
        Integer[] cordsBaza = new Integer[2];

        public void clearPlaces() {
            this.places.clear();
        }
        public void clearTypeOfFotSet() {
            this.typeOfFitSet.clear();
        }
        public void clearCordsBaza() {
            this.cordsBaza = new Integer[2];
        }
        public Integer[] getCordsBaza() {
            return cordsBaza;
        }
        public void setCordsBaza(Integer[] cordsBaza) {
            typeOfFitSet.add(-1);
            this.cordsBaza = cordsBaza;
            places.put(-1,cordsBaza);
        }
        public void addPlaceForDot(Integer[] cords) {
            // ПОДУМАТЬ !!!!
            if (isCordsFit(cords)) {
                typeOfFitSet.add(typeOfFit(cords, places));
                places.put(typeOfFit(cords, places) ,cords);
            }
        }
        public LinkedHashMap<Integer, Integer[]> getPlaces() {
            return places;
        }
        public Set<Integer> getTypeOfFitSet() {
            return typeOfFitSet;
        }
        public boolean isCordsFit(Integer[] cords) {
            if (places.size() >= 4) return false;
            else if (places.isEmpty()) return true;
            else if (!typeOfFitSet.contains(typeOfFit(cords, places)))  return true;
            else return false;

        }
        public Integer typeOfFit(Integer[] cordsForFit, LinkedHashMap<Integer, Integer[]> places) {
            // Вот тут я понял, что подход неверный
            if (places.size() == 1) {
                if (Objects.equals(cordsBaza[0], cordsForFit[0]) && Objects.equals(cordsBaza[1], cordsForFit[1])) return -1;
                else if (Objects.equals(cordsBaza[0], cordsForFit[0])) return 1;
                else if (Objects.equals(cordsBaza[1], cordsForFit[1])) return 2;
                else if (Math.abs(cordsBaza[0] - cordsForFit[0]) == Math.abs(cordsBaza[1] - cordsForFit[1])) return 3;
                else return -1;
            }

            return -1;
        }
    }
}
