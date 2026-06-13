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

        System.out.println("\n-------------------------\n");
        villageois1.playerVoteByNameOrID("Killex8569");
        villageois3.playerVoteByNameOrID("Alexandre");
        villageois2.playerVoteByNameOrID(3);
        loupGarou1.playerVoteByNameOrID(4);

        Villager.ifEqualityBetweenPlayer();


        // Historique de vote
        for (Villager e : Villager.getListeJoueur()){
            System.out.println("Historique de vote du joueur : " + e.getName() + " --> " + e.getHistoriqueVote());
        }

        // Print tout les joueurs avec leurs rôles
        for (Villager e : Villager.getListeJoueur()){
            System.out.println(e.toString());
        }
    }
}
