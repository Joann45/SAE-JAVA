package src;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

public class ControleurOrganisateur implements EventHandler<ActionEvent> {
    private ApplicationJO appli;

    public ControleurOrganisateur(ApplicationJO appli) {
        this.appli = appli;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Button btn = (Button) actionEvent.getSource();
        String buttonText = btn.getText();
        switch (buttonText) {
            case "un athlète":
                try {
                    this.appli.fenetreModifAthlete();
                } catch (Exception e) {
                    new Exception();
                }
                break;
            case "une équipe":
                try {
                    this.appli.fenetreModifEquipe();
                } catch (Exception e) {
                    new Exception();
                }
                break;
            case "une épreuve":
                try {
                    this.appli.fenetreModifEpreuve();
                } catch (Exception e) {
                    new Exception();
                }
                break;
            default:
                this.appli.popUpErreurImportation();
                break;
        }
    }
}
