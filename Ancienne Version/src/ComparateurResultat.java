package src;
/**
*@author Thomas
*/
import java.util.Comparator;

/** Classe permettant de comparer des Résultats, implémentant Comparator de Résultat */
public class ComparateurResultat implements Comparator<Resultat> {

    @Override
    public int compare(Resultat o1, Resultat o2) {
        if(o1.getScore() == o2.getScore()) {
            return 0;
        }
        if (o1.getScore() < o2.getScore()) {
            return 1;
        }
        return -1;
    }

}
