package dbHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Videogames;

public class ReadRecord {
    
    private Connection conn;
    private ResultSet results;
    
    private Videogames videogame = new Videogames();
    private int v_id;
    
    public ReadRecord(int v_id){
        
        Properties props = new Properties();
        InputStream instr = getClass().getResourceAsStream("dbConnection.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String passwd = props.getProperty("user.password");
        
        this.v_id = v_id;
        
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    } // end of method
    
    public void doRead(){
        try {
            String query = "SELECT * FROM video_games WHERE v_id = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setInt(1, v_id);
            
            this.results = ps.executeQuery();
            this.results.next();
            
                videogame.setV_id(this.results.getInt("v_id"));
                videogame.setV_name(this.results.getString("v_name"));
                videogame.setYears_old(this.results.getInt("years_old"));
                videogame.setGame_type(this.results.getString("game_type"));
                videogame.setRating(this.results.getInt("rating"));
            
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Videogames getVideogame(){
        return this.videogame;
    }
}    
