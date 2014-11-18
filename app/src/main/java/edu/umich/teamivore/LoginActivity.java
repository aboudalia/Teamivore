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

        /*List<String> teamsList = new ArrayList<String>();

        teamsList.add("Team 1: Uproar Labs");
        teamsList.add("Team 2: Bogus Trust");
        teamsList.add("Team 3: Gejago");
        teamsList.add("Team 4: Jagurr");
        teamsList.add("Team 5: Raspy Puck");
        teamsList.add("Team 6: Ladybug Studios");
        teamsList.add("Team 7: Fourtwelve");

        SharedPreferencesUtility.putStringList(this, "teams", teamsList);
        */

        List<Team> teamsList = new ArrayList<Team>();

        String defaultDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do" +
                " eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam," +
                " quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat." +
                " Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu " +
                "fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in " +
                "culpa qui officia deserunt mollit anim id est laborum.";

        teamsList.add(new Team(1, "Uproar Labs", defaultDescription));
        teamsList.add(new Team(2, "Bogus Trust", defaultDescription));
        teamsList.add(new Team(3, "Gejago", defaultDescription));
        teamsList.add(new Team(4, "Jagurr", defaultDescription));
        teamsList.add(new Team(5, "Raspy Puck", defaultDescription));
        teamsList.add(new Team(6, "Ladybug Studios", defaultDescription));
        teamsList.add(new Team(7, "Fourtwelve", defaultDescription));

        SharedPreferencesUtility.putTeamList(this, "teams", teamsList);

    }
    
}
