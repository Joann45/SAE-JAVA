package src;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControleurModifEpreuve implements EventHandler<ActionEvent> {
    
    private ApplicationJO appli;
    private JeuxOlympiques modele;

    public ControleurModifEpreuve(ApplicationJO appli, JeuxOlympiques modele) {
        this.appli = appli;
        this.modele = modele;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Button btn = (Button) actionEvent.getSource();
        String buttonId = btn.getId();
        
        switch (buttonId) {
            case "btnAjouter":
                System.out.println("Bouton Ajouter");
                break;
            case "btnModifier":
                System.out.println("Bouton Modifier");
                break;
            case "btnRetirer":
                System.out.println("Bouton Retirer");
                break;
            case "btnAnnuler":
                System.out.println("Bouton Annuler");
                Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
                stage.close();
                break;
        }
        
    }
    
}
