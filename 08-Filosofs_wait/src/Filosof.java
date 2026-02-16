public class Filosof extends Thread {
    private Forquilla forquillaDreta;
    private Forquilla forquillaEsquerra;
    private int comptadorGana;

    public Filosof(int numComensal, Forquilla forquillaDreta, Forquilla forquillaEsquerra) {
        super("fil" + numComensal);
        this.forquillaDreta = forquillaDreta;
        this.forquillaEsquerra = forquillaEsquerra;
        comptadorGana = 0;
    }

    public void agafarForquillaEsquerra() throws InterruptedException {
        forquillaEsquerra.agafar(Integer.parseInt(getName().substring(3)));
        System.out.println("Filòsof: " + getName() + " agafa la forquilla esquerra " + forquillaEsquerra.getNumeroForquilla());
    }

    public void agafarForquillaDreta() throws InterruptedException {
        forquillaDreta.agafar(Integer.parseInt(getName().substring(3)));
        System.out.println("Filòsof: " + getName() + " agafa la forquilla dreta " + forquillaDreta.getNumeroForquilla());
    }

    public void agafarForquilles() throws InterruptedException {
        while (true) {
            agafarForquillaEsquerra();

            if (forquillaDreta.agafarAmbTempsLimit(Integer.parseInt(getName().substring(3)), 100)) {
                System.out.println("Filòsof: " + getName() + " agafa la forquilla dreta " + forquillaDreta.getNumeroForquilla());
                return;
            } else {
                System.out.println("Filòsof: " + getName() + " deixa l'esquerra(" + forquillaEsquerra.getNumeroForquilla() + ") i espera (dreta ocupada)");
                forquillaEsquerra.deixar();
                comptadorGana++;
                System.out.println("Filòsof: " + getName() + " gana=" + comptadorGana);
                Thread.sleep(500 + (int)(Math.random() * 500));
            }
        }
    }

    public void deixarForquilles() {
        forquillaEsquerra.deixar();
        forquillaDreta.deixar();
        System.out.println("Filòsof: " + getName() + " ha acabat de menjar");
    }

    public void menjar() throws InterruptedException {
        agafarForquilles();
        System.out.println("Filòsof: " + getName() + " menja");
        long tempsMenjar = 1000 + (int)(Math.random() * 1000);
        Thread.sleep(tempsMenjar);
        deixarForquilles();
    }

    public void pensar() {
        long temps = 1000 + (int)(Math.random() * 1000);
        try {
            Thread.sleep(temps);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Filòsof: " + getName() + " pensant");
        comptadorGana = 0;
    }

    @Override
    public void run() {
        while (true) {
            try {
                pensar();
                menjar();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}