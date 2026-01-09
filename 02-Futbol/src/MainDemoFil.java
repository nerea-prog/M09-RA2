public class MainDemoFil {
    public static void main(String[] args) {
        //Captura el fil actual en execució
        Thread filActual = Thread.currentThread();

        System.out.println("MainDemoFil.main:");
        System.out.println("Prioritat -> " + filActual.getPriority() + ", Nom -> " + filActual.getName());
        System.out.println("toString() -> " + filActual.toString());
    }
}
