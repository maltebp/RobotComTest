import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Connection implements Runnable {

    private Socket socket;

    private BufferedReader in;

    Connection(Socket socket) throws IOException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

    }

    @Override
    public void run() {
        while(true){
            try {
                String input = in.readLine();
                System.out.println("Input: " + input);
                if( input.equals("forward") ){
                    MotorController.start();
                }
                if( input.equals("back") ){
                    MotorController.back();
                }
                if( input.equals("stop") ){
                    MotorController.stop();
                }
                if( input.equals("left") ){
                    MotorController.left();
                }
                if( input.equals("right") ){
                    MotorController.right();
                }
                if( input.equals("spin")){
                    MotorController.spin();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
