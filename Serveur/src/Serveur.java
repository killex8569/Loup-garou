import java.net.*;
import java.io.*;

public class Serveur {
    public static void main(String[] args) throws IOException {
        // Écoute sur le port 8080
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Serveur en attente de connexions...");


        while (true) {
            Socket clientSocket = serverSocket.accept(); // bloque jusqu'à connexion
            System.out.println("Client connecté : " + clientSocket.getInetAddress());

            // Flux d'entrée/sortie
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Reçu : " + message);
                out.println("Echo : " + message); // renvoie le message au client
            }

            clientSocket.close();
        }
    }

}