package com.baseapp.molina.ale.baseapp.data.local.db;

import com.baseapp.molina.ale.baseapp.data.model.db.Option;
import com.baseapp.molina.ale.baseapp.data.model.db.Question;
import com.baseapp.molina.ale.baseapp.data.model.db.User;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Amolina on 02/02/17.
 */

public interface DbHelper {

    Observable<Boolean> insertUser(final User user);

    Observable<List<User>> getAllUsers();

    Observable<List<Question>> getAllQuestions();

    Observable<List<Option>> getOptionsForQuestionId(Long questionId);

    Observable<Boolean> isQuestionEmpty();

    Observable<Boolean> isOptionEmpty();

    Observable<Boolean> saveQuestion(Question question);

    Observable<Boolean> saveOption(Option option);

    Observable<Boolean> saveQuestionList(List<Question> questionList);

    Observable<Boolean> saveOptionList(List<Option> optionList);

}
