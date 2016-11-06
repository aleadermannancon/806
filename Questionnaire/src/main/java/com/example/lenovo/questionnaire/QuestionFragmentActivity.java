package com.example.lenovo.questionnaire;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

/**
 * Created by Lenovo on 2016/9/24.
 */
public class QuestionFragmentActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_fragment_layout);

        FragmentManager fm=getSupportFragmentManager();
        Fragment fragment =fm.findFragmentById(R.id.Question_fragmnt);

        if (fragment==null){
            fragment=new ActivityFragment();
            fm.beginTransaction()
                    .add(R.id.Question_fragmnt,fragment)
                    .commit();
        }

    }
}
