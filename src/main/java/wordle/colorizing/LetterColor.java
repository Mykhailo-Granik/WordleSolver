package wordle.colorizing;

public enum LetterColor {

    GREEN,
    YELLOW,
    GREY;

    public static LetterColor fromNumber(int number) {
        if (number == 0) {
            return GREY;
        }
        if (number == 1) {
            return YELLOW;
        }
        if (number == 2) {
            return GREEN;
        }
        throw new RuntimeException("Unknown color number code" + number);
    }

}
