/*
 * Naam Student: Stefan Klok
 * Datum: 7-11-2023
 * Opdrachtnummer: 7 Voetbalclub
 * */
import java.util.HashMap;

public class Team {

    private int teamnummer;
    private HashMap<Integer, Speler> spelers;

    public Team(int teamnummer){
        setTeamnummer(teamnummer);
        spelers = new HashMap<>();
    }

    /*
    * Bepaal het teamnummer van het team
    *
    * @param teamnummer: Het teamnummer van het team
    * */
    public void setTeamnummer(int teamnummer){
        this.teamnummer = teamnummer;
    }

    /*
    * Geeft het teamnummer van het team
    *
    * @return: Het teamnummer als int
    * */
    public int getTeamnummer() {
        return teamnummer;
    }

    /*
    * Voegt een speler aan het team toe
    *
    * @param naam: De naam van de speler
    * @param rugnummer: Het rugnummer van de speler
    * */
    public void addSpeler(String naam, int rugnummer){
        Speler speler = new Speler(naam, rugnummer);
        spelers.put(speler.getRugnummer(), speler);
    }

    /*
    * Geeft een bepaalde speler
    *
    * @param rugnummer: Het rugnummer van de speler die gegeven moet worden
    * @return: De opgevraagde speler als Speler object
    * */
    public Speler getSpeler(int rugnummer){
        return spelers.get(rugnummer);
    }

    /*
    * Geeft alle spelers in het team
    *
    * @return: Een hashmap van alle spelers in het team
    * */
    public HashMap<Integer, Speler> getAlleSpelers(){
        return spelers;
    }

    /*
    * Geef een kaart aan een speler
    *
    * @param rugnummer: Het rugnummer van de speler die een kaart ontvangt
    * @param kleur: De kleur van de kaart die de speler ontvangt
    * */
    public void geefKaart(int rugnummer, int kleur){
        getSpeler(rugnummer).geefKaart(kleur);
    }

    /*
     * Bereken de boete voor alle spelers van het team.
     *
     * @return: Het boetebedrag voor het hele team als double.
     * */
    public double getBoeteTeam(){
        double boete = 0;
        for(Speler speler : spelers.values()){
            boete += speler.getBoete();
        }

        return boete;
    }

    /*
    * Geeft de spelers die het minste/de beste kaarten hebben
    *
    * @param kaarten: Het aantal kaarten per soort die de speler moet hebben
    * @param minstekaarten: Het aantal kaarten dat de speler moet hebben;
    * @return: De naam/namen van de speler(s) die het minste/de beste kaarten hebben als String
    * */
    public String getSpelerMetMinsteKaarten(int[] kaarten){
        String besteSpelers = "";

        // Ga door alle spelers van het team en bepaal welke spelers het minste kaarten hebben en voeg deze spelers
        // toe aan de String van beste spelers
        for(Speler speler : getAlleSpelers().values()){
            if(speler.getAantalKleurKaarten(3) == kaarten[0] && speler.getAantalKleurKaarten(2) == kaarten[1] && speler.getAantalKleurKaarten(1) == kaarten[2]){
                besteSpelers += speler.getNaam() + " ";
            }
        }
        return besteSpelers;

    }

    /*
    * Bepaal het minste aantal kaarten van alle spelers in het team
    *
    * @return: Het minste aantal kaarten als int
    * */
    public int getMinstAantalKaarten(){
        int minsteKaarten = getEersteSpeler().getAantalKaarten();

        // Haal van alle spelers het aantal kaarten op en bepaal het minste aantal
        for(Speler speler : spelers.values()){
            if(speler.getAantalKaarten() < minsteKaarten){
                minsteKaarten = speler.getAantalKaarten();
            }
        }
        return minsteKaarten;
    }

