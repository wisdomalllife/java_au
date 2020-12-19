public class Colors {
    private String title;

    private Colors(String title) {
        this.title = title;
    }

    public static Colors Black = new Colors("Черный");
    public static Colors Grey = new Colors("Серый");
    public static Colors White = new Colors("Белый");

    @Override
    public String toString() {
        return "Colors{" +
                "title='" + title + '\'' +
                '}';
    }
}
