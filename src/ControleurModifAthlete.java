package src;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import java.sql.*;
import org.w3c.dom.Text;

public class ControleurModifAthlete implements EventHandler<ActionEvent> {
    
    private ApplicationJO appli;
    private JeuxOlympiques modele;
    private TextField nom;
    private TextField prenom;
    private Spinner<Integer> id;
    private TextField nomEquipe;
    private ToggleGroup sexe;
    private Spinner<Integer> force;
    private Spinner<Integer> agilite;
    private Spinner<Integer> endurance;
    private TextField pays;

    public ControleurModifAthlete(ApplicationJO appli, JeuxOlympiques modele, TextField nom, TextField prenom, Spinner<Integer> id, TextField nomEquipe, ToggleGroup sexe, Spinner<Integer> force, Spinner<Integer> agilite, Spinner<Integer> endurance, TextField pays) {
        this.appli = appli;
        this.modele = modele;
        this.nom = nom;
        this.prenom = prenom;
        this.id = id;
        this.nomEquipe = nomEquipe;
        this.sexe = sexe;
        this.force = force;
        this.agilite = agilite;
        this.endurance = endurance;
        this.pays = pays;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        Button btn = (Button) actionEvent.getSource();
        String buttonId = btn.getText();
    
        // transformation des paramètres vers les bons types pour crée une instance de la classe Athlète
        // récupération des infos
        String TFnomA = this.nom.getText();
        String TFprenomA = this.prenom.getText();
        String TFnomEquipeA = this.nomEquipe.getText();
        Pays TFpaysA = new Pays(this.pays.getText());
        RadioButton selectedRadioButton = (RadioButton) this.sexe.getSelectedToggle();
        char sexee = selectedRadioButton.getText().charAt(0);
        int forcee = this.force.getValue();
        int agilitee = this.agilite.getValue();
        int endurancee = this.endurance.getValue();
        int id = this.id.getValue();
        if (TFnomEquipeA.equals("")){TFnomEquipeA = TFnomA+" "+TFprenomA;}
        Athlete athlete = new Athlete(TFnomA,TFprenomA,sexee,forcee,agilitee,endurancee,TFpaysA,new Equipe(TFnomEquipeA));
        
        switch (buttonId) {
            case "Ajouter":
                try {
                    System.out.println("Bouton Ajouter");
                    this.appli.getRequeteBD().creerAthlete(athlete);
                } catch (Exception e) {
                    System.out.println("Erreur dans les informations entrées, veuillez réessayer.");
                }
                break;

            case "Modifier":
                try {
                    System.out.println("Bouton Modifier");
                    this.appli.getRequeteBD().modifierAthlete(athlete);
                } catch (Exception e) {
                    System.out.println("Erreur dans les informations entrées, veuillez réessayer.");
                }
                break;

            case "Retirer":
                try {
                    System.out.println("Bouton Retirer");
                    this.appli.getRequeteBD().enleverAthlete(id);
                } catch (Exception e) {
                    System.out.println("Erreur dans les informations entrées, veuillez réessayer.");
                }
                break;
            case "Annuler":
                System.out.println("Bouton Annuler");
                Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
                stage.close();
                break;
        }
    }
    
}
