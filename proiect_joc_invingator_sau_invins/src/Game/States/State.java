package Game.States;
import Game.Characters.Elements;

import java.sql.SQLException;

public abstract class State {
    private static State currentState=null;
    protected boolean level1;
    protected boolean level2;
    public static void SetState(State s){currentState=s;}
    public static State GetState(){return currentState;}
    public abstract void Update() throws InterruptedException, SQLException;
    public abstract void Draw() throws InterruptedException;
}
