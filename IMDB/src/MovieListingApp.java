import java.util.List;
import java.util.Scanner;

public class MovieListingApp {
    private static Scanner scanner = new Scanner(System.in);
    private static Database database = new Database();
    public  static  String userEmail = " ";

    public static void main(String[] args) {
        // Main menu
        while (true) {
            System.out.println("1. Register");
            System.out.println("2.Add movie");
            System.out.println("3.Show All movies details");
            System.out.println("4. Search Movies");
            System.out.println("5. Add Movie to Favorites");
            System.out.println("6. Remove Movie from Favorites");
            System.out.println("7. View Personal Details and Favorites");
            System.out.println("8. Search Favorites");
            System.out.println("9. User List");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    addMovie();
                    break;
                case 3:
                    showAllMovie();
                    break;
                case 4:
                    searchMovies();
                    break;
                case 5:
                    addMovieToFavorites();
                    break;
                case 6:
                    removeMovieFromFavorites();
                    break;
                case 7:
                    viewPersonalDetailsAndFavorites();
                    break;
                case 8:
                    searchFavorites();
                    break;
                case 9:
                    showAllUser();
                    break;
                case 10:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:

                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to register a user
    private static void registerUser() {
        System.out.print("Enter your email address: ");
        String email = scanner.nextLine();
        userEmail = email;
        database.registerUser(email);
        System.out.println("Registration successful!");

    }
    private static void  showAllUser(){
        database.userList();
    }
    private static void addMovie() {
        Movie movie;
        String title;
        String cast;
        String category;
        String releaseDate;
        double budget;
        System.out.print("Enter Title: ");
        title = scanner.nextLine();
        System.out.print("Enter cast: ");
        cast = scanner.nextLine();
        System.out.print("Enter category: ");
        category = scanner.nextLine();
        System.out.print("Enter releaseDate: ");
        releaseDate = scanner.nextLine();
        System.out.print("Enter budget: ");
        budget = scanner.nextDouble();
        movie = new Movie(title,cast,category,releaseDate,budget);
        database.addMovies(movie);
    }
    private static void showAllMovie(){
        System.out.println("_________________________________________");
        database.showAllMovies();
    }

    // Method to search for movies
    private static void searchMovies() {
        System.out.print("Enter search query (title/cast/category): ");
        String query = scanner.nextLine();
        List<Movie> searchResults = database.searchMovies(query);
        if (searchResults.isEmpty()) {
            System.out.println("No movies found matching your search.");
        } else {
            for (Movie movie : searchResults) {
                System.out.println(movie);
                System.out.println();
            }
            System.out.println("_________________________________________");
        }
    }

    // Method to add a movie to favorites
    private static void addMovieToFavorites() {
        System.out.print("Enter the title of the movie to add to favorites: ");
        String title = scanner.nextLine();
        if (database.addMovieToFavorites(title,userEmail)) {
            System.out.println("Movie added to favorites successfully.");
        } else {
            System.out.println("Movie not found in the database.");
        }
    }

    // Method to remove a movie from favorites
    private static void removeMovieFromFavorites() {
        System.out.print("Enter the title of the movie to remove from favorites: ");
        String title = scanner.nextLine();
        if (database.removeMovieFromFavorites(title,userEmail)) {
            System.out.println("Movie removed from favorites successfully.");
        } else {
            System.out.println("Movie not found in your favorites.");
        }
    }

    // Method to view personal details and favorites
    private static void viewPersonalDetailsAndFavorites() {
        System.out.print("Enter your email address: ");
        String email = scanner.nextLine();
        User user = database.getUser(email);
        if (user != null) {
            System.out.println("Email: " + user.getEmail());
            List<Movie> favorites = user.getFavorites();
            if (favorites.isEmpty()) {
                System.out.println("You have no favorite movies.");
            } else {
                System.out.println("Favorite Movies:");
                for (Movie movie : favorites) {
                    System.out.println(movie.getTitle());
                }
            }
        } else {
            System.out.println("User not found.");
        }
    }

    // Method to search favorites
    private static void searchFavorites() {
        System.out.print("Enter user email: ");
        String email = scanner.nextLine();

        System.out.print("Enter search query for favorites (title/cast/category): ");
        String query = scanner.nextLine();

       boolean isItHasFavourite = database.searchFavorites(query,email);
        if ( isItHasFavourite == false) {
            System.out.println("You did not add this movie your favourite");
        } else {
            System.out.println("This movie have your favourite list");
        }
    }
}
