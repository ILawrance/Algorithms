package Task1;
public class test {
    public static void main (String [] arg) {
        int maxPechenek = 1;
        
        System.out.println((int)Math.floor(((double)1+(double)2)/2)); 
        System.out.println(5/2);
        System.out.println(5%6);
        int predictMinPechenekFirst = (int)Math.ceil((double)maxPechenek/2);
        System.out.println(predictMinPechenekFirst);

       // int summaPechenek = 0;
      //  System.out.println(N);
      //  System.out.println(M);
      // System.out.println(summaPechenek);
      // for (int i = 0; i<N; i++) {
      //      System.out.println(Places[i]);
      //  }

      //  int pechenekVChas = summaPechenek/M; // Идеальный случай
      //  if (summaPechenek%M > 0) {
      //     pechenekVChas+=1;
      //  }
    
       //  long start = System.nanoTime();
// long finish = System.nanoTime();
           // long elapsed = finish - start;
          //  System.out.println("Прошло времени, мс: " + elapsed / 1000000);
         /* public static void PodschetMinPechenek(int[] Places, int predictMinPechenekFirst, int hours, int M) {
            for (int pechenekNaMeste : Places) {
                       hours += (int)Math.ceil((double)pechenekNaMeste/(double)predictMinPechenekFirst);
                }
            if (hours<M) {
               System.out.println(predictMinPechenekFirst);
            }
           else {
                predictMinPechenekFirst++;
                PodschetMinPechenek(Places, predictMinPechenekFirst, 0, M);
            }
            return;
         }  */
        }
         public static void podschetMinPechenek(int[] Places, int predictMinPechenekFirst, int hours, int M, int borderPechenekMax, int borderPechenekMin) {
            while (borderPechenekMax != borderPechenekMin) {
                hours = 0;
                for (int pechenekNaMeste : Places) {
                    hours += (int) Math.ceil((double) pechenekNaMeste / (double) predictMinPechenekFirst);
                }
                if (hours <= M) {
                    borderPechenekMax = predictMinPechenekFirst - 1;
                } else {
                    borderPechenekMin = predictMinPechenekFirst + 1;
                }
                predictMinPechenekFirst = (int) Math.floor(((double) borderPechenekMin + (double) borderPechenekMax) / 2);
            }
            System.out.println(borderPechenekMin);
            return;

    }

    public static void podschetMinPechenek2(int[] Places, int predictMinPechenekFirst, int hours, int M, int borderPechenekMax, int borderPechenekMin) {  
        while (borderPechenekMax!=borderPechenekMin) {
            hours =0;
            for (int pechenekNaMeste : Places) {
                hours += (int)Math.ceil((double)pechenekNaMeste/(double)predictMinPechenekFirst); 
            }
            if (hours <= M) { // если меньше, то съесть печеньки удается вовремя
                borderPechenekMax = predictMinPechenekFirst;
                predictMinPechenekFirst = (int)Math.floor(((double)borderPechenekMin+(double)borderPechenekMax)/2); 
            }
            else {
                borderPechenekMin = predictMinPechenekFirst+1;
                predictMinPechenekFirst = (int)Math.floor(((double)borderPechenekMax+(double)borderPechenekMin)/2); 
            }
        }
        System.out.println(borderPechenekMin);
        return;
    } 


}
