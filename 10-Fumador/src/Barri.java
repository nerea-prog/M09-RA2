public class Barri {
    private Estanc estanc;
    private Fumador[] fumadors;
    public Barri(){
        estanc = new Estanc();
        fumadors = new Fumador[3];
        fumadors[0] = new Fumador(0, estanc);
        fumadors[1] = new Fumador(1, estanc);
        fumadors[2] = new Fumador(2, estanc);
    }
    public static void main(String[] args) {
        Barri barri = new Barri();
        barri.estanc.start();
        for (int i = 0; i < 3; i++) {
            barri.fumadors[i].start();
        }
        for (int i = 0; i < 3; i++) {
            try {
                barri.fumadors[i].join();   
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        barri.estanc.tancarEstanc();
        System.out.println("Estanc tancat");
    }
}
    