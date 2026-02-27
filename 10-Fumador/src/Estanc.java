import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Estanc implements Runnable {
    private List<Tabac> tabacs;
    private List<Llumi> llumins;
    private List <Paper> papers;
    private boolean obert;

    public Estanc(){
        tabacs = new ArrayList<>();
        llumins = new ArrayList<>();
        papers = new ArrayList<>();
        obert = true;
    }
    
    public synchronized void nouSubministrament(){
        Random random = new Random();
        int opcio = random.nextInt(3);
        switch (opcio) {
            case 0:
                addTabac();
                break;
            case 1: 
                addLlumi();
                break;
            case 2:
                addPaper();
                break;
        }
    }

    public synchronized void addTabac(){
        tabacs.add(new Tabac());
        notifyAll();
    }

    public synchronized void addLlumi(){
        llumins.add(new Llumi());
        notifyAll();
    }

    public synchronized void addPaper(){
        papers.add(new Paper());
        notifyAll();
    }

    public synchronized Tabac venTabac(){
        while (tabacs.isEmpty()) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return tabacs.remove(0);
    }

    public synchronized Paper venPaper(){
        while (papers.isEmpty()) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return papers.remove(0);

    }

    public synchronized Llumi venLlumi(){
        while (llumins.isEmpty()) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return llumins.remove(0);

    }

    public void tancarEstanc(){
        obert = false;
    }

    @Override
    public void run(){
        while(obert){
            nouSubministrament();
            try{
                int temps = 500 + (int)(Math.random() * 1000);
                Thread.sleep(temps);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
