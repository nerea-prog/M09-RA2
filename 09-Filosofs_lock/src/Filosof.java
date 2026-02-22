public class Filosof extends Thread {
    private Forquilla forquillaDreta;
    private Forquilla forquillaEsquerra;
    private long iniciGana;
    private long fiGana;
    private long gana;

    public Filosof(String nom, Forquilla forquillaDreta, Forquilla forquillaEsquerra) {
        super(nom);
        this.forquillaDreta = forquillaDreta;
        this.forquillaEsquerra = forquillaEsquerra;
        this.iniciGana = 0;
        this.fiGana = 0;
        this.gana = 0;
    }

    public void agafarForquillaEsquerra() {
        forquillaEsquerra.agafar();
    }

    public void agafarForquillaDreta() {
        forquillaDreta.agafar();
    }

    public void agafarForquilles() {
        agafarForquillaEsquerra();
        agafarForquillaDreta();
        System.out.println(getName() + " té forquilles esq(" + forquillaEsquerra.getNumeroForquilla() + ") dreta(" + forquillaDreta.getNumeroForquilla() + ")");
    }

    public void deixarForquilles() {
        forquillaDreta.deixar();
        forquillaEsquerra.deixar();
        System.out.println(getName() + " deixa les forquilles");
    }

    public void menjar() {
        agafarForquilles();
        calcularGana();
        System.out.println(getName() + " menja amb gana " + gana);

        long tempsMenjar = 1000 + (long)(Math.random() * 1000);
        try {
            Thread.sleep(tempsMenjar);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(getName() + " ha acabat de menjar");
        resetGana();
        deixarForquilles();
    }

    public void pensar() {
        iniciGana = System.currentTimeMillis();
        System.out.println(getName() + " pensant");

        long tempsPensar = 1000 + (long)(Math.random() * 1000);
        try {
            Thread.sleep(tempsPensar);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public long calcularGana() {
        fiGana = System.currentTimeMillis();
        gana = (fiGana - iniciGana) / 1000;
        return gana;
    }

    public void resetGana() {
        iniciGana = System.currentTimeMillis();
        gana = 0;
    }

    @Override
    public void run() {
        while (true) {
            pensar();
            menjar();
        }
    }
}