package esThreadSemafori;
import java.util.concurrent.Semaphore;

public class Parcheggio 
{
    private int postiDisponibili;
    private Semaphore postiLiberi;
    private Semaphore postiOccupati;
    
    public Parcheggio()
    {
        postiLiberi = new Semaphore(postiDisponibili, true);
        postiOccupati = new Semaphore(0, true);
    }

    public int getPostiDisponibili()
    {
        return postiDisponibili;
    }
    
    public synchronized void entrata()
    {
        try
        {
            postiLiberi.acquire();
        } catch (InterruptedException e) {}
        postiDisponibili--;
        postiOccupati.release();
    }
    
    public synchronized void uscita()
    {
        try
        {
            postiOccupati.acquire();
        } catch (InterruptedException e) {}
        postiDisponibili++;
        postiLiberi.release();
    }
}
