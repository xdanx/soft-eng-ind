/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acmetelecom.utils;

import com.acmetelecom.calls.Call;
import java.math.BigDecimal;

/**
 *
 * @author rr2210
 */
    public class LineItem 
    {
        private Call call;
        private BigDecimal callCost;

        public LineItem(Call call, BigDecimal callCost) {
            this.call = call;
            this.callCost = callCost;
        }

        public String date() {
            return call.date();
        }

        public String callee() {
            return call.callee();
        }

        public String durationMinutes() {
            return "" + call.durationSeconds() / 60 + ":" + String.format("%02d", call.durationSeconds() % 60);
        }

        public BigDecimal cost() {
            return callCost;
        }
    }
