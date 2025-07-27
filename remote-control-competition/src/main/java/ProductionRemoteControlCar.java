class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar> {
    public int metters;
    public int UNITS = 10;
    public int victories;

    public void drive() {
        this.metters += this.UNITS;
    }

    public int getDistanceTravelled() {
        return this.metters;
    }

    public int getNumberOfVictories() {
        return this.victories;
    }

    public void setNumberOfVictories(int numberOfVictories) {
        this.victories = numberOfVictories;
    }

    public int compareTo(ProductionRemoteControlCar o){
        return this.victories - o.victories;
    }
}
