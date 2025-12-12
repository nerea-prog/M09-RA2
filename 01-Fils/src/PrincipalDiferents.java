public class PrincipalDiferents {
    public static void main(String[] args) throws Exception {
        System.out.println("Acaba thread main");

        Fil pepe = new Fil("Pepe");
        Fil juan = new Fil("Juan");

        pepe.setPriority(Thread.MIN_PRIORITY);
        juan.setPriority(Thread.MAX_PRIORITY);
        
        pepe.start();
        juan.start();

    }
}
