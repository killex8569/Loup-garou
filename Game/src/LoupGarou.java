import java.util.ArrayList;

public class LoupGarou extends Villager implements IMangerVillaegois {
    private boolean isWhiteWolf;
    private boolean isBlackWolf;
    private boolean isWolf;
    private ArrayList<Villager> HistoriqueVoteLG = new ArrayList<>();

    // Constructeur

    public LoupGarou(){
        super();

    }

    public LoupGarou(String name, boolean isMayor){
        super(name, isMayor);
    }

    // Getter
    @Override
    public String getDescription() {
        return "Un prédateur nocturne. Son but est de dévorer tous les villageois avec ses compères sans se faire prendre.";
    }

    @Override
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
                        voteplayer(e);
                    } else {
                        System.out.println("Le joueur : " + e.getId() + " est déjà mort");
                    }
                    break;
                }
            }
        } else if (villageois instanceof String){
            String nomCible = (String) villageois;
            for (Villager e : Villager.getListeJoueur()){
                if (e.getName().equals(nomCible)) {
                    if (!e.getisDead()) {
                        voteplayer(e);
                    } else {
                        System.out.println("Le joueur : " + e.getName() + " est déjà mort");
                    }
                    break;
                }
            }
        } else {
            System.out.println("Entrée invalide, veuillez ré-essayer");
        }
    }

}

