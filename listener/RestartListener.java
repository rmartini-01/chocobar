package listener;


import chocobar.Partie;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import vues.PlateauDeJeu;
public class RestartListener implements EventHandler<ActionEvent> {
    private Partie partie;
    private PlateauDeJeu plateau;
    private int taille;
    public RestartListener(Partie partie, PlateauDeJeu plateau, int taille){
    this.partie = partie;
    this.plateau = plateau;

    }

    @Override
    public void handle(ActionEvent actionEvent) {
    partie.restart();
    }
}
