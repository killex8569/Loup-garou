import java.util.ArrayList;
/*
Listes des rôles avec leurs fonctionnalités

- Villageois (ne peux rien faire sauf voter)
- Les loup garou (Chaque nuit, Les loup garou se mettent d'accord sur une personne à tuer, s'il y a disparité/hésitation, c'est la majorité qui l'emporte, sinon un joueur au HASARD est désigner (y compris les loup garou inclu))
- Le loup garou Noir (Il peut choisir d'infecter un villageois qui se transformera en loup garou dès lors de la prochaine nuit, il perdra ainsi sont rôle de villageois) A NERF, limiter les infection, les joueurs peuvent choisir lors de la séléctioner de la partie
- Le loup blanc (Ce rôle ne fait partie d'aucun camp, il gagne TOUT SEUL (ni avec les villageois, ni avec les loup-garou), il vote en même temps que les loup garou, une nuit sur deux il peut dévorer un loup garou)
- Le chien-loup (autrement appeler le loup gris) ce dernier peut choisir en début de partie d'être soit un villageois simple, soit un loup-garou
- Le loup bavar (chaque nuit un nouveau mot lui est donné, il doit le dire avant la fin du vote dans la journée sinon il meurt)
- La sorcière (peut voter une nuit pour utiliser sa potion de soin sur un joueur désigner par les loup garou, ou utiliser sa potion de mort. Elle peut utiliser les deux sur une seul nuit)
- La voyante (elle peut chaque nuit regarder la carte d'un joueur)
- Corbeau (Lors de la nuit, il est apeller pour donnée un double vote sur une personne du village, il n epeut pas voter contre le vagabon durant la nuit)
- le guard (aussi appeler le "salvateur", il peut protéger chaque nuit une personne, il ne peut par contre protéger deux fois la même personne chaque nuit)
- Pyromane (chaque nuit il peut soit asperger d'huile une personne, soit mettre le feu, si cette dernière action est choisi, toutes les personnes asperger perdrons la vie)
- Voleur (lors du premier tour, il peut voler le role d'un autre joueur, le joueur qui se vera volé sont rôle deviendra Villageois)
- Le chasseur (Le chasseur lors de sa mort peut tirer une dernière balle sur un joueur pour l'entrainer avec lui dans sa tombe)
- La petite fille (Dans un loup garou en ligne, il est difficile de de jouer ce rôle, mais une indication sur du "mouvement" (car y'aura une sorte de map) sera donner en fonction de la probabilité de ce dernier (et inversement, les loup garou aurons une probabilité de trouver la petite fille)
- Le nécromancien (il peut envoyer un message au mort, et voir la réponse à ce message, les mort devrons faire dans le chat /dead pour indiquer leurs réponse)
- Ange (lors de la première nuit, il désigne une personne qui devra le tuer durant toute la partie, si la personne vote pour participe à sa mot, il gagne et la partie se termine)
- Le renard (il peut flairer 3 personnes, si parmis ce groupe de personnes, au moins une est loup-garou (peu importe le type de loup) il garde sont flaire pour les nuit suivante sinon il perd son flaire et deviens simple villageois)
- Cupidon (lors de la toute première nuit, il désigne deux personnes qui seront en couple, si l'un des deux meurt, l'autre aussi. Si l'un des deux est loup garou, alors l'objectifs de l'autre joueur villageois est de tuer les autres villageois, il ne prend pas partie au vote des loup garou)
- Le juge bègue (Il peut faire une seul fois durant la partie "un signe au MJ" permettant de relancer sans aucun débat un nouveau vote)
- Le montreur d'ours (si le montreur d'ours est à gauche ou à droite d'un loup garou, il grogne. Si il devient un
- l'enfant sauvage (l'enfant sauvage désigne une personne pour être son mentor mais cette personne ne le sais pas, si cette personne meurt, l'enfant sauvage deviens loup garou simple)
- l'Ancien (il possède deux vie pour les vote de nuit, si il est désigner pour mourir la nuit par un loup-garou, il reste envie sans être averti. le matin il se reveil avec les autres mais dévoil sa carte)
- Le bouc émissaire (si le vote des villageois est une égaliter entre deux joueurs, alors c'est le bouc émissaire qui est désigner (même si l'égaliter ne porte pas sur lui). par contre il peut décider qui ne votera pas lors de la prochaines journée / vote (un joueur unique vote, tout le monde est privée de vote, il laisse alors les plein pouvois à ce dernier joueur qui lors du prochains tour peu voter si il passe la nuit...)
- l'idiot du village (s'il est voter par le village, alors il ne meurt pas et peux toujours participer au débat, il ne pourras jsute plus participer au vote)
- le joueur de flûte (il gagne tout seul comme le loup blanc, il peut en fonction du nombre de joueur restant, charmé un ou deux joueurs, si tout le village est charmé, alors il gagne)
- l'abominable sectaire (role solitaire, il gagne seul et doit éliminé le camp adverse, le MJ désigne le camp adverse (par ex. les joueurs imberbes/barbu, Brun/Blond, Lunette/sans lunette etc...) le sectaire fait partie d'un de ces groupe et doit éliminer l'autre groupe.
- le chevalier à l'épée rouiller (ce rôle donne le tétanos au premier loup-garouà sa gauche, si il est manger par les loup garou, il ce dernier mourra aussi la nuit d'après
- Le comédien (lors des 3 premières nuit, le MJ place à la vu de tout le monde 3 cartes de rôles à la vu de tout le monde, une fois la première nuit tomber, le comédien choisi une carte puis l'utilise pour devenir ce rôle, il repête cette opération plusieurs fois tant qu'il est envie, à la fin s'il ne reste plus aucune carte, il deviens simple villageois)
- Le villageois-villageois (sa carte à des deux coté le sigle villageois, donc tout le monde connais sont rôle, il est simple villageois mais tout le monde le sait)
- Les deux soeurs (au début de la partie, le MJ apelle deux joueurs à être les soeurs, elles se connaissent et se font confiances, pendant la nuit, elles peuvent se concerter (30 secondes max)
- Les 3 frères (la même choses que les deux soeurs mais ils sont 3, c'est soit l'un soit l'autre, il ne peut y avoir les deux role en même temps)
-
-
-

## Role pas implémenter du vrai jeu
- La gitane
- La servante dévouée



*/
public class Villager {
    private final int ID;
    private static int compteurId;
    private String name;
    private boolean isDead;
    private String description;
    private boolean isMayor;
    ArrayList<Villager> HistoriqueVote = new ArrayList<>();
    private boolean isRoleStealed; // Role du voleur, si true alors peu importe le role mais il devient villageois
    private boolean isWinWithVillage; // True pour dire qu'il gagne avec le village, false pour dire que non
    private static ArrayList<Villager> listeJoueur = new ArrayList<Villager>();
    private int nbVoteContre;

