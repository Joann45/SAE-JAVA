public abstract class Sport {
    
    protected String nomSport;
    protected int nbMembresEquipe;

    protected Sport(String nomS) {
        this.nomSport = nomS;
    }

    public String getNomSport() {
        return this.nomSport;
    }

    public int getNbMembresEquipe() {
        return this.nbMembresEquipe;
    }

    @Override
    public String toString() {
        return this.nomSport;
    }
}
