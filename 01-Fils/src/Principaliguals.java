public class Principaliguals {
    public static void main(String[] args) throws Exception {
        System.out.println("Acaba thread main");

        Fil juan = new Fil("Juan");
        Fil pepe = new Fil("Pepe");

        pepe.setPriority(Thread.MAX_PRIORITY);
        juan.setPriority(Thread.MAX_PRIORITY);

        pepe.start();
        juan.start();

    }
}