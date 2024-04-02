package Recursion;

public class RecursionExample {
    public int countOpenBox = 1;
    
    public String SearchForKey(MyBox box) {
            if (box.IsThereBox) {
                countOpenBox++;
                MyBox anatherOne = new MyBox();
                return SearchForKey(anatherOne);
            } else {
                return "Ключ найден, открыто ящиков: " + countOpenBox;
            }
        }
}

