package Game;
import Game.Characters.Score;

import java.sql.*;

public class DataBase {
    Connection c=null;
    Statement stmt=null;

    public DataBase(){
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:database.db");
           // c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS SCORE" +
                    "( SCORE_PLAYER1 INT NOT NULL," +
                    " SCORE_PLAYER2 INT NOT NULL," +
                    " ENTITATI_PLAYER1_LEV1 INT NOT NULL," +
                    " ENTITATI_PLAYER2_LEV1 INT NOT NULL,"+
                    " ENTITATI_PLAYER1_LEV2 INT NOT NULL," +
                    " ENTITATI_PLAYER2_LEV2 INT NOT NULL)";
            stmt.executeUpdate(sql);


        } catch (SQLException | ClassNotFoundException e) {
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
    public void updateSave(Score s) throws SQLException {
        String sql = "INSERT INTO SCORE (SCORE_PLAYER1,SCORE_PLAYER2,ENTITATI_PLAYER1_LEV1,ENTITATI_PLAYER2_LEV1,ENTITATI_PLAYER1_LEV2,ENTITATI_PLAYER2_LEV2) " +
                "VALUES ("+s.scor_player1+","+s.scor_player2+","+s.entitati_player1_lev1+","+s.entitati_player2_lev1+","+s.entitati_player1_lev2+","+s.entitati_player2_lev2+");";
        stmt.executeUpdate(sql);
        sql="SELECT *FROM SCORE ORDER BY ENTITATI_PLAYER1_LEV1 DESC";
        stmt.executeUpdate(sql);
    }

}
