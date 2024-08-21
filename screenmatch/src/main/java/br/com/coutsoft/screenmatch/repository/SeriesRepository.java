package br.com.coutsoft.screenmatch.repository;

import br.com.coutsoft.screenmatch.model.Category;
import br.com.coutsoft.screenmatch.model.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SeriesRepository extends JpaRepository<Series, Long> {
    Optional<Series> findByTitleContainsIgnoreCase(String title);

    List<Series> findByActorsContainingIgnoreCaseAndRatingGreaterThanEqual(String actorName, Double rating);

    List<Series> findTop5ByOrderByRatingDesc();

    List<Series> findByGenre(Category category);

    List<Series> findBySeasonsLessThanEqualAndRatingGreaterThanEqual(Integer numSeasons, Double minRating);

    @Query("SELECT s from Series s WHERE s.seasons <= :numSeasons AND s.rating >= :minRating")
    List<Series> seriesBySeasonsAndRating(Integer numSeasons, double minRating);
}
