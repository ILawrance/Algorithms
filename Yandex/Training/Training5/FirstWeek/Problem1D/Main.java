package YandexTren.Training5.FirstWeek.Problem1D;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[][] board = new String[8][8];
        List<Integer[]> rooksCoords =  new LinkedList<>();
        List<Integer[]> bishopsCoords = new LinkedList<>();
        int countFreeSpace = 64;
        boolean[][] booleanBoard = new boolean[8][8];

        for (int i = 0; i<8; i++) {
            String temp = scan.nextLine();
            for (int j = 0; j<8; j++) {
                board[i][j] = String.valueOf(temp.charAt(j));
                if (board[i][j].equals("B")) {
                    bishopsCoords.add(new Integer[]{i, j});
                }
                else if (board[i][j].equals("R")) {
                    rooksCoords.add(new Integer[]{i,j});
                }
            }
        }

        for (Integer[] rook:rooksCoords) {               // Записываем клетки РУКОВ
            booleanBoard[rook[0]][rook[1]] = true;
            for (int i = rook[0] + 1; i < 8; i++) {      // Двигаемся вверх
                if (!board[i][rook[1]].equals("*")) {
                    break;
                }
                else {
                    booleanBoard[i][rook[1]] = true;
                }
            }
            for (int i = rook[0] - 1; i >= 0; i--) {    // Двигаемся вниз
                if (!board[i][rook[1]].equals("*")) {
                    break;
                }
                else {
                    booleanBoard[i][rook[1]] = true;
                }
            }
            for (int i = rook[1] + 1; i < 8; i++) {      // Двигаемся вправо
                if (!board[rook[0]][i].equals("*")) {
                    break;
                }
                else {
                    booleanBoard[rook[0]][i] = true;
                }
            }
            for (int i = rook[1] - 1; i >= 0; i--) {    // Двигаемся влево
                if (!board[rook[0]][i].equals("*")) {
                    break;
                }
                else {
                    booleanBoard[rook[0]][i] = true;
                }
            }
        }

        for (Integer[] bishop:bishopsCoords) {
            booleanBoard[bishop[0]][bishop[1]] = true;

            int i = bishop[0] +1;                       // Двигаемся вверх вправо
            int j = bishop[1] +1;
            while (i < 8 && j < 8) {
                if (!board[i][j].equals("*")) {
                    break;
                }
                else {
                    booleanBoard[i][j] = true;
                }
                i++;
                j++;
            }
            i = bishop[0] + 1;                         // Двигаемся вверх влево
            j = bishop[1] - 1;
            while (i < 8 && j >= 0) {
                if (!board[i][j].equals("*")) {
                    break;
                }
                else {
                    booleanBoard[i][j] = true;
                }
                i++;
                j--;
            }
            i = bishop[0] - 1;          // Двигаемся вниз вправо
            j = bishop[1] + 1;
            while (i >= 0 && j < 8) {
                if (!board[i][j].equals("*")) {
                    break;
                }
                else {
                    booleanBoard[i][j] = true;
                }
                i--;
                j++;
            }
            i = bishop[0] - 1;    // Двигаемся вниз влево
            j = bishop[1] - 1;
            while (i >= 0 && j >= 0) {
                if (!board[i][j].equals("*")) {
                    break;
                }
                else {
                    booleanBoard[i][j] = true;
                }
                i--;
                j--;
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (booleanBoard[i][j]) {
                    countFreeSpace--;
                }
            }
        }
        System.out.println(countFreeSpace);

    }
}

/*for (Integer[] rook:rooks) {
            System.out.println("Есть рук, он имеет координаты " + rook[0] + " " + rook[1]);
        }
        for (Integer[] book:books) {
            System.out.println("Есть бук, он имеет координаты " + book[0] + " " + book[1]);
        }*/

        /*for (int i = 0; i<8; i++) {
            for (int j = 0; j<8; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }*/