class NeedForSpeed {

    private static final int DEFAULT_BATTERY_PERCENTAGE = 100;

    private int remainingBatteryPercentage = DEFAULT_BATTERY_PERCENTAGE;
    private int batteryDrainInPercent = 0;

    private int speedInMeters = 0;
    private int distanceDriven = 0;

    NeedForSpeed(int speed, int batteryDrain) {
        this.speedInMeters = Math.max(0, speed);
        this.batteryDrainInPercent = Math.clamp(batteryDrain, 0, DEFAULT_BATTERY_PERCENTAGE);
    }

    public boolean batteryDrained() {
        return remainingBatteryPercentage < batteryDrainInPercent;
    }

    public int distanceDriven() {
        return distanceDriven;
    }

    public void drive() {
        if (!this.batteryDrained()) {
            distanceDriven += speedInMeters;
            remainingBatteryPercentage -= batteryDrainInPercent;
        }
    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }
}

class RaceTrack {

    private int distance = 0;

    RaceTrack(int distance) {
        this.distance = distance;
    }

    public boolean canFinishRace(NeedForSpeed car) {

        while (!car.batteryDrained() && car.distanceDriven() < this.distance) {
            car.drive();
        }

        return (car.distanceDriven() >= this.distance);
    }
}
