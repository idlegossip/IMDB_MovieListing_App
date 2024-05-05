import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Movie> movies;
    private List<User> users;

    public Database() {
        movies = new ArrayList<>();
        users = new ArrayList<>();
        // Add some sample movies to the database
        movies.add(new Movie("The Shawshank Redemption", "Tim Robbins, Morgan Freeman", "Drama", "1994", 25.0));
        movies.add(new Movie("The Godfather", "Marlon Brando, Al Pacino", "Crime", "1972", 6.0));
        movies.add(new Movie("The Dark Knight", "Christian Bale, Heath Ledger", "Action", "2008", 185.0));
    }
     public void addMovies(Movie movie){
        movies.add(movie);
     }
     public void showAllMovies(){
        for(Movie movie : movies){
            System.out.println(movie);
            System.out.println("_________________________________________");
        }
     }

    // Method to register a user
    public void registerUser(String email) {
        users.add(new User(email));
    }

    public void userList(){
        for(User user: users){
            System.out.println(user.getEmail());
        }
    }

    // Method to search for movies
    public List<Movie> searchMovies(String query) {
        List<Movie> results = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                    movie.getCast().toLowerCase().contains(query.toLowerCase()) ||
                    movie.getCategory().toLowerCase().contains(query.toLowerCase())) {
                results.add(movie);
            }
        }
        return results;
    }

    // Method to add a movie to favorites
    public boolean addMovieToFavorites(String title,String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) { // Assuming only one user for simplicity
                for (Movie movie : movies) {
                    if (movie.getTitle().equalsIgnoreCase(title)) {
                        user.addFavorite(movie);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // Method to remove a movie from favorites
    public boolean removeMovieFromFavorites(String title,String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) { // Assuming only one user for simplicity
                for (Movie movie : user.getFavorites()) {
                    if (movie.getTitle().equalsIgnoreCase(title)) {
                        user.removeFavorite(movie);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // Method to retrieve a user by email
    public User getUser(String email) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }
        }
        return null;
    }

    // Method to search favorites
    public boolean searchFavorites(String query,String email) {

        for (User user : users) {
            if(user.getEmail().equals(email)) {
                for (Movie movie : user.getFavorites()) {
                    if (movie.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                            movie.getCast().toLowerCase().contains(query.toLowerCase()) ||
                            movie.getCategory().toLowerCase().contains(query.toLowerCase())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
