import java.util.Scanner;

public class Coet {
    private Motor[] motors;

    // Constructor que inicializa los motores
    public Coet() {
        motors = new Motor[4];
        for (int i = 0; i < 4; i++) {
            motors[i] = new Motor("Motor " + i);
        }
    }

    // Inicia todos los motores
    public void arranca() {
        for (Motor motor : motors) {
            motor.start();
        }
    }

    // Establece la potencia objetivo para todos los motores
    public void passaPotencia(int p) {
        if (p < 0 || p > 10) {
            System.out.println("Error: la potència ha de ser entre 0 i 10");
            return;
        }
        for (Motor motor : motors) {
            motor.setPotencia(p);
        }
    }
    
    // Espera a que todos los motores terminen
    public void esperarTerminacio() {
        try {
            for (Motor motor : motors) {
                motor.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Coet coet = new Coet();
        coet.arranca();

        Scanner sc = new Scanner(System.in);

        while (true) {
            if (sc.hasNextInt()) {
                int p = sc.nextInt();

                if (p == 0) {
                    System.out.println("Passant a potència " + p);
                    coet.passaPotencia(p);
                    coet.esperarTerminacio();
                    sc.close();
                    System.exit(0);
                }

                System.out.println("Passant a potencia " + p);
                coet.passaPotencia(p);
            }
        }
    }
}



