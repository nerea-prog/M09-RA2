public class Barber extends Thread {
    public Barber(String nom){
        super(nom);
    }

    @Override
    public void run(){
        while (true) {
            Client client = Barberia.instancia.seguentClient();
            if (client != null) {
                System.out.println("Li toca al client " + client.getName());
                client.tallarseCabell();
            } else {
                synchronized(Barberia.instancia.condBarber){
                    System.out.println("Ningú en espera");
                    try {
                        System.out.println("Barber " + getName() + " dormint");
                        Barberia.instancia.condBarber.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}
