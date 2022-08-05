package sg.edu.rp.c346.id20014027.moremovieslesson12;

import java.io.Serializable;

public class Movie implements Serializable {
    private int id;
    private String movieTitle;
    private String movieGenre;
    private int movieYear;
    private String movieRating;

    public Movie(int id, String movieTitle, String movieGenre, int movieYear, String movieRating) {
        this.id = id;
        this.movieTitle = movieTitle;
        this.movieGenre = movieGenre;
        this.movieYear = movieYear;
        this.movieRating = movieRating;
    }

    public int getId() {
        return id;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public int getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(int movieYear) {
        this.movieYear = movieYear;
    }

    public String getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(String movieRating) {
        this.movieRating = movieRating;
    }
}
