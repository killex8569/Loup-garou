import java.lang.reflect.Array;
import java.util.ArrayList;
/*
# Liste des rôles avec leurs fonctionnalités

* **Villageois** : Ne peut rien faire sauf voter.
* **Les Loups-Garous** (LG): Chaque nuit, ils se mettent d'accord sur une personne à tuer. S'il y a une égalité ou une hésitation, c'est la majorité qui l'emporte. Sinon, un joueur est désigné au **hasard** (y compris parmi les loups-garous eux-mêmes).
* **Le Loup-Garou Noir** (BLG): Il peut choisir d'infecter un villageois qui se transformera en loup-garou dès la nuit suivante, perdant ainsi son rôle de villageois.
  > *Note de dev : À NERF. Limiter les infections, ou permettre aux joueurs de paramétrer cette option lors de la sélection de la partie.*
* **Le Loup Blanc** (WLG): Ce rôle ne fait partie d'aucun camp. Il gagne **tout seul** (ni avec les villageois, ni avec les loups-garous). Il vote en même temps que les loups-garous, et une nuit sur deux, il peut dévorer l'un d'eux.
* **Le Chien-Loup** (WDLG) (autrement appelé le Loup Gris) : Ce dernier peut choisir en début de partie d'être soit un simple villageois, soit un loup-garou.
* **Le Loup Bavard** (BALG): Chaque nuit, un nouveau mot lui est donné. Il doit le prononcer avant la fin du vote de la journée, sinon il meurt.
* **La Sorcière** (WIT) : Peut voter une fois par nuit pour utiliser sa potion de soin sur un joueur désigné par les loups-garous, ou utiliser sa potion de mort. Elle peut utiliser les deux durant la même nuit.
* **La Voyante** (VOY) : Elle peut, chaque nuit, regarder la carte d'un joueur.
* **Le Corbeau** (COR) : Durant la nuit, il est appelé pour attribuer un double vote contre une personne du village. Il ne peut pas voter contre le Vagabond pendant la nuit.
* **Le Garde** (aussi appelé le "Salvateur") (GUA) : Il peut protéger une personne chaque nuit. En revanche, il ne peut pas protéger la même personne deux nuits de suite.
* **Le Pyromane** (PYR): Chaque nuit, il peut soit asperger d'huile une personne, soit y mettre le feu. Si cette dernière action est choisie, toutes les personnes aspergées perdent la vie.
* **Le Voleur** (THI): Lors du premier tour, il peut voler le rôle d'un autre joueur. Le joueur qui se fait voler son rôle devient alors un simple Villageois.
* **Le Chasseur** (HUN): Lors de sa mort, le chasseur peut tirer une dernière balle sur un joueur pour l'entraîner avec lui dans sa tombe.
* **La Petite Fille** : Dans un jeu de Loup-Garou en ligne, il est difficile de jouer ce rôle. Une indication sur le "mouvement" (car il y aura une sorte de carte) sera donnée en fonction d'une probabilité. Inversement, les loups-garous auront une probabilité de débusquer la Petite Fille.
* **Le Nécromancien** : Il peut envoyer un message aux morts et voir leurs réponses. Pour répondre, les morts devront taper `/dead` dans le chat.
* **L'Ange** : Lors de la première nuit, il désigne une personne qui devra le tuer durant la partie. Si cette personne vote ou participe à sa mort, l'Ange gagne et la partie se termine.
* **Le Renard** : Il peut flairer un groupe de 3 personnes. Si parmi ce groupe se trouve au moins un loup-garou (peu importe le type), il garde son pouvoir pour les nuits suivantes. Sinon, il perd son flair et devient un simple villageois.
* **Cupidon** : Lors de la toute première nuit, il désigne deux personnes qui seront en couple. Si l'un des deux meurt, l'autre meurt aussi. Si l'un des deux est un loup-garou, alors l'objectif de l'autre joueur (s'il est villageois) change : il doit tuer tous les autres villageois. Il ne prend pas part au vote nocturne des loups-garous.
* **Le Juge Bègue** : Il peut, une seule fois durant la partie, "faire un signe au MJ" permettant de relancer un nouveau vote immédiatement, sans aucun débat.
* **Le Montreur d'Ours** : Si le montreur d'ours se trouve à gauche ou à droite d'un loup-garou, son ours grogne le matin. *(Note : votre phrase initiale était coupée ici).*
* **L'Enfant Sauvage** : L'Enfant Sauvage désigne un joueur pour être son mentor, mais ce dernier n'est pas au courant. Si le mentor meurt, l'Enfant Sauvage devient un loup-garou simple.
* **L'Ancien** : Il possède deux vies face aux attaques nocturnes. S'il est désigné pour mourir la nuit par un loup-garou, il reste en vie sans en être averti. Le matin, il se réveille avec les autres mais doit dévoiler sa carte.
* **Le Bouc Émissaire** : Si le vote des villageois se termine par une égalité entre deux joueurs, c'est le Bouc Émissaire qui est désigné pour mourir (même si l'égalité ne porte pas sur lui). En contrepartie, il peut décider qui n'aura pas le droit de voter lors de la prochaine journée. S'il choisit de priver tout le monde de vote sauf un joueur unique, il laisse alors les pleins pouvoirs à ce dernier (qui pourra voter au prochain tour s'il survit à la nuit).
* **L'Idiot du Village** : S'il est éliminé par le vote du village, il ne meurt pas. Il peut toujours participer aux débats, mais il perd définitivement son droit de vote.
* **Le Joueur de Flûte** : Il gagne tout seul, comme le Loup Blanc. Chaque nuit, il peut charmer un ou deux joueurs (selon le nombre de survivants). Si tout le village en vie est charmé, il remporte la partie.
* **L'Abominable Sectaire** : Rôle solitaire. Il gagne seul et doit éliminer le camp adverse. Le MJ désigne le camp adverse en début de partie (par exemple : les joueurs imberbes vs barbus, bruns vs blonds, lunettes vs sans lunettes, etc.). Le sectaire fait partie de l'un de ces groupes et doit éliminer l'autre.
* **Le Chevalier à l'Épée Rouillée** : Ce rôle donne le tétanos au premier loup-garou situé à sa gauche. S'il est dévoré par les loups-garous, ce dernier mourra la nuit suivante.
* **Le Comédien** : Lors des 3 premières nuits, le MJ place 3 cartes de rôles face visible au vu de tout le monde. Une fois la nuit tombée, le comédien choisit une carte et s'approprie ce rôle pour la journée. Il répète cette opération tant qu'il est en vie. S'il ne reste plus de cartes, il devient un simple villageois.
* **Le Villageois-Villageois** : Sa carte affiche le symbole villageois des deux côtés, son rôle est donc connu de tous. C'est un simple villageois, mais sa confiance est publiquement établie.
* **Les Deux Sœurs** : Au début de la partie, le MJ appelle deux joueuses pour être les Sœurs. Elles se connaissent et se font mutuellement confiance. Pendant la nuit, elles peuvent se concerter (30 secondes maximum).
* **Les Trois Frères** : Même principe que les Deux Sœurs, mais ils sont trois. C'est soit l'un, soit l'autre rôle qui est présent dans la partie, il ne peut pas y avoir les deux en même temps.

## Rôles non implémentés du vrai jeu
* La Gitane
* La Servante Dévouée



*/

