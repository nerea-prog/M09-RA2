import java.time.Duration;
import java.time.LocalDateTime;

public class DormAleatori extends Thread {

    private LocalDateTime creacioInstancia;
    
    public DormAleatori(String name) {
        super(name);
        this.creacioInstancia = LocalDateTime.now();
    }

    @Override
    public void run(){
        for(int i = 0; i < 10; i++){
            int numAleatori = (int) (Math.random() * 1000);
            LocalDateTime instanciaActual = LocalDateTime.now();
            System.out.println(getName() + "(" + i + ")" + " a dormir " + numAleatori
             + "ms total       " + Duration.between(creacioInstancia, instanciaActual).toMillis() + "ms");
             try{
                Thread.sleep(numAleatori);
             } catch (Exception e){
                e.printStackTrace();
             }
        }
    }

    public static void main(String[] args) {
        DormAleatori joan = new DormAleatori("joan");
        DormAleatori pepe = new DormAleatori("pepe");
        joan.start();
        pepe.start();
        System.out.println("-- Fi del main -----------");
    }
}
