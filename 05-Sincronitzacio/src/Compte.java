public class Compte {
    private float saldo = 0.0f;
    private static Compte instancia;

    private Compte(){
        this.saldo = 0;
    }

    public static Compte getInstancia(){
        if (instancia == null){
            instancia = new Compte();
        }
        return instancia;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
}
