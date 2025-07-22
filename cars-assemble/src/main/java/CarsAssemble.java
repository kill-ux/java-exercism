public class CarsAssemble {

    public double productionRatePerHour(int speed) {
        double res = speed * 221;
        if (speed == 10) {
            res *= 0.77;
        } else if (speed == 9) {
            res *= 0.80;
        } else if (speed >= 5) {
            res *= 0.90;
        }
        return res;
    }

    public int workingItemsPerMinute(int speed) {
        return (int) productionRatePerHour(speed) / 60;
    }
}
