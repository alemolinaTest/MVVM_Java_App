package com.baseapp.molina.ale.baseapp.data.model.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Amolina on 02/02/17.
 */
@Entity(tableName = "questions")
public class Question {

    @Expose
    @PrimaryKey
    public Long id;

    @Expose
    @SerializedName("question_text")
    @ColumnInfo(name = "question_text")
    public String questionText;

    @Expose
    @SerializedName("question_img_url")
    @ColumnInfo(name = "question_img_url")
    public String imgUrl;

    @Expose
    @SerializedName("created_at")
    @ColumnInfo(name = "created_at")
    public String createdAt;

    @Expose
    @SerializedName("updated_at")
    @ColumnInfo(name = "updated_at")
    public String updatedAt;

}
