package practice9_2;

/**
 * Enum that defines vacation accrual rates per day for different roles.
 */
public enum VacAccrual {

    STAFF((2 * 7) / 365d),       // 2 weeks per year
    MANAGER((2.5 * 7) / 365d),   // 2.5 weeks per year
    EXECUTIVE((3 * 7) / 365d);   // 3 weeks per year

    private final double perDay;

    VacAccrual ( double perDay ) {
        this.perDay = perDay;
    }

    public double perDay () {
        return perDay;
    }

    // Return accrual rate based on employee role
    public static double byRole ( Role r ) {
        double accrualRate = 0.0d;

        switch (r) {
            case EXECUTIVE:
                accrualRate = EXECUTIVE.perDay;
                break;
            case MANAGER:
                accrualRate = MANAGER.perDay;
                break;
            case STAFF:
                accrualRate = STAFF.perDay;
                break;
        }

        return accrualRate;
    }
}
