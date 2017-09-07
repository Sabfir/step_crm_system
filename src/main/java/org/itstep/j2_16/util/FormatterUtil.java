package org.itstep.j2_16.util;

import java.math.BigDecimal;

import static java.math.BigDecimal.ROUND_HALF_UP;

public class FormatterUtil {

    public static float round(float number, int decimalPlace) {
        BigDecimal numberBD = new BigDecimal(Float.toString(number));
        numberBD = numberBD.setScale(decimalPlace, ROUND_HALF_UP);
        return numberBD.floatValue();
    }
}
