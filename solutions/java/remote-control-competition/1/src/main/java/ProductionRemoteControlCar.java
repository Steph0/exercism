class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar> {

    private int unitsDriven = 0;
    private int numberOfVictories = 0;

    @Override
    public void drive() {
        this.unitsDriven += 10;
    }

    @Override
    public int getDistanceTravelled() {
        return this.unitsDriven;
    }

    public int getNumberOfVictories() {
        return this.numberOfVictories;
    }

    public void setNumberOfVictories(int numberOfVictories) {
        this.numberOfVictories = Math.max(0, numberOfVictories);
    }

    @Override
    public int compareTo(ProductionRemoteControlCar o) {
        if (o.getNumberOfVictories() > this.getNumberOfVictories()) {
            return 1;
        }

        if (o.getNumberOfVictories() < this.getNumberOfVictories()) {
            return -1;
        }

        return 0;
    }
}
