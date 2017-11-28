package model;

public class Videogames {
    
    private int v_id;
    private String v_name;
    private int years_old;
    private String game_type; 
    private int rating;

    public Videogames(int v_id, String v_name, int years_old, String game_type, int rating) {
     
       this.v_id = v_id;
        this.v_name = v_name;
        this.years_old = years_old;
        this.game_type = game_type;
        this.rating = rating;
    }
    
    public Videogames() {
     
       this.v_id = 0;
        this.v_name = "";
        this.years_old = 0;
        this.game_type = "";
        this.rating = 0;
    }

    public int getV_id() {
        return v_id;
    }

    public void setV_id(int v_id) {
        this.v_id = v_id;
    }

    public String getV_name() {
        return v_name;
    }

    public void setV_name(String v_name) {
        this.v_name = v_name;
    }

    public int getYears_old() {
        return years_old;
    }

    public void setYears_old(int years_old) {
        this.years_old = years_old;
    }

    public String getGame_type() {
        return game_type;
    }

    public void setGame_type(String game_type) {
        this.game_type = game_type;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Videogames{" + "v_id=" + v_id + ", v_name=" + v_name + ", years_old=" + years_old + ", game_type=" + game_type + ", rating=" + rating + '}';
    }
    
}
