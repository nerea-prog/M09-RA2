public class Organitzador {
    private Esdeveniment esdeveniment = new Esdeveniment(5);
    private Assistent[] assistents = new Assistent[10];

    public static void main(String[] args) {
        Organitzador organitzador = new Organitzador();
        for (int i = 0; i < 10; i++) {
            organitzador.assistents[i] = new Assistent("Assistent-" + i, organitzador.esdeveniment);
            organitzador.assistents[i].start();
        }
    }
}
