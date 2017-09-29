/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genericrest.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author valerialarissa
 */
public class DateUtils {
  private static final String PATTERN = "dd/MM/yyyy";

    public static Date newDate(String date) {
        return newDate(date, PATTERN);
    }

    public static Date newDate(String date, String pattern) {
        try {
            DateFormat formatter = new SimpleDateFormat(pattern);
            return new Date(formatter.parse(date).getTime());
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }  
}
