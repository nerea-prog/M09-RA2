public class Client extends Thread {
    private String nom;
    public Client(int id){
        nom = "Client-" + id;
    }
    public void tallarseCabell(){
        System.out.println("Tallant cabell a " + nom);
    }
    public String getNom() {
        return nom;
    }
    
}
