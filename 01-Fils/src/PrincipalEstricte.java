public class PrincipalEstricte {
    public static void main(String[] args) {
        Fil juan = new Fil("Juan");
        Fil pepe = new Fil("Pepe");

        System.out.println("Termina thread main");

        juan.start();
        pepe.start();
    }
}
