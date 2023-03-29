package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView questionTV, questionNumberTV;
    private Button option1Bt, option2Bt, option3Bt, option4Bt;
    private ArrayList<mainModal> mainModalArrayList;
    Random random;
    int currentScore = 0, questionAttempted =0, currentPos;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionTV = findViewById(R.id.idTVQuestion);
        questionNumberTV = findViewById(R.id.idTVQuestionAttempted);
        option1Bt = findViewById(R.id.idBtnOption1);
        option2Bt = findViewById(R.id.idBtnOption2);
        option3Bt = findViewById(R.id.idBtnOption3);
        option4Bt = findViewById(R.id.idBtnOption4);

        mainModalArrayList = new ArrayList<>();
        random = new Random();

        getQuizQuestions(mainModalArrayList);

        currentPos = random.nextInt(mainModalArrayList.size());
        setToView(currentPos);

        option1Bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mainModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Bt.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(mainModalArrayList.size());
                setToView(currentPos);
            }
        });

        option2Bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mainModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Bt.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(mainModalArrayList.size());
                setToView(currentPos);
            }
        });

        option3Bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mainModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Bt.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(mainModalArrayList.size());
                setToView(currentPos);
            }
        });

        option4Bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mainModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Bt.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(mainModalArrayList.size());
                setToView(currentPos);
            }
        });

    }

    private void showScore(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_page,(LinearLayout)findViewById(R.id.idBottomScore));
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView score = bottomSheetView.findViewById(R.id.idScore);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button retakeQuizBt = bottomSheetView.findViewById(R.id.idReset);
        score.setText("Your Marks is \n"+ currentScore + " out of 10");
        retakeQuizBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPos = random.nextInt(mainModalArrayList.size());
                setToView(currentPos);
                questionAttempted = 1;
                currentScore = 0;
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();

    }
    private void setToView(int currentPos){
        questionNumberTV.setText("You attempted "+questionAttempted+ " out of 10");

        if (questionAttempted == 10){
            showScore();
        }else {
            questionTV.setText(mainModalArrayList.get(currentPos).getQuestion());
            option1Bt.setText(mainModalArrayList.get(currentPos).getOption1());
            option2Bt.setText(mainModalArrayList.get(currentPos).getOption2());
            option3Bt.setText(mainModalArrayList.get(currentPos).getOption3());
            option4Bt.setText(mainModalArrayList.get(currentPos).getOption4());
        }

    }
    private void getQuizQuestions(ArrayList<mainModal> mainModalArrayList) {
        mainModalArrayList.add(new mainModal("What is the return type of malloc() or calloc()", "void *", "Pointer of allocated memory type", "void **", "int *", "void *"));
        mainModalArrayList.add(new mainModal("Which languages necessarily need heap allocation in the run time environment?", "Those that support recursion", "Those that use dynamic scoping", "Those that use global variables", "Those that allow dynamic data structures", "Those that allow dynamic data structures"));
        mainModalArrayList.add(new mainModal("Which of the following statements is/are TRUE regarding JAVA ? (a) Constants that cannot be changed are declared using the ‘static’ keyword. (b) A class can only inherit one class but can implement multiple interfaces.", "Only (a) is TRUE.", "Both (a) and (b) are TRUE.", "Only (b) is TRUE.", "Neither (a) nor (b) are TRUE.", "Only (b) is TRUE."));
        mainModalArrayList.add(new mainModal("class Main {   \n" +
                "   public static void main(String args[]) {      \n" +
                "         int t;      \n" +
                "         System.out.println(t); \n" +
                "    }   \n" +
                "}", "garbage value", "compiler error", "0", "runtime error", "compiler error"));
        mainModalArrayList.add(new mainModal("Which of the following function convert a string to a float in python?", "long(x [,base] )", "int(x [,base])", "float(x)", "str(x)", "float(x)"));
        mainModalArrayList.add(new mainModal("What is the output of the following program :\n" +
                "y = 8\n" +
                "z = lambda x : x * y\n" +
                "print (z(6))", "14", "48", "64", "128", "48"));
        mainModalArrayList.add(new mainModal("When fopen() is not able to open a file, it returns", "Runtime Error", "EOF", "NULL", "Compiler Dependent", "NULL"));
        mainModalArrayList.add(new mainModal("A member function can always access the data in __________ , (in C++).", "the class of which it is member", "the object of which it is a member", "the public part of its class", "None of these", "the class of which it is member"));
        mainModalArrayList.add(new mainModal("In Java, when we implement an interface method, it must be declared as:", "Private", "Protected", "Friend", "Public", "Public"));
        mainModalArrayList.add(new mainModal("Which of the following command is used to delete a table in SQL?", "truncate", "delete", "drop", "remove", "drop"));
        mainModalArrayList.add(new mainModal("A unix file may be of the type:", "Regular file", "Directory file", "Device file", "Any one of the above", "Any one of the above"));
        mainModalArrayList.add(new mainModal("In UNIX, processes that have finished execution but have not yet had their status collected are known as _________.", "Sleeping processes", "Stopped processes", "Zombie processes", "Orphan processes", "Zombie processes"));
        mainModalArrayList.add(new mainModal("Which of the following is/are correct?", "An SQL query automatically eliminates the duplicates", "An SQL query will not work if there are no indexes on the relations", "SQL permits attribute names to be repeated in the same relation", "None of the above", "None of the above"));
    }
}