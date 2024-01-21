package Task1;
import java.util.Scanner;

public class OldMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        int [] Places = new int[N];
        int summaPechenek = 0;
        int maxPechenek = 0;
        int minPechenek = 0;
        for (int i = 0; i<N; i++) {
            Places[i] = scan.nextInt();
            summaPechenek+=Places[i];
            if (maxPechenek < Places[i]) {
                maxPechenek = Places[i];
            }
            if (minPechenek > Places[i]) {
                minPechenek = Places [i];
            }
        }
        scan.close();
        int pechenekVChas = summaPechenek/M; // Идеальный случай
        if (summaPechenek%M > 0) {
            pechenekVChas+=1;
        }
       // int minimumChasov = M/N;

        if (M<N) {
            System.out.println(0);
        }
        else if (M==N) {
            System.out.println(maxPechenek);
        }
        else {
            System.out.println(pechenekVChas);
        }
    }
}
