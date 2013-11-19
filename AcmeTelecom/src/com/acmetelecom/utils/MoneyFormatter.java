package com.acmetelecom.utils;

import java.math.BigDecimal;

public class MoneyFormatter 
{
    /**
     * 
     * @param pence
     * @return 
     */
    public static String penceToPounds(BigDecimal pence) 
    {
        BigDecimal pounds = pence.divide(new BigDecimal(100));
        return String.format("%.2f", pounds.doubleValue());
    }
}
