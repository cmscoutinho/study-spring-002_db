package br.com.coutsoft.screenmatch.model;

import br.com.coutsoft.screenmatch.service.ChatGPTQuery;
import br.com.coutsoft.screenmatch.service.translation.MyMemoryAPIQuery;
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
        this.genre = Category.fromString(seriesData.genre().split(",")[0].trim());
        this.seasons = seriesData.seasons();
        this.actors = seriesData.actors();
        this.releaseDate = seriesData.releaseDate();
        this.rating = OptionalDouble.of(Double.valueOf(seriesData.rating())).orElse(0);
        this.poster = seriesData.poster();
//        this.plot = ChatGPTQuery.getTranslation("portuguese", seriesData.plot().trim());
        this.plot = MyMemoryAPIQuery.getTranslation(seriesData.plot()).trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getGenre() {
        return genre;
    }

    public void setGenre(Category genre) {
        this.genre = genre;
    }

    public Integer getSeasons() {
        return seasons;
    }

    public void setSeasons(Integer seasons) {
        this.seasons = seasons;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    @Override
    public String toString() {
        return "genre=" + genre +
                ", title='" + title + '\'' +
                ", seasons=" + seasons +
                ", actors='" + actors + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", rating=" + rating +
                ", poster='" + poster + '\'' +
                ", plot='" + plot + '\'';
    }
}
