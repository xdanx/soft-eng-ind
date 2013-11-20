/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acmetelecom.tests.unit.utils;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.LinkedList;
import java.util.List;
import java.math.BigDecimal;
import com.acmetelecom.utils.MoneyFormatter;

import org.junit.Before;
import org.junit.Test;
/**
 *
 * @author rr2210
 */
public class MoneyFormatterTest 
{
	@Test
	public void penceToPoundsTest() 
        {
		
            assertEquals("0 ", MoneyFormatter.penceToPounds(new BigDecimal("0")),  0 );
            assertEquals("358791 ", MoneyFormatter.penceToPounds(new BigDecimal("358791")),  3587.91 );
	} 
    
}
