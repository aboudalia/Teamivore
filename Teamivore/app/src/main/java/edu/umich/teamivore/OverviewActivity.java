package edu.umich.teamivore;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class OverviewActivity extends Activity {

    List<Map<String, String>> teamsList = new ArrayList<Map<String,String>>();
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        initList();
        ListView teamListView = (ListView) findViewById(R.id.listView1);
        SimpleAdapter simpleAdpt = new SimpleAdapter(this, teamsList, android.R.layout.simple_list_item_1, new String[] {"team"}, new int[] {android.R.id.text1});
        teamListView.setAdapter(simpleAdpt);

        // React to user clicks on item
        teamListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parentAdapter, View view, int position,
                                    long id) {


                openTeamDetail(id);

                // We know the View is a TextView so we can cast it
                //TextView clickedView = (TextView) view;



                //Toast.makeText(OverviewActivity.this, "Item with id ["+id+"] - Position ["+position+"] - Planet ["+clickedView.getText()+"]", Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void initList() {
        teamsList.add(createTeam("team", "Team 1"));
        teamsList.add(createTeam("team", "Team 2"));
        teamsList.add(createTeam("team", "Team 3"));
        teamsList.add(createTeam("team", "Team 4"));
        teamsList.add(createTeam("team", "Team 5"));
        teamsList.add(createTeam("team", "Team 6"));
        teamsList.add(createTeam("team", "Team 7"));
    }

    private HashMap<String, String> createTeam(String key, String name) {
        HashMap<String, String> team = new HashMap<String, String>();
        team.put(key, name);
        return team;
    }



    public void openTeamDetail(long id) {
        Intent intent = new Intent(this, TeamDetailActivity.class);
        String message = String.valueOf(id);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
