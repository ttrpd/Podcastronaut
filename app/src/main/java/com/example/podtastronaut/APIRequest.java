package com.example.podtastronaut;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

abstract class APIRequest extends AsyncTask<String, Integer, String> {
    private static final String ITUNES_API_URL = "https://itunes.apple.com/search?media=podcast&term=";

    protected abstract void updateUI();

    @Override
    protected String doInBackground(String... searchTerms) {
        try {
            URL url = new URL(ITUNES_API_URL + searchTerms[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            connection.connect();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            );
            String response = "";
            String line = "";
            while ((line = reader.readLine()) != null) {
                response += line + "\n";
            }
            connection.disconnect();
            return response;
        } catch (MalformedURLException e) {
            Log.e(
                    "APIRequest",
                    "The following URL was invalid:\n"+ITUNES_API_URL+searchTerms[0]
            );
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    protected void onProgressUpdate(Integer... progress) {
    }

    protected void onPostExecute(String result) {
        // this is executed on the main thread after the process is over
        // update your UI here
        updateUI();
    }
}

