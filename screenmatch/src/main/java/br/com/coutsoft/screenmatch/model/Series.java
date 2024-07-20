package br.com.coutsoft.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.OptionalDouble;

public class Series {

    private String title;
    private Category genre;
    private Integer seasons;
    private String actors;
    private String releaseDate;
    private Double rating;
    private String poster;
    private String plot;

    public Series(SeriesData seriesData) {
        this.title = seriesData.title();
        this.seasons = seriesData.seasons();
        this.rating = OptionalDouble.of(Double.valueOf(seriesData.rating())).orElse(0);
        this.genre = Category.fromString(seriesData.genre().split(",")[0].trim());
        this.actors = seriesData.actors();
        this.poster = seriesData.poster();
        this.plot = seriesData.plot();
    }

}
