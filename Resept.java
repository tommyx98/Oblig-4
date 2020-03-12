abstract class Resept{
    private static int teller=0;
    Legemiddel legemiddel;
    Lege utskrivendeLege;
    Pasient pasient;
    int reit;
    private int teller2=0;// Inneholder id
    Resept(Legemiddel legemiddel, Lege utskrivendeLege, 
    Pasient pasient, int reit){
        teller2=teller;
        teller++; // Øker id vær gang klassen blir instantiert
        this.legemiddel=legemiddel;
        this.utskrivendeLege=utskrivendeLege;
        this.pasient=pasient;
        this.reit=reit;
    }

    public int hentReit(){ // Henter reit på resept
       return this.reit;
    }

    public int hentId(){
        return teller2;
        
    }

    public Legemiddel hentLegemiddel(){ 
        return this.legemiddel;
    }

    public Lege hentLege(){ // Returnerer lege
        return this.utskrivendeLege;
    }

    public Pasient hentPasientId(){ // Returnerer pasient id
        return this.pasient;
    }

    public boolean bruk(){ // Bruker resept
        if(this.reit>0){
            return true;
        }
        else{
            return false;
        }
    }

    abstract public String farge();
        /* Returnerer reseptens
        farge. Enten “hvit” eller "blaa". **/
    

    abstract public double prisAaBetale();
       // Returnerer prisen pasienten må betale.


}














/*Reference is, in the Java context, a variable* - it is something 
pointing to an object/instance. For example, String s = null; 
- s is a reference, that currently references no instance, 
but can reference an instance of the String class.**/