public class Fumador implements Runnable {
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
    }

    public void compraPaper(){
        paper = estanc.venPaper();
    }

    public void compraLlumi(){
       llumi = estanc.venLlumi();
    }

    @Override
    public void run(){
        for (int i = 0; i < 3; i++) {
            compraLlumi();
            compraTabac();
            compraPaper();
            fuma();
            nFumades++;
        }
    }
}
