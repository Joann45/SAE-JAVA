package src;
import java.io.File;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;

import java.sql.*;
import java.util.ArrayList;
import java.util.Set;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ApplicationJO extends Application {

    Scene mainScene;
    BorderPane root;
    Stage stage;

    JeuxOlympiques modele;
    ConnexionMySQL connexionMySQL;
    RequeteBD requeteBD;

    @Override
    public void init() throws ClassNotFoundException, SQLException {
        this.root = new BorderPane();
        this.modele = new JeuxOlympiques();
        this.modele.ajouterConnexion("J", "j");
        this.modele.ajouterConnexion("A", "a");
        this.modele.ajouterConnexion("O", "o");
        this.modele.ajouterConnexion("j_002", "journaux");
        this.modele.ajouterConnexion("a_002", "Administrateur");
        this.modele.ajouterConnexion("o_002", "orga2024");
        this.modele.ajouterConnexion("J_001", "jour");
        this.modele.ajouterConnexion("A_001", "admin");
        this.modele.ajouterConnexion("O_001", "orga");


        try {
            this.connexionMySQL = new ConnexionMySQL();
            this.connexionMySQL.connecter();
        } catch (ClassNotFoundException ex){
            System.out.println("Driver MySQL non trouvé!!!");
            System.exit(1);
        }
        this.requeteBD = new RequeteBD(this.connexionMySQL);
    }
    
    @Override
    public void start(Stage st) throws Exception {
        this.stage = st;
        this.fenetreConnexion();
    }   
    
    public ConnexionMySQL getConnexionMySQL(){
        return this.connexionMySQL;
    }

    public RequeteBD getRequeteBD(){
        return this.requeteBD;
    }

    /**
     * Création et affichage de la fenêtre de connexion
     * @throws Exception
     */
    public void fenetreConnexion() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("connexion.fxml"));
        this.root = loader.load();
        this.mainScene = new Scene(root);

        TextField textFieldId = (TextField) this.mainScene.lookup("#tFid");
        PasswordField passFieldMdp = (PasswordField) this.mainScene.lookup("#pFmdp");
        TextField tFmdp = (TextField) this.mainScene.lookup("#tFmdp");
        Button btnoeil = (Button) this.mainScene.lookup("#btnOeil");

        tFmdp.setManaged(false);
        tFmdp.setVisible(false);

        passFieldMdp.textProperty().bindBidirectional(tFmdp.textProperty());

        btnoeil.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            tFmdp.setVisible(true);
            tFmdp.setManaged(true);
            passFieldMdp.setVisible(false);
            passFieldMdp.setManaged(false);
        });

        btnoeil.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> {
            tFmdp.setVisible(false);
            tFmdp.setManaged(false);
            passFieldMdp.setVisible(true);
            passFieldMdp.setManaged(true);
        });
        

        Button btnConnexion = (Button) this.mainScene.lookup("#btnConnexion");
        btnConnexion.setOnAction(new ControleurAccueil(this, this.modele, textFieldId, passFieldMdp));

        this.stage.setScene(this.mainScene);
        this.stage.setTitle("Jeux IUT'Olympiques - Identification");
        this.stage.show();
    }

    /**
     * Création et affichage de la fenêtre Journaliste
     * @throws Exception
     */
    public void fenetreJournaliste() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("journaliste.fxml"));
        this.root = loader.load();
        this.mainScene = new Scene(root);

        Button btnDeconnexion = (Button) this.mainScene.lookup("#btnDeconnexion");
        btnDeconnexion.setOnAction(new ControleurDeconnexion(this));

        ScrollPane scrollPane1 = new ScrollPane();
        TitledPane panePays1 = new TitledPane();
        panePays1.setText("Classement des pays (selon le nombre des médailles)");

        GridPane grille1 = new GridPane();
        grille1.setGridLinesVisible(true);
        addTextToGrid(grille1, "Pays", 1, 0);
        addTextToGrid(grille1, "Nombre d'or", 2, 0);
        addTextToGrid(grille1, "Nombre d'argent", 3, 0);
        addTextToGrid(grille1, "Nombre de bronze", 4, 0);

        scrollPane1.setContent(grille1);
        panePays1.setContent(scrollPane1);

        ArrayList<Pays> listePays = this.requeteBD.classementPays();
        int i = 1;
        for (Pays pays : listePays) {
            addTextToGrid(grille1, String.valueOf(i), 0, i);
            addTextToGrid(grille1, pays.getNomPays(), 1, i);
            addTextToGrid(grille1, String.valueOf(pays.getNbOr()), 2, i);
            addTextToGrid(grille1, String.valueOf(pays.getNbArgent()), 3, i);
            addTextToGrid(grille1, String.valueOf(pays.getNbBronze()), 4, i);
            i++;
        }

        ScrollPane scrollPane2 = new ScrollPane();
        TitledPane paneAthlete2 = new TitledPane();
        paneAthlete2.setText("Classement des athlètes (selon le nombre de médailles)");

        GridPane grille2 = new GridPane();
        grille2.setGridLinesVisible(true);
        addTextToGrid(grille2, "Nom Prénom", 1, 0);
        addTextToGrid(grille2, "Nombre d'or", 2, 0);
        addTextToGrid(grille2, "Nombre d'argent", 3, 0);
        addTextToGrid(grille2, "Nombre de bronze", 4, 0);

        scrollPane2.setContent(grille2);
        paneAthlete2.setContent(scrollPane2);

        ArrayList<Athlete> listeAthlete = this.requeteBD.classementAthletes();
        i = 1;
        for (Athlete athlete : listeAthlete) {
            addTextToGrid(grille2, String.valueOf(i), 0, i);
            addTextToGrid(grille2, athlete.obtenirNom(), 1, i);
            addTextToGrid(grille2, String.valueOf(athlete.getNbOr()), 2, i);
            addTextToGrid(grille2, String.valueOf(athlete.getNbArgent()), 3, i);
            addTextToGrid(grille2, String.valueOf(athlete.getNbBronze()), 4, i);
            i++;
        }

        ScrollPane scrollPane3 = new ScrollPane();
        TitledPane paneEquipe3 = new TitledPane();
        paneEquipe3.setText("Classement des equipes (selon le nombre de médailles)");

        GridPane grille3 = new GridPane();
        grille3.setGridLinesVisible(true);
        addTextToGrid(grille3, "Nom équipe", 1, 0);
        addTextToGrid(grille3, "Pays équipe", 2, 0);
        addTextToGrid(grille3, "Nombre d'or", 3, 0);
        addTextToGrid(grille3, "Nombre d'argent", 4, 0);
        addTextToGrid(grille3, "Nombre de bronze", 5, 0);

        scrollPane3.setContent(grille3);
        paneEquipe3.setContent(scrollPane3);

        ArrayList<Equipe> listeEquipe = this.requeteBD.classementEquipe();
        i = 1;
        for (Equipe equipe : listeEquipe) {
            addTextToGrid(grille3, String.valueOf(i), 0, i);
            addTextToGrid(grille3, equipe.obtenirNom(), 1, i);
            addTextToGrid(grille3, equipe.getPaysEquipe().toString(), 2, i);
            addTextToGrid(grille3, String.valueOf(equipe.getNbOr()), 3, i);
            addTextToGrid(grille3, String.valueOf(equipe.getNbArgent()), 4, i);
            addTextToGrid(grille3, String.valueOf(equipe.getNbBronze()), 5, i);
            i++;
        }

        Accordion accordion = new Accordion(panePays1, paneAthlete2, paneEquipe3);
        this.root.setCenter(accordion);

        this.stage.setScene(this.mainScene);
        this.stage.setTitle("Jeux IUT'Olympiques - Journaliste");
        this.stage.show();
    }

    private void addTextToGrid(GridPane grid, String text, int col, int row) {
        Text t = new Text(text);
        StackPane stackPane = new StackPane(t);
        stackPane.setAlignment(Pos.CENTER);
        stackPane.setPadding(new Insets(10));
        grid.add(stackPane, col, row);
    }

    /**
     * Création et affichage de la fenêtre administrateur
     * @throws Exception
     */
    public void fenetreAdministrateur() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("pageAdmin.fxml"));
        this.root = loader.load();
        this.mainScene = new Scene(root);

        Button btnDeconnexion = (Button) this.mainScene.lookup("#btnDeconnexion");
        btnDeconnexion.setOnAction(new ControleurDeconnexion(this));

        ScrollPane scrollPane1 = new ScrollPane();
        TitledPane panePays1 = new TitledPane();
        panePays1.setText("Classement des pays (selon le nombre des médailles)");

        GridPane grille1 = new GridPane();
        grille1.setGridLinesVisible(true);
        addTextToGrid(grille1, "Pays", 1, 0);
        addTextToGrid(grille1, "Nombre d'or", 2, 0);
        addTextToGrid(grille1, "Nombre d'argent", 3, 0);
        addTextToGrid(grille1, "Nombre de bronze", 4, 0);

        scrollPane1.setContent(grille1);
        panePays1.setContent(scrollPane1);

        ArrayList<Pays> listePays = this.requeteBD.classementPays();
        System.out.println(listePays);
        int i = 1;
        for (Pays pays : listePays) {
            addTextToGrid(grille1, String.valueOf(i), 0, i);
            addTextToGrid(grille1, pays.getNomPays(), 1, i);
            addTextToGrid(grille1, String.valueOf(pays.getNbOr()), 2, i);
            addTextToGrid(grille1, String.valueOf(pays.getNbArgent()), 3, i);
            addTextToGrid(grille1, String.valueOf(pays.getNbBronze()), 4, i);
            i++;
        }
 
        ScrollPane scrollPane2 = new ScrollPane();
        TitledPane paneAthlete2 = new TitledPane();
        paneAthlete2.setText("Classement des athlètes (selon le nombre de médailles)");

        GridPane grille2 = new GridPane();
        grille2.setGridLinesVisible(true);
        addTextToGrid(grille2, "Nom Prénom", 1, 0);
        addTextToGrid(grille2, "Nombre d'or", 2, 0);
        addTextToGrid(grille2, "Nombre d'argent", 3, 0);
        addTextToGrid(grille2, "Nombre de bronze", 4, 0);

        scrollPane2.setContent(grille2);
        paneAthlete2.setContent(scrollPane2);

        ArrayList<Athlete> listeAthlete = this.requeteBD.classementAthletes();
        i = 1;
        for (Athlete athlete : listeAthlete) {
            addTextToGrid(grille2, String.valueOf(i), 0, i);
            addTextToGrid(grille2, athlete.obtenirNom(), 1, i);
            addTextToGrid(grille2, String.valueOf(athlete.getNbOr()), 2, i);
            addTextToGrid(grille2, String.valueOf(athlete.getNbArgent()), 3, i);
            addTextToGrid(grille2, String.valueOf(athlete.getNbBronze()), 4, i);
            i++;
        }

        ScrollPane scrollPane3 = new ScrollPane();
        TitledPane paneEquipe3 = new TitledPane();
        paneEquipe3.setText("Classement des equipes (selon le nombre de médailles)");

        GridPane grille3 = new GridPane();
        grille3.setGridLinesVisible(true);
        addTextToGrid(grille3, "Nom équipe", 1, 0);
        addTextToGrid(grille3, "Pays équipe", 2, 0);
        addTextToGrid(grille3, "Nombre d'or", 3, 0);
        addTextToGrid(grille3, "Nombre d'argent", 4, 0);
        addTextToGrid(grille3, "Nombre de bronze", 5, 0);

        scrollPane3.setContent(grille3);
        paneEquipe3.setContent(scrollPane3);

        ArrayList<Equipe> listeEquipe = this.requeteBD.classementEquipe();
        i = 1;
        for (Equipe equipe : listeEquipe) {
            Set<Athlete> membres = equipe.getMembres();
            Athlete premierMembre = null;
            if (!membres.isEmpty()) {
                premierMembre = new ArrayList<>(membres).get(0);
            }

            addTextToGrid(grille3, String.valueOf(i), 0, i);
            addTextToGrid(grille3, equipe.obtenirNom(), 1, i);
            addTextToGrid(grille3, premierMembre.getPaysAthlete().getNomPays(), 2, i);
            addTextToGrid(grille3, String.valueOf(equipe.getNbOr()), 3, i);
            addTextToGrid(grille3, String.valueOf(equipe.getNbArgent()), 4, i);
            addTextToGrid(grille3, String.valueOf(equipe.getNbBronze()), 5, i);
            i++;
        }

        Accordion accordion = new Accordion(panePays1, paneAthlete2, paneEquipe3);
        this.root.setCenter(accordion);

        Button btnModifA = (Button) this.mainScene.lookup("#btnAthlete");
        btnModifA.setOnAction(new ControleurAdmin(this));
        Button btnModifEq = (Button) this.mainScene.lookup("#btnEquipe");
        btnModifEq.setOnAction(new ControleurAdmin(this));
        Button btnModifEp = (Button) this.mainScene.lookup("#btnEpreuve");
        btnModifEp.setOnAction(new ControleurAdmin(this));

        Button btnImportAthlete = (Button) this.mainScene.lookup("#choisirAthlete");

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Importer le fichier");
        FileChooser.ExtensionFilter filtre = new FileChooser.ExtensionFilter("CSV", "*.csv");
        fileChooser.getExtensionFilters().add(filtre);

        btnImportAthlete.setOnAction(new EventHandler<ActionEvent>() {
            private JeuxOlympiques modele = new JeuxOlympiques();
            @Override
            public void handle(final ActionEvent e) {
                File file = fileChooser.showOpenDialog(stage);
                System.out.println(file.getName());
                try {
                    this.modele.ajouterAthleteCSV(file.getName());
                    popUpValidation();
                } catch (Exception ex) {
                    popUpErreurImportation();
                }
            }
        });

        this.stage.setScene(this.mainScene);
        this.stage.setTitle("Jeux IUT'Olympiques - Administrateur");
        this.stage.show();
    }

    /**
     * Création et affichage de la fenêtre organisateur
     * @throws Exception
     */
    public void fenetreOrganisateur() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("pageOrganisateur.fxml"));
        this.root = loader.load();
        this.mainScene = new Scene(root);

        Button btnDeconnexion = (Button) this.mainScene.lookup("#btnDeconnexion");
        btnDeconnexion.setOnAction(new ControleurDeconnexion(this));

        ToggleGroup group = new ToggleGroup();
        RadioButton rbF = new RadioButton("F");
        rbF.setPadding(new Insets(5));
        RadioButton rbM = new RadioButton("M");
        rbM.setPadding(new Insets(5));
        rbF.setToggleGroup(group);
        rbM.setToggleGroup(group);

        ChoiceBox<String> choixSport = (ChoiceBox) this.mainScene.lookup("#ChoixSport");
        choixSport.getItems().add("Athlétisme 100m");
        choixSport.getItems().add("Athlétisme relais");
        choixSport.getItems().add("Escrime fleuret");
        choixSport.getItems().add("Escrime épée");
        choixSport.getItems().add("Handball");
        choixSport.getItems().add("Natation brasse");
        choixSport.getItems().add("Natation libre");
        choixSport.getItems().add("Volley-ball");

        HBox hBoxSexe = (HBox) this.mainScene.lookup("#RBtnMF");
        hBoxSexe.getChildren().addAll(rbF, rbM);

        this.stage.setScene(this.mainScene);
        this.stage.setTitle("Jeux IUT'Olympiques - Organisateur");
        this.stage.show();
    }
 
    /**
     * Création et affichage d'une sur-fenêtre permettant de modifier l'athlète (ajout, modif, suppression)
     * @throws Exception
     */
    public void fenetreModifAthlete() throws Exception {
        BorderPane borderPane = new BorderPane();
        Text titre = new Text("Entrez les informations concernant l'athlète");
        titre.setFont (Font.font("Comfortaa", FontWeight.NORMAL, 19));
        titre.setTextAlignment(TextAlignment.CENTER);
        borderPane.setTop(titre);

        Spinner<Integer> spinnerId = new Spinner<Integer>();
        int initialValueId = 0; 
        SpinnerValueFactory<Integer> valueFactoryId = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 1000, initialValueId);
        spinnerId.setValueFactory(valueFactoryId);
        spinnerId.setEditable(true);

        Spinner<Integer> spinnerForce = new Spinner<Integer>();
        int initialValueForce = 0;
        SpinnerValueFactory<Integer> valueFactoryForce = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, initialValueForce);
        spinnerForce.setValueFactory(valueFactoryForce);
        spinnerForce.setEditable(true);

        Spinner<Integer> spinnerAgilite = new Spinner<Integer>();
        int initialValueAgilite = 0;
        SpinnerValueFactory<Integer> valueFactoryAgilite = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, initialValueAgilite);
        spinnerAgilite.setValueFactory(valueFactoryAgilite);
        spinnerAgilite.setEditable(true);

        Spinner<Integer> spinnerEndurance = new Spinner<Integer>();
        int initialValueEndurance = 0;
        SpinnerValueFactory<Integer> valueFactoryEndurance = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, initialValueEndurance);
        spinnerEndurance.setValueFactory(valueFactoryEndurance);
        spinnerEndurance.setEditable(true);

        GridPane grilleAthlete = new GridPane();
        Text nom = new Text("Nom");
        Text prenom = new Text("Prenom");
        Text pays = new Text("Pays");
        Text numId = new Text("Numéro id");
        Text nomEquipe = new Text("Nom de l'équipe");
        Text sexe = new Text("Sexe");
        Text force = new Text("Force");
        Text agilite = new Text("Agilité");
        Text endurance = new Text("Endurance");
        TextField tfNom = new TextField();
        TextField tfPrenom = new TextField();
        TextField tfPays = new TextField();
        TextField tfNomEquipe = new TextField();

        HBox hBoxSexe = new HBox();
        ToggleGroup group = new ToggleGroup();
        RadioButton rbF = new RadioButton("F");
        RadioButton rbM = new RadioButton("M");
        rbF.setSelected(true);
        rbF.setToggleGroup(group);
        rbM.setToggleGroup(group);
        hBoxSexe.getChildren().addAll(rbF, rbM);

        grilleAthlete.add(nom, 1, 1, 1, 1);
        grilleAthlete.add(prenom,3, 1, 3, 1);
        grilleAthlete.add(pays,7,1,2,1);
        grilleAthlete.add(tfNom, 1, 2, 1, 1);
        grilleAthlete.add(tfPrenom, 3, 2, 3, 1);
        grilleAthlete.add(tfPays, 7, 2, 1, 1);
        grilleAthlete.add(numId, 1, 4, 1, 1);
        grilleAthlete.add(nomEquipe, 3, 4, 3, 1);
        grilleAthlete.add(sexe, 7, 4, 1, 1);
        grilleAthlete.add(spinnerId, 1, 5, 3, 1);
        grilleAthlete.add(tfNomEquipe, 3, 5, 3, 1);
        grilleAthlete.add(hBoxSexe, 7, 5, 1, 1);
        grilleAthlete.add(force, 1, 7, 1, 1);
        grilleAthlete.add(agilite, 3, 7, 2, 1);
        grilleAthlete.add(endurance, 7, 7, 1, 1);
        grilleAthlete.add(spinnerForce, 1, 8, 1, 1);
        grilleAthlete.add(spinnerAgilite, 3, 8, 3, 1);
        grilleAthlete.add(spinnerEndurance, 7, 8, 1, 1);

        borderPane.setCenter(grilleAthlete);

        Button ajouter = new Button("Ajouter");
        ajouter.setOnAction(new ControleurModifAthlete(this, modele, tfNom, tfPrenom, spinnerId, tfNomEquipe, group, spinnerForce, spinnerAgilite, spinnerEndurance, tfPays));
        Button modifier = new Button("Modifier");
        modifier.setOnAction(new ControleurModifAthlete(this, modele, tfNom, tfPrenom, spinnerId, tfNomEquipe, group, spinnerForce, spinnerAgilite, spinnerEndurance, tfPays));
        Button retirer = new Button("Retirer");
        retirer.setOnAction(new ControleurModifAthlete(this, modele, tfNom, tfPrenom, spinnerId, tfNomEquipe, group, spinnerForce, spinnerAgilite, spinnerEndurance, tfPays));
        Button annuler = new Button("Annuler");
        annuler.setOnAction(new ControleurModifAthlete(this, modele, tfNom, tfPrenom, spinnerId, tfNomEquipe, group, spinnerForce, spinnerAgilite, spinnerEndurance, tfPays));
        HBox boutonBottom = new HBox();
        boutonBottom.getChildren().addAll(ajouter,modifier,retirer,annuler);

        borderPane.setBottom(boutonBottom);

        Scene scene = new Scene(borderPane, 600, 400);

        Stage stageBis = new Stage();
        stageBis.setScene(scene);
        stageBis.setTitle("Jeux IUT'Olympiques - Administrateur - Modification Athlète");
        stageBis.show();
    }

    /**
     * Création et affichage d'une sur-fenêtre permettant de modifier une équipe (ajout, modif, suppression)
     * @throws Exception
     */
    public void fenetreModifEquipe() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("pageAdminModifEquipe.fxml"));
        BorderPane rootBis = loader.load();
        Scene mainSceneBis = new Scene(rootBis);  
        
        Button btnAjouter = (Button) mainSceneBis.lookup("#BtnAjouter");
        btnAjouter.setOnAction(new ControleurModifEquipe(this, this.modele));
        Button btnModifier = (Button) mainSceneBis.lookup("#BtnModifier");
        btnModifier.setOnAction(new ControleurModifEquipe(this, this.modele));
        Button btnRetirer = (Button) mainSceneBis.lookup("#BtnRetirer");
        btnRetirer.setOnAction(new ControleurModifEquipe(this, this.modele));
        Button btnAnnuler = (Button) mainSceneBis.lookup("#BtnAnnuler");
        btnAnnuler.setOnAction(new ControleurModifEquipe(this, this.modele));

        GridPane grille = new GridPane();

        for (int i = 0; i < 7; i++) {
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(100.0 / 7);
            grille.getColumnConstraints().add(column);
        }

        for (int i = 0; i < 10; i++) {
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(100.0 / 10);
            grille.getRowConstraints().add(row);
        }

        Label numId = new Label("Numéro Id");
        grille.add(numId, 1, 1);
        Label nomE = new Label("Nom");
        grille.add(nomE, 4, 1, 2, 1);
        Label tOr = new Label("Or");
        grille.add(tOr, 1, 6);
        Label tArgent = new Label("Argent");
        grille.add(tArgent, 1, 7);
        Label tBronze = new Label("Bronze");
        grille.add(tBronze, 1, 8);

        TextField tFNom = new TextField();
        grille.add(tFNom, 4, 2, 2, 1);
        
        Spinner<Integer> spinnerId = new Spinner<Integer>();
        int initialValueId = 3;
        SpinnerValueFactory<Integer> valueFactoryId = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 1000, initialValueId);
        spinnerId.setValueFactory(valueFactoryId);
        spinnerId.setEditable(true);
        grille.add(spinnerId, 1, 2, 3, 1);

        Spinner<Integer> spinnerOr = new Spinner<Integer>();
        int initialValueOr = 0;
        SpinnerValueFactory<Integer> valueFactoryOr = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50, initialValueOr);
        spinnerOr.setValueFactory(valueFactoryOr);
        spinnerOr.setEditable(true);
        grille.add(spinnerOr, 3, 6, 2, 1);
        
        Spinner<Integer> spinnerArgent = new Spinner<Integer>();
        int initialValueArgent = 0;
        SpinnerValueFactory<Integer> valueFactoryArgent = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50, initialValueArgent);
        spinnerArgent.setValueFactory(valueFactoryArgent);
        spinnerArgent.setEditable(true);
        grille.add(spinnerArgent, 3, 7, 2, 1);
        
        Spinner<Integer> spinnerBronze = new Spinner<Integer>();
        int initialValueBronze = 0;
        SpinnerValueFactory<Integer> valueFactoryBronze = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50, initialValueBronze);
        spinnerBronze.setValueFactory(valueFactoryBronze);
        spinnerBronze.setEditable(true);
        grille.add(spinnerBronze, 3, 8, 2, 1);

        rootBis.setCenter(grille);
        
        Stage stageBis = new Stage();
        stageBis.setScene(mainSceneBis);
        stageBis.setTitle("Jeux IUT'Olympiques - Administrateur - Modification Equipe");
        stageBis.show();
    }


    /**
     * Création et affichage d'une sur-fenêtre permettant de modifier une épreuve (ajout, modif, suppression)
     * @throws Exception
     */
    public void fenetreModifEpreuve() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("pageAdminModifEpreuve.fxml"));
        BorderPane rootBis = loader.load();
        Scene mainSceneBis = new Scene(rootBis);

        ToggleGroup group = new ToggleGroup();
        RadioButton rbF = new RadioButton("F");
        RadioButton rbM = new RadioButton("M");
        rbF.setToggleGroup(group);
        rbM.setToggleGroup(group);

        HBox hBoxSexe = (HBox) mainSceneBis.lookup("#RBtnMF");
        hBoxSexe.getChildren().addAll(rbF, rbM);

        Button btnAjouter = (Button) mainSceneBis.lookup("#btnAjouter");
        btnAjouter.setOnAction(new ControleurModifEpreuve(this, this.modele));
        Button btnModifier = (Button) mainSceneBis.lookup("#btnModifier");
        btnModifier.setOnAction(new ControleurModifEpreuve(this, this.modele));
        Button btnRetirer = (Button) mainSceneBis.lookup("#btnRetirer");
        btnRetirer.setOnAction(new ControleurModifEpreuve(this, this.modele));
        Button btnAnnuler = (Button) mainSceneBis.lookup("#btnAnnuler");
        btnAnnuler.setOnAction(new ControleurModifEpreuve(this, this.modele));

        final ChoiceBox<String> choixSport = (ChoiceBox) mainSceneBis.lookup("#ChoixSport");
        choixSport.getItems().add("Athlétisme 100m");
        choixSport.getItems().add("Athlétisme relais");
        choixSport.getItems().add("Escrime fleuret");
        choixSport.getItems().add("Escrime épée");
        choixSport.getItems().add("Handball");
        choixSport.getItems().add("Natation brasse");
        choixSport.getItems().add("Natation libre");
        choixSport.getItems().add("Volley-ball");

        Stage stageBis = new Stage();
        stageBis.setScene(mainSceneBis);
        stageBis.setTitle("Jeux IUT'Olympiques - Administrateur - Modification Epreuve");
        stageBis.show();
    }

    /**
     * Appel de la fonction fenêtre journaliste permettant de créer sa fenêtre
     * @param motDePasse
     * @throws Exception
     */
    public void modeJournaliste(String motDePasse) throws Exception {
        System.out.println("Mode journaliste");
        fenetreJournaliste();
    }

    /**
     * Appel de la fonction fenêtre administrateur permettant de créer sa fenêtre
     * @param motDePasse
     * @throws Exception
     */
    public void modeAdministrateur(String motDePasse) throws Exception {
        System.out.println("Mode administrateur");
        fenetreAdministrateur();
    }

    /**
     * Appel de la fonction fenêtre organisateur permettant de créer sa fenêtre
     * @param motDePasse
     * @throws Exception
     */
    public void modeOrganisateur(String motDePasse) throws Exception {
        System.out.println("Mode organisateur");
        fenetreOrganisateur();
    }

    /**
     * Création d'une popup pour la page de connexion informant l'utilisateur
     * que son identifiant est incorrect
     */
    public void erreurId() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Erreur d'identifiant");
        alert.setHeaderText("Erreur dans votre identifiant : ");
        alert.setContentText("Il doit commencer par" + System.lineSeparator() + "- 'J', si vous êtes journaliste" + System.lineSeparator() + "- 'A', si vous êtes administrateur" + System.lineSeparator() + "- 'O', si vous êtes organisateur"+ System.lineSeparator() + "Vérifier également vos numéros");
        
        ImageView imageErreur = new ImageView(new Image("img/logoPopUpErreur.png"));
        imageErreur.setFitWidth(48);
        imageErreur.setFitHeight(48);
        alert.setGraphic(imageErreur);

        alert.showAndWait();
    }

    /**
     * Création d'une popup pour la page connexion informant l'utilisateur
     * que son mot de passe est incorrect
     */
    public void erreurMdp() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur de mot de passe");
        alert.setHeaderText(null);
        alert.setContentText("Erreur dans votre mot de passe");

        ImageView imageErreur = new ImageView(new Image("img/logoPopUpErreur.png"));
        imageErreur.setFitWidth(48);
        imageErreur.setFitHeight(48);
        alert.setGraphic(imageErreur);

        alert.showAndWait();
    }
    
    /**
     * Création d'une popup pour confirmer l'importation des données via un fichier CSV
     */
    public void popUpValidation() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Importation réussie");
        alert.setHeaderText("L'importation a bien été effectuée");
        alert.setContentText(this.modele.getNbAthleteAjoutCSV() + " athlètes ont été ajouté !");

        ImageView imageValidation = new ImageView(new Image("img/logoPopUpValidation (1).png"));
        imageValidation.setFitWidth(48);
        imageValidation.setFitHeight(48);
        alert.setGraphic(imageValidation);

        alert.showAndWait();
    }

    /**
     * Création d'une popup pour informer l'utilisateur qu'une erreur s'est produite lors de
     * l'importation d'athlètes via un fichier CSV
     */
    public void popUpErreurImportation() {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Échec de l'importation");
        alert.setHeaderText("Erreur de l'importation");
        alert.setContentText("Veuillez vérifier votre fichier CSV"); 

        ImageView imageValidation = new ImageView(new Image("img/logoPopUpErreur.png"));
        imageValidation.setFitWidth(48);
        imageValidation.setFitHeight(48);
        alert.setGraphic(imageValidation);

        alert.showAndWait();
    }

    /**
     * Pour récupérer la scène
     * @return la scène
     */
    public Scene getScene (){
        return this.mainScene;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
