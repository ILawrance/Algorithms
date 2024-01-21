package Task1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        List<Integer> Places = new ArrayList<Integer>();
        int maxPechenek = 0;
        for (int i = 0; i < N; i ++) {
            int pechenek = scan.nextInt();
            if (pechenek == 0) {
                continue;
            }
            Places.add(pechenek);
            if (maxPechenek < pechenek) {
                maxPechenek = pechenek;
            }
        }
        scan.close();
        int predictMinPechenek = (int)Math.floor((double)maxPechenek / 2);
        int hours = 0;
        int borderPechenekMax = maxPechenek;
        int borderPechenekMin = 1;
        if (M < Places.size() || maxPechenek == 0) {
            System.out.println(0);
            return;
        }
        else if (M == Places.size()) {
            System.out.println(maxPechenek);
            return;
        }
        else {
            while (borderPechenekMin < borderPechenekMax) {
            hours = 0;
            for (int pechenekNaMeste : Places) {
                hours += (int)Math.ceil((double)pechenekNaMeste / (double)predictMinPechenek);
            }
            if (hours <= M) {
                borderPechenekMax = predictMinPechenek;
            }
            else {
                borderPechenekMin = predictMinPechenek + 1;
            }
            predictMinPechenek = (int)Math.floor(((double)borderPechenekMin + (double)borderPechenekMax) / 2);
            }
        System.out.println(borderPechenekMin);
        return;
        }
    }
}