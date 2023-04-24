package Game.Characters;
import Game.Game;
import Game.Graphics.Assets;
import Game.Input.KeyInput;
import Game.Links;
import Game.Map.RectangleI;
import Game.States.Level2State;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

public abstract class Elements {
    public BufferedImage[] putere;
    private BufferedImage actual;
    protected int x;                                      //x actual pentru element -> e protectez o sa am acces direct in clasa derivata
    protected int y;
    protected int width;
    protected int height;
    protected int widthR;
    protected int heightR;
    int H = 35;//dimensiunea imaginii personajului
    int W = 35;
    protected BufferedImage img;
    public RectangleI box;
    public boolean right1 = false, left1 = false, up1 = false, down1 = false;
    public boolean play1 = false;
    public boolean right2 = false, left2 = false, up2 = false, down2 = false;
    public boolean play2 = false;
    public int nrEntitati = 0;
    public boolean[] stari = new boolean[9];
    public Rectangle[] entitati=new Rectangle[9];
    public int captura=0;
    public boolean colecteazaAdversar;
    public int secondPassed=0;
    public int scor=0;
    public static Rectangle[] butoaneRect =new Rectangle[4];
    public Elements(int x, int y, int width, int height, int widthR, int heightR, BufferedImage img) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.widthR = widthR;
        this.heightR = heightR;
        this.img = img;
        box = new RectangleI(x + 11, y + 3, widthR, widthR);
        for (int i = 0; i < 9; i++) {
            stari[i] = true;
        }
        butoaneRect[0]=new Rectangle(775+5-17,720-5-2,25,25);
        butoaneRect[1]=new Rectangle(750+5-17,700-5-2,25,25);
        butoaneRect[2]=new Rectangle(725+5-17,720-5-2,25,25);
        butoaneRect[3]=new Rectangle(750+5-17,740-5-2,25,25);

    }
    /*! fn public static boolean GetCollision(Vector<RectangleI> rect, int x, int y, boolean right, boolean left, boolean up, boolean down)
    Aceasta functie v-a returna daca obiectul spre care se indreapta personajul este sau nu in vectorul ce contine elementele
     prin care personajul nu are voie sa patrunda
     */
    public static boolean GetCollision(Vector<RectangleI> rect, int x, int y, boolean right, boolean left, boolean up, boolean down) {
        for (int i = 0; i < rect.size(); i++) {
            //personajul nu este centrat fix in coltul imaginii
            //coordonatele x si y ale personajului repr coordonatele x+10 si y+5 ale pozei
            //(15,30)marimea personajului
            if ((right == true) && ((rect.get(i).r.contains(x + 10 + 15 + 5, y + 5) || (rect.get(i).r.contains(x + 10 + 15 + 5, y + 30 + 5))) == true)) {
                return true;
            } else if ((left == true) && (rect.get(i).r.contains(x + 10 - 5, y + 5) || (rect.get(i).r.contains(x + 10 - 5, y + 5 + 30))) == true) {
                return true;
            } else if ((up == true) && (rect.get(i).r.contains(x + 10, y - 5 + 5) || (rect.get(i).r.contains(x + 10 + 15, y - 5 + 5))) == true) {
                return true;
            } else if ((down == true) && (rect.get(i).r.contains(x + 10, y + 30 + 5 + 5) || (rect.get(i).r.contains(x + 10 + 15, y + 30 + 5 + 5))) == true) {
                return true;
            }

        }

        return false;
    }
    /*! fn public void Update1()
    Aceasta functie v-a porni personajul 1 daca acesta necesita sau nu o miscare(in functie de starea tastelor)
     */
    public void Update1() {
        if(Level2State.stop1==false) {
            if (MoveXPlayer1() == true || MoveYPlayer1() == true)                                                                          //daca am mutari//daca am mutari
            {
                play1 = true;

            } else {
                play1 = false;
            }
        }
    }
    /*! fn void boolean Update2()
   Aceasta functie v-a porni personajul 1 daca acesta necesita sau nu o miscare(in functie de starea tastelor)
    */
    public void Update2() {
        if(Level2State.stop2==false) {
            if (MoveXPlayer2() == true || MoveYPlayer2() == true) {
                play2 = true;
            } else {
                play2 = true;
            }
        }
    }

    /*! fn public boolean MoveXPlayer1()
   Aceasta functie v-a seta unul dintre butoanele pentru miscarea pe axa X a personajului 1
    */
    public boolean MoveXPlayer1() {
        if (Links.game.keyInput.right1 == true) {
            right1 = true;
            x = x + 5;
            this.box.UpdateX(x + 11);
            KeyInput.right1 = false;
            return true;
        } else if (Links.game.keyInput.left1 == true) {
            left1 = true;
            x = x - 5;
            this.box.UpdateX(x + 11);
            KeyInput.left1 = false;
            return true;
        }

        return false;

    }
    /*! fn public boolean MoveYPlayer1()
 Aceasta functie v-a seta unul dintre butoanele pentru miscarea pe axa Y a personajului 1
  */
    public boolean MoveYPlayer1() {
        if (Links.game.keyInput.up1 == true) {
            up1 = true;
            y = y - 5;
            this.box.UpdateY(y + 3);
            KeyInput.up1 = false;
            return true;
        } else if (Links.game.keyInput.down1 == true) {
            down1 = true;
            y = y + 5;
            this.box.UpdateY(y + 3);
            KeyInput.down1 = false;
            return true;
        }
        return false;
    }
    /*! fn public boolean MoveXPlayer2()
 Aceasta functie v-a seta unul dintre butoanele pentru miscarea pe axa X a personajului 2
  */
    public boolean MoveXPlayer2() {
        if (Links.player2.butoaneRect[0].contains(Links.game.mouseInput.getX(),Links.game.mouseInput.getY())&&Links.game.mouseInput.clickRight) {
            right2 = true;
            x = x + 5;
            this.box.UpdateX(x + 11);
            KeyInput.right = false;
            return true;
        } else if (Links.player2.butoaneRect[2].contains(Links.game.mouseInput.getX(),Links.game.mouseInput.getY())&&Links.game.mouseInput.clickRight) {
            left2 = true;
            x = x - 5;
            this.box.UpdateX(x + 11);
            KeyInput.left = false;
            return true;
        }
        return false;

    }

    /*! fn public boolean MoveYPlayer2()
 Aceasta functie v-a seta unul dintre butoanele pentru miscarea pe axa Y a personajului 2
  */
    public boolean MoveYPlayer2() {
        if (Links.player2.butoaneRect[1].contains(Links.game.mouseInput.getX(),Links.game.mouseInput.getY())&&Links.game.mouseInput.clickRight) {
            up2 = true;
            y = y - 5;
            this.box.UpdateY(y + 3);
            KeyInput.up = false;
            return true;
        } else if (Links.player2.butoaneRect[3].contains(Links.game.mouseInput.getX(),Links.game.mouseInput.getY())&&Links.game.mouseInput.clickRight) {
            down2 = true;
            y = y + 5;
            this.box.UpdateY(y + 3);
            KeyInput.down = false;
            return true;
        }
        return false;
    }

    public void Stop() {
        play1 = false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public void setXY(int x,int y){
        this.x=x;
        this.y=y;
    }
    public abstract void Draw();
    /*! fn public void DrawPers(BufferedImage img[])
    Aceasta functie v-a desena imaginile consecutiv pentru personaj(miscarile acestuia)
     */
    public void DrawPers(BufferedImage img[]) {
        BufferedImage actual = img[0];
        Links.g.drawImage(actual, x, y, W, H, null);
        actual = img[1];
        Links.g.drawImage(actual, x, y, W, H, null);
        actual = img[2];
        Links.g.drawImage(actual, x, y, W, H, null);
        actual = img[3];
        Links.g.drawImage(actual, x, y, W, H, null);
        actual = img[4];
        Links.g.drawImage(actual, x, y, W, H, null);
      /*  actual = img[5];
        Links.g.drawImage(actual, x, y, H, W, null);*/
        actual = img[0];
        Links.g.drawImage(actual, x, y, H, W, null);

    }
    /*! fn public void UpdatePosition(int newX, int newY)
    Functie ce schimba pozitia cutiei Personajului
     */
    public void UpdatePosition(int newX, int newY) {
        x = newX;
        y = newY;
    }

    /*! fn public boolean StareEntitate(Rectangle cutieEntitate, int i)
    Functie ce modifica starea entitatilor personajelor in momentul in care personajul le atinge
     */
    public boolean StareEntitate(Rectangle cutieEntitate, int i) {
        if (cutieEntitate.intersects(this.box.r) == true) {

            if (this.stari[i] == true) {

                this.nrEntitati++;
            }
            this.stari[i] = false;

        }
        return this.stari[i];
    }

    /*! fn public void EntityPers1map1(BufferedImage img[])
    Functie ce deseneaza entitatile personajului 1 pe prima mapa
     */
    public void EntityPers1map1(BufferedImage img[]) {
        int h = 40, w = 40;
        Rectangle entitati[] = new Rectangle[9];
        BufferedImage actual;
        for (int i = 0; i < 5; i++) {
            actual = img[i];
            entitati[0] = new Rectangle(2 * 40 + 10, 17 * 40 - 20, 10, 10);
            if (this.StareEntitate(entitati[0], 0) == true && this.stari[0] == true) {
                Links.g.drawImage(actual, 2 * 40 + 10, 17 * 40 - 20, h, w, null);
            }
            entitati[1] = new Rectangle(2 * 40 + 10, 16 * 40 - 10, 10, 10);
            if (this.StareEntitate(entitati[1], 1) == true && this.stari[1]) {
                Links.g.drawImage(actual, 2 * 40 + 10, 16 * 40 - 10, h, w, null);
            }

            entitati[2] = new Rectangle(2 * 40 + 10, 15 * 40, 10, 10);
            if (this.StareEntitate(entitati[2], 2) == true && this.stari[2]) {
                Links.g.drawImage(actual, 2 * 40 + 10, 15 * 40, h, w, null);
            }

            entitati[3] = new Rectangle(380 - 8, 405 - 15, 10, 10);
            if (this.StareEntitate(entitati[3], 3) == true && this.stari[3]) {
                Links.g.drawImage(actual, 380 - 8, 405 - 15, h, w, null);
            }


            entitati[4] = new Rectangle(380 - 8, 405 - 40, 10, 10);
            if (this.StareEntitate(entitati[4], 4) == true && this.stari[4] == true) {
                Links.g.drawImage(actual, 380 - 8, 405 - 40, h, w, null);
            }

            entitati[5] = new Rectangle(380 + 20, 405 - 40, 10, 10);
            if (this.StareEntitate(entitati[5], 5) == true && this.stari[5] == true) {
                Links.g.drawImage(actual, 380 + 20, 405 - 40, h, w, null);
            }
            entitati[6] = new Rectangle(260, 50, 10, 10);
            if (this.StareEntitate(entitati[6], 6) == true && this.stari[6] == true) {
                Links.g.drawImage(actual, 260, 50, h, w, null);
            }
            entitati[7] = new Rectangle(260 + 30, 50, 10, 10);
            if (this.StareEntitate(entitati[7], 7) == true && this.stari[7] == true) {
                Links.g.drawImage(actual, 260 + 30, 50, h, w, null);
            }
            entitati[8] = new Rectangle(260 + 60, 50, 10, 10);
            if (this.StareEntitate(entitati[8], 8) == true && this.stari[8] == true) {
                Links.g.drawImage(actual, 260 + 60, 50, h, w, null);
            }
            this.entitati=entitati;
        }
    }
    /*! fn public void EntityPers2map1(BufferedImage img[])
    Functie ce deseneaza entitatile personajului 2 pe prima mapa
     */
    public void EntityPers2map1(BufferedImage img[]) {
        int h = 40, w = 40;
        Rectangle entitati[] = new Rectangle[9];
        BufferedImage actual;
        for (int i = 0; i < 5; i++) {
            actual = img[i];
            entitati[0] = new Rectangle(15 * 40, 18 * 40 + 10, 10, 10);
            if (this.StareEntitate(entitati[0], 0) == true && this.stari[0] == true) {
                Links.g.drawImage(actual, 15 * 40, 18 * 40 + 10, h, w, null);
            }

            entitati[1] = new Rectangle(15 * 40 + 30, 18 * 40 + 10, 10, 10);
            if (this.StareEntitate(entitati[1], 1) == true && this.stari[1] == true) {
                Links.g.drawImage(actual, 15 * 40 + 30, 18 * 40 + 10, h, w, null);
            }

            entitati[2] = new Rectangle(16 * 40 + 20, 18 * 40 + 10, 10, 10);
            if (this.StareEntitate(entitati[2], 2) == true && this.stari[2] == true) {
                Links.g.drawImage(actual, 16 * 40 + 20, 18 * 40 + 10, h, w, null);
            }

            entitati[3] = new Rectangle(222 - 10, 335, 10, 10);
            if (this.StareEntitate(entitati[3], 3) == true && this.stari[3] == true) {
                Links.g.drawImage(actual, 222 - 10, 335, h, w, null);
            }
            entitati[4] = new Rectangle(222 - 10, 335 + 30, 10, 10);
            if (this.StareEntitate(entitati[4], 4) == true && this.stari[4] == true) {
                Links.g.drawImage(actual, 222 - 10, 335 + 30, h, w, null);
            }

            entitati[5] = new Rectangle(222 - 10, 335 + 60, 10, 10);
            if (this.StareEntitate(entitati[5], 5) == true && this.stari[5] == true) {
                Links.g.drawImage(actual, 222 - 10, 335 + 60, h, w, null);
            }
            entitati[6] = new Rectangle(777 - 10 + 2, 405, 10, 10);
            if (this.StareEntitate(entitati[6], 6) == true && this.stari[6] == true) {
                Links.g.drawImage(actual, 777 - 10 + 2, 405, h, w, null);
            }
            entitati[7] = new Rectangle(777 - 10 + 2, 405 - 30, 10, 10);
            if (this.StareEntitate(entitati[7], 7) == true && this.stari[7] == true) {
                Links.g.drawImage(actual, 777 - 10 + 2, 405 - 30, h, w, null);
            }
            entitati[8] = new Rectangle(777 - 10 + 2, 405 - 60, 10, 10);
            if (this.StareEntitate(entitati[8], 8) == true && this.stari[8] == true) {
                Links.g.drawImage(actual, 777 - 10 + 2, 405 - 60, h, w, null);
            }
            this.entitati=entitati;
        }

    }

    /*! fn public void EntityPers1map2(BufferedImage img[])
    Functie ce deseneaza entitatile personajului 1 pe a 2-a mapa
     */
    public void EntityPers1map2(BufferedImage img[]) {
        int h = 40, w = 40;
        Rectangle entitati[] = new Rectangle[9];
        BufferedImage actual;

        for (int i = 0; i < 5; i++) {
            actual = img[i];
            entitati[0] = new Rectangle(15*40, 17*40+20-5, 10, 10);
            if (this.StareEntitate(entitati[0], 0) == true && this.stari[0] == true) {
                Links.g.drawImage(actual, 15*40, 17*40+20, h, w, null);
            }
            entitati[1] = new Rectangle(15*40+40, 17*40+20-5, 10, 10);
            if (this.StareEntitate(entitati[1], 1) == true && this.stari[1] == true) {
                Links.g.drawImage(actual, 15*40+40, 17*40+20, h, w, null);
            }

            entitati[2] = new Rectangle(15*40+80, 17*40+20-5, 10, 10);
            if (this.StareEntitate(entitati[2], 2) == true && this.stari[2] == true) {
                Links.g.drawImage(actual, 15*40+80, 17*40+20, h, w, null);
            }

            entitati[3] = new Rectangle(415 + 38, 420 - 5, 10, 10);
            if (this.StareEntitate(entitati[3], 3) == true && this.stari[3] == true) {
                Links.g.drawImage(actual, 415 + 38, 420, h, w, null);
                //Links.g.drawRect(415,420, 10, 10);
            }


            entitati[4] = new Rectangle(415 + 38, 420 + 40 - 5, 10, 10);
            if (this.StareEntitate(entitati[4], 4) == true && this.stari[4] == true) {
                Links.g.drawImage(actual, 415 + 38, 420 + 40, h, w, null);
            }

            entitati[5] = new Rectangle(415 + 38, 420 + 80 - 5, 10, 10);
            if (this.StareEntitate(entitati[5], 5) == true && this.stari[5] == true) {
                Links.g.drawImage(actual, 415 + 38, 420 + 80, h, w, null);


            }
            //entitati ce pot fi capturate
            entitati[6] = new Rectangle(4*40+10, 6*40+10, 10, 10);
            if (this.StareEntitate(entitati[6], 6) == true && this.stari[6] == true) {
                Links.g.drawImage(actual, 4*40+10, 6*40+10, h, w, null);
                //    Links.g.drawRect(340-10,255-10, 35, 35);
            }
            entitati[7] = new Rectangle(4*40+10, 6*40+40+10, 10, 10);
            if (this.StareEntitate(entitati[7], 7) == true && this.stari[7] == true) {
                Links.g.drawImage(actual, 4*40+10, 6*40+40+10, h, w, null);
            }
            entitati[8] = new Rectangle(4*40+10, 6*40+80+10, 10, 10);
            if (this.StareEntitate(entitati[8], 8) == true && this.stari[8] == true) {
                Links.g.drawImage(actual, 4*40+10, 6*40+80+10, h, w, null);
            }
            this.entitati=entitati;
        }
    }
    /*! fn public void EntityPers2map2(BufferedImage img[])
    Functie ce deseneaza entitatile personajului 2 pe a 2-a mapa
     */
    public void EntityPers2map2(BufferedImage img[]) {
        int h = 40, w = 40;
        Rectangle entitati[] = new Rectangle[9];
        BufferedImage actual;
        for (int i = 0; i < 5; i++) {
            actual = img[i];
            entitati[0] = new Rectangle(520 + 15, 160 + 20 - 10, 10, 10);
            if (this.StareEntitate(entitati[0], 0) == true && this.stari[0] == true) {
                Links.g.drawImage(actual, 520 + 15, 160 + 20, h, w, null);
                //  Links.g.drawRect(520 + 15-10, 160 + 20-10, h, w);
            }
            entitati[1] = new Rectangle(520 + 15, 160 + 40 + 20 - 10, 10, 10);
            if (this.StareEntitate(entitati[1], 1) == true && this.stari[1] == true) {
                Links.g.drawImage(actual, 520 + 15, 160 + 40 + 20, h, w, null);

            }

            entitati[2] = new Rectangle(520 + 15, 160 + 40 + 40 + 20 - 10, 10, 10);
            if (this.StareEntitate(entitati[2], 2) == true && this.stari[2] == true) {
                Links.g.drawImage(actual, 520 + 15, 160 + 40 + 40 + 20, h, w, null);
            }

            entitati[3] = new Rectangle(335, 120 - 30, 10, 10);
            if (this.StareEntitate(entitati[3], 3) == true && this.stari[3] == true) {
                Links.g.drawImage(actual, 335, 120 - 30, h, w, null);
                // Links.g.drawRect(335-10,120-30-10, h, w);

            }

            entitati[4] = new Rectangle(335 , 120 + 40 - 30, 10, 10);
            if (this.StareEntitate(entitati[4], 4) == true && this.stari[4] == true) {
                Links.g.drawImage(actual, 335, 120 + 40 - 30, h, w, null);

            }

            entitati[5] = new Rectangle(335 , 120 + 40 + 40 - 30, 10, 10);
            if (this.StareEntitate(entitati[5], 5) == true && this.stari[5] == true) {
                Links.g.drawImage(actual, 335, 120 + 40 + 40 - 30, h, w, null);
            }
            //entitati pot fi capturate
            entitati[6] = new Rectangle(615, 300, 10, 10);
            if (this.StareEntitate(entitati[6], 6) == true && this.stari[6] == true) {
                Links.g.drawImage(actual, 615, 300, h, w, null);
            }
            entitati[7] = new Rectangle(615, 300 + 40, 10, 10);
            if (this.StareEntitate(entitati[7], 7) == true && this.stari[7] == true) {
                Links.g.drawImage(actual, 615, 300 + 40, h, w, null);
            }

            entitati[8] = new Rectangle(615, 300 + 80, 10, 10);
            if (this.StareEntitate(entitati[8], 8) == true && this.stari[8] == true) {
                Links.g.drawImage(actual, 615, 300 + 80, h, w, null);
            }
            this.entitati=entitati;
        }

    }
    /*! fn public Elements SuperPutere(BufferedImage image[],int x,int y) {
    Functie ce creeaza si deseneaza Dublura unuia dintre personaje
     */
    public Elements SuperPutere(BufferedImage image[],int x,int y) {
        Elements DoublePers = new Elements(x,y,40,40,15, 30,image[0] ) {

            @Override
            public void Draw() {
                DrawPers(image);
            }
        };
        return DoublePers;
    }
    public void resetare()
    {
         nrEntitati = 0;
         for(int i=0;i<9;i++)
            stari[i] =false;
         captura=0;
        colecteazaAdversar=false;
        secondPassed=0;
        scor=0;
    }

}


