package LongestPrefix;

import java.util.Arrays;
public class LongestPrefix2 {
    
    public static void main(String[] args) {
        String[] exampl = {"Wer", "Wee", "Wea"};
        System.out.println(longestCommonPrefix(exampl));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length-1];
        int count = 0;

        while (count < s1.length() && count < s2.length()) {
            if (s1.charAt(count) == s2.charAt(count)) {
                count++;
            }
            else {
                break;
            }
        }
        return strs[0].substring(0, count);
    }
    
}
