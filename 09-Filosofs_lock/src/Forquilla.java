import java.util.concurrent.locks.ReentrantLock;

public class Forquilla {
    private int numeroForquilla;
    private ReentrantLock bloqueig;

    public Forquilla(int numeroForquilla) {
        this.numeroForquilla = numeroForquilla;
        this.bloqueig = new ReentrantLock();
    }

    public int getNumeroForquilla() {
        return numeroForquilla;
    }

    public void agafar() {
        bloqueig.lock();
    }

    public void deixar() {
        bloqueig.unlock();
    }
}