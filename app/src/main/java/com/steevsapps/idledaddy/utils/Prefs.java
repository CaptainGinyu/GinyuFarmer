package com.steevsapps.idledaddy.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.UUID;

/**
 * SharedPreferences manager
 */
public class Prefs {
    private final static String USERNAME = "username";
    private final static String LOGIN_KEY = "login_key";
    private final static String MACHINE_ID = "machine_id";
    private final static String SENTRY_HASH = "sentry_hash";
    private final static String CM_SERVERS = "cm_servers";
    private final static String OFFLINE = "offline";
    private final static String STAY_AWAKE = "stay_awake";
    private final static String SIMPLE = "simple";
    private final static String MINIMIZE_DATA = "minimize_data";
    private final static String PARENTAL_PIN = "parental_pin";

    private static SharedPreferences prefs;

    private Prefs() {
    }

    public static void init(Context c) {
        if (prefs == null) {
            prefs = PreferenceManager.getDefaultSharedPreferences(c.getApplicationContext());

            if (getMachineId().isEmpty()) {
                // Generate machine id
                writePref(MACHINE_ID, UUID.randomUUID().toString());
            }
        }
    }

    public static SharedPreferences getPrefs() {
        return prefs;
    }

    public static void writeUsername(String username) {
        writePref(USERNAME, username);
    }

    public static void writeLoginKey(String loginKey) {
        writePref(LOGIN_KEY, loginKey);
    }

    public static void writeSentryHash(String sentryHash) {
        writePref(SENTRY_HASH, sentryHash);
    }

    public static void writeCmServers(String servers) {
        writePref(CM_SERVERS, servers);
    }

    public static String getUsername() {
        return prefs.getString(USERNAME, "");
    }

    public static String getLoginKey() {
        return prefs.getString(LOGIN_KEY, "");
    }

    public static String getMachineId() {
        return prefs.getString(MACHINE_ID, "");
    }

    public static String getSentryHash() {
        return prefs.getString(SENTRY_HASH, "");
    }

    public static String getCmServers() {
        return prefs.getString(CM_SERVERS, "");
    }

    public static boolean getOffline() {
        return prefs.getBoolean(OFFLINE, false);
    }

    public static boolean stayAwake() {
        return prefs.getBoolean(STAY_AWAKE, false);
    }

    public static boolean simpleFarming() { return  prefs.getBoolean(SIMPLE, false); }

    public static boolean minimizeData() { return prefs.getBoolean(MINIMIZE_DATA, false); }

    public static String getParentalPin() {
        return prefs.getString(PARENTAL_PIN, "");
    }

    private static void writePref(String key, String value) {
        final SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key, value);
        editor.apply();
    }

    private static void writePref(String key, int value) {
        final SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(key, value);
        editor.apply();
    }
}
