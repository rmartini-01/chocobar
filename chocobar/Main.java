package chocobar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import vues.FinDePartie;
import vues.PlateauDeJeu;
import vues.VueJoueur;
import vues.VueMenu;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Partie partie = new Partie();
        BorderPane root = new BorderPane();

        root.setTop(new VueJoueur(partie));
        PlateauDeJeu plateauDeJeu = new PlateauDeJeu(partie, 10);
        root.setCenter(plateauDeJeu);
        root.setBottom(new FinDePartie(partie));
        root.setLeft(new VueMenu(partie, plateauDeJeu));
        primaryStage.setTitle("Chocobar");
        primaryStage.setScene(new Scene(root, 1000, 800));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
