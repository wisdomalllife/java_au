public enum AgeRating {
    G("general"),
    PG("parental control"),
    R("restricted");

    private String name;

    AgeRating(String name) { this.name = name; }

    public String getName() { return name; }
}
