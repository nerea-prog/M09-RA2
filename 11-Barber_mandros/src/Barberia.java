import java.util.LinkedList;
import java.util.Queue;

public class Barberia extends Thread {
    private Queue<Client> cola = new LinkedList<>();
    private int nMaximCadires;
    public Object condBarber = new Object();
    public static Barberia instancia;
    public Barberia(int nMaximCadires){
        this.nMaximCadires = nMaximCadires;
    }

    public synchronized Client seguentClient(){
        return cola.poll();
    }

    public void entrarClient(Client client){
        if (cola.size() < nMaximCadires) {
            cola.add(client);
            System.out.println("Client " + client.getName() + " en espera");
            synchronized(instancia.condBarber){
                instancia.condBarber.notify();
            }
        } else {
            System.out.println("No queden cadires, client " + client.getName() + " se'n va");
        }
    }

    @Override
    public void run(){
        for (int i = 1; i <= 10; i++) {
            entrarClient(new Client(i));
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 11; i <= 20; i++) {
            entrarClient(new Client(i));
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Barberia.instancia = new Barberia(3);
        Barber barber = new Barber("Pepe");
        barber.start();
        Barberia.instancia.start();
    }
}
