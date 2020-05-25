package esThreadWaitNotify;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args)
    {
        Parcheggio parcheggio = new Parcheggio();
        ArrayList<Auto> auto = new ArrayList<>();
        for (int i = 0; i < 10; i++) auto.add(new Auto(i + "", parcheggio));
    }
}