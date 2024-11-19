import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
public class ReplaceVowelWithIndexes {
    public static void main(String[] args) {

        System.out.println(solution(new ArrayList<>(List.of("python", "kyklos"))));
    }
    public static List<String> solution(List<String> words) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('y');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('U');
        vowels.add('Y');

        List<String> ansList = new ArrayList<>();

        for (String s : words) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (vowels.contains(s.charAt(i))) {
                    stringBuilder.append(i);
                }
                else {
                    stringBuilder.append(s.charAt(i));
                }
            }
            ansList.add(stringBuilder.toString());
        }
        return ansList;
    }
}
