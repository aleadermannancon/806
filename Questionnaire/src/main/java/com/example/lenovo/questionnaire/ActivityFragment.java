package com.example.lenovo.questionnaire;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Lenovo on 2016/9/22.
 */
public class ActivityFragment extends Fragment{
       private TextView mQuestionText;
       private EditText mQuestionEdit;
       private Button mNextButton;
       private ImageView mImageView;
       private RadioGroup mOneCh;
       private LinearLayout mtwoCh_Checkbox;
       private ArrayList<Question> mQuestionList;
       private Question mQuestion;

       private RadioButton mOneCh_A;
       private RadioButton mOneCh_B;
       private RadioButton mOneCh_C;
       private RadioButton mOneCh_D;

       private CheckBox mtwoCh_A;
       private CheckBox mtwoCh_B;
       private CheckBox mtwoCh_C;
       private CheckBox mtwoCh_D;

       private  int i;

        Intent SetAnwser=null;

       private String Result=null;
       public static final String RESULT_QUESTION_ANWSER="question";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mQuestionList=QuestionList.get(getActivity()).getQuestions();
     //   Toast.makeText(getActivity(),"  "+mQuestionList.size()+"  ",Toast.LENGTH_LONG).show();
        SetAnwser=new Intent(getActivity(),Result_Anwser.class);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.question_main,container,false);
        i=0;

        mQuestion=mQuestionList.get(i);


        mQuestionText=(TextView)v.findViewById(R.id.question_text);

        mQuestionText.setText(mQuestion.getQuestiontext());


        mImageView=(ImageView)v.findViewById(R.id.imageview);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"只是充当摆设而已",Toast.LENGTH_SHORT).show();
            }
        });


        mOneCh=(RadioGroup)v.findViewById(R.id.question_one_ch);
        mtwoCh_Checkbox=(LinearLayout)v.findViewById(R.id.question_two_ch);
        mQuestionEdit=(EditText)v.findViewById(R.id.question_edit);

        mOneCh.setVisibility(View.GONE);
        mtwoCh_Checkbox.setVisibility(View.VISIBLE);

      //  Toast.makeText(getActivity(),"  "+mQuestionList.size()+"  ",Toast.LENGTH_LONG).show();

        mOneCh_A=(RadioButton)v.findViewById(R.id.question_one_A);
        mOneCh_B=(RadioButton)v.findViewById(R.id.question_one_B);
        mOneCh_C=(RadioButton)v.findViewById(R.id.question_one_C);
        mOneCh_D=(RadioButton)v.findViewById(R.id.question_one_D);

        mtwoCh_A=(CheckBox)v.findViewById(R.id.question_two_A);
        mtwoCh_B=(CheckBox)v.findViewById(R.id.question_two_B);
        mtwoCh_C=(CheckBox)v.findViewById(R.id.question_two_C);
        mtwoCh_D=(CheckBox)v.findViewById(R.id.question_two_D);



        whichType(i);

        mNextButton=(Button)v.findViewById(R.id.question_next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getLastAnwser(i);

                i=i+1;

                if(i<mQuestionList.size()){
                    mQuestion=mQuestionList.get(i);

                    mQuestionText.setText(mQuestion.getQuestiontext());

                    whichType(i);

                }
               else if (i==mQuestionList.size()){
                   // Toast.makeText(getActivity(),"  "+"后面没了"+"  ",Toast.LENGTH_LONG).show();
                     mNextButton.setText("回答结束,查看结果");
                  //  mNextButton.setEnabled(false);
                    mNextButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(SetAnwser);
                        }
                    });

                }
            }
        });

        return v;
    }



    public void whichType(int i)
    {
        mQuestion=mQuestionList.get(i);
        ArrayList<String> couldCH=mQuestion.getCuoldchose();

        if (mQuestion.getType()==Question.TYPE_ONE_C)
        {

           // Toast.makeText(getActivity(),"  "+"单选题"+"  ",Toast.LENGTH_LONG).show();
            mOneCh.setVisibility(View.VISIBLE);
            mtwoCh_Checkbox.setVisibility(View.GONE);
            mQuestionEdit.setVisibility(View.GONE);

            mOneCh_A.setText(couldCH.get(0).toString());
            mOneCh_B.setText(couldCH.get(1).toString());

            mOneCh_C.setVisibility(View.VISIBLE);
            mOneCh_D.setVisibility(View.VISIBLE);
            mOneCh_C.setText(couldCH.get(2).toString());
            mOneCh_D.setText(couldCH.get(3).toString());

            return;
        }else if (mQuestion.getType()==Question.TYPE_TWO_C)
        {
         //   Toast.makeText(getActivity(),"  "+"多选题"+"  ",Toast.LENGTH_LONG).show();
            mOneCh.setVisibility(View.GONE);
            mtwoCh_Checkbox.setVisibility(View.VISIBLE);
            mQuestionEdit.setVisibility(View.GONE);

            mtwoCh_A.setText(couldCH.get(0).toString());
            mtwoCh_B.setText(couldCH.get(1).toString());
            mtwoCh_C.setText(couldCH.get(2).toString());
            mtwoCh_D.setText(couldCH.get(3).toString());

            return;
        }else if (mQuestion.getType()==Question.TYPE_TRUE_FALSE_C)
        {
          //  Toast.makeText(getActivity(),"  "+"判断题"+"  ",Toast.LENGTH_LONG).show();
            mOneCh.setVisibility(View.VISIBLE);
            mtwoCh_Checkbox.setVisibility(View.GONE);
            mQuestionEdit.setVisibility(View.GONE);

            mOneCh_A.setText("正确");
            mOneCh_B.setText("错误");
            mOneCh_C.setVisibility(View.GONE);
            mOneCh_D.setVisibility(View.GONE);

            return;
        }else {
          //  Toast.makeText(getActivity(),"  "+"问答题"+"  ",Toast.LENGTH_LONG).show();
            mOneCh.setVisibility(View.GONE);
            mtwoCh_Checkbox.setVisibility(View.GONE);
            mQuestionEdit.setVisibility(View.VISIBLE);

            mQuestionEdit.setText("");

            return;
        }

    }

    public void  getLastAnwser(int i){
         mQuestion=mQuestionList.get(i);
        ArrayList<String> ResultList=new ArrayList<String>();
       Result="";
        if (mQuestion.getType()==Question.TYPE_ONE_C)
        {
                    if (mOneCh.getCheckedRadioButtonId()>0) {
                        Result =((RadioButton) getActivity().findViewById(mOneCh.getCheckedRadioButtonId())).getText().toString();

                       // Toast.makeText(getActivity(), mOneCh.getCheckedRadioButtonId() + "", Toast.LENGTH_LONG).show();
                       SetAnwser.putExtra(RESULT_QUESTION_ANWSER+i,Result);
                        ResultList.add(Result);
                        SetAnwser.putStringArrayListExtra(RESULT_QUESTION_ANWSER+i,ResultList);
                    }

                         return;
        }else if (mQuestion.getType()==Question.TYPE_TWO_C)
        {
                if (mtwoCh_A.isChecked())
                {
                    Result=Result+" "+mtwoCh_A.getText();
                    ResultList.add(mtwoCh_A.getText().toString());
                }
                if(mtwoCh_B.isChecked()){
                    Result=Result+" "+mtwoCh_B.getText();
                    ResultList.add(mtwoCh_B.getText().toString());
                }
               if(mtwoCh_C.isChecked()){
                    Result=Result+" "+mtwoCh_C.getText();
                   ResultList.add(mtwoCh_C.getText().toString());
                }
                if(mtwoCh_D.isChecked()){
                    Result=Result+" "+mtwoCh_D.getText();
                    ResultList.add(mtwoCh_D.getText().toString());
                }

            SetAnwser.putExtra(RESULT_QUESTION_ANWSER+i,Result);
            SetAnwser.putStringArrayListExtra(RESULT_QUESTION_ANWSER+i,ResultList);
            return;
          //  Toast.makeText(getActivity(),Result,Toast.LENGTH_LONG).show();
        }else if (mQuestion.getType()==Question.TYPE_TRUE_FALSE_C)
        {
            if (mOneCh.getCheckedRadioButtonId()>0) {
                Result =((RadioButton) getActivity().findViewById(mOneCh.getCheckedRadioButtonId())).getText().toString();

               // Toast.makeText(getActivity(), Result, Toast.LENGTH_LONG).show();

                SetAnwser.putExtra(RESULT_QUESTION_ANWSER+i,Result);
                ResultList.add(Result);
                SetAnwser.putStringArrayListExtra(RESULT_QUESTION_ANWSER+i,ResultList);
            }
            return;
        }else {

            Result=mQuestionEdit.getText().toString();

          //  Toast.makeText(getActivity(),Result,Toast.LENGTH_LONG).show();
            SetAnwser.putExtra(RESULT_QUESTION_ANWSER+i,Result);
            ResultList.add(Result);
            SetAnwser.putStringArrayListExtra(RESULT_QUESTION_ANWSER+i,ResultList);
            return;

        }
    }

}
