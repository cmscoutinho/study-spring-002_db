package br.com.coutsoft.screenmatch.repository;

import br.com.coutsoft.screenmatch.model.Series;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SeriesRepository extends JpaRepository<Series, Long> {
    Optional<Series> findByTitleContainsIgnoreCase(String title);
}
