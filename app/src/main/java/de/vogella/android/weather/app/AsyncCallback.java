package de.vogella.android.weather.app;

/**
 * Created by shotaokutsu on 6/18/14.
 */
public interface AsyncCallback {
    void onPreExecute();
    void onPostExecute(String result);
    void onProgressUpdate(int progress);
    void onCancelled();
}
