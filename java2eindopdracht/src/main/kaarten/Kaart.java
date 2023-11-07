/*
 * Naam Student: Stefan Klok
 * Datum: 7-11-2023
 * Opdrachtnummer: 7 Voetbalclub
 * */
package kaarten;
import enums.Kleur;
public abstract class Kaart {
    protected double boete;
    protected Kleur kleur;

    public Kaart(Kleur kleur, double boete){
        setKleur(kleur);
        setBoete(boete);
    }

    /*
    * Bepaal de kleur van de kaart
    *
    * @param kleur: De kleur van de kaart
    * */
    public void setKleur(Kleur kleur){
        this.kleur = kleur;
    }

    /*
    * Geeft de kleur van de kaart
    *
    * return: De kleur van de kaart als Kleur
    * */
    public Kleur getKleur(){
        return kleur;
    }

    /*
    * Bepaal de boete waarde van de kaart
    *
    * @param boete: De boete waarde
    * */
    public void setBoete(double boete){
        this.boete = boete;
    }

    /*
    * Haal de boete waarde van de kaart op
    *
    * @return de boete waarde als double
    * */
    public double getBoete(){
        return boete;
    }
}
