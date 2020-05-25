package esThreadWaitNotify;

public class Parcheggio 
{
    private int postiDisponibili = 10;

    public int getPostiDisponibili() {
        return postiDisponibili;
    }
    
    public synchronized void entrata() {
        while (postiDisponibili == 0) 
        {
            try
            {
                wait();
            } catch (InterruptedException e) {}
        }
        postiDisponibili--;
    }
    
    public synchronized void uscita() {
        postiDisponibili++;
        notifyAll();
    }
}
