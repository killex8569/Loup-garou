import java.util.ArrayList;

public class LoupGarou extends Villager {
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
        return "Un prédateur nocturne. Son but est de dévorer tous les villageois sans se faire prendre.";
    }


}
