package com.baseapp.molina.ale.baseapp.ui.main;

import android.graphics.Color;
import android.widget.Button;
import android.widget.TextView;

import com.baseapp.molina.ale.baseapp.R;
import com.baseapp.molina.ale.baseapp.data.model.db.Option;
import com.baseapp.molina.ale.baseapp.data.model.others.QuestionCardData;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;


/**
 * Created by Amolina on 02/02/17.
 */

//using annotation to get the views

@NonReusable
@Layout(R.layout.card_layout)
public class QuestionCard {

    private static final String TAG = "QuestionCard";

    @View(R.id.tv_question_txt)
    private TextView mQuestionTextView;

    @View(R.id.btn_option_1)
    private Button mOption1Button;

    @View(R.id.btn_option_2)
    private Button mOption2Button;

    @View(R.id.btn_option_3)
    private Button mOption3Button;

    private QuestionCardData mQuestionCardData;


    public QuestionCard(QuestionCardData questionCardData) {
        mQuestionCardData = questionCardData;
    }

    @Resolve
    private void onResolved() {

        mQuestionTextView.setText(mQuestionCardData.question.questionText);
        if (mQuestionCardData.mShowCorrectOptions) {
            showCorrectOptions();
        }

        for (int i = 0; i < 3; i++) {
            Button button = null;
            switch (i) {
                case 0:
                    button = mOption1Button;
                    break;
                case 1:
                    button = mOption2Button;
                    break;
                case 2:
                    button = mOption3Button;
                    break;
            }

            if (button != null)
                button.setText(mQuestionCardData.options.get(i).optionText);
        }
    }

    private void showCorrectOptions() {
        mQuestionCardData.mShowCorrectOptions = true;
        for (int i = 0; i < 3; i++) {
            Option option = mQuestionCardData.options.get(i);
            Button button = null;
            switch (i) {
                case 0:
                    button = mOption1Button;
                    break;
                case 1:
                    button = mOption2Button;
                    break;
                case 2:
                    button = mOption3Button;
                    break;
            }
            if (button != null) {
                if (option.isCorrect) {
                    button.setBackgroundColor(Color.GREEN);
                } else {
                    button.setBackgroundColor(Color.RED);
                }
            }
        }
    }

    @Click(R.id.btn_option_1)
    public void onOption1Click() {
        showCorrectOptions();
    }

    @Click(R.id.btn_option_2)
    public void onOption2Click() {
        showCorrectOptions();
    }

    @Click(R.id.btn_option_3)
    public void onOption3Click() {
        showCorrectOptions();
    }

}
