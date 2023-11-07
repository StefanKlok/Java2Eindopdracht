/*
 * Naam Student: Stefan Klok
 * Datum: 7-11-2023
 * Opdrachtnummer: 7 Voetbalclub
 * */
import java.util.HashMap;
import exceptions.*;

public class FCEmmen {

    // Atributes
    private HashMap<Integer, Team> teams;       // A HashMap to contain all the teams

    // Initializer
    public FCEmmen(){
        teams = new HashMap<>();                // Setup the HashMap
    }

    /*
    * Geeft een team
    *
    * @param teamnummer: Het teamnummer van het team dat opgevraagd wordt
    * @return: Het team als Team object
    * */
    public Team getTeam(int teamnummer){
        return teams.get(teamnummer);
    }

    /*
    * Add a new team to the teams map
    * @param teamnummer: het nummer van het team
    * @param team: het team dat aan de map wordt toegevoegd
    *  */
    public void addNewTeam(Integer teamnummer){
        // Probeer om een nieuw team toe te voegen
        try {
            // Kijk of het team al bestaat
            if(checkVoorTeam(teamnummer)){
                throw new TeamBestaatAlException();
            }

            // Als het team nog niet bestaat, maak dan een nieuw team aan
            Team team = new Team(teamnummer);
            teams.put(team.getTeamnummer(), team);
        }catch(Exception exception){
            // Do nothing
        }
    }

    /*
    * Voeg een speler toe aan een team
    *
    * @param teamnummer: Het team waar de speler aan toegevoegd moet worden
    * @param rugnummer: Het rugnummer van de speler
    * @param naam: De naam van de speler
    * */
    public void addSpelerToTeam(int teamnummer, int rugnummer, String naam){
        //Probeer om de speler toe te voegen aan een team
        try{
            // Kijk of het team wel bestaat en of er al een speler met dat rugnummer bestaat
            if(!checkVoorTeam(teamnummer) || checkVoorSpeler(teamnummer, rugnummer)){
                throw new Exception();
            }
            // Voeg de speler aan het juiste team toe
            teams.get(teamnummer).addSpeler(naam, rugnummer);
        }catch(Exception exception){
            // do nothing
        }
    }

    /*
    * Geef een kaart aan een speler
    *
    * @param teamnummer: Het team waar de speler die een kaart ontvangt in speelt
    * @param rugnummer: Het rugnummer van de speler
    * @param kleur: De kleur van de kaart
    * */
    public void geefKaart(int teamnummer, int rugnummer, int kleur){
        try {
            if(!checkVoorSpeler(teamnummer, rugnummer)){
                throw new SpelerBestaatNietException();
            }
            teams.get(teamnummer).geefKaart(rugnummer, kleur);
        }catch(SpelerBestaatNietException exception){
            // Do nothing
        }
    }

    /*
    * Bepaal of het gegeven team bij FC Emmen speelt
    *
    * @param teamnummer: Het teamnummer van het team
    * @return: true als het team bij FC Emmen speelt en false als het dat niet doet
    * */
    public boolean checkVoorTeam(int teamNummer){
        return getTeams().containsKey(teamNummer);
    }

    /*
    * Kijkt of er teams zijn
    *
    * @return: true als er teams zijn en false als er geen teams zijn
    * */
    public boolean checkVoorTeams(){
        return !getTeams().isEmpty();
    }

    /*
    * Bepaal of de gegeven speler bij FC Emmen speelt
    *
    * @param teamnummer: Het teamnummer waar de speler in speelt
    * @param rugnummer: Het rugnummer dat de speler heeft
    * @return: true als de gegeven speler bij FC Emmen speelt en false als hij dat niet doet
    * */
    public boolean checkVoorSpeler(int teamNummer, int rugnummer){
        return getTeams().get(teamNummer).getAlleSpelers().containsKey(rugnummer);
    }

    /*
    * Kijkt of er een speler is in een team
    *
    * @return: true als er spelers zijn en false als er geen spelers zijn
    * */
    public boolean checkVoorSpelers(){
        boolean spelers = false;

        if(checkVoorTeams()){
            for(Team team : getTeams().values()){
                if(team.checkVoorSpelers()){
                    spelers = team.checkVoorSpelers();
                }
            }
        }
        return spelers;
    }

    /*
    * Geeft alle teams
    *
    * @return: Een hashmap met daarin alle teams
    * */
    public HashMap<Integer, Team> getTeams(){
        return teams;
    }


    /*
     * Geeft het bedrag dat FC Emmen aan de National Soccer Association moet betalen
     *
     * @return: Het totaalbedrag dat betaald moet worden
     * */
    public double getBoeteBedrag(){
        double boete = 0;

        // Bereken per team het boetebedrag en voeg deze toe aan het totaal
        for(Team team : getTeams().values()) {
            boete += team.getBoeteTeam();
        }
        return boete;
    }

    /*
    * Bepaal welke speler(s) de minste/beste kaarten hebben
    *
    * @return: De speler(s) met de minste/beste kaarten als een String
    * */
    public String getSpelersMinsteKaarten(){
        // Bepaal het minste aantal kaarten en de beste kaarten
        int[] besteKaarten = getBesteKaarten(getMinstAantalKaarten());

        String besteSpelers = "";

        // Bepaal per team welke speler(s) de minste/beste kaarten hebben en voeg deze toe aan de String
        for(Team team : getTeams().values()){
            if(team.checkVoorSpelers()) {
                besteSpelers += team.getSpelerMetMinsteKaarten(besteKaarten);
            }
        }

        return besteSpelers;
    }


