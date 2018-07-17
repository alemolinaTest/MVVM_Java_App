package com.baseapp.molina.ale.baseapp.data.local.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.baseapp.molina.ale.baseapp.data.model.db.Option;
import com.baseapp.molina.ale.baseapp.data.model.db.Question;
import com.baseapp.molina.ale.baseapp.data.model.db.User;
import com.baseapp.molina.ale.baseapp.data.local.db.dao.OptionDao;
import com.baseapp.molina.ale.baseapp.data.local.db.dao.QuestionDao;
import com.baseapp.molina.ale.baseapp.data.local.db.dao.UserDao;

/**
 * Created by Amolina on 02/02/17.
 */
//the classes to be tables
@Database(entities = {User.class, Question.class, Option.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();

    public abstract QuestionDao questionDao();

    public abstract OptionDao optionDao();

}
