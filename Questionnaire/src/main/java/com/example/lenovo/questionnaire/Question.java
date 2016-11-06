package com.example.lenovo.questionnaire;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Lenovo on 2016/9/23.
 */
public class Question {
    private UUID Qid;
    private String questiontext;
    private int type;
    private ArrayList<String> cuoldchose;
    private ArrayList<String> answer;

    public static final int TYPE_ONE_C=1;
    public static final int TYPE_TWO_C=2;
    public static final int TYPE_TRUE_FALSE_C=3;
    public static final int TYPE_EDIT_WRITE=0;


    public Question(){
        Qid=UUID.randomUUID();
    }

    public Question(String questiontext, int type, ArrayList<String> cuoldchose,ArrayList<String> answer)
    {
        Qid=UUID.randomUUID();
        this.questiontext=questiontext;
        this.type=type;
        this.cuoldchose=cuoldchose;
        this.answer=answer;
    }


    public String getQuestiontext() {
        return questiontext;
    }

    public void setQuestiontext(String questiontext) {
        this.questiontext = questiontext;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ArrayList<String> getCuoldchose() {
        return cuoldchose;
    }

    public void setCuoldchose(ArrayList<String> cuoldchose) {
        this.cuoldchose = cuoldchose;
    }

    public ArrayList<String> getAnswer() {
        return answer;
    }

    public void setAnswer(ArrayList<String> anwser) {
        this.answer = anwser;
    }

    public UUID getQid() {
        return Qid;
    }

    public void setQid(UUID qid) {
        Qid = qid;
    }
}
