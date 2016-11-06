package com.example.lenovo.questionnaire;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Lenovo on 2016/9/25.
 */
public class Result_Anwser extends Activity{


    private ArrayList<Question>  mQuestionList;
    //private String Result="";
    private String Result2="";
    private String TrueResult="";
    private TextView mResultTextView;
    private TextView mTrueTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anwser_result);

        Intent i=getIntent();
        mQuestionList=QuestionList.get(Result_Anwser.this).getQuestions();

        for (int a=0;a<mQuestionList.size();a++){

            /*Result=Result
                    +ActivityFragment.RESULT_QUESTION_ANWSER+a
                    +": "
                    +i.getSerializableExtra(ActivityFragment.RESULT_QUESTION_ANWSER+a)
                    +"\n";*/

            ArrayList<String> RtuLIST= i.getStringArrayListExtra(ActivityFragment.RESULT_QUESTION_ANWSER+a);
            Result2=Result2
                    +ActivityFragment.RESULT_QUESTION_ANWSER+a
                    +": "
                    +RtuLIST
                    +"\n";


            ArrayList<String> anwserList=mQuestionList.get(a).getAnswer();

            TrueResult=TrueResult
                    +"question"+a
                    +": "
                    +anwserList
                 //   +"  "+RtuLIST.equals(anwserList)
                    +"\n";



        }




        mResultTextView=(TextView) findViewById(R.id.result_textview);
        mResultTextView.setText("所选答案\n"+Result2);

        mTrueTextView=(TextView) findViewById(R.id.true_textview);
        mTrueTextView.setText("正确答案\n"+TrueResult);
    }
}
