public class ExperimentalRemoteControlCar implements RemoteControlCar {
    public int metters;
    public int UNITS = 20;

    public void drive() {
        this.metters += this.UNITS;
    }

    public int getDistanceTravelled() {
        return this.metters;
    }
}
