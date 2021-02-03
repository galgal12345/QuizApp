package com.drillgil.android.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void imDone(View view) {

        /**
         * declaring Questions
         */

        //The First Question
        EditText editTextFirstAnswer = (EditText) findViewById(R.id.edit_text_us_capitol_answer_field);
        String stringFirstAnswer = editTextFirstAnswer.getText().toString();

        //The Second Question
        RadioButton radioButtonSecondAnswerOptionOne = (RadioButton) findViewById(R.id.first_radio_1);
        boolean booleanSecondAnswerOptionOne = radioButtonSecondAnswerOptionOne.isChecked();

        //The Third Question
        CheckBox checkBoxThirdAnswerOptionOne = (CheckBox) findViewById(R.id.first_check_box_1);
        boolean booleanThirdAnswerOptionOne = checkBoxThirdAnswerOptionOne.isChecked();

        CheckBox checkBoxThirdAnswerOptionTwo = (CheckBox) findViewById(R.id.first_check_box_2);
        boolean booleanThirdAnswerOptionTwo = checkBoxThirdAnswerOptionTwo.isChecked();

        CheckBox checkBoxThirdAnswerOptionThree = (CheckBox) findViewById(R.id.first_check_box_3);
        boolean booleanThirdAnswerOptionThree = checkBoxThirdAnswerOptionThree.isChecked();

        //The Fourth Question
        EditText editTextFourthAnswer = (EditText) findViewById(R.id.edit_text_smallest_us_state);
        String stringFourthAnswer = editTextFourthAnswer.getText().toString();

        //The Fifth Question
        RadioButton radioButtonFifthAnswerOptionOne = (RadioButton) findViewById(R.id.second_radio_1);
        boolean booleanFifthAnswerOptionOne = radioButtonFifthAnswerOptionOne.isChecked();

        //The Sixth Question
        CheckBox checkBoxSixthAnswerOptionOne = (CheckBox) findViewById(R.id.second_check_box_1);
        boolean booleanSixthAnswerOptionOne = checkBoxSixthAnswerOptionOne.isChecked();

        CheckBox checkBoxSixthAnswerOptionTwo = (CheckBox) findViewById(R.id.second_check_box_2);
        boolean booleanSixthAnswerOptionTwo = checkBoxSixthAnswerOptionTwo.isChecked();

        CheckBox checkBoxSixthAnswerOptionThree = (CheckBox) findViewById(R.id.second_check_box_3);
        boolean booleanSixthAnswerOptionThree = checkBoxSixthAnswerOptionThree.isChecked();


        /**
         * sanding values to 2 methods that check
         * that if the user chose the right answer
         * the user will get points
         */
        double finalGrade_1 = checkAnswers_1(stringFirstAnswer, booleanSecondAnswerOptionOne, booleanThirdAnswerOptionOne, booleanThirdAnswerOptionTwo, booleanThirdAnswerOptionThree);
        double finalGrade_2 = checkAnswers_2(stringFourthAnswer, booleanFifthAnswerOptionOne, booleanSixthAnswerOptionOne, booleanSixthAnswerOptionTwo, booleanSixthAnswerOptionThree);

        /**
         * calculateing the final grade
         */
        double finalGrade = finalGrade_1 + finalGrade_2 + 0.4;

        /**
         * displaying Toast on screen
         */
        displayToast(finalGrade);

    }


    /**
     * @param stringFirstAnswer
     * @param booleanSecondAnswerOptionOne
     * @param booleanThirdAnswerOptionOne
     * @param booleanThirdAnswerOptionTwo
     * @param booleanThirdAnswerOptionThree
     * @return the grade of the first three answers
     */
    private double checkAnswers_1(String stringFirstAnswer, boolean booleanSecondAnswerOptionOne, boolean booleanThirdAnswerOptionOne, boolean booleanThirdAnswerOptionTwo, boolean booleanThirdAnswerOptionThree) {

        double grade = 0;

        //checks the first answer
        if (stringFirstAnswer.equals("New York") || stringFirstAnswer.equals("new york")) {
            grade += 1.6;
        }

        //checks the Second answer
        if (booleanSecondAnswerOptionOne) {
            grade += 1.6;
        }

        //checks the Third answer
        if (booleanThirdAnswerOptionOne && booleanThirdAnswerOptionThree && !booleanThirdAnswerOptionTwo) {
            grade += 1.6;
        }

        return grade;

    }

    /**
     * @param stringFourthAnswer
     * @param booleanFifthAnswerOptionOne
     * @param booleanSixthAnswerOptionOne
     * @param booleanSixthAnswerOptionTwo
     * @param booleanSixthAnswerOptionThree
     * @return the grade of the last three answers
     */
    private double checkAnswers_2(String stringFourthAnswer, boolean booleanFifthAnswerOptionOne, boolean booleanSixthAnswerOptionOne, boolean booleanSixthAnswerOptionTwo, boolean booleanSixthAnswerOptionThree) {

        double grade = 0;

        //checks the Fourth answer
        if (stringFourthAnswer.equals("Rhode Island") || stringFourthAnswer.equals("rhode island")) {
            grade += 1.6;
        }

        //checks the Fifth answer
        if (booleanFifthAnswerOptionOne) {
            grade += 1.6;
        }

        //checks the Sixth answer
        if (booleanSixthAnswerOptionTwo && booleanSixthAnswerOptionThree && !booleanSixthAnswerOptionOne) {
            grade += 1.6;
        }

        return grade;

    }

    /**
     * @param finalGrade
     */
    private void displayToast(double finalGrade) {

        if (finalGrade >= 10) {
            Toast.makeText(this, " great job 🥳🥳 you passed the test your final garde is: " + finalGrade, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "try again " + finalGrade, Toast.LENGTH_SHORT).show();
        }
    }

}