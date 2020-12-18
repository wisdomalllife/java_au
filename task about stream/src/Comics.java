public class Comics {
    private final String title;
    private final AgeRating ageRating;
    private final Genre genre;

    public Comics(AgeRating ageRating, Genre genre, String title) {
        this.ageRating = ageRating;
        this.genre = genre;
        this.title = title;
    }

    public AgeRating getAgeRating(){ return ageRating; }
    public Genre getGenre(){ return genre;}

}