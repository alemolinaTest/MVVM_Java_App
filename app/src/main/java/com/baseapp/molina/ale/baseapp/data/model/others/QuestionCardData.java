package com.baseapp.molina.ale.baseapp.data.model.others;

import com.baseapp.molina.ale.baseapp.data.model.db.Option;
import com.baseapp.molina.ale.baseapp.data.model.db.Question;

import java.util.List;

/**
 * Created by Amolina on 02/02/17.
 */
//a complex object
public class QuestionCardData {

    public Question question;
    public List<Option> options;
    public boolean mShowCorrectOptions;

    public QuestionCardData(Question question, List<Option> options) {
        this.question = question;
        this.options = options;
    }
}
