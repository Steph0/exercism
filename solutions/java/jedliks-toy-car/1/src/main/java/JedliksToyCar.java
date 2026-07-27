import java.text.MessageFormat;

public class JedliksToyCar {

    private int distanceDrivenInMeters = 0;
    private int batteryRemainingPercentage = 100;

    public static JedliksToyCar buy() {
        return new JedliksToyCar();
    }

    public String distanceDisplay() {
        return MessageFormat.format("Driven{0, number, #} meters", distanceDrivenInMeters);
    }

    public String batteryDisplay() {

        return switch (batteryRemainingPercentage) {
            case 0 -> "Battery empty";
            default -> MessageFormat.format("Battery at{0, number, #}%", batteryRemainingPercentage);
        };
    }

    public void drive() {
        if (this.batteryRemainingPercentage > 0) {
            this.distanceDrivenInMeters += 20;
            this.batteryRemainingPercentage--;
        }
    }
}
