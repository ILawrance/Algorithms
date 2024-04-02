package Recursion;

public class ProgramRecursion {
    public static void main (String[] args) {
    MyBox BoxWithKey = new MyBox();
    RecursionExample RecExp1 = new RecursionExample();
    System.out.println(RecExp1.SearchForKey(BoxWithKey));

    System.out.println("Расчет: ");
    CountDown.Count(4);
    }
}