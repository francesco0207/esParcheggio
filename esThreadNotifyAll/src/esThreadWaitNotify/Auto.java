package esThreadWaitNotify;
import static java.lang.Thread.sleep;

public class Auto extends Thread 
{
    private String numero;
    private Parcheggio parcheggio;
    
    public Auto (String numero, Parcheggio parcheggio)
    {
        this.numero = numero;
        this.parcheggio = parcheggio;
        start();
    }
    
    @Override
    public void run()
    {
        while(true)
        {            
            try
            {
                sleep((long)(Math.random() * 1000));
            } catch (InterruptedException e) {}
            
            synchronized (parcheggio)
            {
                parcheggio.entrata();
                System.out.println("Auto " + numero + " e' entrata (posti disponibili : " + parcheggio.getPostiDisponibili() + ")");
            }
            
            try
            {
                sleep((long)(Math.random() * 1000));
            } catch (InterruptedException e) {}
            
            
            synchronized (parcheggio)
            {
                parcheggio.uscita();
                System.out.println("Auto " + numero + " e' uscita (posti disponibili : " + parcheggio.getPostiDisponibili() + ")");
            }
        }
    }
}
