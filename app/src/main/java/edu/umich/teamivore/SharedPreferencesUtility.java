package edu.umich.teamivore;

import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

// Shared preferences has no methods that allow us to save lists of strings
// through a bit of string manipulation, we can create our own utility class that allows us to do that

public class SharedPreferencesUtility {


    public static List<String> getStringList(Activity activity, String key) {

        List<String> list = new ArrayList<String>();

        // grab the preferences associated with the activity passed into this method
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        String listString = preferences.getString(key, "");

        Log.i("MyActivity", "Getting" + listString);


        if(listString.length() != 0) {

            // string.split will create an array returning everything in between the provided "delimiter"
            // parameter

            // example: if the string is hello;world;!, calling split(";") on it would return an array
            // with 3 items: "hello", "world", and "!"

            String[] items = listString.split(";");

            // loop through the array and add it to a list so we can give it back to the method caller
            for (String i : items) {
                list.add(i);
            }

        }

        Log.i("MyActivity", "Getting size " + list.size());

        return list;

    }

    public static void putStringList(Activity activity, String key, List<String> list) {

        // for each string in the list, we want to add it to a new variable and separate the strings
        // by putting semicolons in between them

        // TextUtils.join takes a list or array of objects and places them into one string separated
        // by the string in the first parameter (semicolon in this case)

        String listString = TextUtils.join(";", list);

        // save the new combined string into preferences
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, listString);
        editor.apply();

    }

}
