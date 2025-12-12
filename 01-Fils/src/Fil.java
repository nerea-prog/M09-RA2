public class Fil extends Thread {
    private int repeticions;

    public Fil(String nom){
        super(nom);
    }

    @Override
    public void run(){
        for (int i = 1; i <= repeticions; i++) {
            System.out.println(getName() + " " + i);

            for (int j = 0; j < 1000; j++) {
                
            }
        }
        System.out.println("Acaba el fil " + getName());
    }

}
