package com.baseapp.molina.ale.baseapp.data.local.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.baseapp.molina.ale.baseapp.data.model.db.Question;

import java.util.List;

/**
 * Created by Amolina on 02/02/17.
 */
//ROOM Data Access Object - database interactions
@Dao
public interface QuestionDao {

    @Query("SELECT * FROM questions")
    List<Question> loadAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Question question);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Question> questions);

}
