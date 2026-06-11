import java.net.*;
import java.io.*;
import java.util.Scanner;

// Côté client
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345); // même port que le serveur
        System.out.println("Connecté !");

        // TODO : récupère les flux (mêmes indices que côté serveur)

        // TODO : un Scanner pour lire ce que tu tapes au clavier

        Scanner sc = new Scanner(System.in);
        String texte = sc.nextLine();


        // TODO : boucle :
        //   - lis une ligne tapée
        //   - envoie-la au serveur
        //   - lis la réponse du serveur et affiche-la
        //   - si tu tapes "quit", arrête la boucle
        String Message = "quit";

        while(texte != Message){

        }

    }
}