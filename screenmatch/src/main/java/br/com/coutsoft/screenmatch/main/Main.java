package br.com.coutsoft.screenmatch.main;

import br.com.coutsoft.screenmatch.model.SeasonData;
import br.com.coutsoft.screenmatch.model.SeriesData;
import br.com.coutsoft.screenmatch.service.APIConsumer;
import br.com.coutsoft.screenmatch.service.DataConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private APIConsumer consumer = new APIConsumer();
    private DataConverter converter = new DataConverter();
    private Scanner scanner = new Scanner(System.in);
    private List<SeriesData> searchedSeries = new ArrayList<>();

    public void main() {
        menu();
    }

    private void menu() {
        int usrChoice = -1;

        while (usrChoice != 4) {
            System.out.println("""
                    Choose one type of search:
                    1-Title search
                    2-Season search
                    3-List searched titles
                    4-Exit
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
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option!");
            }

        }
    }

    private void listSearchedTitles() {
        System.out.println("These are the titles you searched so far:");
        searchedSeries.forEach(System.out::println);
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
        searchedSeries.add(seriesData);
        System.out.println("Output:");
        System.out.println(seriesData);
    }

    private void searchBySeason() {
        SeriesData seriesData = getSeasonData();
        List<SeasonData> seasons = new ArrayList<>();

        for (int i = 1; i <= seriesData.seasons(); i++) {
            String json = consumer.consume(seriesData.title() + "&season=" + i);
            SeasonData seasonData = converter.getData(json, SeasonData.class);
            seasons.add(seasonData);
        }

        seasons.forEach(System.out::println);
    }


}
