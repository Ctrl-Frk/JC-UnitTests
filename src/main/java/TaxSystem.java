public class TaxSystem {

    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax15 = (earnings - spendings) * 15 / 100;
        if (tax15 >= 0) {
            return tax15;
        } else {
            return 0;
        }
    }

    public static int taxEarnings(int earnings) {
        int tax6 = earnings * 6 / 100;
        if (tax6 >= 0) {
            return tax6;
        } else {
            return 0;
        }
    }

    public static int compareTax(int tax15, int tax6) {
        if (tax15 < tax6) {
            return -1;
        } else if (tax15 > tax6) {
            return 1;
        } else {
            return 0;
        }
    }
}
