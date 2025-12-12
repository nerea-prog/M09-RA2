public class PrincipalEstricte {
    public static void main(String[] args) {
        System.out.println("Termina thread main");
        Fil juan = new Fil("Juan") {
            @Override
            public void run()  {
                for (int i = 1; i <= 9; i++) {
                    System.out.println(getName() + " " + i);
                    try {
                      Thread.sleep(1);   
                    } catch (Exception e) {}
                }
                System.out.println("Termina el fil " + getName());
            }
        };

        Fil pepe = new Fil("Pepe"){
            @Override
            public void run(){
                for (int i = 1; i <= 9; i++) {
                    System.out.println(getName() + " " + i);
                    try {
                        Thread.sleep(1);
                    } catch (Exception e) {}
                }
                System.out.println("Termina el fil " + getName());
            }
        };
        
        juan.start();
        pepe.start();
    }
}
