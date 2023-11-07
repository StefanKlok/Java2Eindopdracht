/*
 * Naam Student: Stefan Klok
 * Datum: 7-11-2023
 * Opdrachtnummer: 7 Voetbalclub
 * */
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FCEmmenTest {

    FCEmmen fcEmmen = new FCEmmen();

    @Test
    void voegNieuwTeamToe() {
        int teamnummer = 1;
        fcEmmen.addNewTeam(teamnummer);
        assertTrue(fcEmmen.checkVoorTeam(teamnummer));
    }

    @Test
    void addBestaandeTeam(){
        int teamnummer1 = 1;
        int teamnummer2 = 1;
        fcEmmen.addNewTeam(teamnummer1);
        fcEmmen.addNewTeam(teamnummer2);

        assertEquals(1, fcEmmen.getTeams().size());
    }

    @Test
    void addSpelerToTeam() {
        int teamnummer = 1;
        int rugnummer = 1;
        String naam = "Stefan";

        fcEmmen.addNewTeam(teamnummer);
        fcEmmen.addSpelerToTeam(teamnummer,rugnummer,naam);

        assertTrue(fcEmmen.checkVoorSpeler(teamnummer, rugnummer));
    }

    @Test
    void addBestaandeSpeler(){
        int teamnummer = 1;
        int rugnummer = 1;
        String naam = "Stefan";

        fcEmmen.addNewTeam(teamnummer);
        fcEmmen.addSpelerToTeam(teamnummer,rugnummer,naam);
        fcEmmen.addSpelerToTeam(teamnummer,rugnummer,naam);

        assertEquals(1, fcEmmen.getTeam(teamnummer).getAlleSpelers().size());
    }

    @Test
    void geefGeleKaart() {
        int teamnummer = 1;
        int rugnummer = 1;
        String naam = "Stefan";
        int kaartKleur = 1;

        fcEmmen.addNewTeam(teamnummer);
        fcEmmen.addSpelerToTeam(teamnummer, rugnummer, naam);

        fcEmmen.geefKaart(teamnummer, rugnummer, kaartKleur);
        assertEquals(1, fcEmmen.getTeams().get(teamnummer).getSpeler(rugnummer).getAantalKleurKaarten(kaartKleur));
    }

    @Test
    void geefRodeKaart() {
        int teamnummer = 1;
        int rugnummer = 1;
        String naam = "Speler";
        int kaartKleur = 2;

        fcEmmen.addNewTeam(teamnummer);
        fcEmmen.addSpelerToTeam(teamnummer, rugnummer, naam);

        fcEmmen.geefKaart(teamnummer, rugnummer, kaartKleur);
        assertEquals(1, fcEmmen.getTeams().get(teamnummer).getSpeler(rugnummer).getAantalKleurKaarten(2));
    }

    @Test
    void geefZwarteKaart() {
        int teamnummer = 1;
        int rugnummer = 1;
        String naam = "Speler";
        int kaartKleur = 3;

        fcEmmen.addNewTeam(teamnummer);
        fcEmmen.addSpelerToTeam(teamnummer, rugnummer, naam);

        fcEmmen.geefKaart(teamnummer, rugnummer, kaartKleur);
        assertEquals(1, fcEmmen.getTeams().get(teamnummer).getSpeler(rugnummer).getAantalKleurKaarten(3));
    }

    @Test
    void getSpelersMinsteKaarten() {
        fcEmmen.addNewTeam(1);
        fcEmmen.addSpelerToTeam(1,1,"A");
        fcEmmen.addSpelerToTeam(1,1,"B");
        fcEmmen.addSpelerToTeam(1,1,"C");
        fcEmmen.geefKaart(1,1,1);
        fcEmmen.geefKaart(1,2,1);
        fcEmmen.geefKaart(1, 2, 3);
        fcEmmen.geefKaart(1, 3, 2);

        assertEquals("A ", fcEmmen.getSpelersMinsteKaarten());
    }

    @Test
    void getBoeteBedrag() {
        fcEmmen.addNewTeam(1);
        fcEmmen.addSpelerToTeam(1,1,"a");
        fcEmmen.addSpelerToTeam(1,1,"b");
        fcEmmen.geefKaart(1,1,1);
        fcEmmen.geefKaart(1,1,3);
        fcEmmen.geefKaart(1, 1, 2);

        assertEquals(409.68, fcEmmen.getBoeteBedrag());
    }
}