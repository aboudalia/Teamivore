package edu.umich.teamivore;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;


public class AddTeamActivity extends Activity {

    public final static String EXTRA_MESSAGE = "edu.umich.teamivore.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_team);
    }

    public void confirmAddTeam(View view) {

        // add team

        List<Team> teams = SharedPreferencesUtility.getTeamList(this, "teams");

        int id = teams.size();
        EditText name = (EditText) findViewById(R.id.add_team_name);
        EditText description = (EditText) findViewById(R.id.add_team_description);

        teams.add(new Team(name.getText().toString(), description.getText().toString()));

        SharedPreferencesUtility.putTeamList(this, "teams", teams);

        // toast message long

        Toast.makeText(getApplicationContext(), "A new team has been successfully added!",
                Toast.LENGTH_LONG).show();

        // intent to detail view

        Intent intent = new Intent(this, TeamDetailActivity.class);
        String message = String.valueOf(id);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

        // finish this activity

        finish();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add_team, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
