package chocobar;

import vues.PlateauDeJeu;

import java.util.ArrayList;
public class Partie {
private ArrayList<Observateur> observateurs = new ArrayList<>(10);
private PlaqueDeChocolat plaque;
    private boolean gameover;
    protected Joueur joueur1;
    protected Joueur joueur2;
    protected boolean nouvellePartie;
    private boolean turn;

    public Partie(){
        plaque = new PlaqueDeChocolat();
        joueur1 = new Joueur("Lenôtre ");
        joueur2 = new Joueur("Loiseau ");
        if(getPlaque().isFinDePartie()){
            gameover= true;
        }else{
            gameover= false;
        }
        nouvellePartie = true;
        turn = true;
    }
    public void ajouterObservateur(Observateur obs){
        this.observateurs.add(obs);
    }
    public void modifierPlateau(PlateauDeJeu plateau, int nouvelleTaille){
        plateau.setTaille(nouvelleTaille);
        this.prevenirObservateurs();
    }
    public void croquer(int i, int j){
        //si on croque le burger
        if (i == 0 && j == 0){
            plaque.setPlaqueFalse(0, 0);
            gameover = true;
        }else{
            //si on croque des chocolats
            if(plaque.getCarre(i,j)){
                plaque.setPlaqueFalse(i, j);
                if(turn){
                    this.joueur1.setScore(this.joueur1.getScore()+ plaque.getCarreMange()) ;
                }
                else{
                    this.joueur2.setScore(this.joueur2.getScore()+ plaque.getCarreMange()) ;
                }
            }
        }
        plaque.setCarreMange(0);
        switchTurns();
        this.prevenirObservateurs();
    }

    public PlaqueDeChocolat getPlaque() {
        return plaque;
    }
    public boolean isGameover() {
        return gameover;
    }
    public void prevenirObservateurs(){
        for(Observateur o: this.observateurs){
         o.reagir();
        }
    }
    public void restart(){
        plaque.setPlaqueTrue();
        this.getJoueur1().setScore(0);
        this.getJoueur2().setScore(0);
        this.prevenirObservateurs();

    }
    public boolean isTurn() {
        return turn;
    }

    public void switchTurns(){
        turn = !turn;
    }

    public Joueur getJoueur1() {
        return joueur1;
    }

    public Joueur getJoueur2() {
        return joueur2;
    }
}
