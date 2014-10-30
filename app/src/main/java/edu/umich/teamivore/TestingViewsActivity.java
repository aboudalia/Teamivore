package edu.umich.teamivore;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class TestingViewsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing_views);

        TextView t = (TextView) findViewById(R.id.testTextView);

        t.setAllCaps(true);

    }

    public void changeColor(View view) {

        TextView t = (TextView) findViewById(R.id.testTextView);
        LinearLayout l = (LinearLayout) findViewById(R.id.testLinearLayout);

        if(view.getId() == R.id.testButtonGreen){
            t.setText("green!");
            l.setBackgroundColor(Color.GREEN);
        }
        else if(view.getId() == R.id.testButtonRed){
            t.setText("red!");
            l.setBackgroundColor(Color.RED);
        }
        else if(view.getId() == R.id.testButtonWhite) {
            t.setText("white!");
            l.setBackgroundColor(Color.WHITE);
        }

    }

    public void autofillForm(View view) {

        EditText name = (EditText) findViewById(R.id.testEditTextName);
        EditText email = (EditText) findViewById(R.id.testEditTextEmail);
        EditText phone = (EditText) findViewById(R.id.testEditTextPhone);

        if(view.getId() == R.id.testButtonClearForm) {

            name.setText("");
            email.setText("");
            phone.setText("");

        }
        else {
            name.setText("Amine Boudalia");
            email.setText("amineb@umich.edu");
            phone.setText("734-555-1212");
        }

    }

    public void showHide(View view) {

        TextView t1 = (TextView) findViewById(R.id.testTextShowHide);
        TextView t2 = (TextView) findViewById(R.id.testTextShowHide2);

        if(t1.getVisibility() == TextView.VISIBLE){

            t1.setVisibility(View.GONE);
            t2.setVisibility(View.GONE);

        }
        else {

            t1.setVisibility(View.VISIBLE);
            t2.setVisibility(View.VISIBLE);

        }

    }

}
