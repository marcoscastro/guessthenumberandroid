package com.mcastrosouza.guessthenumber;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

/**
 * Created by Marcos Castro on 17/12/16.
 */

public class MainActivity extends Activity {

    EditText number;
    TextView tip, attempts;
    Random rand;
    int guess_number, count_attempts, min = 1, max = 100;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rand = new Random();
        guess_number = rand.nextInt((max - min) + 1) + min;
        number = (EditText)findViewById(R.id.editTextNumber);
        tip = (TextView)findViewById(R.id.textViewTip);
        attempts = (TextView)findViewById(R.id.textViewAttempts);
    }

    public void checkNumber(View v) {

        int n = Integer.parseInt(number.getText().toString());
        boolean congratz = false;

        if(n < guess_number)
            tip.setText("Tip: UP");
        else if(n > guess_number)
            tip.setText("Tip: DOWN");
        else
        {
            tip.setText("CONGRATULATIONS!!");
            congratz = true;
        }

        count_attempts++;
        attempts.setText("Attempts: " + Integer.toString(count_attempts));
    }
}