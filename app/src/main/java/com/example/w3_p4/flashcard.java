package com.example.w3_p4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
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

        topVal  = (TextView) findViewById(R.id.firstOperand);
        downVal = (TextView) findViewById(R.id.secondOperand);
        op = (TextView) findViewById(R.id.operator);

        answer = (EditText) findViewById(R.id.answer);

        Integer[] additions = new Integer[10];
        Integer[] subtractions = new Integer[10];


        generator = (Button) findViewById(R.id.generateProblems);
        generator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < 10; i += 2){
                    topNum = random.nextInt(99) + 1;
                    downNum = random.nextInt(20) + 1;
                    additions[i] = topNum;
                    additions[i+1] = downNum;
                }

                for (int i = 0; i < 10; i += 2){
                    topNum = random.nextInt(99) + 1;
                    downNum = random.nextInt(20) + 1;
                    subtractions[i] = topNum;
                    subtractions[i+1] = downNum;
                }

                if (flip()){
                    topVal.setText(String.valueOf(additions[0]));
                    downVal.setText(String.valueOf(additions[1]));
                    additions[0] = null;
                    additions[1] = null;
                    op.setText("+");
                }else {
                    topVal.setText(String.valueOf(subtractions[0]));
                    downVal.setText(String.valueOf(subtractions[1]));
                    subtractions[0] = null;
                    subtractions[1] = null;
                    op.setText("-");
                }
                score = 0;
                generator.setEnabled(false);
                submit.setEnabled(true);
            }
        }); // generator click

        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isEmpty(additions,subtractions)){
                    if (answer.getText().toString().equals("")){
                        Toast.makeText(getApplicationContext(), "Type the answer", Toast.LENGTH_LONG).show();
                    }else {
                        int userAnswer = Integer.valueOf(answer.getText().toString());
                        int topNum = Integer.valueOf(topVal.getText().toString());
                        int downnum = Integer.valueOf(downVal.getText().toString());

                        if (op.getText().toString().equals("+")){
                            if ((topNum+downnum) == userAnswer){
                                score += 1;
                                String mesg = score + " out of 10";
                                Toast.makeText(getApplicationContext(), mesg, Toast.LENGTH_LONG).show();
                                submit.setEnabled(false);
                                generator.setEnabled(true);
                            }else {
                                Toast.makeText(getApplicationContext(), "Wrong!", Toast.LENGTH_LONG).show();
                                generator.setEnabled(true);
                                submit.setEnabled(false);
                            }
                        } else {
                            if ((topNum-downnum) == userAnswer){
                                score += 1;
                                String mesg = score + " out of 10";
                                Toast.makeText(getApplicationContext(), mesg, Toast.LENGTH_LONG).show();
                                generator.setEnabled(true);
                                submit.setEnabled(false);
                            }else {
                                Toast.makeText(getApplicationContext(), "Wrong!", Toast.LENGTH_LONG).show();
                                generator.setEnabled(true);
                                submit.setEnabled(false);
                            }
                        }

                    }

                }else {
                    if (answer.getText().toString().equals("")){
                        Toast.makeText(getApplicationContext(), "Type the answer ", Toast.LENGTH_LONG).show();
                    }else {
                        int userAnswer = Integer.valueOf(answer.getText().toString());
                        int topNum = Integer.valueOf(topVal.getText().toString());
                        int downnum = Integer.valueOf(downVal.getText().toString());

                        if (op.getText().toString().equals("+")){
                            if ((topNum+downnum) == userAnswer){
                                score += 1;
                                String mesg = score + " out of 10";
                                Toast.makeText(getApplicationContext(), mesg, Toast.LENGTH_LONG).show();
                                if (flip()){
                                    Integer[] recentVals = getRecentVal(additions);
                                    topVal.setText(String.valueOf(recentVals[0]));
                                    downVal.setText(String.valueOf(recentVals[1]));
                                    op.setText("+");
                                }else {
                                    Integer[] recentVals = getRecentVal(subtractions);
                                    topVal.setText(String.valueOf(recentVals[0]));
                                    downVal.setText(String.valueOf(recentVals[1]));
                                    op.setText("-");
                                }
                            }else {
                                Toast.makeText(getApplicationContext(), "Wrong!", Toast.LENGTH_LONG).show();
                                if (flip()){
                                    Integer[] recentVals = getRecentVal(additions);
                                    topVal.setText(String.valueOf(recentVals[0]));
                                    downVal.setText(String.valueOf(recentVals[1]));
                                    op.setText("+");
                                }else {
                                    Integer[] recentVals = getRecentVal(subtractions);
                                    topVal.setText(String.valueOf(recentVals[0]));
                                    downVal.setText(String.valueOf(recentVals[1]));
                                    op.setText("-");
                                }
                            }
                        } else {
                            if ((topNum-downnum) == userAnswer){
                                score += 1;
                                String mesg = score + " out of 10";
                                Toast.makeText(getApplicationContext(), mesg, Toast.LENGTH_LONG).show();
                                if (flip()){
                                    Integer[] recentVals = getRecentVal(additions);
                                    topVal.setText(String.valueOf(recentVals[0]));
                                    downVal.setText(String.valueOf(recentVals[1]));
                                    op.setText("+");
                                }else {
                                    Integer[] recentVals = getRecentVal(subtractions);
                                    topVal.setText(String.valueOf(recentVals[0]));
                                    downVal.setText(String.valueOf(recentVals[1]));
                                    op.setText("-");
                                }
                            }else {
                                Toast.makeText(getApplicationContext(), "Wrong!", Toast.LENGTH_LONG).show();
                                if (flip()){
                                    Integer[] recentVals = getRecentVal(additions);
                                    topVal.setText(String.valueOf(recentVals[0]));
                                    downVal.setText(String.valueOf(recentVals[1]));
                                    op.setText("+");
                                }else {
                                    Integer[] recentVals = getRecentVal(subtractions);
                                    topVal.setText(String.valueOf(recentVals[0]));
                                    downVal.setText(String.valueOf(recentVals[1]));
                                    op.setText("-");
                                }
                            }
                        }
                    }// Outer if statement
                }
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

    public boolean isEmpty (Integer[] arr1, Integer[] arr2){
        for (int i = 0; i < arr1.length; i++){
            if (arr1[i] != null){
                return false;
            }
        }
        for (int i = 0; i < arr2.length; i++){
            if (arr2[i] != null){
                return false;
            }
        }

        return true;
    }

    public void onConfigurationChanged (@NonNull Configuration flashcard) {
        super.onConfigurationChanged(flashcard);
    }

}