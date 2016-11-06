package com.example.lenovo.questionnaire;


import android.content.Context;

import java.util.ArrayList;

/**
 * Created by Lenovo on 2016/9/23.
 */
public class QuestionList {
    private static QuestionList mQuestionList;
    private ArrayList<Question> mQuestions;
    private Context mAppContext;

    private QuestionList(Context appContext){
           mAppContext=appContext;
           mQuestions =new ArrayList<Question>();

        for (int i=0;i<4;i++)
        {
           Question ques=new Question();
            ques.setQuestiontext("question     "+i);

            ques.setType(i%4);


            ArrayList<String> cuoldch=new ArrayList<String>();
            cuoldch.add("A"+i);
            cuoldch.add("B"+i);
            cuoldch.add("C"+i);
            cuoldch.add("D"+i);
            ques.setCuoldchose(cuoldch);

            ArrayList<String> answer=new ArrayList<String>();
                answer.add("A"+i);
            if(ques.getType()==Question.TYPE_TWO_C){
                answer.add("B"+i);
            }

            ques.setAnswer(answer);

            mQuestions.add(ques);
        }
    }

    public static QuestionList get(Context c){
        if (mQuestionList==null){
            mQuestionList=new QuestionList(c.getApplicationContext());
        }
        return mQuestionList;
    }

    public  ArrayList<Question> getQuestions()
    {return mQuestions;}


    public void add(Question Q){
        mQuestions.add(Q);
    }

    public void deleteCrime(Question Q)
    {
        mQuestions.remove(Q);
    }
}
