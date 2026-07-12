import java.util.Arrays;

class BirdWatcher {
    private final int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public static int[] getLastWeek() {
        return new int[] {0, 2, 5, 3, 7, 8, 4};
    }

    public int getToday() {
        return birdsPerDay[birdsPerDay.length-1];
    }

    public void incrementTodaysCount() {
        birdsPerDay[birdsPerDay.length-1] += 1;
    }

    public boolean hasDayWithoutBirds() {
        return Arrays
            .stream(birdsPerDay)
            .anyMatch(numberOfBirds -> numberOfBirds == 0);
    }

    public int getCountForFirstDays(int numberOfDays) {
        int boundary = Math.clamp(numberOfDays, 0, birdsPerDay.length);
        return Arrays
            .stream(birdsPerDay, 0, boundary)
            .sum();
    }

    public int getBusyDays() {
        return Math.toIntExact(
            Arrays
            .stream(birdsPerDay)
            .filter(numberOfBirds -> numberOfBirds >= 5)
            .count()
        );
    }
}
