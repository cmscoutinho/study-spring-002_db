package br.com.coutsoft.screenmatch.main;

import br.com.coutsoft.screenmatch.model.SeasonData;
import br.com.coutsoft.screenmatch.model.SeriesData;
import br.com.coutsoft.screenmatch.service.APIConsumer;
import br.com.coutsoft.screenmatch.service.DataConverter;

import java.util.List;
import java.util.Scanner;

public class Main {

    private APIConsumer consumer = new APIConsumer();
    private DataConverter converter = new DataConverter();
    private Scanner scanner = new Scanner(System.in);

    public void main() {
        menu();
    }

    private void menu() {
        int usrChoice = -1;

        while (usrChoice != 3) {
            System.out.println("""
                    Choose one type of search:
                    1-Title search
                    2-Season search
                    3-Exit
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
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option!");
            }

        }
    }

    private void searchByTitle() {
        String title = readTitle();

        String json = consumer.consume(title);
        SeriesData data = converter.getData(json, SeriesData.class);
        System.out.println("Output:");
        System.out.println(data);
    }

    private void searchBySeason() {
        String title = readTitle();

        String json = consumer.consume(title + "&season=1");
        SeasonData seasonData = converter.getData(json, SeasonData.class);
        System.out.println(seasonData);
        int seasons = Integer.parseInt(seasonData.totalSeasons());

        for (int i = 2; i <= seasons; i++) {
            json = consumer.consume(title + "&season=" + i);
            seasonData = converter.getData(json, SeasonData.class);
            System.out.println(seasonData);
        }
    }

    private String readTitle() {
        System.out.print("Type in the Show's title: ");
        String title = scanner.nextLine();
        return title;
    }


}
