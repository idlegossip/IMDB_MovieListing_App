public class Movie {
    private String title;
    private String cast;
    private String category;
    private String releaseDate;
    private double budget;

    public void setCast(String cast) {
        this.cast = cast;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Constructor
    public Movie(String title, String cast, String category, String releaseDate, double budget) {
        this.title = title;
        this.cast = cast;
        this.category = category;
        this.releaseDate = releaseDate;
        this.budget = budget;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getCast() {
        return cast;
    }

    public String getCategory() {
        return category;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public double getBudget() {
        return budget;
    }

    // toString method to display movie details
    @Override
    public String toString() {
        return "Title: " + title + "\n" +
                "Cast: " + cast + "\n" +
                "Category: " + category + "\n" +
                "Release Date: " + releaseDate + "\n" +
                "Budget: $" + budget;
    }
}
