package br.com.coutsoft.screenmatch.main;

import br.com.coutsoft.screenmatch.model.SeasonData;
import br.com.coutsoft.screenmatch.model.SeriesData;
import br.com.coutsoft.screenmatch.service.APIConsumer;
import br.com.coutsoft.screenmatch.service.DataConverter;

import java.util.Scanner;

public class Main {

    private APIConsumer consumer = new APIConsumer();
    private DataConverter converter = new DataConverter();
    private Scanner scanner = new Scanner(System.in);

    public void main() {

        String entry = "friends&season=2";
        String json = consumer.consume(entry);
        System.out.println(converter.getData(json, SeasonData.class));
    }

    private void menu() {
        int usrChoice = -1;

        while (usrChoice != 3) {
            System.out.println("""
                    Choose one type of search:
                    1-Show title
                    2-Show season
                    3-Exit
                    """);

            usrChoice = scanner.nextInt();
            scanner.nextLine();

            switch (usrChoice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid option!");
            }

        }
    }
}
