package com.digitalrelay.sortablelist;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Chris on 4/26/17.
 */

public class RootApp extends Application {
    //  Identity...
    private static RootApp I;
    //  Properties of the app...  Lists that are accessed globally, Utilities that are used globally, etc...
//    private FragmentUtility FRAG_UTIL;

    //  Fragment Tags to be used through the entire app
    public final static String TAG_FRAGMENT1 = "examplefrag";

    //  Other final static constants...
    //  These should not be storing anything that may be shown in the UI.
    //  Implementing these constants will speed up run time.
    public final static String URL_GOOGLE = "https://www.google.com";

    //  Boilerplate Application Singleton
    public static RootApp getInstance() { return I; }


    //  getters()
//    public FragmentUtility getFragUtil() { return this.FRAG_UTIL; }

    //  setters()

    //  Overridden methods
    @Override
    public void onCreate() {
        super.onCreate();
        I = this;
//        this.FRAG_UTIL = null;
    }

//    public void setFM(AppCompatActivity activity) {
//        this.FRAG_UTIL = new FragmentUtility(activity);
//    }
}
