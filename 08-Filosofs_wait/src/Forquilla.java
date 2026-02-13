public class Forquilla {
    private int numeroForquilla;
    public int propietario;
    public static int LLIURE = -1;

    public Forquilla(int numeroForquilla) {
        this.numeroForquilla = numeroForquilla;
        this.propietario = LLIURE;
    }

    public int getNumeroForquilla() {
        return numeroForquilla;
    }

    public void setNumeroForquilla(int numeroForquilla) {
        this.numeroForquilla = numeroForquilla;
    }

    public int getPropietario() {
        return propietario;
    }

    public void setPropietario(int propietario) {
        this.propietario = propietario;
    }

    public synchronized boolean agafar(int propietario) throws InterruptedException{
        while (this.propietario != LLIURE){
            wait();
        }
        this.propietario = propietario;
        return true;
    }

    public synchronized void deixar(){
        this.propietario = LLIURE;
        notifyAll();
    }
}