public class Villager implements Vote {
    private final int ID;
    private static int compteurId;
    private String name;
    private boolean isDead;
    private String description = "Ne peut rien faire sauf voter";
    private boolean isMayor;
    private ArrayList<String> HistoriqueVote = new ArrayList<>();
    private boolean isRoleStealed; // Role du voleur, si true alors peu importe le role mais il devient villageois
    private boolean isWinWithVillage; // True pour dire qu'il gagne avec le village, false pour dire que non
    private static ArrayList<Villager> listeJoueur = new ArrayList<Villager>();
    private int nbVoteContre;
    private Villager lastPlayervoted;

    public Villager(){
        compteurId ++;
        this.ID = compteurId;
    }

    public Villager(String name, boolean isMayor){
        this();
        this.name = name;
        this.isMayor = isMayor;
        listeJoueur.add(this);
    }

    // Getter

    public int getId(){
        return this.ID;
    }
    public String getName(){
        return this.name;
    }
    public String getDescription(){
        return this.description;
    }
    public boolean getisDead(){
        return this.isDead;
    }
    public boolean getisMayor(){
        return this.isMayor;
    }
    public ArrayList<String> getHistoriqueVote(){
        return this.HistoriqueVote;
    }
    public int getNbVoteContre(){
        return this.nbVoteContre;
    }
    public boolean isRoleStealed(){
        return this.isRoleStealed;
    }
    public boolean isWinWithVillage(){
        return this.isWinWithVillage;
    }
    public Villager getLastPlayervoted(){
        return this.lastPlayervoted;
    }

