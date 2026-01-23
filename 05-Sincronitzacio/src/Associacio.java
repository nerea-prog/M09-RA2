public class Associacio {
    private int numSocis = 1000;
    Soci[] socis = new Soci[numSocis];
    public Associacio(){
        for (int i = 0; i < socis.length; i++) {
            socis[i] = new Soci("Soci-" + i);
        }
    }

    public void iniciaCompteTempsSocis(){
        Compte.getInstancia();
    }

    public void esperaPeriodeSocis(){
        for (int i = 0; i < socis.length; i++) {
            socis[i].start();
        }
    }

    public void mostraBalancComptes(){
        for (int i = 0; i < socis.length; i++) {
            try{
                socis[i].join();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        Compte compte = Compte.getInstancia();
        System.out.println("Saldo: " + compte.getSaldo());
    }
    public static void main(String[] args) {
        Associacio associacio = new Associacio();
        associacio.iniciaCompteTempsSocis();
        associacio.esperaPeriodeSocis();
        associacio.mostraBalancComptes();
    }
}
