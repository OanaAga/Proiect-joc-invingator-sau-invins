package Game;
import Game.States.Level2State;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Time implements ActionListener {
    int seconds =0;
    int elapsedTime = 0;
    boolean started = false;
    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            elapsedTime=elapsedTime+1000;
            seconds = (elapsedTime/1000) % 60;
        }
    });

    @Override
    public void actionPerformed(ActionEvent e) {
        if(Level2State.dublura1 || Level2State.dublura2) {
            if(started==false) {
                started=true;
                start();
            }
            else {
                started=false;
                stop();
            }

        }

    }
    void start() {
        timer.start();
    }

    void stop() {
        timer.stop();
    }
    void reset() {
        timer.stop();
        elapsedTime=0;
        seconds =0;
    }
}
