public class Forquilla {
    private int numeroForquilla;
    private int propietari;
    public static final int LLIURE = -1;

    public Forquilla(int numeroForquilla) {
        this.numeroForquilla = numeroForquilla;
        this.propietari = LLIURE;
    }

    public synchronized boolean agafarAmbTempsLimit(int propietari, long tempsLimitMs) throws InterruptedException {
        long limit = System.currentTimeMillis() + tempsLimitMs;
        while (this.propietari != LLIURE) {
            long restant = limit - System.currentTimeMillis();
            if (restant <= 0) {
                return false;
            }
            wait(restant);
        }
        this.propietari = propietari;
        return true;
    }

    public int getNumeroForquilla() {
        return numeroForquilla;
    }

    public void setNumeroForquilla(int numeroForquilla) {
        this.numeroForquilla = numeroForquilla;
    }

    public int getPropietari() {
        return propietari;
    }

    public void setPropietari(int propietari) {
        this.propietari = propietari;
    }

    public synchronized boolean agafar(int propietari) throws InterruptedException {
        while (this.propietari != LLIURE) {
            wait();
        }
        this.propietari = propietari;
        return true;
    }

    public synchronized void deixar() {
        this.propietari = LLIURE;
        notifyAll();
    }
}