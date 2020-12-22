package personal.phil_gab99.mathgame;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

/**
* The class MainActivity defines how the application behaves with respect to
* user-triggered events
*
* @author Philippe Gabriel
* @version 1.5.3 2020-12-21
***/

public class MainActivity extends AppCompatActivity {
    
    private TextView num1;
    private TextView num2;
    
    private TextView good;
    private TextView bad;
    
    /**
    * The method onCreate is called upon launching the application from the
    * device
    *
    * @param savedInstanceState Bundle for passing data between Android
    * activities
    * @see android.app.Activity
    ***/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //Initializing fields
        num1 = findViewById(R.id.Number1);
        num2 = findViewById(R.id.Number2);
        
        good = findViewById(R.id.good);
        bad = findViewById(R.id.bad);
        
        generateNumbers();
    }
    
    /**
    * The method generateNumbers generates the random numbers to display to the
    * user
    ***/
    
    public void generateNumbers() {
        
        Random rand = new Random();
        
        int val1 = rand.nextInt(100);
        int val2 = rand.nextInt(100);
        
        num1.setText("" + val1);
        num2.setText("" + val2);
    }
    
    /**
    * The method onSubmitClick is triggered upon the user's press of the submit
    * button and verifies whether the user input is correct or not
    *
    * @param view View from which event inducing objects originate from
    * @see android.view.View
    ***/
    
    public void onSubmitClick(View view) {
        
        TextView answer = findViewById(R.id.Answer);
        EditText attempt = findViewById(R.id.Attempt);
        
        int userAnswer;
        
        try {
            
            //Retrieving user input
            userAnswer = Integer.parseInt(attempt.getText().toString());
        } catch(NumberFormatException e) {
            
            answer.setText("Please input a value.");
            return;
        }
        
        //Retrieving values to be summed
        int val1 = Integer.parseInt(num1.getText().toString());
        int val2 = Integer.parseInt(num2.getText().toString());
        
        //Verifying user inputted answer
        if (userAnswer == (val1 + val2)) {
            
            answer.setText("Correct!");
            good.setText("" + (Integer.parseInt(good.getText().toString()) + 1));
        } else {
            
            answer.setText("Wrong! The correct answer is " + (val1 + val2));
            bad.setText("" + (Integer.parseInt(bad.getText().toString()) + 1));
        }
        
        generateNumbers();
    }
}