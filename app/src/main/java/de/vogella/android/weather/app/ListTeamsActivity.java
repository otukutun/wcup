package de.vogella.android.weather.app;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class ListTeamsActivity extends ActionBarActivity {
    static String api = "http://worldcup.sfg.io/teams/";
    Context listTeamsActivity;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_teams);

        AsyncGet asyncGet = new AsyncGet(new AsyncCallback() {
            @Override
            public void onPreExecute() {
                try {

                } catch (Exception e) {

                }

            }

            @Override
            public void onPostExecute(String result) {
                try {
                    listTeamsActivity = ListTeamsActivity.this;
                    ArrayList<String> list = new ArrayList<String>();
                    JSONArray jsonArray = new JSONArray(result);
                    for (int i = 0; i< jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String country = jsonObject.getString("country");

                        list.add(country);
                    }
                    listView = (ListView) findViewById(R.id.listView);
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(listTeamsActivity,android.R.layout.simple_list_item_1,list);
                    listView.setAdapter(adapter);
                } catch (Exception e) {

                }

            }

            @Override
            public void onProgressUpdate(int progress) {

            }

            @Override
            public void onCancelled() {

            }
        });
        asyncGet.execute(api);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.list_treams, menu);
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
