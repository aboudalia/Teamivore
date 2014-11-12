package edu.umich.teamivore;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class LoginActivity extends Activity {

    // all the login activity needs to do onCreate is set the layout to the xml layout we've
    // defined in activity_login.xml

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Since everyone has to pass through the login screen, we will initialize our data structures here
        initData();

    }

    // the logIn method is associated with the appropriate button in xml using the
    // android:onClick="logIn" option

    public void logIn(View view) {
        // log in defines a new basic intent that for now simply switches the activity to the teams
        // list view activity

        Intent intent = new Intent(this, OverviewActivity.class);
        startActivity(intent);

        // make note that a true login activity would perform much more complex actions after
        // clicking the login button such as authentication and database lookups, but for the
        // purposes of this demo, we leave those out

    }

    public void createAccount(View view) {

        Intent intent = new Intent(this, TestingViewsActivity.class);
        startActivity(intent);

    }
    
    private void initData() {

        List<String> teamsList = new ArrayList<String>();

        teamsList.add("Team 1: Uproar Labs");
        teamsList.add("Team 2: Bogus Trust");
        teamsList.add("Team 3: Gejago");
        teamsList.add("Team 4: Jagurr");
        teamsList.add("Team 5: Raspy Puck");
        teamsList.add("Team 6: Ladybug Studios");
        teamsList.add("Team 7: Fourtwelve");

        SharedPreferencesUtility.putStringList(this, "teams", teamsList);

    }
    
}
