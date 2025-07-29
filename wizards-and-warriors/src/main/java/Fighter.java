class Fighter {

    boolean isVulnerable() {
        return true;
    }

    int getDamagePoints(Fighter fighter) {
        return 1;
    }
}

class Warrior extends Fighter {

    public String toString() {
        return "Fighter is a Warrior";
    }

    @Override
    boolean isVulnerable() {
        return false;
    }

    @Override
    int getDamagePoints(Fighter fighter) {
        if (fighter.isVulnerable()) {
            return 10;
        } else {
            return 6;
        }
    }

}

class Wizard extends Fighter {
    public boolean spell;

    public String toString() {
        return "Fighter is a Wizard";
    }

    public void prepareSpell() {
        this.spell = true;
    }

    @Override
    boolean isVulnerable() {
        return !this.spell;
    }

    @Override
    int getDamagePoints(Fighter fighter) {
        if (this.spell) {
            return 12;
        } else {
            return 3;
        }
    }

}
