import Services.InterestingPlaceDescriptionFinder;
import Services.InterestingPlacesFinder;
import Services.LocationsFinder;
import Services.WeatherInLocationFinder;
import model.Data;


import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String location = scanner.nextLine().trim();
        try {
            Data data = new Data();
            new LocationsFinder(location).find(data);

            System.out.println(data.getLocations());
            int id = scanner.nextInt() - 1;

            int finalId = id;
            CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() -> {
                try {
                    new WeatherInLocationFinder(finalId).find(data);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                return null;
            }).thenCompose(s -> CompletableFuture.supplyAsync(() -> {
                try {
                    new InterestingPlacesFinder(finalId).find(data);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                return null;
            }));

            completableFuture.get();

            System.out.println(data.getWeatherInfo());
            System.out.println(data.getPlaces());


            id  = scanner.nextInt();
            new InterestingPlaceDescriptionFinder(id).find(data);
            System.out.println(data.getDescription());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
