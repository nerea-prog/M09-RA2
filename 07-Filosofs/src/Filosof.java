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
                System.out.println("Filòsof: " + getName() + " agafa la forquilla esquerra");
                if (forquillaDreta.agafar()) {
                    System.out.println("Filòsof: " + getName() + " agafa la forquilla dreta");
                    try {
                        Thread.sleep(2000);
                    } catch (Exception e) {
                        Thread.currentThread();
                    }
                    forquillaEsquerra.deixar();
                    forquillaDreta.deixar();
                    menjar = true;
                }
            }
        }

    }

    public void pensar() {
        Math.random();
        try {
            Thread.sleep(MAX_PRIORITY);
        } catch (Exception e) {
            Thread.currentThread();
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
