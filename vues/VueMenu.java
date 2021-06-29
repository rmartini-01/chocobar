package vues;

import chocobar.Observateur;
import chocobar.Partie;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import listener.NomListener;
import listener.RestartListener;

public class VueMenu extends VBox implements Observateur {
    private Partie partie;
    private Button entrer;
    private TextField nomJ1;
    private TextField nomJ2;
    public VueMenu(Partie partie, PlateauDeJeu plateau){
        super();
        this.partie = partie;
        this.setMaxWidth(100);
        this.setSpacing(10);
        //bouton restart
        Button restart = new Button("", new ImageView(new Image(getClass().getResourceAsStream("/ressources/restart.png"),30, 30, true, true)));
        restart.setStyle("-fx-background-color:#CEF6D8;");

        Button exit = new Button("", new ImageView(new Image(getClass().getResourceAsStream("/ressources/exit.png"),30, 30, true, true)));
        exit.setOnAction(event-> Platform.exit());
        exit.setStyle("-fx-background-color:#CEF6D8;");

        RestartListener restartListener = new RestartListener(partie, plateau, plateau.getTaille());
        restart.setOnAction(restartListener);


        //this.nomJ1 = new Label("Nom Joueur 1");
        this.entrer = new Button("Entrer");
        VBox noms = new VBox();
         nomJ1 = new TextField ();
        nomJ1.setPromptText("Nom Joueur 1");
        nomJ2 = new TextField();
        nomJ2.setPromptText("Nom Joueur 2");
        noms.getChildren().addAll(nomJ1, nomJ2);
        noms.setSpacing(10);
        this.entrer.setOnAction(new NomListener(partie, nomJ1, nomJ2));

        this.setStyle("-fx-background-color:#CEF6D8;");
        setPadding(new Insets(0, 0 , 0, 5));
        this.getChildren().addAll(exit, restart, noms, entrer);
        this.setAlignment(Pos.CENTER);
    }

    @Override
    public void reagir() {
        this.partie = new Partie();
    }
}
