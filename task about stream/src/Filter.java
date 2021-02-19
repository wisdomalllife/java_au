import java.util.Arrays;
import java.util.List;

public class Filter {
    public static boolean getComparison(List<Comics> comics){
        long historyPGCount = comics.stream()
                .filter(x -> x.getAgeRating().equals(AgeRating.PG))
                .filter(x -> x.getGenre().equals(Genre.HISTORY))
                .count();
        long dramaRCount = comics.stream()
                .filter(x -> x.getAgeRating().equals(AgeRating.R))
                .filter(x -> x.getGenre().equals(Genre.DRAMA))
                .count();
        return  dramaRCount > historyPGCount;
    }

    public static List<Comics> generateComicsList() {
        return Arrays.asList(
                new Comics(AgeRating.PG, Genre.HISTORY,"Шотландская удача"),
                new Comics(AgeRating.PG, Genre.HISTORY, "Прислуга"),
                new Comics(AgeRating.R, Genre.HISTORY, "Эннеада"),
                new Comics(AgeRating.R, Genre.DRAMA,"Милый рот"),
                new Comics(AgeRating.R, Genre.DRAMA,"Сколопендра"),
                new Comics(AgeRating.R, Genre.DRAMA,"После дождя"),
                new Comics(AgeRating.R, Genre.DRAMA,"Белый шум"),
                new Comics(AgeRating.G, Genre.DRAMA,"Дело в шляпе"),
                new Comics(AgeRating.R, Genre.DRAMA,"Розовая нить"),
                new Comics(AgeRating.PG, Genre.GAMES,"FifthTale"),
                new Comics(AgeRating.R, Genre.GAMES,"Идиоты Азерота"),
                new Comics(AgeRating.PG, Genre.GAMES,"Сказание Элизиума"),
                new Comics(AgeRating.PG, Genre.STEAMPUNK,"Spy Beat"),
                new Comics(AgeRating.R, Genre.STEAMPUNK,"Заговор Единорогов"),
                new Comics(AgeRating.R, Genre.STEAMPUNK,"Попаданец!18+"),
                new Comics(AgeRating.R, Genre.STEAMPUNK,"Радужный эпос")
        );
    }
}