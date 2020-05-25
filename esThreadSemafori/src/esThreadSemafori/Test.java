package esThreadSemafori;

public class Test 
{
    public static void main(String[] args)
    {
        Parcheggio parcheggio = new Parcheggio();
        for (int i = 0; i < 10; i++)
        {
            Auto a = new Auto(i + "", parcheggio);
        }
    }
}