    public Villager(){
        compteurId ++;
        this.ID = compteurId;
    }

    public Villager(String name, String description, boolean isMayor){
        this();
        this.name = name;
        this.description = description;
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
    public ArrayList<Villager> getHistoriqueVote(){
        return this.HistoriqueVote;
    }
    public int getNbVoteContre(){
        return this.nbVoteContre;
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
        this.nbVoteContre += nbVoteContre;
    }


    // Méthodes

    // Simple villageois
    public void addOneVote(Villager villager){
        villager.setNbVoteContre(1);
    }

    // Corbeau
    public void addTwoVote(Villager villager){
        villager.setNbVoteContre(2);
    }

    public void playerVote(Object personnageVote){
        if (personnageVote instanceof Integer){
            for (Villager e : Villager.listeJoueur){
                if (personnageVote.equals(e.getId())){
                    addOneVote(e);
                }
            }
        }else if (personnageVote instanceof String){
            for (Villager e : Villager.listeJoueur){
                if (personnageVote.equals(e.getName())){
                    addOneVote(e);
                }
            }
        }
    }

    public void playerVoteCorbeau(Object personnageVote){
        if (personnageVote instanceof Integer){
            for (Villager e : Villager.listeJoueur){
                if (personnageVote.equals(e.getId())){
                    addTwoVote(e);
                }
            }
        }else if (personnageVote instanceof String){
            for (Villager e : Villager.listeJoueur){
                if (personnageVote.equals(e.getName())){
                    addTwoVote(e);
                }
            }
        }
    }









}
