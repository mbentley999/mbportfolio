package dbHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Videogames;

public class UpdateQuery {
    private Connection conn;
    
    public UpdateQuery(){
        Properties props = new Properties();
        InputStream instr = getClass().getResourceAsStream("dbConnection.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String passwd = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    } // end of method
    
    public void doUpdate(Videogames videogame){
        try {
            String query = "UPDATE video_games SET v_name = ?, years_old = ?, game_type = ?, rating = ? WHERE v_id = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, videogame.getV_name());
            ps.setInt(2, videogame.getYears_old());
            ps.setString(3, videogame.getGame_type());
            ps.setInt(4, videogame.getRating());
            ps.setInt(5, videogame.getV_id());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

    