public class Motor extends Thread {
    private int potenciaActual = 0;
    private int potenciaObjectiu = 0;
    private boolean treballant = false;

    // Constructor que inicializa el motor con un nombre
    public Motor(String nom) {
        super(nom);
    }
     // Establece la potencia objetivo del motor, synchronized para evitar condiciones del hilo
    public synchronized void setPotencia(int potenciaObjectiu) {
        this.potenciaObjectiu = potenciaObjectiu;
        this.treballant = true;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (treballant) {
                    String accio;
                    if (potenciaActual < potenciaObjectiu) {
                        accio = "Incre.";
                        potenciaActual++;
                    } else if (potenciaActual > potenciaObjectiu) {
                        accio = "Decre.";
                    } else {
                        accio = "FerRes";
                        treballant = false;
                    }

                    if (potenciaActual == potenciaObjectiu && !accio.equals("FerRes")) {
                        accio = "FerRes";
                        treballant = false;
                    }

                    System.out.println(String.format("%s: %s Objectiu: %d Actual: %d",
                        getName(), accio, potenciaObjectiu, potenciaActual));

                    if (potenciaActual > potenciaObjectiu) {
                        potenciaActual--;
                    }

                    if (potenciaActual == potenciaObjectiu && potenciaObjectiu == 0 && !accio.equals("FerRes")) {
                        System.out.println(String.format("%s: FerRes Objectiu: %d Actual: %d",
                            getName(), potenciaObjectiu, potenciaActual));
                        return;
                    }

                    Thread.sleep(1000 + (int)(Math.random() * 1000));
                } else {
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}



