package com.example.lenovo.questionnaire;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Lenovo on 2016/9/25.
 */
public class AddQuestion extends Activity{

    private Spinner spinner;
    private static String[] couldCh={"单选","多选","判断","问答/填空"};

    private Button mCleanButton;
    private Button mAddButton;

    private EditText mQuestionEidtText;

    private LinearLayout mLinear;

    private RadioGroup mRadioAnwserNumber;

    private RadioButton mRaidoNumber02;
    private RadioButton mRaidoNumber03;
    private RadioButton mRaidoNumber04;

    private EditText mCouldChAnwserA;
    private EditText mCouldChAnwserB;
    private EditText mCouldChAnwserC;
    private EditText mCouldChAnwserD;

    private EditText mTrueAnwserA;
    private EditText mTrueAnwserB;
    private EditText mTrueAnwserC;
    private EditText mTrueAnwserD;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_question_activity);

        spinner=(Spinner)findViewById(R.id.question_type_ch);
        ArrayList<String> could_type=new ArrayList<String>();
        for(int i=0;i<couldCh.length;i++)
        {
            could_type.add(couldCh[i]);
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,could_type);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        mQuestionEidtText=(EditText)findViewById(R.id.question_text_edit);

        mTrueAnwserA=(EditText)findViewById(R.id.true_anwser_edit_A);
        mTrueAnwserB=(EditText)findViewById(R.id.true_anwser_edit_B);
        mTrueAnwserC=(EditText)findViewById(R.id.true_anwser_edit_C);
        mTrueAnwserD=(EditText)findViewById(R.id.true_anwser_edit_D);

        mRadioAnwserNumber=(RadioGroup)findViewById(R.id.anwser_number);


        mRaidoNumber02=(RadioButton)findViewById(R.id.anwser_number_02);
        mRaidoNumber02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(AddQuestion.this," ",Toast.LENGTH_SHORT).show();
                mTrueAnwserB.setVisibility(View.VISIBLE);
                mTrueAnwserC.setVisibility(View.GONE);
                mTrueAnwserD.setVisibility(View.GONE);
            }
        });

        mRaidoNumber03=(RadioButton)findViewById(R.id.anwser_number_03);
        mRaidoNumber03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(AddQuestion.this," ",Toast.LENGTH_SHORT).show();
                mTrueAnwserB.setVisibility(View.VISIBLE);
                mTrueAnwserC.setVisibility(View.VISIBLE);
                mTrueAnwserD.setVisibility(View.GONE);
            }
        });
        mRaidoNumber04=(RadioButton)findViewById(R.id.anwser_number_04);
        mRaidoNumber04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(AddQuestion.this," ",Toast.LENGTH_SHORT).show();
                mTrueAnwserB.setVisibility(View.VISIBLE);
                mTrueAnwserC.setVisibility(View.VISIBLE);
                mTrueAnwserD.setVisibility(View.VISIBLE);
            }
        });

        mCouldChAnwserA=(EditText)findViewById(R.id.couldCh_anwser_edit_A);
        mCouldChAnwserB=(EditText)findViewById(R.id.couldCh_anwser_edit_B);
        mCouldChAnwserC=(EditText)findViewById(R.id.couldCh_anwser_edit_C);
        mCouldChAnwserD=(EditText)findViewById(R.id.couldCh_anwser_edit_D);



        mCleanButton=(Button)findViewById(R.id.clean_button);
        mCleanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Clean();
            }
        });



        mAddButton=(Button)findViewById(R.id.add_button);
        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String questionText=mQuestionEidtText.getText().toString();
                int questionType;
                ArrayList<String> cuoldChose=new ArrayList<String>();
                ArrayList<String> anwser=new ArrayList<String>();

                String S= spinner.getSelectedItem().toString();

                mLinear=(LinearLayout)findViewById(R.id.radio_layout);

                if(S.equals("多选"))
                {
                    questionType=Question.TYPE_TWO_C;
                   // String RB= ((RadioButton)findViewById(mRadioAnwserNumber.getCheckedRadioButtonId())).getText().toString();


                    anwser.add(mTrueAnwserA.getText().toString());
                    anwser.add(mTrueAnwserB.getText().toString());
                    anwser.add(mTrueAnwserC.getText().toString());
                    anwser.add(mTrueAnwserD.getText().toString());


                    cuoldChose.add(mCouldChAnwserA.getText().toString());
                    cuoldChose.add(mCouldChAnwserB.getText().toString());
                    cuoldChose.add(mCouldChAnwserC.getText().toString());
                    cuoldChose.add(mCouldChAnwserD.getText().toString());
                }else if(S.equals("判断"))
                {
                    questionType=Question.TYPE_TRUE_FALSE_C;

                    anwser.add(mTrueAnwserA.getText().toString());


                    cuoldChose.add(mCouldChAnwserA.getText().toString());
                    cuoldChose.add(mCouldChAnwserB.getText().toString());



                }else if(S.equals("问答/填空"))
                {
                    questionType=Question.TYPE_EDIT_WRITE;

                    anwser.add(mTrueAnwserA.getText().toString());



                }
                else {
                    questionType=Question.TYPE_ONE_C;

                    anwser.add(mTrueAnwserA.getText().toString());


                    cuoldChose.add(mCouldChAnwserA.getText().toString());
                    cuoldChose.add(mCouldChAnwserB.getText().toString());
                    cuoldChose.add(mCouldChAnwserC.getText().toString());
                    cuoldChose.add(mCouldChAnwserD.getText().toString());
                }


                Question question=new Question(questionText,questionType,cuoldChose,anwser);
              //  QuestionList.get(AddQuestion.this).getQuestions().add(question);
                ArrayList<Question> q=QuestionList.get(AddQuestion.this).getQuestions();
                q.add(question);
                Toast.makeText(AddQuestion.this,"添加成功",Toast.LENGTH_SHORT).show();

                Clean();

            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String S= spinner.getSelectedItem().toString();
                // mRadioAnwserNumber=(RadioGroup)findViewById(R.id.anwser_number);
                mLinear=(LinearLayout)findViewById(R.id.radio_layout);
                if(S.equals("多选"))
                {
                    //Toast.makeText(AddQuestion.this,"多选",Toast.LENGTH_SHORT).show();
                    mLinear.setVisibility(View.VISIBLE);

                    mCouldChAnwserA.setText("");
                    mCouldChAnwserB.setText("");

                    mTrueAnwserB.setVisibility(View.VISIBLE);
                    mTrueAnwserC.setVisibility(View.VISIBLE);
                    mTrueAnwserD.setVisibility(View.VISIBLE);
                }else if(S.equals("判断"))
                {
                    mLinear.setVisibility(View.GONE);
                    mTrueAnwserB.setVisibility(View.GONE);
                    mTrueAnwserC.setVisibility(View.GONE);
                    mTrueAnwserD.setVisibility(View.GONE);

                    mCouldChAnwserA.setText("正确");
                    mCouldChAnwserB.setText("错误");
                    mCouldChAnwserC.setVisibility(View.GONE);
                    mCouldChAnwserD.setVisibility(View.GONE);


                }else if(S.equals("问答/填空"))
                {
                    mLinear.setVisibility(View.GONE);
                    mTrueAnwserB.setVisibility(View.GONE);
                    mTrueAnwserC.setVisibility(View.GONE);
                    mTrueAnwserD.setVisibility(View.GONE);

                    mCouldChAnwserA.setVisibility(View.GONE);
                    mCouldChAnwserB.setVisibility(View.GONE);
                    mCouldChAnwserC.setVisibility(View.GONE);
                    mCouldChAnwserD.setVisibility(View.GONE);
                }
                else {
                    mLinear.setVisibility(View.GONE);
                    mTrueAnwserB.setVisibility(View.GONE);
                    mTrueAnwserC.setVisibility(View.GONE);
                    mTrueAnwserD.setVisibility(View.GONE);

                    mCouldChAnwserA.setText("");
                    mCouldChAnwserB.setText("");

                    mCouldChAnwserA.setVisibility(View.VISIBLE);
                    mCouldChAnwserB.setVisibility(View.VISIBLE);
                    mCouldChAnwserC.setVisibility(View.VISIBLE);
                    mCouldChAnwserD.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }

    public void Clean(){
        mQuestionEidtText.setText("");

        mLinear.setVisibility(View.GONE);


        mCouldChAnwserA.setText("");
        mCouldChAnwserB.setText("");
        mCouldChAnwserC.setText("");
        mCouldChAnwserD.setText("");

        mTrueAnwserA.setText("");
        mTrueAnwserB.setText("");
        mTrueAnwserC.setText("");
        mTrueAnwserD.setText("");
    }
}
