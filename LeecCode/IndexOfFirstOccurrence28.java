package ProblemsLeetCode;

public class IndexOfFirstOccurrence28 {
    public int strStr(String haystack, String needle) {
        int haLength = haystack.length();
        int needleLength = needle.length();
        if (haLength < needleLength) {
            return -1;
        }
        for (int i = 0; i < haLength; i++ ) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if ((haLength - i) < needleLength) {
                    return -1;
                }
                for (int j = 0; j < needleLength; j++) {
                    if (haystack.charAt(i + j) == needle.charAt(j)) {
                        if (j + 1 == needleLength) {
                            return i;
                        }
                    }
                    else {
                        break;
                    }
                }
            }
        }
        return -1;
    }
}