package enums;

public enum SandwichSize {
    FOUR_INCH,
    EIGHT_INCH,
    TWELVE_INCH;

    public String getName() {
        return name().charAt(0) + name().substring(1).toLowerCase().replace("_", " ");
    }
}
