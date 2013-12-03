package com.forwiz.star.Util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class Preference {

	private final static String PREF_NAME = "com.star.pref";

	public static void put(Context ctx, String key, String value) {
		SharedPreferences pref = ctx.getSharedPreferences(PREF_NAME, Activity.MODE_PRIVATE);
		SharedPreferences.Editor editor = pref.edit();

		editor.putString(key, value);
		editor.commit();
	}

	public static void put(Context ctx, String key, boolean value) {
		SharedPreferences pref = ctx.getSharedPreferences(PREF_NAME, Activity.MODE_PRIVATE);
		SharedPreferences.Editor editor = pref.edit();

		editor.putBoolean(key, value);
		editor.commit();
	}

	public static void put(Context ctx, String key, int value) {
		SharedPreferences pref = ctx.getSharedPreferences(PREF_NAME, Activity.MODE_PRIVATE);
		SharedPreferences.Editor editor = pref.edit();

		editor.putInt(key, value);
		editor.commit();
	}

	public static String getValue(Context ctx, String key, String dftValue) {
		SharedPreferences pref = ctx.getSharedPreferences(PREF_NAME, Activity.MODE_PRIVATE);

		try {
			return pref.getString(key, dftValue);
		} catch (Exception e) {
			return dftValue;
		}

	}

	public static int getValue(Context ctx, String key, int dftValue) {
		SharedPreferences pref = ctx.getSharedPreferences(PREF_NAME, Activity.MODE_PRIVATE);

		try {
			return pref.getInt(key, dftValue);
		} catch (Exception e) {
			return dftValue;
		}

	}

	public static boolean getValue(Context ctx, String key, boolean dftValue) {
		SharedPreferences pref = ctx.getSharedPreferences(PREF_NAME, Activity.MODE_PRIVATE);

		try {
			return pref.getBoolean(key, dftValue);
		} catch (Exception e) {
			return dftValue;
		}
	}
}
