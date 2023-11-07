/*
 * Naam Student: Stefan Klok
 * Datum: 7-11-2023
 * Opdrachtnummer: 7 Voetbalclub
 * */
package exceptions;

public class TeamBestaatNietException extends Exception{
    public TeamBestaatNietException(){
        super("Het team bestaat niet");
    }

    public TeamBestaatNietException(String message){
        super(message);
    }
}
