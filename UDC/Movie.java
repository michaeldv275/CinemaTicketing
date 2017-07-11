/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UltimateDesignChallenge;

/**
 *
 * @author Angel
 */
public class Movie {
 
    private String title;
    private String description;
    private String genre;
    private String moviePoster;

    public Movie(String title, String description, String genre, String moviePoster) {
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.moviePoster = moviePoster;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getMoviePoster() {
        return moviePoster;
    }

    public void setMoviePoster(String moviePoster) {
        this.moviePoster = moviePoster;
    }
    
    
}
