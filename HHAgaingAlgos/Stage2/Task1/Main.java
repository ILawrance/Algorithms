package HHAgaing.Stage2.Task1;

public class Main {
    public static void main(String[] args) {
        char[][] matrix =  new char[][]{
                {'A', 'F', 'R', 'D', 'H'},
        {'O', 'L', 'M', 'O', 'E'},
        {'L', 'M', 'Q', 'L', 'L'}
};
        String word = "HELLO";
        System.out.println(isWordPresentInMatrix(matrix, word));
    }
    public static boolean isWordPresentInMatrix(char[][] matrix, String word) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == word.charAt(0)) {
                    if (dfs(matrix, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] matrix, String word, int i, int j, int countChars) {
        if (countChars == word.length()) {
            return true;
        }

        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] != word.charAt(countChars)) {
            return false;
        }

        char used = matrix[i][j];
        matrix[i][j] = '#';
        boolean isFound = dfs(matrix, word, i - 1, j, countChars + 1) ||
                dfs(matrix, word, i + 1, j, countChars + 1) ||
                dfs(matrix, word, i, j - 1, countChars + 1) ||
                dfs(matrix, word, i, j + 1, countChars + 1);

        matrix[i][j] = used;
        return isFound;
    }
}
