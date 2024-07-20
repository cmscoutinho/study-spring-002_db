package br.com.coutsoft.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SeriesData(@JsonAlias("Title") String title,
                         @JsonAlias("Genre") String genre,
                         @JsonAlias("totalSeasons") Integer seasons,
                         @JsonAlias("Actors") String actors,
                         @JsonAlias("Released") String releaseDate,
                         @JsonAlias("imdbRating") String rating,
                         @JsonAlias("Poster") String poster,
                         @JsonAlias("Plot") String plot){

//    @Override
//    public String toString() {
//        return "Title: "    + title         + "\n" +
//               "Seasons: "  + seasons       + "\n" +
//               "Released: " + releaseDate   + "\n" +
//               "Rating: "   + rating;
//    }
}
