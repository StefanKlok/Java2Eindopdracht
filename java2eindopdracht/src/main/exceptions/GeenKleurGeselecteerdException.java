/*
 * Naam Student: Stefan Klok
 * Datum: 7-11-2023
 * Opdrachtnummer: 7 Voetbalclub
 * */
package exceptions;

public class GeenKleurGeselecteerdException extends Exception{
    public GeenKleurGeselecteerdException(){
        super("Selecteer een kleur");
    }
    public GeenKleurGeselecteerdException(String message){
        super(message);
    }
}
