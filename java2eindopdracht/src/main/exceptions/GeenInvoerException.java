/*
 * Naam Student: Stefan Klok
 * Datum: 7-11-2023
 * Opdrachtnummer: 7 Voetbalclub
 * */
package exceptions;

public class GeenInvoerException extends Exception{
    public GeenInvoerException(){
        super("Dit veld moet ingevuld worden");
    };

    public GeenInvoerException(String message){
        super(message);
    }
}
