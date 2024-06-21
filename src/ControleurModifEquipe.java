package src;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControleurModifEquipe implements EventHandler<ActionEvent> {
    
    private ApplicationJO appli;
    private JeuxOlympiques modele;

    public ControleurModifEquipe(ApplicationJO appli, JeuxOlympiques modele) {
        this.appli = appli;
        this.modele = modele;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Button btn = (Button) actionEvent.getSource();
        String buttonId = btn.getId();
        
        switch (buttonId) {
            case "BtnAjouter":
                System.out.println("Bouton Ajouter");
                break;
            case "BtnModifier":
                System.out.println("Bouton Modifier");
                break;
            case "BtnRetirer":
                System.out.println("Bouton Retirer");
                break;
            case "BtnAnnuler":
                System.out.println("Bouton Annuler");
                Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
                stage.close();
                break;
        }
        
    }
    
}
