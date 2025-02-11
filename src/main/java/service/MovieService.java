package org.example;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class MovieService {
    private static List<Movie> movies = new ArrayList<>();
    private static List<Actor> actors = new ArrayList<>();
    private static List<Director> directors = new ArrayList<>();

    public static void loadMovies(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                movies.add(new Movie(data[0], data[1], data[2], Integer.parseInt(data[3]), Double.parseDouble(data[4])));
            }
        } catch (IOException e) {
            System.err.println("Error loading movies: " + e.getMessage());
        }
    }

    public static void loadActors(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                actors.add(new Actor(data[0], data[1], Integer.parseInt(data[2])));
            }
        } catch (IOException e) {
            System.err.println("Error loading actors: " + e.getMessage());
        }
    }

    public static void loadDirectors(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                directors.add(new Director(data[0], data[1]));
            }
        } catch (IOException e) {
            System.err.println("Error loading directors: " + e.getMessage());
        }
    }

    public static void getMovieInfo(Scanner scanner) {
        System.out.print("Enter movie name: ");
        String name = scanner.nextLine();
        movies.stream()
                .filter(movie -> movie.getTitle().equalsIgnoreCase(name))
                .findFirst()
                .ifPresentOrElse(System.out::println, () -> System.out.println("Movie not found."));
    }

    public static void getTopRatedMovies() {
        movies.stream()
                .sorted(Comparator.comparingDouble(Movie::getRating).reversed())
                .limit(10)
                .forEach(System.out::println);
    }

    public static void getMoviesByGenre(Scanner scanner) {
        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();
        movies.stream()
                .filter(movie -> movie.getGenre().equalsIgnoreCase(genre))
                .forEach(System.out::println);
    }

    public static void getMoviesByDirector(Scanner scanner) {
        System.out.print("Enter director name: ");
        String director = scanner.nextLine();
        movies.stream()
                .filter(movie -> movie.getDirector().equalsIgnoreCase(director))
                .forEach(System.out::println);
    }

    public static void getMoviesByReleaseYear(Scanner scanner) {
        System.out.print("Enter release year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        movies.stream()
                .filter(movie -> movie.getReleaseYear() == year)
                .forEach(System.out::println);
    }

    public static void getMoviesByYearRange(Scanner scanner) {
        System.out.print("Enter start year: ");
        int startYear = scanner.nextInt();
        System.out.print("Enter end year: ");
        int endYear = scanner.nextInt();
        scanner.nextLine();
        movies.stream()
                .filter(movie -> movie.getReleaseYear() >= startYear && movie.getReleaseYear() <= endYear)
                .forEach(System.out::println);
    }

    public static void addMovie(Scanner scanner) {
        System.out.print("Enter movie title: ");
        String title = scanner.nextLine();
        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter director: ");
        String director = scanner.nextLine();
        System.out.print("Enter release year: ");
        int year = scanner.nextInt();
        System.out.print("Enter rating: ");
        double rating = scanner.nextDouble();
        scanner.nextLine();
        movies.add(new Movie(title, genre, director, year, rating));
        System.out.println("Movie added successfully.");
    }

    public static void updateMovieRating(Scanner scanner) {
        System.out.print("Enter movie title: ");
        String title = scanner.nextLine();
        System.out.print("Enter new rating: ");
        double newRating = scanner.nextDouble();
        scanner.nextLine();
        movies.stream()
                .filter(movie -> movie.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .ifPresent(movie -> movie.setRating(newRating));
        System.out.println("Movie rating updated successfully.");
    }

    public static void deleteMovie(Scanner scanner) {
        System.out.print("Enter movie title: ");
        String title = scanner.nextLine();
        movies.removeIf(movie -> movie.getTitle().equalsIgnoreCase(title));
        System.out.println("Movie deleted successfully.");
    }
}
