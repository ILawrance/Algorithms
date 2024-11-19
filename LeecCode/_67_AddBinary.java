package ProblemsLeetCode;
public class _67_AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder strB = new StringBuilder();
        int temp = 0;
        int jb = b.length() -1;
        int ja = a.length() -1;
        if (a.length() >= b.length()) {
            temp = iteratorS(a,b, temp, strB, jb);
        } else {
            temp = iteratorS(b,a, temp, strB, ja);
        }
        if (temp == 1) {
            strB.append('1');
        }
        return strB.reverse().toString();
    }
    public int iteratorS(String a, String b, int temp, StringBuilder strB, int jab) {
        for (int i = a.length() - 1; i >= 0; i--) {
            if (jab >= 0) {
                if (a.charAt(i) == '0' && temp == 0) {
                    strB.append(b.charAt(jab));
                } else if ((a.charAt(i) == '1' && b.charAt(jab) == '0' && temp == 0) || (a.charAt(i) == '1' && b.charAt(jab) == '1' && temp == 1)) {
                    strB.append('1');
                } else if ((a.charAt(i) == '0' && b.charAt(jab) == '1' && temp == 1) || (a.charAt(i) == '1' && b.charAt(jab) == '0' && temp == 1)) {
                    strB.append('0');
                } else if (a.charAt(i) == '1' && b.charAt(jab) == '1' && temp == 0) {
                    strB.append('0');
                    temp = 1;
                } else if (a.charAt(i) == '0' && b.charAt(jab) == '0' && temp == 1) {
                    strB.append('1');
                    temp = 0;
                }
                jab--;
            } else {
                if ((a.charAt(i) == '0' && temp == 1) || (a.charAt(i) == '1' && temp == 0)) {
                    strB.append('1');
                    temp = 0;
                } else if ((a.charAt(i) == '1' && temp == 1) || (a.charAt(i) == '0' && temp == 0)) {
                    strB.append('0');
                }
            }
        }
        return temp;
    }
}