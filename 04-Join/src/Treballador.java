import java.util.Random;

public class Treballador extends Thread {
    private final float SOU_ANUAL_BRUT; 
    private int edat_inici_treball;
    private int edat_fi_treball;
    private int edat_actual;
    private float cobrat;
    Random rnd;

    public Treballador(float sou_anual_brut, 
        int edat_inici_treball, 
        int edat_fi_treball, String nom){
        super(nom);
        this.SOU_ANUAL_BRUT = sou_anual_brut;
        this.edat_inici_treball = edat_inici_treball;
        this.edat_fi_treball = edat_fi_treball;
        this.edat_actual = 0;
        this.cobrat = 0.0f;
        this.rnd = new Random();
    }
    public void cobra(){
        float souMensual = SOU_ANUAL_BRUT / 12;
        this.cobrat += souMensual;
    }

    public void pagaImpostos(){
        float impost = (SOU_ANUAL_BRUT / 12) * 0.24f;
        this.cobrat -= impost;
    }

    @Override
    public void run(){
        for(int i = edat_inici_treball; i < edat_fi_treball; i++){
            for (int j = 1; j <= 12; j++) {
                try {
                    int delay = rnd.nextInt(100);
                    Thread.sleep(delay);
                } catch (Exception e) {
                    Thread.currentThread().interrupt();                }
                cobra();
                pagaImpostos();
            }
        }
        edat_actual = edat_fi_treball;
    }

    public int getEdat() {
        return edat_actual;
    }

    public float getCobrat() {
        return cobrat;
    }    
}
