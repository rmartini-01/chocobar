package vues;


import chocobar.Observateur;
import chocobar.PlaqueDeChocolat;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import chocobar.Partie;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.nio.file.Paths;

public class PlateauDeJeu extends GridPane implements Observateur {
    private final Button[][] grid;
    private final Partie partie;
    private final PlaqueDeChocolat plaque;
    private final StackPane sp;
    private final ImageView end;
    private final MediaPlayer audioPlayer;
    private int taille;
    public PlateauDeJeu(Partie partie, int taille){
        this.taille = taille;
        //gridpane principal
        GridPane gp = new GridPane();
        //stackpane lors de la fin du jeu
        this.sp = new StackPane();
        this.grid = new Button[this.taille][this.taille];
        //déclaration de la partie et de la plaque de jeu
        this.partie = partie;
        this.partie.ajouterObservateur(this);
        this.plaque = this.partie.getPlaque();
        //image de fin de jeu
        Image endImg = new Image(getClass().getResourceAsStream("/ressources/end.png"),400, 555, true, true);
        this.end = new ImageView(endImg);
        sp.getChildren().add(this.end);
        sp.setVisible(false);
        //images et boutons
        ImageView burgerImg = new ImageView(new Image(getClass().getResourceAsStream("/ressources/burger.png"),40, 55, true, true));
        Button burger = new Button();
        burger.setGraphic(burgerImg);
        for(int i = 0; i<this.taille; ++i){
           for(int j = 0; j<this.taille; ++j){
               if(i == 0 && j == 0){
                   this.grid[0][0] = burger;
                   gp.add(burger, 0,0);
                   burger.setOnAction(event->this.partie.croquer(0, 0));
                   j++;
               }
               ImageView chocolatImg = new ImageView(new Image(getClass().getResourceAsStream("/ressources/chocolate.png"),40, 55, true, true));
               int finalI = i;
               int finalJ = j;
               Button chocolate = new Button();
               chocolate.setGraphic(chocolatImg);
               this.grid[finalI][finalJ] = chocolate;
               chocolate.setOnAction(event->this.partie.croquer(finalI, finalJ));
               gp.add(chocolate, i,j);
            }
        }
        //audio de fin de jeu.
        String filePath =new File( "src/ressources/lose.mp3").getAbsolutePath();
        Media audio = new Media(Paths.get(filePath).toUri().toString());
        this.audioPlayer = new MediaPlayer(audio);
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(gp, this.sp);
        this.setStyle("-fx-background-color:#CEF6D8;");
    }

    public int getTaille() {
        return taille;
    }
    public void setTaille(int taille){
        this.taille = taille;
    }

    @Override
    public void reagir() {
        for(int i = 0; i<this.taille; i++) {
            for (int j = 0; j < this.taille; j++) {
                if(!plaque.getCarre(0,0)){ //si on appuie sur le burger
                    this.grid[0][0].setVisible(false);
                    this.sp.setVisible(true);
                    audioPlayer.play();
                }
                if (!plaque.getCarre(i, j)) {
                    for(int k = i; k<10; k++) {
                        for (int l = j; l < 10; l++) {
                            this.grid[k][l].setVisible(false);
                        }
                    }
                }else{
                    for(int k = i; k<10; k++) {
                        for (int l = j; l < 10; l++) {
                            this.grid[k][l].setVisible(true);
                        }
                    }
                }

            }
        }

    }
}
