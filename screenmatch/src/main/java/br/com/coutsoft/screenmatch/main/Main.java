package br.com.coutsoft.screenmatch.main;

import br.com.coutsoft.screenmatch.model.Episode;
import br.com.coutsoft.screenmatch.model.SeasonData;
import br.com.coutsoft.screenmatch.model.Series;
import br.com.coutsoft.screenmatch.model.SeriesData;
import br.com.coutsoft.screenmatch.repository.SeriesRepository;
import br.com.coutsoft.screenmatch.service.APIConsumer;
import br.com.coutsoft.screenmatch.service.DataConverter;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private APIConsumer consumer = new APIConsumer();
    private DataConverter converter = new DataConverter();
    private Scanner scanner = new Scanner(System.in);
    private List<SeriesData> searchedSeries = new ArrayList<>();

    private SeriesRepository repository;

    private List<Series> series = new ArrayList<>();
    public Main(SeriesRepository repository) {
        this.repository = repository;
    }

    public void main() {
        menu();
    }

    private void menu() {
        int usrChoice = -1;

        while (usrChoice != 0) {
            System.out.println("""
                    Choose one type of search:
                    1-Title search
                    2-Season search
                    3-List searched titles
                    4-Find series by title
                    5-Find series by actor
                    0-Exit
                    """);

            usrChoice = scanner.nextInt();
            scanner.nextLine();

            switch (usrChoice) {
                case 1:
                    searchByTitle();
                    break;
                case 2:
                    searchBySeason();
                    break;
                case 3:
                    listSearchedTitles();
                    break;
                case 4:
                    findSeriesByTitle();
                    break;
                case 5:
                    findSeriesByActor();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option!");
            }

        }
    }

    private void listSearchedTitles() {
        series = repository.findAll();
        //        series = searchedSeries.stream()
//                .map(d -> new Series(d))
//                .collect(Collectors.toList());
        System.out.println("These are the titles you searched so far:");
        series.stream()
                .sorted(Comparator.comparing(Series::getGenre))
                .forEach(System.out::println);
    }

    private String readTitle() {
        System.out.print("Type in the Show's title: ");
        String title = scanner.nextLine();
        return title;
    }

    private SeriesData getSeasonData() {
        String title = readTitle();
        String json = consumer.consume(title);
        SeriesData data = converter.getData(json, SeriesData.class);
        return data;
    }

    private void searchByTitle() {
        SeriesData seriesData = getSeasonData();
        Series series = new Series(seriesData);
//        searchedSeries.add(seriesData);
        repository.save(series);
        System.out.println("Output:");
        System.out.println(seriesData);
    }

    private void searchBySeason() {
        listSearchedTitles();
        var seriesName = readTitle();

//        Old method using streams
//        Optional<Series> selectedSeries = series.stream()
//                .filter(s -> s.getTitle().toLowerCase().contains(seriesName.toLowerCase()))
//                .findFirst();

//        New method using the JPA repository
        Optional<Series> selectedSeries = repository.findByTitleContainsIgnoreCase(seriesName);

        if(selectedSeries.isPresent()) {
            //SeriesData seriesData = getSeasonData();
            Series foundSeries = selectedSeries.get();
            List<SeasonData> seasons = new ArrayList<>();

            for (int i = 1; i <= foundSeries.getSeasons(); i++) {
                String json = consumer.consume(foundSeries.getTitle() + "&season=" + i);
                SeasonData seasonData = converter.getData(json, SeasonData.class);
                seasons.add(seasonData);
            }

            seasons.forEach(System.out::println);

            List<Episode> episodes = seasons.stream()
                    .flatMap(d -> d.episodeData().stream()
                            .map(e -> new Episode(d.seasonIdx(), e)))
                    .collect(Collectors.toList());

            foundSeries.setEpisodes(episodes);
            repository.save(foundSeries);
        } else {
            System.out.println("Series not found!");
        }
    }

    private void findSeriesByTitle() {
        System.out.print("Type in the Show's title: ");
        String title = scanner.nextLine();

        Optional<Series> searchedSeries = repository.findByTitleContainsIgnoreCase(title);

        if(searchedSeries.isPresent()) {
            System.out.println("Series data: " + searchedSeries.get());
        } else {
            System.out.println("Series not found!");
        }
    }


    private void findSeriesByActor() {
        System.out.print("Type in the actor's name: ");
        var actorName = scanner.nextLine();
        System.out.print("Rating starting from: ");
        var rating = scanner.nextDouble();
        List<Series> seriesFound = repository.findByActorsContainingIgnoreCaseAndRatingGreaterThanEqual(actorName, rating);
        System.out.println("Shows where " + actorName + " made part:");
        seriesFound.forEach(s ->
                System.out.println(s.getTitle() + " | Rating: " + s.getRating()));
    }
}
