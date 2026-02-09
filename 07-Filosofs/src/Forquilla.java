public class Forquilla {
    private int numeroForquilla;
    private boolean enUs;

    public Forquilla(int numeroForquilla) {
        this.numeroForquilla = numeroForquilla;
    }

    public int getNumeroForquilla() {
        return numeroForquilla;
    }

    public void setNumeroForquilla(int numeroForquilla) {
        this.numeroForquilla = numeroForquilla;
    }

    public boolean isEnUs() {
        return enUs;
    }

    public void setEnUs(boolean enUs) {
        this.enUs = enUs;
    }

    public boolean agafar() {
        if (!enUs) {
            enUs = true;
            return true;
        }
        return false;
    }

    public void deixar() {
        enUs = false;
    }
}