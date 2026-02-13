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

    public void agafarForquillaEsquerra() throws InterruptedException{
        forquillaEsquerra.agafar(Integer.parseInt(getName().substring(3)));
        System.out.println("Filòsof " + getName() + " agafa la forquilla esquerra " + forquillaEsquerra.getNumeroForquilla());
    }

    public void agafarForquillaDreta() throws InterruptedException {
        forquillaDreta.agafar(Integer.parseInt(getName().substring(3)));
        System.out.println("Filòsof: " + getName() + " agafa la forquilla dreta " + forquillaDreta.getNumeroForquilla());
    }

    public void agafarForquilles() throws InterruptedException {
        agafarForquillaEsquerra();
        agafarForquillaDreta();
    }

    public void deixarForquilles() {
        forquillaEsquerra.deixar();
        forquillaDreta.deixar();
        System.out.println("Filòsof: " + getName() + " ha acabat de menjar");
    }


    public void menjar() {
        boolean menjar = false;
        while (!menjar) {
            try {
                agafarForquilles();  // Intenta agafar ambas
                System.out.println("Filòsof: " + getName() + " menja");
                long tempsMenjar = 1000 + (int)(Math.random() * 1000);
                Thread.sleep(tempsMenjar);
                deixarForquilles();  // Deixa ambas
                menjar = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!menjar) {
                // Si no pudo (aunque con wait debería ser raro), espera y reintenta
                comptadorGana++;
                System.out.println("Filòsof: " + getName() + " gana=" + comptadorGana);
                long tempsEspera = 500 + (int)(Math.random() * 500);
                try {
                    Thread.sleep(tempsEspera);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
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
            pensar();
            menjar();
        }
    }
}