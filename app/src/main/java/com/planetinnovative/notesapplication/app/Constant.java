package com.planetinnovative.notesapplication.app;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class Constant {
    public static String SP_DB_NAME = "LoginSystem";
    public static String USERNAME = "USERNAME";
    public static String PASSWORD = "PASSWORD";


    public static Realm getRealm(Context  ctx){
        Realm.init(ctx);
        RealmConfiguration config = new RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build();
        Realm mReal = Realm.getInstance(config);
        return mReal;
    }
}