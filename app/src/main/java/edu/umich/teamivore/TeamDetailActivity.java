package edu.umich.teamivore;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class TeamDetailActivity extends Activity {

    List<Team> teamsList;

    int teamId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_detail);

        initList();

        // Get the message from the intent
        Intent intent = getIntent();
        String message = intent.getStringExtra(OverviewActivity.EXTRA_MESSAGE);

        teamId = (int) Long.parseLong(message);

        // Create the text view
        TextView textView = (TextView) findViewById(R.id.textView_teamname);
        textView.setText(teamsList.get(teamId).getName());

        // Just to demonstrate, the following two lines grab a rating bar element and set its value
        // programatically
        RatingBar ratings = (RatingBar) findViewById(R.id.ratingBar2);
        ratings.setRating(2);

    }

    // initList is a helper method that grabs our "team data" and associates it with the correct id
    // based on its position in the list
    // in a real application, this would be where we query the database and fetch the data associated
    // with the teams
    // we can perform some shared preferences data storing for now
    private void initList() {

        teamsList = SharedPreferencesUtility.getTeamList(this, "teams");

    }

    // onCreateOptionsMenu adds the options menu to your activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.team_detail, menu);
        return true;
    }

    public void deleteTeamDialog() {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(TeamDetailActivity.this);

        // Setting Dialog Title
        alertDialog.setTitle("Confirm Delete...");

        // Setting Dialog Message
        alertDialog.setMessage("Are you sure you want delete this team?");

        // Setting Icon to Dialog
        alertDialog.setIcon(android.R.drawable.ic_dialog_info);

        // Setting Positive "Yes" Button
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int which) {
                // Write your code here to invoke YES event
                deleteTeam();
            }
        });

        // Setting Negative "NO" Button
        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        // Showing Alert Message
        alertDialog.show();

    }

    public void deleteTeam() {

        teamsList.remove(teamId);
        SharedPreferencesUtility.putTeamList(this, "teams", teamsList);
        Toast.makeText(getApplicationContext(), "Team has been deleted!", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, OverviewActivity.class);
        startActivity(intent);

        finish();

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
        else if (id == R.id.action_delete_team) {
            deleteTeamDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



}
