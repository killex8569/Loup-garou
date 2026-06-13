import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        Villager villageois1 = new Villager("Alexandre", false);
        Villager villageois2 = new Villager("Killex8569", false);
        Villager villageois3 = new Villager("Nicolas", true);
        LoupGarou loupGarou1 = new LoupGarou("Jean", false);
        LoupGarou loupGarou2 = new LoupGarou("Alice", false);
        Villager villageois4 = new Villager("Bob", false);

        for (Villager e : Villager.getListeJoueur()){
            System.out.println(e.getName() + " ID : " + e.getId());
        }

        System.out.println("\nVOTE DES JOUEURS (JOURS)\n-------------------------\n");
        villageois1.playerVoteByNameOrID("Killex8569");
        villageois3.playerVoteByNameOrID("Alexandre");
        villageois2.playerVoteByNameOrID(3);
        loupGarou1.playerVoteByNameOrID(4);
        System.out.println("-------------------------\n\nVERIFICATION du grand perdant\n-------------------------");

        Villager.ifEqualityBetweenPlayer();


        // Nombre de vote pour chaque joueur + reset des votes à la fin du tour
        System.out.println("----");

        for (Villager e : Villager.getListeJoueur()){
            System.out.println("Nombre de vote pour le joueur : " + e.getName() + " : " + e.getNbVoteContre());
        }
        System.out.println("Reset des vote");
        Villager.resetNbVoteContre();
        for (Villager e : Villager.getListeJoueur()){
            System.out.println("Nombre de vote pour le joueur : " + e.getName() + " : " + e.getNbVoteContre());
        }


        // La nuit les votes des loup garou

        System.out.println("\nVOTE DES LOUP GAROU (NUIT)\n-------------------------\n");
        loupGarou1.mangerVillageois("Alexandre");
        loupGarou2.mangerVillageois("Killex8569");


        System.out.println("\nHISTORIQUE DES VOTES DES JOUEURS\n-------------------------\n");
        // Historique de vote
        for (Villager e : Villager.getListeJoueur()){
            System.out.println("Historique de vote du joueur : " + e.getName() + " --> " + e.getHistoriqueVote());
        }
        System.out.println("\nHISTORIQUE DES VOTES DES LOUP GAROU (NUIT)\n-------------------------\n");

        for (LoupGarou e : LoupGarou.getListeJoueurLG()){
            System.out.println("Historique de vote du Loup Garou : " + e.getName() + " : " + e.getHistoriqueVoteLG());
        }



        // Print tout les joueurs avec leurs rôles
        for (Villager e : Villager.getListeJoueur()){
            System.out.println(e.toString());
        }
    }
}
