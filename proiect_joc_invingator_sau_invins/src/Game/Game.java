package Game;
import Game.GameWindow.GameWindow;
import Game.Graphics.Assets;
import Game.Input.KeyInput;
import Game.Input.MouseInput;
import Game.States.*;


import java.awt.*;
import java.awt.image.BufferStrategy;
import java.sql.SQLException;

public class Game implements Runnable {
    private GameWindow Window; //fereastra in care v-a fi desenat jocul
    private boolean runState; //flag pt starea firului de exectie
    private Thread gameThread; //referinta pt thread-ul de update si draw al ferestrei
    private BufferStrategy bs; //referinta catre un mecanism ce gestioneaza memoria pentru un canvas
    //sunt cateva tipuri de buffer strategies, scopul lor fiind eliminarea a fenomenului de palpare a ecranului
    //modul in care se v-a implementa aceasta strategie va fi triple-buffer
    private Graphics g;
    public KeyInput keyInput;
    public MouseInput mouseInput;
    public State startState;
    public State chooseCharacter1;
    public State chooseCharacter2;
    public static State level1State;
    public static State level2State;
    public State levelComplet;
    public State pause;
    public State menuState;
    public State win;
    public State fail;
    public State settingsState;
    public State scoreState;
    public Personaj1State personaj1State;
    public Personaj2State personaj2State;
    public static DataBase database;

    public Game(String title, int width, int height) throws InterruptedException {
        Window = new GameWindow(title, width, height);
        runState = false;//flag ce indica starea firului de executie started/stoped
        Links.game=this;
        database=new DataBase();

    }

    /*! \fn private void init()
        \brief  Metoda construieste fereastra jocului, initializeaza aseturile, listenerul de tastatura etc.

        Fereastra jocului va fi construita prin apelul functiei BuildGameWindow();
        Sunt construite elementele grafice (assets): dale, player, elemente active si pasive.

     */

    private void InitGame() throws InterruptedException {
        Window = new GameWindow("Învingător sau învins", 820, 800);
        Window.BuildGameWindow();
        keyInput = new KeyInput();
        mouseInput=new MouseInput();
        Assets.Init();
        Window.GetWindowFrame().addKeyListener(keyInput);
        Window.GetCanvas().addKeyListener(keyInput);
        Window.GetWindowFrame().addMouseListener(mouseInput);
        Window.GetWindowFrame().addMouseMotionListener(mouseInput);
        Window.GetCanvas().addMouseListener(mouseInput);
        Window.GetCanvas().addMouseMotionListener(mouseInput);
        chooseCharacter1=new ChooseCharacter1();
        chooseCharacter2=new ChooseCharacter2();
        level1State=new Level1State();
        level2State=new Level2State();
        startState=new StartState();
        menuState=new MenuState();
        levelComplet=new LevelCompletState();
        pause=new PauseState();
        win=new WinState(this);
        fail=new FailState();
        personaj1State=new Personaj1State();
        personaj2State=new Personaj2State();
        scoreState=new ScoreState();
        settingsState=new SettingsState();

        State.SetState(startState);
        KeyInput keyInput = new KeyInput();
        Draw();
    }
     /*! \fn public void run()
        \brief Functia ce va rula in thread-ul creat.

        Aceasta functie va actualiza starea jocului si va redesena tabla de joc (va actualiza fereastra grafica)
     */

    public void run() {
        try {
            InitGame();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long oldTime = System.nanoTime();//retine timpul aferent frame-ului anterior
        long curentTime;//retine timpul curent de executie
        final int framesPerSecond = 60;
        final double timeFrame = 1000000000 / framesPerSecond;

        while (runState == true) {
            curentTime = System.nanoTime();
            if ((curentTime - oldTime) > timeFrame) {
                try {
                    Update();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    Draw();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                oldTime = curentTime;
            }
        }
    }

    /*! \fn public synchronized void start()
        \brief Creaza si starteaza firul separat de executie (thread).

        Metoda trebuie sa fie declarata synchronized pentru ca apelul acesteia sa fie semaforizat.
     */

    public synchronized void StartGame() {
        if (runState == false) {
            runState = true;
            gameThread = new Thread(this);
            gameThread.start();
        } else {
            return;
        }
    }
     /*! \fn public synchronized void stop()
        \brief Opreste executie thread-ului.

        Metoda trebuie sa fie declarata synchronized pentru ca apelul acesteia sa fie semaforizat.
     */

    public synchronized void StopGame() {
        if (runState == true) {
            runState = false;
            try {
                gameThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            return;
        }
    }
    /*! \fn private void Update()
        \brief Actualizeaza starea elementelor din joc.

        Metoda este declarata privat deoarece trebuie apelata doar in metoda run()
     */

    private void Update() throws InterruptedException, SQLException {

       State.GetState().Update();
    }
     /*! \fn private void Draw()
        \brief Deseneaza elementele grafice in fereastra coresponzator starilor actualizate ale elementelor.

        Metoda este declarata privat deoarece trebuie apelata doar in metoda run()
     */
    private void Draw() throws InterruptedException {
        bs = Window.GetCanvas().getBufferStrategy();
        if (bs == null) {
            try {
                Window.GetCanvas().createBufferStrategy(3);
                return;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        g = bs.getDrawGraphics();
        g.clearRect(0, 0, Window.GetWindowWidth(), Window.GetWindowHeight());


        //***operatie de desenare****//
        Links.g = g;
        State.GetState().Draw();
        bs.show();//se afiseaza pe ecran
        g.dispose();//se elibereaza resursele folosite

    }
    public GameWindow getWnd() {
        return Window;
    }

    public int GetWidth() {
        return Window.GetWindowWidth();
    }

    public int GetHeight() {
        return Window.GetWindowHeight();
    }

    public BufferStrategy getBs(){
        return bs;
    }
    public void setBs(BufferStrategy x)
    {
        bs=x;
    }
    public void sleep(int x) throws InterruptedException {
        gameThread.sleep(x);
    }

}
