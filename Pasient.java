import java.util.*;
class Pasient{
    private static int teller=0;
    String navn;
    String foedselsnummer;
    private int teller2=0; //Inneholder id
    Pasient(String navn, String foedselsnummer){
        teller2=teller;
        teller++; // Øker id hver gang klassen blir instantiert
        this.navn=navn;
        this.foedselsnummer=foedselsnummer;
    }

    private Stack<Resept> stack= new Stack<Resept>();

    public int hentId(){
        return teller2;
    }

    public String hentNavn(){
        return this.navn;
    }

    public String hentFoedselsnummer(){
        return this.foedselsnummer;
    }

    public void leggTilResept(Resept resept){
        stack.add(resept);
    }

    public Stack heleStabel(){
        return stack;
    }
}