package Game.GameWindow;

import javax.swing.*;
import java.awt.*;


public class GameWindow {
    public static JFrame WindowFrame;//fereastra principala a jocului
    private String WindowTitle;//titlu
    private int WindowWidth;//latimea ferestrei
    private int WindowHeight;//inaltimea ferestrei

    private Canvas canvas;//panza pe care si va desena\

    public GameWindow(String title,int width,int height){
        WindowTitle=title;
        WindowWidth=width;
        WindowHeight=height;
        WindowFrame=null;
    }
    public void BuildGameWindow()
    {
        if(WindowFrame!=null)
        {
            return;
        }
        WindowFrame=new JFrame(WindowTitle);//fereastra noua
        WindowFrame.setSize(WindowWidth,WindowHeight);
        WindowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//optiune de inchidere
        WindowFrame.setResizable(false);//optiune pt deplasarea personajului doar in fereastra
        WindowFrame.setLocationRelativeTo(null);//localizare fereastra in centrul paginii
        WindowFrame.setVisible(true);//optiune pt a face vizibila fereastra, care initial este ascunsa

        canvas=new Canvas();//creeaza o panza pe care putem desena
        canvas.setPreferredSize(new Dimension(WindowWidth,WindowHeight));
        canvas.setMaximumSize(new Dimension(WindowWidth,WindowHeight));
        canvas.setMinimumSize(new Dimension(WindowWidth,WindowHeight));
        //pt a adauga panza in fereastra creeata
        WindowFrame.add(canvas);
        WindowFrame.pack();//eventuala redimensionar
    }
    public JFrame GetWindowFrame() {
        return WindowFrame;
    }
    public int GetWindowWidth()
    {
        return WindowWidth;
    }
    public int GetWindowHeight()
    {
        return WindowHeight;
    }
    public Canvas GetCanvas(){
        return canvas;
    }
    public static void close()
    {
        WindowFrame.setVisible(false);
        WindowFrame.dispose();

    }
}
