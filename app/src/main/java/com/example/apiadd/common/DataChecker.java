package com.example.apiadd.common;

import android.app.AlertDialog;
import android.content.Context;

public class DataChecker {
    public static void Message(String message, Context context)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Ошибка,");
            builder.setMessage(message);
            builder.show();
        }
        public static boolean Proverka(String value)
        {
            return value.matches("[a-z0-9]+@[a-z0-9]+.[a-z]{1,3}");
        }
}
