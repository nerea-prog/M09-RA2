import java.util.Random;

public class Soci extends Thread {
    private Compte compte;
    private final float APORTACIO = 10f;
    private final int ESPERAMAX = 100;
    private final int MAXANYS = 10;
    Random rnd;

    public Soci(String nom){
        super(nom);
        this.compte = Compte.getInstancia();
        this.rnd = new Random();
    }

    @Override
    public void run(){
        for(int i = 0; i < MAXANYS; i++){
            for (int mes = 0; mes < 12; mes++) {
                synchronized(compte){
                    if (mes%2==0) {
                        compte.setSaldo(compte.getSaldo() + APORTACIO);
                    } else{
                        compte.setSaldo(compte.getSaldo() - APORTACIO);
                    }
                }
                try {
                    Thread.sleep(rnd.nextInt(ESPERAMAX + 1));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
