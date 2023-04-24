package Game.Input;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/*! \public class MouseInput extends MouseAdapter
    \brief Trateaza evenimentele de mouse -> apasare click drept pentru selectie , coordonate mouse(trebuie sa stiu pe ce apas )

    Clasa retine daca a fost apasat click pe butonul stang si coordonatele actuale ale mouse-ului

 */
public class MouseInput extends MouseAdapter {
    private static int x, y;             //cele doua coordonate ale mouse-ului
    public static boolean clickRight;           //retine starea click-ului stang clikRight = 1 => este apasat ? clikRight = 0 => nu este apasat

    /*! \fn public void mousePressed(MouseEvent e)
        \brief modifica clikRight il pune pe 1 daca am apasat butonul stang
     */
    @Override                            //suprascriu metoda din  MouseAdapte
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1)
            clickRight = true;
    }

    /*! \fn public void mouseReleased(MouseEvent e)
        \brief brief modifica clikRight il pune pe 1 daca daca butonul stang nu mai este apelat
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1)
            clickRight = false;
    }

    /*! \fn public void mouseMoved(MouseEvent e)
        \brief returneaza coordonatele mouse-ului
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }
    public static int getX() {
        return  x;
    }
    public static int getY() {
        return  y;
    }
}
