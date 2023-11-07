/*
 * Naam Student: Stefan Klok
 * Datum: 7-11-2023
 * Opdrachtnummer: 7 Voetbalclub
 * */
package exceptions;

public class TeamBestaatAlException extends Exception{
    public TeamBestaatAlException(){
        super("Team bestaat al");
    }

    public TeamBestaatAlException(String message){
        super(message);
    }
}
