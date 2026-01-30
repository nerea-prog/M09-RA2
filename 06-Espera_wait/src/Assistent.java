import java.util.Random;

public class Assistent extends Thread {
    private Random rnd = new Random();
    private Esdeveniment esdeveniment;

    public Assistent(String nom, Esdeveniment esdeveniment) {
        super(nom);
        this.esdeveniment = esdeveniment;
    }

    @Override
    public void run() {
        while (true) {
            double probabilitat = rnd.nextDouble();
            if (probabilitat < 0.5) {
                try {
                    esdeveniment.ferReserva(this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                esdeveniment.cancelaReserva(this);
            }
            try {
                Thread.sleep(rnd.nextInt(1000));
            } catch (InterruptedException e) {
                Thread.currentThread();
            }
        }
    }
}
