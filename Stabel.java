class Stabel<T> extends Lenkeliste <T>{
    
    // Legge til elementer på slutten av listen 
    public void leggPaa(T x) {
        if(stoerrelse()==0){
            leggTil(x);
        }
        else{
            Node node=henter(stoerrelse()-1);
            Node nyNode=new Node(x, null);
            node.setNextNode(nyNode);
            setLast(nyNode);
            oppdaterStoerrelse();
        }
    }

    // Fjerne elementer fra slutten av listen 
    T taAv() {
        return fjern(stoerrelse()-1);
    }

}





/* 
En stabel er en liste som fungerer litt annerledes enn en vanlig lenkeliste. Når man legger et
element inn, skal det være det første som skal hentes ut.

Skriv klassen Stabel<T>. Klassen skal arve fra Lenkeliste<T>, men skal i tillegg ha
metodene leggPaa (T x) og taAv(). Disse metodene skal henholdsvis legge til og fjerne
elementer fra slutten av listen, slik at det siste elementet som legges inn er det første som
tas ut (Last in, First out). Merk: Det forventes her at du tar i bruk metodene som er arvet fra
Lenkeliste<T>. **/

