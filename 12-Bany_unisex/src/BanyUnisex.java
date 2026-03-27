import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class BanyUnisex {
    private EstatBany estatActual;
    private final int BANY_BUIT = 0;
    private final  int BANY_AMB_DONES = 1;
    private final int BANY_AMB_HOMES = 2;
    private int numOcupants;
    private final int CAPACITAT_MAXIMA;
    private Semaphore capacitat;
    private ReentrantLock lockEstat;

    public BanyUnisex(){
        this.estatActual = EstatBany.BANY_BUIT;
        numOcupants = 0;
        CAPACITAT_MAXIMA = 3;
        capacitat = new Semaphore(CAPACITAT_MAXIMA, true);
        lockEstat = new ReentrantLock(true);
    }

    public void entraHome(){
        lockEstat.lock();
        while (estatActual != EstatBany.BANY_AMB_HOMES && estatActual != EstatBany.BANY_BUIT) { // mentres hi hagi una dona
            lockEstat.unlock();
            lockEstat.lock();
        }
        if (capacitat.tryAcquire()){
            numOcupants++;
            estatActual = EstatBany.BANY_AMB_HOMES;
        } else {

        }
        lockEstat.unlock();
    }

    public void entraDona(){

    }

    public void surtHome(){

    }
    
    public void surtDona(){

    }
}
