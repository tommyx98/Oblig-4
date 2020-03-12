class Lenkeliste<T> implements Liste<T>{
    @SuppressWarnings ("unchecked")
    private int iBruk=0;
    private Node head;
    private Node last;

    class Node{
        public T data;
        public Node next;

        Node(T data, Node next){
            this.data=data;
            this.next=next;
        }

        Node getNextNode() {
            return this.next;
        }

        void setNextNode(Node x) {
            this.next=x;
        }

        void setData(T x) {
            this.data=x;
        }

        T getData() {
            return this.data;
        }
        
        
    }

     Node getLast(){
            return last;
        }

        void setLast(Node x){
            this.last=x;

        }

    // Skal fjerne på gitt indeks i listen.
    public T fjern(int pos){
        if (pos < 0 || pos >= stoerrelse() || henter(pos) == null) throw new UgyldigListeIndeks(pos);
        Node retur;
       if(pos==0) {
            assert head!=null;
            if (stoerrelse() == 0) throw new UgyldigListeIndeks(0);
            Node foerste=head;
            head=head.getNextNode();
            iBruk--;
            return foerste.getData(); 
       }
       else {
            Node foer=henter(pos-1);
            retur=foer.getNextNode();
            Node etter=retur.getNextNode();
            foer.setNextNode(etter);
       }
       iBruk--;
       return retur.getData();
    }

    /* Skal legge inn et nytt element i listen og skyve neste element 
    ett hakk lenger bak. **/
    public void leggTil(T x){
        Node node= new Node(x, null);
        if(head==null) {
            head=node;
            last=node;
        }
        else {
            last.setNextNode(node);
            last=node;
        }
        iBruk++;
    }

    //Skal legge inn et nytt element i listen og skyve neste element ett hakk lenger bak.
    public void leggTil(int pos, T x) {
        if (pos < 0 || pos > stoerrelse()) throw new UgyldigListeIndeks(pos);

        Node node= new Node(x, null);
        if(head==null) {
            head=node;
            last=node;
        } 
        else {
            Node foer;
            if (pos==0){
                node.setNextNode(head);
                head = node;
                iBruk++;
                return;
            }
            else if (pos == stoerrelse()) {
                last.setNextNode(node);
                last = node;
                iBruk++;
                return;
            }
            else{
                foer=henter(pos-1);
            }

            Node etter=foer.getNextNode();
            foer.setNextNode(node);
            node.setNextNode(etter);
        }
        iBruk++;
    }

    /* Skal sette inn elementet på en gitt posisjon og overskrive det 
    som var der fra før av. **/
    public void sett(int pos, T x){
        if (pos < 0 || pos >= stoerrelse()) throw new UgyldigListeIndeks(pos);
        Node node=henter(pos);
        node.setData(x);
    }

    void oppdaterStoerrelse(){
        iBruk++;
    }
    // Henter størrelsen på lista
    public int stoerrelse(){
        return iBruk;
    }

    /*Henter ut et element (uten å fjerne det fra lista) på oppgitt 
    indeks. **/
    public T hent(int pos){
        if (pos < 0 || pos >= stoerrelse()) throw new UgyldigListeIndeks(pos);
        return henter(pos).getData();
}

    public Node henter(int pos) {
        if (pos==0) {
            return head;
        }
        if (pos == stoerrelse() - 1) {
            return last;
        }
        Node current = head;
        for (int i = 0; i < pos; i++) {
            current = current.getNextNode();
        }
        assert current != null;
        return current;
    }

   // Skal fjerne og returnere elementet på starten av listen.
    public T fjern() {
        assert head!=null;
        if (stoerrelse() == 0) throw new UgyldigListeIndeks(0);
        Node foerste=head;
        head=head.getNextNode();
        iBruk--;
        return foerste.getData(); //Returnere data eller hele elementet
    }
}
