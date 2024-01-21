package Recursion;

public class MyBox {
    boolean IsThereKey = false;
    boolean IsThereBox = false;
    public MyBox() {
                
        double randomDouble = 100*Math.random();
        int randomInt = (int) randomDouble;
        if (randomInt > 98) {
            IsThereKey = true;
           
        }
        else {
            IsThereBox = true;
        }
            
    }
}
