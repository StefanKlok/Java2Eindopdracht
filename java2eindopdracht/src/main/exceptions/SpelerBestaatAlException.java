/*
 * Naam Student: Stefan Klok
 * Datum: 7-11-2023
 * Opdrachtnummer: 7 Voetbalclub
 * */
package exceptions;

public class SpelerBestaatAlException extends Exception{
    public SpelerBestaatAlException(){
        super("Speler bestaat al");
    }

    public SpelerBestaatAlException(String message){
        super(message);
    }
}
