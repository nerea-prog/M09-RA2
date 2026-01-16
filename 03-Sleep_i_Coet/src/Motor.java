public class Motor extends Thread {
    private int potenciaObjectiu = 0;
    private int potenciaActual = 0;
    
    public void setPotenciaObjectiu(int potenciaObjectiu) {
        this.potenciaObjectiu = potenciaObjectiu;
        if (potenciaObjectiu > potenciaActual) {
            for (int i = potenciaActual; i < potenciaObjectiu; i++) {
                this.potenciaActual = i;
                int segons = (int) (Math.random() * 1000);
                try{
                    Thread.sleep(segons);
                } catch (Exception e){
                    e.printStackTrace();
                }
                if (potenciaObjectiu == 0 && potenciaActual == 0) {
                    return;
                }
            }
        } else {
            for (int i = potenciaActual; i > potenciaObjectiu; i--) {
                this.potenciaActual = i;
                int segons = (int) (Math.random() * 1000);
                try{
                    Thread.sleep(segons);
                } catch (Exception e){
                    e.printStackTrace();
                }
                if (potenciaObjectiu == 0 && potenciaActual == 0) {
                    return;
                }
            }
        }
    }    
}
