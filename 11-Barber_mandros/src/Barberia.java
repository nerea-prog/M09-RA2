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

    public Client seguentClient(){
        return null;
    }

    public void entrarClient(Client client){

    }

    public static void main(String[] args) {
        
    }

    @Override
    public void run(){

    }
}
