public class ExperimentalRemoteControlCar implements RemoteControlCar {

    private int unitsDriven = 0;

    @Override
    public void drive() {
        this.unitsDriven += 20;
    }

    @Override
    public int getDistanceTravelled() {
        return this.unitsDriven;
    }
}
