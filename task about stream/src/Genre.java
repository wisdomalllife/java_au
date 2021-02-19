public enum Genre {
    HISTORY("history"),
    STEAMPUNK("steampunk"),
    DRAMA("drama"),
    GAMES("games");

    private String name;

    Genre(String name) { this.name = name; }

    public String getName() { return name; }
}