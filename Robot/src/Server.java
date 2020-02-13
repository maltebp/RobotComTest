
import lejos.hardware.Sound;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    void start() throws IOException {
        System.out.println("Starting MotorController");
        new Thread(new MotorController()).start();
        System.out.println("Started MotorController");

        ServerSocket serverSocket = new ServerSocket(1337);
        System.out.println("Server started");

        while (true) {
            System.out.println("\nListening...");
            Socket clientSocket = serverSocket.accept();
            new Thread(new Connection(clientSocket)).start();
            System.out.println("Client accepted");
            Sound.beepSequence();
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Starting");
        new Server().start();
    }
}
