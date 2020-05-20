package com.example.assgn2_rrambo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button trueBtn;
    private Button falseBtn;
    private Button hintBtn;
    private Button cheatBtn;
    private Button prevBtn;
    private Button nextBtn;
    private TextView questionText;
    private TextView questionsDone;
    private TextView totalMarksDisplay;
    int totalMarks = 0;
    int currentPage = 0;
    int numberFinished = 0;

    public Question[] questions = new Question[]{
            new Question(R.string.question_australia, R.string.hint_australia, true, false, false, false),
            new Question(R.string.question_oceans, R.string.hint_oceans, true, false, false, false),
            new Question(R.string.question_mideast, R.string.hint_mideast, false, false, false, false),
            new Question(R.string.question_africa, R.string.hint_africa, false, false, false, false),
            new Question(R.string.question_americas, R.string.hint_americas, true, false, false, false),
            new Question(R.string.question_asia, R.string.hint_asia, false, false, false, false)
    };
//TODO: hint screen, cheat screen, toasts for button clicks GO OVER PROFS APK AND COPY EVERYTHING IT DOES

    //questions: do you get a question completed for an incorrect answer?
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionText = (TextView)findViewById(R.id.textViewQuestion);
        questionText.setText(questions[currentPage].getQuestion());

        questionsDone = (TextView)findViewById(R.id.textViewQuestionsDone);
        totalMarksDisplay = (TextView)findViewById(R.id.textViewTotalMarks);

        trueBtn = (Button)findViewById(R.id.trueButton);
        trueBtn.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view) {
                 totalMarks += checkAnswerGetPoints(true);
                 questionsDone.setText("Questions Completed " + numberFinished);
                totalMarksDisplay.setText("Total Marks " + totalMarks);
            }
        });

        falseBtn = (Button)findViewById(R.id.falseButton);
        falseBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                totalMarks += checkAnswerGetPoints(false);
                questionsDone.setText("Questions Completed " + numberFinished);
                totalMarksDisplay.setText("Total Marks " + totalMarks);
            }
        });

        nextBtn = (Button)findViewById(R.id.nextButton);
        nextBtn.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view) {
                if (currentPage < 5){
                    currentPage++;
                    questionText.setText(questions[currentPage].getQuestion());
                }
            }
        });

        prevBtn = (Button)findViewById(R.id.prevButton);
        prevBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentPage > 0){
                    currentPage--;
                    questionText.setText(questions[currentPage].getQuestion());
                }
            }
        });

    }


    public int checkAnswerGetPoints(boolean t){
        int marks = 0;
        if (questions[currentPage].compareTrue(t)) { // if answer was correct,
            if (!questions[currentPage].getQuestionDone()) { // and if question wasn't already done, add 2 marks
                marks += 2;
                questions[currentPage].setCompleted(true);
                numberFinished++;
                if (questions[currentPage].getHinted()) // if hinted, take 1 mark
                    marks -= 1;
                if (questions[currentPage].getCheated()) // if cheated, take 2 marks
                    marks -= 2;
            }
        }

        if (marks<0)
            marks = 0;

        return marks;
    }
}
