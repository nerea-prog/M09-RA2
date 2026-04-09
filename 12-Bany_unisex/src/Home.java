public class Home extends Thread {

    private final String nom;
    private final BanyUnisex lavabo;

    public Home(String nom, BanyUnisex lavabo) {
        this.nom = nom;
        this.lavabo = lavabo;
    }

    @Override
    public void run() {
        System.out.println(nom + " vol entrar al bany");
        lavabo.entraHome();
        try {
            Thread.sleep(1000 + (long)(Math.random() * 1000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        lavabo.surtHome();
        System.out.println(nom + " ha acabat d'usar el bany");
    }
}
