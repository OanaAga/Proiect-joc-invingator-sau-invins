package Game;

public class ChooseCharacterException extends Exception{
    /*!
    Exceptie pentru momentul in care utilizatorul doreste sa aleaga acelasi personaj de 2 ori
     */
    public ChooseCharacterException(){
        super("Nu puteti alege acelasi personaj.");
    }
}
