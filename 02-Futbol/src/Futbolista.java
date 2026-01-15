public class Futbolista extends Thread {
    
    //Variables
    private int ngols = 0;
    private int ntirades = 0;
    
    // constants
    private static final int NUM_JUGADORS = 11;
    private static final int NUM_TIRADES = 20;
    private static final double PROBABILITAT = 0.5f;
    
    // constructor
    public Futbolista(String nom) {
        super(nom);
        this.ngols = 0;
        this.ntirades = 0;
    }

    //getters i setters
    public int getNgols() {
        return ngols;
    }
    public void setNgols(int ngols) {
        this.ngols = ngols;
    }
    public int getNtirades() {
        return ntirades;
    }
    public void setNtirades(int ntirades) {
        this.ntirades = ntirades;
    }

    @Override
    public void run(){
        // Cada jugador fa les seves tirades
        for (int i = 0; i < NUM_TIRADES; i++) {
            ntirades++;
            if (Math.random() < PROBABILITAT) {
                ngols++;
            }
        }
    }

    public static void main(String[] args) {
        Futbolista[] jugadors = new Futbolista[NUM_JUGADORS];
        
        // Es creen tots els fils i s'inicien tots els fils
        for (int i = 0; i < NUM_JUGADORS; i++) {
            jugadors[i] = new Futbolista("Jugador " + (i + 1));
            jugadors[i].start();
        }

        // S'espera a tots els fils que acabin
        for (int i = 0; i < NUM_JUGADORS; i++) {
            try{
                jugadors[i].join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        //Mostra els resultats

        System.out.println("Inici del xut --------------------");
        System.out.println("Fi del xut -----------------------");
        System.out.println("--- Estadistiques ------");

        for (int i = 0; i < NUM_JUGADORS; i++) {
            System.out.println(jugadors[i].getName() + "\t-> " + jugadors[i].getNgols() + " gols");
        }
    }
}
