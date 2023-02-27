package com.example.multipurposecamera;

import android.os.AsyncTask;
import android.util.Log;

import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;



/**
 * The class Retrieve website task extends async task< void, void, string>
 */
public class RetrieveWebsiteTask extends AsyncTask<Void, Void, String> {

    @Override
    protected String doInBackground(Void... voids) {
        try {
            URL url = new URL("https://4azfs5ytk7.execute-api.us-east-1.amazonaws.com/production/@connections");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            return response.toString();
        } catch (Exception e) {
            return e.toString();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Log.d("Result", result);
    }
}
