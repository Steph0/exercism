public class Lasagna {
    private static final int MINUTES_SPENT_PER_LAYER = 2;
    private static final int TOTAL_COOKING_MINUTES = 40;

    public int expectedMinutesInOven() {
        return TOTAL_COOKING_MINUTES;
    }

    public int remainingMinutesInOven(int minutesSpentInOven) {
        int remainingMinutesInOven = this.expectedMinutesInOven() - minutesSpentInOven;
        return Math.min(
            Math.max(remainingMinutesInOven, 0),
            TOTAL_COOKING_MINUTES
        );
    }

    public int preparationTimeInMinutes(int numberOfLayers) {
        return Math.max(numberOfLayers * MINUTES_SPENT_PER_LAYER, 0);
    }

    public int totalTimeInMinutes(int numberOfLayers, int minutesSpentInOven) {
        return this.preparationTimeInMinutes(numberOfLayers) + Math.max(minutesSpentInOven, 0);
        
    }
}
