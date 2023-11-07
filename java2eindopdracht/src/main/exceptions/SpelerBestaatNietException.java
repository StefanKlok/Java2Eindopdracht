/*
 * Naam Student: Stefan Klok
 * Datum: 7-11-2023
 * Opdrachtnummer: 7 Voetbalclub
 * */
package exceptions;

public class SpelerBestaatNietException extends Exception{
    public SpelerBestaatNietException(){
        super("Deze speler bestaat niet");
    }

    public SpelerBestaatNietException(String message){
        super(message);
    }
}
