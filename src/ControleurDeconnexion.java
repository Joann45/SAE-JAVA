package src;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurDeconnexion implements EventHandler<ActionEvent> {

    private ApplicationJO appli;

    public ControleurDeconnexion(ApplicationJO appli) {
        this.appli = appli;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            this.appli.fenetreConnexion();
        } catch (Exception e) {
            new Exception();
        }
    }
}
