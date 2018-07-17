package com.baseapp.molina.ale.baseapp.utils;

/**
 * Created by Amolina on 02/02/17.
 */

public final class AppConstants {

    private AppConstants() {
        // This utility class is not publicly instantiable
    }

    public static final String STATUS_CODE_SUCCESS = "success";
    public static final String STATUS_CODE_FAILED = "failed";

    public static final int API_STATUS_CODE_LOCAL_ERROR = 0;

    public static final String DB_NAME = "amolina_test.db";
    public static final String PREF_NAME = "test_pref";

    public static final long NULL_INDEX = -1L;

    public static final String SEED_DATABASE_OPTIONS = "seed/options.json";
    public static final String SEED_DATABASE_QUESTIONS = "seed/questions.json";

    public static final String DATE_FORMAT = "dd MMM, yyyy at HH:mm:ss";
    public static final String TIMESTAMP_FORMAT = "yyyyMMdd_HHmmss";
}
