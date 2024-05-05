import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class MovieListingAppTest {
    private Database database;

    @BeforeEach
    void setUp() {
        database = new Database();
    }

    @Test
    void testUserRegistration_ValidEmail() {
        String email = "nazim@gmail.com";
        database.registerUser(email);
        assertNotNull(database.getUser(email));
    }

    @Test
    void testUserRegistration_InvalidEmailFormat() {
        String email = "invalid_email";
        assertThrows(IllegalArgumentException.class, () -> {
            database.registerUser(email);
        });
    }

    @Test
    void testSearchMovies_ByTitle() {
        List<Movie> searchResults = database.searchMovies("Shawshank Redemption");
        assertEquals(1, searchResults.size());
        assertEquals("The Shawshank Redemption", searchResults.get(0).getTitle());
    }


    @Test
    void testAddMovieToFavorites() {
        String title = "The Godfather";
        database.addMovieToFavorites(title,"nazim@gmail.com");
        assertEquals(1, database.getUser("nazim@gmail.com").getFavorites().size());
    }


    @Test
    void testRemoveMovieFromFavorites() {
        String title = "The Shawshank Redemption";
        database.removeMovieFromFavorites(title,"nazim@gmail.com");
        assertEquals(0, database.getUser("nazim@gmail.com").getFavorites().size());
    }


    @Test
    void testViewPersonalDetailsAndFavorites_ExistingUser() {
        User user = database.getUser("nazim@gmail.com");
        assertNotNull(user);
        assertEquals("nazim@gmail.com", user.getEmail());
    }

    // Similar test for viewing personal details and favorites for a non-existent user

    @Test
    void testSearchFavorites_ByTitle() {
        boolean searchResults = database.searchFavorites("The Godfather","nazim@gmail.com");
        assertEquals(1, searchResults);
        
    }
}
