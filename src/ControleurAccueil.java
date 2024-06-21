package src;
import javafx.event.EventHandler;

import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ControleurAccueil implements EventHandler<ActionEvent> {
    
    private ApplicationJO appli;
    private JeuxOlympiques modele;
    private TextField tFid;
    private PasswordField pFmdp;

    public ControleurAccueil(ApplicationJO appli, JeuxOlympiques modele, TextField id, PasswordField mdp) {
        this.appli = appli;
        this.modele = modele;
        this.tFid = id;
        this.pFmdp = mdp;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String id = this.tFid.getText();
        String mdp = this.pFmdp.getText();
        if ((this.tFid.getText().contains("J") || this.tFid.getText().contains("j")) && this.modele.verificationMdp(id, mdp).equals("Valide")) {
            try {
                this.appli.modeJournaliste(mdp);
            } catch (Exception e) {
                new Exception();
            }
        }
        else if ((this.tFid.getText().contains("A") || this.tFid.getText().contains("a")) && this.modele.verificationMdp(id, mdp).equals("Valide")) {
            ;
            try {
                this.appli.modeAdministrateur(mdp);
            } catch (Exception e) {
                new Exception();
            }
        }
        else if ((this.tFid.getText().contains("O") || this.tFid.getText().contains("o")) && this.modele.verificationMdp(id, mdp).equals("Valide")) {
            try {
                this.appli.modeOrganisateur(mdp);
            } catch (Exception e) {
                new Exception();
            }
        }
        else if (this.modele.verificationMdp(id, mdp).equals("id inconnu")) {
            this.appli.erreurId();
        }
        else if (this.modele.verificationMdp(id, mdp).equals("Mdp invalide")){
            this.appli.erreurMdp();
        }
        else {
            System.out.println("Erreur Connexion !");
        }
    }
}
