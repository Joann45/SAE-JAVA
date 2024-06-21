package src;
public abstract class Sport {
    
    protected String nomSport;
    protected Integer nbMembresEquipe;

    protected Sport(String nomS) {
        this.nomSport = nomS;
    }

    public String getNomSport() {
        return this.nomSport;
    }

    public Integer getNbMembresEquipe() {
        return this.nbMembresEquipe;
    }

    @Override
    public String toString() {
        return this.nomSport;
    }
}
