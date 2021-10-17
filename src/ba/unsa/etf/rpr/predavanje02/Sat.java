package ba.unsa.etf.rpr.predavanje02;

public class Sat {
    private int sati;
    private int minute;
    private int sekunde;
    Sat(int s, int min, int sec) { //konstruktor klase "Sat"
        postavi(s, min, sec);
    }

    public void postavi(int s, int min, int sec) {
        sati = s;
        minute = min;
        sekunde = sec;
    }
    public void sljedeci() {
        sekunde=sekunde+1;
        if(sekunde==60) {sekunde=0;minute=minute+1;}
        if(minute==60) {minute=0;sati=sati+1;}
        if(sati==24) sati=0;
    }
    public void prethodni() {
        sekunde=sekunde-1;
        if(sekunde==-1) {sekunde=59; minute=minute-1; }
        if(minute==-1) {minute=59; sati=sati-1; }
        if(sati==-1) sati=23;
    }
    public void pomjeriZa(int pomak) {
        if(pomak>0) {
            for(int i=0;i<pomak;i++) sljedeci();
        }
        else
            for(int i=0;i<-pomak;i++) prethodni();
    }
    public int dajSate()  {return sati;}
    public int dajMinute() {return minute;}
    public int dajSekunde() {return sekunde;}
    void ispisi()  { //poenta je sto ce ova funkcija raditi i bez "public" jer se poziva iz public static main metode iste klase u kojoj je definirana i ona sama
        System.out.println(sati+":"+minute+":"+sekunde);
    }


    public static void main(String[] args) {
        Sat s = new Sat(15, 30 , 45);
        s.ispisi();
        s.sljedeci();
        s.ispisi();
        s.pomjeriZa(-48);
        s.ispisi();
        s.postavi(0,0,0);
        s.ispisi();
    }
}
