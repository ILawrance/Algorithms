package LongestPrefix;

public class LongestPrefix {
    public static void main(String[] args) {
        String[] exampl = {"Wer", "Wee", "Dea"};
        System.out.println(longestCommonPrefix(exampl));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        String longestPrefix = "";
        int count = 0;
        int maxCount = 0;

        for ( int i = 0; i < strs.length-1; i++) {
            for (int j = 0; j < Math.min(strs[i].length(), strs[i+1].length()) ; j++) {
                if (strs[i].charAt(j) == strs[i+1].charAt(j)) {
                    count++;
                }
                else {
                    count--;
                    j--;
                    if (strs[i].charAt(j) == strs[i+1].charAt(j)) {
                        continue;
                    }
                    else {
                        
                    }
                }
            }
            maxCount = count;
            count = 0;
        }
        longestPrefix = strs[0].substring(0, maxCount);
        return longestPrefix;
    }
}
