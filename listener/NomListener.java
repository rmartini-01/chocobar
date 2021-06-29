package listener;

import chocobar.Partie;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import vues.VueMenu;

public class NomListener implements EventHandler<ActionEvent> {
    private final Partie partie;
    private final TextField nomJ1;
    private final TextField nomJ2;

    public NomListener(Partie partie, TextField nomJ1, TextField nomJ2){
        this.partie =partie;
    this.nomJ1 = nomJ1;
    this.nomJ2 = nomJ2;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
            partie.getJoueur1().setNom(nomJ1.getText());
            partie.getJoueur2().setNom(nomJ2.getText());
    }
}
