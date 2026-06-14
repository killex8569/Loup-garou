import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class LoupGarou extends Villager implements IMangerVillaegois {
    private boolean isWhiteWolf;
    private boolean isBlackWolf;
    private boolean isWolf;
    private ArrayList<String> HistoriqueVoteLG = new ArrayList<>();
    private static ArrayList<LoupGarou> listeJoueurLG = new ArrayList<>();

    // Constructeur

    public LoupGarou(){
        super();

    }

    public LoupGarou(String name, boolean isMayor){

        super(name, isMayor);
        listeJoueurLG.add(this);
    }

    // Getter

    public boolean getIsWhiteWolf(){
        return this.isWhiteWolf;
    }
    public boolean getIsBlackWolf(){
        return this.isBlackWolf;
    }
    public boolean getIsWolf(){
        return this.isWolf;
    }
    public static ArrayList<LoupGarou> getListeJoueurLG(){
        return listeJoueurLG;
    }
    public ArrayList<String> getHistoriqueVoteLG(){
        return this.HistoriqueVoteLG;
    }


    // Setter
    public void setWhiteWolf(boolean isWhiteWolf){
        this.isWhiteWolf = isWhiteWolf;
    }
    public void setBlackWolf(boolean isBlackWolf){
        this.isBlackWolf = isBlackWolf;
    }
    public void setWolf(boolean isWolf){
        this.isWolf = isWolf;
    }



    @Override
    public String getDescription() {
        return "Un prédateur nocturne. Son but est de dévorer tous les villageois avec ses compères sans se faire prendre.";
    }

    public void addPlayerVotedToHistoriqueLG(Villager villager){
        this.HistoriqueVoteLG.add(villager.getName());
    }


    public void voteplayerLG(Villager villager){
        villager.addNbVoteContre(1);
        addPlayerVotedToHistoriqueLG(villager);
        this.setlastPlayervoted(villager);
        System.out.println(this.getName() + " a voté pour : " + villager.getName());
    }


    public static void ifEqualityBetweenPlayerLG(){
        int maxVote = 0;
        Villager player;
        ArrayList<Villager> listeEgaliter = new ArrayList<>();
        Villager playerMayor = null;
        for (Villager e : Villager.getListeJoueur()){
            if (maxVote < e.getNbVoteContre()){
                player = e;
                maxVote = e.getNbVoteContre();
            }
            if (e.getisMayor()){
                playerMayor = e;
            }
        }
        for (Villager e : Villager.getListeJoueur()){
            if (e.getNbVoteContre() == maxVote){
                listeEgaliter.add(e);
            }
        }
        int tailleListeEgaliter = listeEgaliter.size();
        if (tailleListeEgaliter > 1){
            int randomKillPlayer = ThreadLocalRandom.current().nextInt(0, tailleListeEgaliter + 1);
            Villager villageoisDesigner = listeEgaliter.get(randomKillPlayer);
            villageoisDesigner.setDead(true);
            System.out.println("Le joueur " + villageoisDesigner.getName() + " est éliminé sur une égalité de manière aléatoire !");
        } else {
            Villager villageoisMort = listeEgaliter.get(0);
            villageoisMort.setDead(true);
            System.out.println("Pas d'égaliter, le joueur est éliminé : " + villageoisMort.getName());
        }
    }


    public void mangerVillageois(Object villageois){
        if (this.getisDead()){
            System.out.println("Vous ne pouvez pas voter, vous êtes mort...");
            return;
        }

        if (villageois instanceof Integer){
            int idCible = (Integer) villageois;
            for (Villager e : Villager.getListeJoueur()){
                if (e.getId() == idCible) {
                    if (!e.getisDead()) {
                        voteplayerLG(e);
                    } else {
                        System.out.println("Le joueur : " + e.getId() + " est déjà mort, vous ne pouvez pas voter pour lui");
                    }
                    break;
                }
            }
        } else if (villageois instanceof String){
            String nomCible = (String) villageois;
            for (Villager e : Villager.getListeJoueur()){
                if (e.getName().equals(nomCible)) {
                    if (!e.getisDead()) {
                        voteplayerLG(e);
                    } else {
                        System.out.println("Le joueur : " + e.getName() + " est déjà mort, vous ne pouvez pas voter pour lui");
                    }
                    break;
                }
            }
        } else {
            System.out.println("Entrée invalide, veuillez ré-essayer");
        }
    }


}

