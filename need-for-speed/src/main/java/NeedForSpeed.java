class NeedForSpeed {

    public int speed;
    public int batteryDrain;
    private int BATTERY = 100;
    private int meters = 0;

    NeedForSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.batteryDrain = batteryDrain;
    }

    public boolean batteryDrained() {
        return this.BATTERY < this.batteryDrain;
    }

    public int distanceDriven() {
        return this.meters;
    }

    public void drive() {
        if (this.BATTERY > 0) {
            this.meters += this.speed;
            this.BATTERY -= this.batteryDrain;
        }
    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }
}

class RaceTrack {

    private int distance;

    RaceTrack(int distance) {
        this.distance = distance;
    }

    public boolean canFinishRace(NeedForSpeed car) {
        int res = 100;
        int res_dist = 0;
        while (res > car.batteryDrain) {
            res = -car.batteryDrain;
            res_dist += car.speed;
        }
        return this.distance <= res_dist;
    }
}
