import java.util.Comparator;
public class ComparatorMedaillesParticipant implements Comparator<Participant>{
    @Override
    public int compare(Participant p1, Participant p2){
        if (p1.getNbOr()>p2.getNbOr()){return 1;}
        if (p1.getNbOr()<p2.getNbOr()){return -1;}
        else {
            if (p1.getNbArgent()>p2.getNbArgent()){return 1;}
            if (p1.getNbArgent()<p2.getNbArgent()){return -1;}
            else {
                if (p1.getNbBronze()>p2.getNbBronze()){return 1;}
                if (p1.getNbBronze()<p2.getNbBronze()){return -1;}
            }
        }
        return 0;
    }
}