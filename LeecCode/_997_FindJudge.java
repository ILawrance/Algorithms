package ProblemsLeetCode;

public class _997_FindJudge {
    public static void main(String[] args) {
        System.out.println(findJudge(3, new int[][]{{1, 3}, {2, 3}}));
    }
    public static int findJudge(int n, int[][] trust) {
        int[] persons = new int[n + 1];
        int ans = n - 1;
        for (int[] people : trust) {
            persons[people[0]]--;
            persons[people[1]]++;
        }
        for (int i = 1; i < persons.length; i++)
            if (persons[i] == ans) return i;
        return -1;
    }
}
