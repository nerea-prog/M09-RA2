public class Client extends Thread {
    public Client(int id){
        super("Client-" + id);
    }
    public void tallarseCabell(){
        try {
            int temps = 900 + (int)(Math.random() * 100);
            Thread.sleep(temps);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Tallant cabell a " + getName());
    }
    public String getNom() {
        return getName();
    }
    
}
