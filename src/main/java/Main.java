package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MovieService.loadMovies("/home/tetarwal005/Desktop/wk_assignment/movie_dataset_insights2/src/main/resources/movies_data.csv");
        MovieService.loadActors("/home/tetarwal005/Desktop/wk_assignment/movie_dataset_insights2/src/main/resources/actors_data.csv");
        MovieService.loadDirectors("/home/tetarwal005/Desktop/wk_assignment/movie_dataset_insights2/src/main/resources/directors_data.csv");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMovie Data Management System");
            System.out.println("1. Get Movie Information");
            System.out.println("2. Get Top 10 Rated Movies");
            System.out.println("3. Get Movies by Genre");
            System.out.println("4. Get Movies by Director");
            System.out.println("5. Get Movies by Release Year");
            System.out.println("6. Get Movies by Year Range");
            System.out.println("7. Add a New Movie");
            System.out.println("8. Update Movie Rating");
            System.out.println("9. Delete a Movie");
            System.out.println("10. Get Top 15 Movies Sorted by Release Year");
            System.out.println("11. Get Directors with Most Movies");
            System.out.println("12. Get Actors Who Worked in Most Movies");
            System.out.println("13. Get Movies of Youngest Actor (as of 10-02-2025)");
            System.out.println("14. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    MovieService.getMovieInfo(scanner);
                    break;
                case 2:
                    MovieService.getTopRatedMovies();
                    break;
                case 3:
                    MovieService.getMoviesByGenre(scanner);
                    break;
                case 4:
                    MovieService.getMoviesByDirector(scanner);
                    break;
                case 5:
                    MovieService.getMoviesByReleaseYear(scanner);
                    break;
                case 6:
                    MovieService.getMoviesByYearRange(scanner);
                    break;
                case 7:
                    MovieService.addMovie(scanner);
                    break;
                case 8:
                    MovieService.updateMovieRating(scanner);
                    break;
                case 9:
                    MovieService.deleteMovie(scanner);
                    break;
                case 10:
                    MovieService.getTopMoviesByYear();
                    break;
                case 11:
                    MovieService.getTopDirectors();
                    break;
                case 12:
                    MovieService.getActorsWithMostMovies();
                    break;
                case 13:
                    MovieService.getYoungestActorMovies();
                    break;
                case 14:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}