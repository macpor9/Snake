public class Main {

    public static void main(String[] args) {
        App app = new App();
        while (true){
            app.repaint();
            try{
                Thread.sleep(150);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }
}
