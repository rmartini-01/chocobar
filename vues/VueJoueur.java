package vues;

import chocobar.Joueur;
import chocobar.Partie;
import chocobar.PlaqueDeChocolat;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import chocobar.Observateur;

public class VueJoueur extends VBox implements Observateur {
    private final Label joueur1;
    private final Label joueur2;

    private final Label winner;
    private final Partie partie;
    private PlaqueDeChocolat plaque;

    public VueJoueur(Partie partie){

        this.plaque= partie.getPlaque();
        this.joueur1 = new Label(partie.getJoueur1().getNom());

        this.joueur2 = new Label(partie.getJoueur2().getNom());
        this.joueur1.setVisible(true);
        this.joueur2.setVisible(false);
        this.winner= new Label("Le gagnant est ");
        this.winner.setVisible(false);
        this.getChildren().addAll(this.joueur1, this.joueur2, this.winner);
        this.setStyle("-fx-background-color:#CEF6D8;");

        this.partie = partie;
        this.partie.ajouterObservateur(this);
        this.setAlignment(Pos.CENTER);
    }
    @Override
    public void reagir() {
        if(!this.partie.isGameover()){
            if(partie.isTurn()){
                this.joueur1.setVisible(false);
                this.joueur2.setText( partie.getJoueur2().getNom() + " " + partie.getJoueur2().getScore());
                this.joueur2.setVisible(true);

            }else{
                this.joueur1.setVisible(true);
                this.joueur2.setVisible(false);
                this.joueur1.setText(partie.getJoueur1().getNom() + " "  + partie.getJoueur1().getScore());
            }
        }else{
            this.getWinner();
        }

    }
    public void getWinner(){

        if(this.partie.isGameover() && this.joueur1.isVisible()){
            winner.setText(winner.getText()+this.joueur2.getText());
        }else if (this.partie.isGameover() && this.joueur2.isVisible()){
            winner.setText(winner.getText()+this.joueur1.getText());
        }
        winner.setVisible(true);
    }


}
