package vues;

import chocobar.Observateur;
import chocobar.Partie;
import chocobar.PlaqueDeChocolat;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class FinDePartie extends VBox implements Observateur {
    private final Partie partie;
    private final PlaqueDeChocolat plaque;
    private final Label fin;
    public FinDePartie(Partie partie){
        this.partie = partie;
        this.partie.ajouterObservateur(this);
        this.plaque = partie.getPlaque();
        this.fin = new Label();
        this.fin.setText(" Partie en cours");

        this.setStyle("-fx-background-color:#CEF6D8;");
        this.setAlignment(Pos.CENTER);
        this.setLayoutY(10);
        this.getChildren().addAll( this.fin);
    }
    @Override
    public void reagir() {
        if(this.partie.isGameover()){
            this.fin.setText("Fin de la partie");

        }
    }
}