    // Setter

    public void setName(String name){
        this.name = name;
    }
    public void setDead(boolean isDead){
        this.isDead = isDead;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setMayor(boolean isMayor){
        this.isMayor = isMayor;
    }
    public void setRoleStealed(boolean isRoleStealed){
        this.isRoleStealed = isRoleStealed;
    }
    public void setWinWithVillage(boolean isWinWithVillage){
        this.isWinWithVillage = isWinWithVillage;
    }
    public void setNbVoteContre(int nbVoteContre){
        this.nbVoteContre = nbVoteContre;
    }
    public void addNbVoteContre(int nbVoteContre){
        this.nbVoteContre += nbVoteContre;
    }
    public void setHistoriqueVote(ArrayList<String> HistoriqueVote){
        this.HistoriqueVote = HistoriqueVote;
    }
    public void setIsRoleStealed(boolean isRoleStealed){
        this.isRoleStealed = isRoleStealed;
    }
    public void setIsWinWithVillage(boolean isWinWithVillage){
        this.isWinWithVillage = isWinWithVillage;
    }


    // Méthodes

    @Override
    public void addPlayerVotedToHistorique(Villager villager){
        this.HistoriqueVote.add(villager.getName());
    }

    // Simple villageois
    @Override
    public void voteplayer(Villager villager){
        villager.addNbVoteContre(1);
        addPlayerVotedToHistorique(villager);
        this.lastPlayervoted = villager;
    }


    // Classe ou le joueur choisi le joueur pour lequel il souhaite voter
    @Override
    public void playerVoteByNameOrID(Object personnageVote){
        if (personnageVote instanceof Integer){
            for (Villager e : Villager.listeJoueur){
                if (personnageVote.equals(e.getId())){
                    voteplayer(e);
                }
            }
        }else if (personnageVote instanceof String){
            for (Villager e : Villager.listeJoueur){
                if (personnageVote.equals(e.getName())){
                    voteplayer(e);
                }
            }
        }
    }


    public static void ifEqualityBetweenPlayer(){
        int maxVote = 0;
        Villager player;
        ArrayList<Villager> listeEgaliter = new ArrayList<>();
        Villager playerMayor = null;
        for (Villager e : Villager.listeJoueur){
            if (maxVote < e.getNbVoteContre()){
                player = e;
                maxVote = e.getNbVoteContre();
            }
            if (e.isMayor){
                playerMayor = e;
            }
        }
        for (Villager e : Villager.listeJoueur){
            if (e.getNbVoteContre() == maxVote){
                listeEgaliter.add(e);
            }
        }
        if (listeEgaliter.size() > 1){
            if (playerMayor != null){
                for (Villager e : listeEgaliter){
                    if (playerMayor.getLastPlayervoted().equals(e)){
                        playerMayor.playerVoteByNameOrID(e.getName());
                        System.out.println("Le joueur " + e.getName() + " est éliminé sur une égalité avec le vote du maire!");
                    }
                }
            }
        } else {
            System.out.println("Pas d'égaliter, le joueur est éliminé : " + listeEgaliter.get(0).getName());
        }


    }


    @Override
    public String toString(){
        return "\n -----------------------------------" +
                "\nName : " + this.name +
                "\nRole : Villageois" +
                "\nID : " + this.ID +
                "\nDescription : " + this.description +
                "\nest Mort : " + this.isDead + "\n" +
                "\nest Maire : " + this.isMayor +
                "\nHistorique des votes : " +this.HistoriqueVote +
                "\n -----------------------------------";
    }









}
