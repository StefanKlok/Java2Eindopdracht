/*
 * Naam Student: Stefan Klok
 * Datum: 7-11-2023
 * Opdrachtnummer: 7 Voetbalclub
 * */
import kaarten.*;
import enums.Kleur;
import java.util.HashMap;

public class Speler {
    private String naam;
    private int rugnummer;
    private boolean gediskwalificeerd;
    private HashMap<Integer, Kaart> kaarten;

    public Speler(String naam, int rugnummer){
        setNaam(naam);
        setRugnummer(rugnummer);
        kaarten = new HashMap<>();
        gediskwalificeerd = false;
    }

    /*
    * Geeft de naam van de speler
    *
    * @return: De naam van de speler als String
    * */
    public String getNaam() {
        return naam;
    }

    /*
    * Bepaal de naam van de speler
    *
    * @param naam: De naam van de speler
    * */
    public void setNaam(String naam){
        this.naam = naam;
    }

    /*
    * Geeft het rugnummer van de speler
    *
    * @return: Het rugnummer van de speler als int
    * */
    public int getRugnummer() {
        return rugnummer;
    }

    /*
    * Bepaal het rugnummer van de speler
    *
    * @param rugnummer: Het rugnummer van de speler
    * */
    public void setRugnummer(int rugnummer){
        this.rugnummer = rugnummer;
    }

    /*
    * Bepaal of de speler gediskwalificeerd is
    *
    * @param gediskwalificeerd: true wanneer de speler gediskwalificeerd is en false wanneer de speler niet
    *                           gediskwalificeerd is
    * */
    public void setGediskwalificeerd(boolean gediskwalificeerd){
        this.gediskwalificeerd = gediskwalificeerd;
    }

    public HashMap<Integer, Kaart> getKaarten(){
        return kaarten;
    }

    /*
     * Berekend de boete die de speler moet betalen
     *
     * @return: Het bedrag als double
     * */
    public double getBoete(){
        double boete = 0;

        // Ga door alle kaarten die de speler heeft en bepaal het boete bedrag van elke kaart
        for(Kaart kaart : kaarten.values()){
            boete += kaart.getBoete();
        }
        return boete;
    }

    /*
     * Geeft het aantal kaarten van een bepaalde kleur die de speler heeft ontvangen
     *
     * @param kleur: een int die staat voor de kleur van een kaart
     * return: Het aantal kaarten als int
     * */
    public int getAantalKleurKaarten(int kleur){
        int aantalKleurKaarten = 0;

        for(Kaart kaart : getKaarten().values()){
            if(kleur == 3){
                if(kaart.getKleur() == Kleur.ZWART){
                    aantalKleurKaarten++;
                }
            }else if(kleur == 2){
                if(kaart.getKleur() == Kleur.ROOD){
                    aantalKleurKaarten++;
                }
            }else if(kleur == 1){
                if(kaart.getKleur() == Kleur.GEEL){
                    aantalKleurKaarten++;
                }
            }
        }

        return aantalKleurKaarten;
    }

    /*
    * Geeft een kaart aan de speler
    *
    * @param kleur: De kleur van de kaart die de speler ontvangt
    * */
    public void geefKaart(int kleur){
        // Bepaal welke kleur kaart de speler heeft ontvangen en geef deze kleur kaart aan de speler
        if(kleur == 1){
            GeleKaart gelekaart = new GeleKaart();
            kaarten.put(kaarten.size()+1, gelekaart);
        }else if(kleur == 2){
            RodeKaart rodeKaart = new RodeKaart();
            kaarten.put(kaarten.size()+1, rodeKaart);
        }else if(kleur == 3){
            ZwarteKaart zwarteKaart = new ZwarteKaart();
            kaarten.put(kaarten.size()+1, zwarteKaart);
            // Diskwalificeer de speler
            setGediskwalificeerd(true);
        }
    }

    /*
    * Geeft het aantal kaarten dat de speler heeft
    *
    * @return: Het aantal kaarten dat de speler heeft als int
    * */
    public int getAantalKaarten(){
        return kaarten.size();
    }
}
