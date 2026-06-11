import java.net.*;
import java.io.*;
// Côté serveur
public class Serveur {
    public static void main(String[] args) throws IOException {
        int port = 12345; // un port libre au-dessus de 1024

        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("En attente d'un client...");

        Socket clientSocket = serverSocket.accept(); // <- bloque ici tant que personne ne se connecte
        System.out.println("Client connecté !");

        // TODO : récupère les flux du socket
        //   Indice : pour LIRE du texte ligne par ligne depuis
        //            clientSocket.getInputStream(), il faut enchaîner
        //            InputStreamReader puis BufferedReader.
        //   Indice : pour ÉCRIRE, PrintWriter peut envelopper directement
        //            un OutputStream — regarde le constructeur à 2 arguments
        //            (avec le booléen autoFlush).

        // TODO : boucle "tant que le client n'a pas envoyé quit"
        //   - lis une ligne (readLine)
        //   - renvoie une réponse au client

        // TODO : ferme proprement (flux + socket)
        //   Indice : regarde try-with-resources, ça ferme tout
        //            automatiquement même en cas d'erreur.
    }
}