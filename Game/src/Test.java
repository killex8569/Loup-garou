import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        Villager villageois1 = new Villager("Alexandre", false);
        Villager villageois2 = new Villager("Killex8569", false);
        Villager villageois3 = new Villager("Nicolas", true);


        System.out.println("Alexandre ID : " + villageois1.getId());
        System.out.println("killex ID : " + villageois2.getId());
        System.out.println("Nicolas ID : " + villageois3.getId());

        villageois1.playerVoteByNameOrID("Killex8569");
        villageois3.playerVoteByNameOrID("Alexandre");
        villageois2.playerVoteByNameOrID(3);

        Villager.ifEqualityBetweenPlayer();

        System.out.println("killex nb vote : " + villageois2.getNbVoteContre());
        System.out.println("Alexandre nb vote : " + villageois1.getNbVoteContre());
        System.out.println("Nicolas nb vote : " + villageois3.getNbVoteContre());
        System.out.println("Historique de vote du JOUEUR 1" + villageois1.getHistoriqueVote());
        System.out.println("Historique de vote du JOUEUR 2" + villageois2.getHistoriqueVote());
        System.out.println("Historique de vote du JOUEUR 3" + villageois3.getHistoriqueVote());

        System.out.println(villageois1.toString());



    }
}
