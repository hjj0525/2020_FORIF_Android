package com.example.hw_4;

import android.provider.BaseColumns;

public class DataBases {

    public static final class CreateDB implements BaseColumns{
        public static final String USERID = "userid";
        public static final String PASSWORD = "password";
        public static final String NAME = "name";
        public static final String AGE = "age";
        public static final String _TABLENAME0 = "usertable";
        public static final String _CREATE0 = "create table if not exists "+_TABLENAME0+"("
                +_ID+" integer primary key autoincrement, "
                +USERID+" text not null, "
                +PASSWORD+" text not null , "
                +NAME+" text not null , "
                +AGE+" integer not null );";
    }
}
