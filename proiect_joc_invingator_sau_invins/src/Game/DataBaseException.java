package Game;

public class DataBaseException extends Exception{
    /*!
    Exceptie pentru momentul in care utilizatorul doreste sa aleaga acelasi personaj de 2 ori
     */
    public DataBaseException(){
        super("Nu puteti adauga in baza de data daca inca nu s-a terminat jocul");
    }
}
