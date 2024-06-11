package src;
/**
*@author Naima
*/

public class Sport {

    private final String nomSport;

    public Sport(String nom){
        this.nomSport = nom; 
    }

    /**
     * @return le nom du sport
     */
    public String getNomSport(){
        return this.nomSport; 
    }

    /**
     * @return le nom du sport
     */
    @Override
    public String toString() {
        return this.nomSport;
    }   
}
