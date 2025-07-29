import java.util.Random;

class CaptainsLog {

    private static final char[] PLANET_CLASSES = new char[]{'D', 'H', 'J', 'K', 'L', 'M', 'N', 'R', 'T', 'Y'};

    private Random random;

    CaptainsLog(Random random) {
        this.random = random;
    }

    char randomPlanetClass() {
        return PLANET_CLASSES[this.random.nextInt(10)] ;
    }

    String randomShipRegistryNumber() {
        return "NCC-" + (1000 + this.random.nextInt(9000));
    }

    double randomStardate() {
        return 41000. + this.random.nextDouble(1000.);
    }
}
