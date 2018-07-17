

package com.baseapp.molina.ale.baseapp.data.model.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Amolina on 02/02/17.
 */
@Entity(tableName = "options", foreignKeys  = @ForeignKey(entity = Question.class,
        parentColumns = "id",
        childColumns = "question_id"))
public class Option {

    @Expose
    @PrimaryKey
    public Long id;

    @Expose
    @SerializedName("option_text")
    @ColumnInfo(name = "option_text")
    public String optionText;

    @Expose
    @SerializedName("question_id")
    @ColumnInfo(name = "question_id")
    public Long questionId;

    @Expose
    @SerializedName("is_correct")
    @ColumnInfo(name = "is_correct")
    public boolean isCorrect;

    @Expose
    @SerializedName("created_at")
    @ColumnInfo(name = "created_at")
    public String createdAt;

    @Expose
    @SerializedName("updated_at")
    @ColumnInfo(name = "updated_at")
    public String updatedAt;

}
