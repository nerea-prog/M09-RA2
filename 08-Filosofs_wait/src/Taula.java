public class Taula {
    private Filosof[] filosofs;
    private Forquilla[] forquilles;
    private Forquilla[] forquillesEsquerra;
    private Forquilla[] forquillesDreta;

    public Taula(int numeroFilosofs) {
        forquilles = new Forquilla[numeroFilosofs];
        for (int i = 0; i < numeroFilosofs; i++) {
            forquilles[i] = new Forquilla(i);
        }
        filosofs = new Filosof[numeroFilosofs];
        forquillesEsquerra = new Forquilla[numeroFilosofs];
        forquillesDreta = new Forquilla[numeroFilosofs];
        for (int i = 0; i < numeroFilosofs; i++) {
            Forquilla forquillaEsquerra = forquilles[i];
            Forquilla forquillaDreta = forquilles[(i + 1) % numeroFilosofs];
            filosofs[i] = new Filosof(i, forquillaDreta, forquillaEsquerra);
            forquillesEsquerra[i] = forquillaEsquerra;
            forquillesDreta[i] = forquillaDreta;
        }
    }

    public void showTaula() {
        for (int i = 0; i < filosofs.length; i++) {
            System.out.println("Comensal: " + filosofs[i].getName() + " esq:" + forquillesEsquerra[i].getNumeroForquilla() + " dret:" + forquillesDreta[i].getNumeroForquilla());
        }
    }

    public void cridarATaula() {
        for (Filosof filosof : filosofs) {
            filosof.start();
        }
    }

    public static void main(String[] args) {
        Taula taula = new Taula(5);
        taula.showTaula();
        taula.cridarATaula();
    }
}