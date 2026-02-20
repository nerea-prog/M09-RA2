import java.util.concurrent.locks.ReentrantLock;

public class Forquilla {

    private int num;
    private ReentrantLock bloqueig;

    public Forquilla(int num) {
        this.num = num;
        this.bloqueig = new ReentrantLock();
    }

    public int getNum() {
        return num;
    }

    public void agafar(String nomFilosof) {
        bloqueig.lock();
        System.out.println(nomFilosof + " agafa la forquilla " + num);
    }

    public void deixar(String nomFilosof) {
        System.out.println(nomFilosof + " deixa la forquilla " + num);
        bloqueig.unlock();
    }
}