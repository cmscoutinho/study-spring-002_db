package br.com.coutsoft.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Episode(@JsonAlias("Episode") String episodeIdx,
                      @JsonAlias("Title") String title,
                      @JsonAlias("Released") String releaseDate,
                      @JsonAlias("imdbRating") String rating) {
//    @Override
//    public String toString() {
//        return "Episode: "  + episodeIdx + "\n" +
//               "Title: "    + title + "\n" +
//               "Released: " + releaseDate + "\n" +
//               "Rating: "    + rating;
//    }
}
