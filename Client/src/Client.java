import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int port = 8080;

        // Connexion au serveur (localhost, port 8080)
        Socket socket = new Socket(host, port);

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String ligne;
        while ((ligne = console.readLine()) != null) {
            out.println(ligne);                          // envoie au serveur
            System.out.println(in.readLine());           // affiche la réponse
        }

        socket.close();
    }
}