package src;
import javafx.event.EventHandler;

import javafx.event.ActionEvent;

public class ControleurJournaliste implements EventHandler<ActionEvent> {
    
    private ApplicationJO appli;

    public ControleurJournaliste(ApplicationJO appli) {
        this.appli = appli;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        
    }
}
