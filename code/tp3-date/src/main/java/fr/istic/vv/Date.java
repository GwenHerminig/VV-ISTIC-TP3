package fr.istic.vv;

class Date implements Comparable<Date> {

    private final int day;
    private final int month;
    private final int year;
    public Date(int day, int month, int year) {
        if (!isValidDate(day, month, year)) {
            throw new IllegalArgumentException("Invalid date.");
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public static boolean isValidDate(int day, int month, int year) {
        if (month < 1 || month > 12) {
        return false;
    }
        if (day < 1 || day > getDaysInMonth(month, year)) {
            return false;
        }
        return true;
    }

    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
        return true;
        }
        if (year % 100 == 0) {
            return false;
        }
        return (year % 4 == 0);
    }

    private static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 2:
                return isLeapYear(year) ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }
    public Date nextDate() {
        int nextDay = day + 1;
        int nextMonth = month;
        int nextYear = year;
        if (nextDay > getDaysInMonth(month, year)) {
            nextDay = 1;
            nextMonth++;
            if (nextMonth > 12) {
                nextMonth = 1;
                nextYear++;
            }
        }
        return new Date(nextDay, nextMonth, nextYear);
    }

    public Date previousDate() {
        int previousDay = day - 1;
        int previousMonth = month;
        int previousYear = year;
        if (previousDay == 0) {
            previousMonth--;
            if (previousMonth == 0) {
                previousMonth = 12;
                previousYear--;
            }
            previousDay = getDaysInMonth(previousMonth, previousYear);
        }
        return new Date(previousDay, previousMonth, previousYear);
    }

    public int compareTo(Date other) {
        if (this.year != other.year) {
            return Integer.compare(this.year, other.year);
        }
        if (this.month != other.month) {
            return Integer.compare(this.month, other.month);
        }
        return Integer.compare(this.day, other.day);
    }

}