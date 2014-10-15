package edu.umich.teamivore;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class TeamDetailActivity extends Activity {

    List<String> teamsList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_detail);

        initList();

        // Get the message from the intent
        Intent intent = getIntent();
        String message = intent.getStringExtra(OverviewActivity.EXTRA_MESSAGE);

        int id = (int) Long.parseLong(message);

        // Create the text view
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(teamsList.get(id));

        // Set the text view as the activity layout
        setContentView(textView);

    }

    // initList is a helper method that grabs our "team data" and associates it with the correct id
    // based on its position in the list
    // in a real application, this would be where we query the database and fetch the data associated
    // with the teams
    private void initList() {
        teamsList.add("Team 1");
        teamsList.add("Team 2");
        teamsList.add("Team 3");
        teamsList.add("Team 4");
        teamsList.add("Team 5");
        teamsList.add("Team 6");
        teamsList.add("Team 7");
    }

    // onCreateOptionsMenu adds the options menu to your activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.team_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            // launch intent to settings screen
            return true;
        }
        else if (id == R.id.action_logout) {
            // launch intent to settings screen
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
