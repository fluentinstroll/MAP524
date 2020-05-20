package com.example.assgn2_rrambo;

public class Question {
    boolean isTrue;
    boolean questionIsDone;
    boolean hinted;
    boolean cheated;
    int questionText;
    int questionHint;

    public Question(int qText, int qHint, boolean tf, boolean done, boolean h, boolean c){
        isTrue = tf;
        questionIsDone = done;
        hinted = h;
        cheated = c;
        questionText = qText;
        questionHint = qHint;
    }
    public int getQuestion() {
        return this.questionText;
    }

    public boolean getAnswerTrueFalse() {
        return this.isTrue;
    }

    public boolean getCheated() {
        return this.cheated;
    }

    public void setCheated(boolean c) {
        this.cheated = c;
    }

    public boolean getHinted() {
        return this.hinted;
    }

    public void setHinted(boolean h) {
        this.hinted = h;
    }

    public boolean getQuestionDone() {
        return this.questionIsDone;
    }

    public void setCompleted(boolean c) {
        this.questionIsDone = c;
    }

    public int getHint() {
        return this.questionHint;
    }

    public boolean compareTrue(boolean t){
        questionIsDone = true;
        if(t == isTrue)
            return true;
        else
            return false;
    }
}
