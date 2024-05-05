import java.util.ArrayList;
import java.util.List;

public class User {
    private String email;
    private List<Movie> favorites;

    // Constructor
    public User(String email) {
        this.email = email;
        this.favorites = new ArrayList<>();
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Add a movie to favorites
    public void addFavorite(Movie movie) {
        favorites.add(movie);
    }

    // Remove a movie from favorites
    public void removeFavorite(Movie movie) {
        favorites.remove(movie);
    }

    // Get list of favorite movies
    public List<Movie> getFavorites() {
        return favorites;
    }
}
