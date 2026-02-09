public class Filosof extends Thread {
    private Forquilla forquillaDreta;
    private Forquilla forquillaEsquerra;
    private int comptadorGana;

    public Filosof(String nom, Forquilla forquillaDreta, Forquilla forquillaEsquerra) {
        super(nom);
        this.forquillaDreta = forquillaDreta;
        this.forquillaEsquerra = forquillaEsquerra;
        comptadorGana = 0;
    }

    public void menjar() {
        boolean menjar = false;
        while (!menjar) {
            if (forquillaEsquerra.agafar()) {
                System.out.println("Filòsof: " + getName() + " agafa la forquilla esquerra " + forquillaEsquerra.getNumeroForquilla());
                if (forquillaDreta.agafar()) {
                    System.out.println("Filòsof: " + getName() + " agafa la forquilla dreta " + forquillaDreta.getNumeroForquilla());
                    System.out.println("Filòsof: " + getName() + " menja");
                    long tempsMenjar = 1000 + (int)(Math.random() * 1000);
                    try {
                        Thread.sleep(tempsMenjar);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    forquillaEsquerra.deixar();
                    forquillaDreta.deixar();
                    System.out.println("Filòsof: " + getName() + " ha acabat de menjar");
                    menjar = true;
                } else {
                    System.out.println("Filòsof: " + getName() + " deixa l'esquerra(" + forquillaEsquerra.getNumeroForquilla() + ") i espera (dreta ocupada)");
                    forquillaEsquerra.deixar();
                    comptadorGana++;
                    System.out.println("Filòsof: " + getName() + " gana=" + comptadorGana);
                }
            } else {
                comptadorGana++;
                System.out.println("Filòsof: " + getName() + " gana=" + comptadorGana);
            }
            if (!menjar) {
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