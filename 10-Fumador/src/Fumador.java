public class Fumador extends Thread {
    private Estanc estanc;
    private long id;
    private Tabac tabac;
    private Llumi llumi;
    private Paper paper;
    private int nFumades;

    public Fumador(long id, Estanc estanc){
        this.estanc = estanc;
        this.id = id;

    }

    public void fuma(){
        System.out.println("Fumador " + id + " fumant");
        if (tabac != null && paper != null && llumi != null) {
            tabac = null;
            llumi = null;
            paper = null;
            try {
                int temps = 500 + (int)(Math.random() * 1000);
                Thread.sleep(temps);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void compraTabac(){
        tabac = estanc.venTabac();
        System.out.println("Fumador " + id + " comprant tabac");
    }

    public void compraPaper(){
        paper = estanc.venPaper();
        System.out.println("Fumador " + id + " comprant paper");
    }

    public void compraLlumi(){
       llumi = estanc.venLlumi();
       System.out.println("Fumador " + id + " comprant llumi");
    }

    @Override
    public void run(){
        for (int i = 0; i < 3; i++) {
            compraLlumi();
            compraTabac();
            compraPaper();
            fuma();
            nFumades++;
            System.out.println("Fumador " + id + " ha fumat " + nFumades + " vegades");
        }
    }
}
