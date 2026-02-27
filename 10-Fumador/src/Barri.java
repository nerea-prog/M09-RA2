public class Barri {
    private Estanc estanc;
    private Fumador[] fumadors;
    public Barri(Estanc estanc){
        this.estanc = estanc;
        fumadors = new Fumador[3];
    }
    public static void main(String[] args) {
        fumadors.start();
    }
}
    