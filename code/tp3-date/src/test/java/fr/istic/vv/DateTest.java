package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static fr.istic.vv.Date.isLeapYear;
import static fr.istic.vv.Date.isValidDate;
import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    //isValidDate
        //Date ok
        @Test
        public void dateOK() {
            assertTrue(isValidDate(12,12,1212));
        }
        //Date ok : année très grande
        @Test
        public void dateOKYear() {
            assertTrue(isValidDate(12,12,121222222));
        }
        //Date pas ok : sur le mois
        @Test
        public void dateNotOKmonth() {
            assertFalse(isValidDate(12,13,121222222));
        }
        //Date pas ok : sur le jour
        @Test
        public void dateNotOKday() {
            assertFalse(isValidDate(32,12,121222222));
        }

    //isLeapYear
        //isLeapYear 400 multiple
        @Test
        public void leapYearOk400() {
            assertTrue(isLeapYear(2000));
        }
        //is not Leap Year 100 multiple
        @Test
        public void leapYearNotOk100() {
            assertFalse(isLeapYear(1900));
        }
        // is Leap year classic but not 400 multiple
        @Test
        public void leapYearOk() {
            assertTrue(isLeapYear(2004));
        }
        // is not leap year classic but not 100 multiple
        @Test
        public void leapYearNotOk() {
            assertFalse(isLeapYear(2003));
        }

    //nextDate
        //deux jours normaux
        @Test
        public void dayNextDate() {
            var d1 = new Date(12,12,200);
            var d2 = new Date(13,12,200);
            assertEquals(d1.nextDate().compareTo(d2),0);
        }
        //deux mois différents
        @Test
        public void monthNextDate() {
            var d1 = new Date(30,11,200);
            var d2 = new Date(1,12,200);
            assertEquals(d1.nextDate().compareTo(d2),0);
        }
        //deux années différentes
        @Test
        public void yearNextDate() {
            var d1 = new Date(31,12,2000);
            var d2 = new Date(1,1,2001);
            assertEquals(d1.nextDate().compareTo(d2),0);
        }

    //previousDate
    //deux jours normaux
    @Test
    public void dayPreviousDate() {
        var d2 = new Date(12,12,200);
        var d1 = new Date(13,12,200);
        assertEquals(d1.previousDate().compareTo(d2),0);
    }
    //deux mois différents
    @Test
    public void monthPreviousDate() {
        var d2 = new Date(30,11,200);
        var d1 = new Date(1,12,200);
        assertEquals(d1.previousDate().compareTo(d2),0);
    }
    //deux années différentes
    @Test
    public void yearPreviousDate() {
        var d2 = new Date(31,12,2000);
        var d1 = new Date(1,1,2001);
        assertEquals(d1.previousDate().compareTo(d2),0);
    }

    @Test
    public void throwException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Date(31,13,2000);
        });
        String expectedMessage = "Invalid date.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }





}