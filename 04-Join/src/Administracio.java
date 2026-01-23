public class Administracio {
    private static final int NUM_POBLACIO_ACTIVA = 50;
    private Treballador[] poblacio_activa = new Treballador[NUM_POBLACIO_ACTIVA];

    public Administracio(){
        for (int i = 0; i < poblacio_activa.length; i++) {
            poblacio_activa[i] = new Treballador(25000f, 20, 
                65, "Ciutadà-" + i);
        }
    }
    public static void main(String[] args) {
        Administracio administracio = new Administracio();
        for (int i = 0; i < administracio.poblacio_activa.length; i++) {
            administracio.poblacio_activa[i].start();
        }
        for (int i = 0; i < administracio.poblacio_activa.length; i++) {
            try {
                administracio.poblacio_activa[i].join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < administracio.poblacio_activa.length; i++) {
            System.out.printf("Ciutadà-%d -> edat: %d / total: %.2f\n", i, administracio.poblacio_activa[i].getEdat(), 
            administracio.poblacio_activa[i].getCobrat());
        }
    }
}