    /*
    * Bepaal het aantal kaarten van de speler met het minste aantal kaarten per soort kaart
    *
    * @param kaarten: het aantal kaarten dat een speler heeft
    * @return: Een array met daarin het aantal zwarte kaarten, het aantal rode kaarten en het aantal gele kaarten
    * */
    public int[] getBesteKaarten(int kaarten){
        // Stop de functie wanneer het aantal gegeven kaarten minder is dan het minste aantal kaarten in het team
        if(kaarten < getMinstAantalKaarten()){
            return new int[]{-1, -1, -1};
        }

        // Maak een hashmap van alle spelers die het minst aantal kaarten hebben
        HashMap<Integer, Speler> spelersMinsteKaarten = new HashMap<>();
        for(Speler speler : spelers.values()){
            if(speler.getAantalKaarten() == kaarten){
                spelersMinsteKaarten.put(speler.getRugnummer(), speler);
            }
        }

        // Maak een nieuwe hashmap waar spelers worden toegevoegd en uiteindelijk vergelijkt met de spelers met het
        // minst aantal kaarten.
        HashMap<Integer, Speler> map = new HashMap<>();

        // Kijk wat het laagste aantal zwarte kaarten zijn
        int aantalZwarteKaarten = getMinsteKleurKaarten(spelersMinsteKaarten, 3);

        // Voeg alle spelers die meer zwarte kaarten hebben dan het minste toe aan de hashmap map
        for(Speler speler : spelersMinsteKaarten.values()){
            if(speler.getAantalKleurKaarten(3) > aantalZwarteKaarten){
                map.put(speler.getRugnummer(), speler);

            }
        }

        // Verwijder alle spelers die meer zwarte kaarten hebben dan het minste aantal zwarte kaarten
        for(int i : map.keySet()){
            spelersMinsteKaarten.remove(i);
        }

        // Kijk wat het laagste aantal zwarte kaarten zijn
        int aantalRodeKaarten = getMinsteKleurKaarten(spelersMinsteKaarten, 2);

        // Voeg alle spelers die meer rode kaarten hebben dan het minste toe aan de hashmap map
        for(Speler speler : spelersMinsteKaarten.values()){
            if(speler.getAantalKleurKaarten(2) > aantalRodeKaarten){
                map.put(speler.getRugnummer(), speler);
            }
        }

        // Verwijder alle spelers die meer rode kaarten hebben dan het minste aantal rode kaarten
        for(int i : map.keySet()){
            spelersMinsteKaarten.remove(i);
        }

        // Kijk wat het laagste aantal gele kaarten zijn
        int aantalGeleKaarten = getMinsteKleurKaarten(spelersMinsteKaarten, 1);

        // Voeg alle spelers die meer gele kaarten hebben dan het minste toe aan de hashmap map
        for(Speler speler : spelersMinsteKaarten.values()){
            if(speler.getAantalKleurKaarten(2) > aantalGeleKaarten){
                map.put(speler.getRugnummer(), speler);
            }
        }

        // Verwijder alle spelers die meer rode kaarten hebben dan het minste aantal rode kaarten
        for(int i : map.keySet()){
            spelersMinsteKaarten.remove(i);
        }

        // Zet de aantallen kaarten in een array
        return new int[]{aantalZwarteKaarten, aantalRodeKaarten, aantalGeleKaarten};
    }

    /*
     * Kijk of er spelers in het team zitten
     *
     * @return: true als er spelers in het team zitten en false wanneer er geen spelers in het team zitten
     * */
    public boolean checkVoorSpelers(){
        return !getAlleSpelers().isEmpty();
    }

    /*
    * Bepaal het minste aantal kaarten van een gegeven kleur van de gegeven spelers
    *
    * @param spelers: De spelers waarvan het minste aantal kaarten gevonden moet worden
    * @return: Het minste aantal kaarten als int
    * */
    private int getMinsteKleurKaarten(HashMap<Integer, Speler> spelers, int kleur){
        int aantalKleurKaarten = getEersteSpeler().getAantalKleurKaarten(kleur);
        for(Speler speler : spelers.values()){
            if(speler.getAantalKleurKaarten(kleur) < aantalKleurKaarten){
                aantalKleurKaarten = speler.getAantalKleurKaarten(1);
            }
        }
        return aantalKleurKaarten;
    }


    /*
     * Geeft de eerst gevonden speler in het team
     *
     * @return: De eeste speler in het team als Speler object
     * */
    private Speler getEersteSpeler(){
        // Kijk eerst of er spelers in het team zitten en daarna wat de eerste speler is
        if(checkVoorSpelers()) {
            for(int rugnummer : getAlleSpelers().keySet()){
                return getSpeler(rugnummer);
            }
        }
        return null;
    }
}
