package de.vogella.android.weather.app;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class TomrrowsMatchActivity extends ActionBarActivity {
    static String api = "http://worldcup.sfg.io/matches/tomorrow";
    Context tomrrowsMatchActivity;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tomrrows_match);
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
                    tomrrowsMatchActivity = TomrrowsMatchActivity.this;
                    ArrayList<String> list = new ArrayList<String>();
                    JSONArray jsonArray = new JSONArray(result);
                    for (int i = 0; i< jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String status = jsonObject.getString("status");

                        JSONObject home_team = jsonObject.getJSONObject("home_team");
                        String home_country = home_team.getString("country");
                        JSONObject away_team = jsonObject.getJSONObject("away_team");
                        String away_country = away_team.getString("country");
                        String message = home_country + " vs " + away_country;
                        list.add(message);
                    }
                    listView = (ListView) findViewById(R.id.listView);
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(tomrrowsMatchActivity,android.R.layout.simple_list_item_1,list);
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
        Log.d("test", "test");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tomrrows_match, menu);
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
