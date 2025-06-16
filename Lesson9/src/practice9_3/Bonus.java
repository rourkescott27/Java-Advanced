package practice9_3;

/**
 * Enum representing bonus percentages for different employee roles.
 */
public enum Bonus {

    STAFF(0.02),       // Staff get a 2% bonus
    MANAGER(0.04),     // Managers get a 4% bonus
    EXECUTIVE(0.06);   // Executives get a 6% bonus

    private final double percent;

    Bonus(double percent) {
        this.percent = percent;
    }

    // Getter for the bonus percentage
    public double percent() {
        return percent;
    }

    // Static method to return the bonus percentage based on role
    public static double byRole( Role r) {
        double bonusPercent = 0.0d;

        switch (r) {
            case EXECUTIVE:
                bonusPercent = EXECUTIVE.percent;
                break;
            case MANAGER:
                bonusPercent = MANAGER.percent;
                break;
            case STAFF:
                bonusPercent = STAFF.percent;
                break;
        }

        return bonusPercent;
    }
}
