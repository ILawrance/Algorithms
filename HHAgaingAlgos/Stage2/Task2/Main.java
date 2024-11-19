package HHAgaing.Stage2.Task2;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/*
Дано бинарное дерево. Найдите наименьшего общего предка (LCA) для двух заданных значений в дереве.

        1
       / \
      2   3
     / \ /
    4  5 6


public class Node {
    int value;
    Node left;
    Node right;
    Node(int x) { value = x; }
}
 */
public class Main {
    public static void main(String[] args) {
        Node node = new Node(1);
        Scanner sc = new Scanner(System.in);
        int child1 = sc.nextInt();
        int child2 = sc.nextInt();
        sc.close();
        System.out.println(numberSameParent(node, child1, child2));
    }

    public static int numberSameParent(Node node, int val1, int val2) {
        ArrayList<Integer> listToChild1 = dfs(node, val1);
        ArrayList<Integer> listToChild2 = dfs(node, val2);
        int maxSize = Math.max(listToChild1.size(), listToChild2.size());
        int sameParent = -1;
        for (int i = 0; i < maxSize; i++) {
            if (Objects.equals(listToChild1.get(i), listToChild2.get(i))) {
                sameParent = i;
            }
        }
        return -1;
    }

    public static ArrayList<Integer> dfs(Node node, int val) {
        boolean isFind = false;
        ArrayList<Integer> list = new ArrayList<>();
        if (node == null) {
            return list;
        }
        list.add(node.value);
        if (node.value == val) {
            isFind = true;
            return list;
        }
        if (!isFind) {
            dfs(node.left, val);
            dfs(node.right, val);
        }

        return list;
    }

    public static class Node {
        int value;
        Node left;
        Node right;
        Node(int x) { value = x; }
    }
}
