package personal.phil_gab99.mathgame;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

/**
* The class MainActivity
*
* @author Philippe Gabriel
* @version 1.0 2020-12-21
***/

public class MainActivity extends AppCompatActivity {

    TextView num1;
    TextView num2;

    /**
    * The method onCreate
    * 
    * @param savedInstanceState Bundle
    * @see android.app.Activity
    ***/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        int val1 = 12;
        num1 = findViewById(R.id.Number1);
        num1.setText(val1);
        
        int val2 = 64;
        num2 = findViewById(R.id.Number2);
        num2.setText(val2);
    }
    
    /**
    * The method onSubmitOnClick
    * 
    * @param view
    ***/
    
    public void onSubmitOnClick(View view) {
        
        TextView answer = findViewById(R.id.Answer);
        EditText attempt = findViewById(R.id.Attempt);
        
        int userAnswer = Integer.parseInt(attempt.getText().toString());
        
        int val1 = Integer.parseInt(num1.getText().toString());
        int val2 = Integer.parseInt(num2.getText().toString());
        
        if (userAnswer == (val1 + val2)) {
            
            Answer.setText("Correct!");
        } else {
            
            Answer.setText("Wrong! The correct answer is " + (val1 + val2));
        }
    }
}