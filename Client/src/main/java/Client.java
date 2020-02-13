import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.43.130", 1337);
        System.out.println("Connected to host");
        Scanner scan = new Scanner(System.in);

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        //BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        while(true){
            String input = scan.nextLine();
            System.out.println("input");
            out.println(input);
        }

    }

}