    /*
    * Bepaal wat het minste aantal kaarten is van alle spelers
    * */
    private int getMinstAantalKaarten(){
        int minsteAantalKaarten = -1;

        // Bekijk van elk team wat het minste aantal kaarten is en bepaal vervolgens wat van alle teams het minste
        // aantal kaarten is
        for(Team team : getTeams().values()){
            if(team.checkVoorSpelers()) {
                if (minsteAantalKaarten == -1) {
                    minsteAantalKaarten = team.getMinstAantalKaarten();
                } else if (team.getMinstAantalKaarten() < minsteAantalKaarten) {
                    minsteAantalKaarten = team.getMinstAantalKaarten();
                }
            }
        }
        return minsteAantalKaarten;
    }

    /*
    * Bepaal wat de beste kaarten zijn
    * De beste kaarten zijn het aantal kaarten van alle soorten kaarten dat de speler met het minste aantal kaarten heeft
    *
    * @param kaarten: Het aantal kaarten dat de speler heeft waarvan de beste kaarten bepaalt moeten worden
    * return: Een array met het aantal zwarte, rode en gele
    * */
    private int[] getBesteKaarten(int kaarten){
        int besteGeel = -1;
        int besteRood = -1;
        int besteZwart = -1;

        HashMap<Team, int[]> teamsBesteKaarten = new HashMap<>();
        for(Team team : getTeams().values()){
            if(team.checkVoorSpelers()) {
                int[] kaartenSet = team.getBesteKaarten(kaarten);
                // Als 1 van de verschillende soorten kaarten niet -1 is dan moet de gegeven set kaarten toe worden gevoegd
                // aan de beste kaarten van elke team
                if (kaartenSet[0] != -1 || kaartenSet[1] != -1 || kaartenSet[2] != -1) {
                    teamsBesteKaarten.put(team, team.getBesteKaarten(kaarten));
                }
            }
        }

        // Bepaal wat het minste aantal zwarte kaarten zijn en verwijder elke set kaarten waarbij het aantal zwarte
        // kaarten meer is
        besteZwart = setAantalBesteKaarten(teamsBesteKaarten, 0);
        teamsBesteKaarten = verwijderTeamKaarten(teamsBesteKaarten, 0, besteZwart);

        // Bepaal wat het minste aantal rode kaarten zijn en verwijder elke set kaarten waarbij het aantal rode
        // kaarten meer is
        besteRood = setAantalBesteKaarten(teamsBesteKaarten, 1);
        teamsBesteKaarten = verwijderTeamKaarten(teamsBesteKaarten, 1, besteRood);

        // Bepaal wat het minste aantal zwarte kaarten zijn
        besteGeel = setAantalBesteKaarten(teamsBesteKaarten, 2);

        // Maak een array met de beste aantal zwarte, rode en gele kaarten
        return new int[]{besteZwart, besteRood, besteGeel};
    }

    /*
    * Bepaal het aantal kaarten van een kaartset van beste kaarten van een team voor een bepaalde kleur
    *
    * @param teamsBesteKaarten: Een hashmap met als key een team en als value een kaartset van de beste kaarten van dat
    *                           team
    * @param kaartKleur: een getal dat staat voor een bepaalde kleur kaart
    * @return: Het minste aantal kaarten van een bepaalde kleur kaart
    * */
    private int setAantalBesteKaarten(HashMap<Team, int[]> teamsBesteKaarten, int kaartKleur){
        int aantalBesteKaart = -1;

        for(int[] kleurkaarten : teamsBesteKaarten.values()){
            if(aantalBesteKaart == -1){
                aantalBesteKaart = kleurkaarten[kaartKleur];
            }else if(kleurkaarten[kaartKleur] < aantalBesteKaart){
                aantalBesteKaart = kleurkaarten[kaartKleur];
            }
        }

        return aantalBesteKaart;
    }

    /*
    * Verwijder het team en kaartset uit de teamsBesteKaarten hashmap waarvan het aantal kaarten meer is dan het minste
    * aantal kaarten
    *
    * @param teamsBesteKaarten: Een hashmap met als key een team en als value een kaartset van de beste kaarten van dat
    *                           team
    * @param kaartKleur: Een getal dat staat voor een bepaalde kleur kaart
    * @param besteAantalKaarten: Het minste aantal kaarten van een bepaalde kleur kaart
    * @return: Een hashmap van de teams met bijbehorende kaartset van beste kaarten dat overblijft
    * */
    private HashMap<Team, int[]> verwijderTeamKaarten(HashMap<Team, int[]> teamsBesteKaarten, int kaartKleur, int besteAantalKaarten){
        for(Team team : teamsBesteKaarten.keySet()){
            int[] kaarten = teamsBesteKaarten.get(team);
            if(kaarten[kaartKleur] > besteAantalKaarten){
                teamsBesteKaarten.remove(team);
            }
        }

        return teamsBesteKaarten;
    }

}
