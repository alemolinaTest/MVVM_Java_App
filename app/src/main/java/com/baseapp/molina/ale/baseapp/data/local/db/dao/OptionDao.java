package com.baseapp.molina.ale.baseapp.data.local.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.baseapp.molina.ale.baseapp.data.model.db.Option;

import java.util.List;

/**
 * Created by Amolina on 02/02/17.
 */
//ROOM Data Access Object - database interactions
@Dao
public interface OptionDao {

    @Query("SELECT * FROM options")
    List<Option> loadAll();

    @Query("SELECT * FROM options WHERE question_id = :questionId")
    List<Option> loadAllByQuestionId(Long questionId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Option option);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Option> options);

}
