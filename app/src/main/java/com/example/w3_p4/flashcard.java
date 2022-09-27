package com.example.w3_p4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class flashcard extends AppCompatActivity {
    Button generator, submit;
    TextView op,topVal,downVal;
    EditText answer;
    int topNum = 0;
    int downNum = 0;
    int score = 0;

    Random random = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard);
        Random random = new Random();

        Integer[] additions = {};
        Integer[] subtractions = {};

        topVal.findViewById(R.id.firstoperand);
        downVal.findViewById(R.id.secondOperand);
        op.findViewById(R.id.operator);

        answer.findViewById(R.id.answer);




        generator.findViewById(R.id.generateProblems);
        generator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < 10; i += 2){
                    topNum = random.nextInt(100);
                    downNum = random.nextInt(21);
                    additions[i] = topNum;
                    additions[i+1] = downNum;
                }

                for (int i = 0; i < 10; i += 2){
                    topNum = random.nextInt(100);
                    downNum = random.nextInt(21);
                    subtractions[i] = topNum;
                    subtractions[i+1] = downNum;
                }

                if (flip()){
                    topVal.setText(additions[0]);
                    downVal.setText(additions[1]);
                    additions[0] = null;
                    additions[1] = null;
                    op.setText("+");
                }else {
                    topVal.setText(subtractions[0]);
                    downVal.setText(subtractions[1]);
                    subtractions[0] = null;
                    subtractions[1] = null;
                    op.setText("-");
                }
                score = 0;
            }
        }); // generator click

        submit.findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Type the answer first!", Toast.LENGTH_LONG).show();
                }else {
                    int userAnswer = Integer.parseInt(answer.getText().toString());
                    int topNum = Integer.parseInt(topVal.getText().toString());
                    int downnum = Integer.parseInt(downVal.getText().toString());

                    if (op.getText().toString().equals("+")){
                        if ((topNum+downnum) == userAnswer){
                            score += 1;
                            String mesg = "Correct! " + score + " out of 10";
                            Toast.makeText(getApplicationContext(), mesg, Toast.LENGTH_LONG).show();
                            if (flip()){
                                Integer[] recentVals = getRecentVal(additions);
                                topVal.setText(recentVals[0]);
                                downVal.setText(recentVals[1]);
                                op.setText("+");
                            }else {
                                Integer[] recentVals = getRecentVal(subtractions);
                                topVal.setText(recentVals[0]);
                                downVal.setText(recentVals[1]);
                                op.setText("-");
                            }
                        }else {
                            Toast.makeText(getApplicationContext(), "Wrong!", Toast.LENGTH_LONG).show();
                            if (flip()){
                                Integer[] recentVals = getRecentVal(additions);
                                topVal.setText(recentVals[0]);
                                downVal.setText(recentVals[1]);
                                op.setText("+");
                            }else {
                                Integer[] recentVals = getRecentVal(subtractions);
                                topVal.setText(recentVals[0]);
                                downVal.setText(recentVals[1]);
                                op.setText("-");
                            }
                        }
                    } else {
                        if ((topNum-downnum) == userAnswer){
                            score += 1;
                            String mesg = "Correct! " + score + " out of 10";
                            Toast.makeText(getApplicationContext(), mesg, Toast.LENGTH_LONG).show();
                            if (flip()){
                                Integer[] recentVals = getRecentVal(additions);
                                topVal.setText(recentVals[0]);
                                downVal.setText(recentVals[1]);
                                op.setText("+");
                            }else {
                                Integer[] recentVals = getRecentVal(subtractions);
                                topVal.setText(recentVals[0]);
                                downVal.setText(recentVals[1]);
                                op.setText("-");
                            }
                        }else {
                            Toast.makeText(getApplicationContext(), "Wrong!", Toast.LENGTH_LONG).show();
                            if (flip()){
                                Integer[] recentVals = getRecentVal(additions);
                                topVal.setText(recentVals[0]);
                                downVal.setText(recentVals[1]);
                                op.setText("+");
                            }else {
                                Integer[] recentVals = getRecentVal(subtractions);
                                topVal.setText(recentVals[0]);
                                downVal.setText(recentVals[1]);
                                op.setText("-");
                            }
                        }
                    }
                }// Outer if statement
            }// onClick
        }); //submit BT


    } // onCreate

    public boolean flip(){
        int flip = random.nextInt(2);
        return flip == 0;
    }

    public Integer[] getRecentVal (Integer[] arr){
        Integer[] holder = {0,0};
        for (int i = 0; i < arr.length; i += 2){
            if (arr[i] != null){
                holder[0] = arr[i];
                holder[1] = arr[i+1];
                arr[i] = null;
                arr[i+1] = null;
                break;
            }
        }

        return holder;
    }


}