package com.appengine.connectivity;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Pair;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by aramide on 15/03/2016.
 */
public class ServletPostAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {

    private Context context;

    @Override
    protected String doInBackground(Pair<Context, String> ...params){
        context = params[0].first;
        String name = params[0].second;

        try {
            //set up the request
            /**
             * Path to where GET is outputted (localhost)...
             */
            //URL url = new URL("http://10.0.2.2:8080/hello");

            /**
             * Path to where POST is outputted (deployed path...)
             */
            URL url = new URL("http://noted-bliss-125121.appspot.com/hello");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoInput(true);
            connection.setDoOutput(true);

            //Build name data request params
            Map<String, String> nameValuePairs = new HashMap<>();

            nameValuePairs.put("name", name); // defines what param. method signature to look for (doPost -> String name = req.getParameter("name");)

            String postParams = this.buildPostDataString(nameValuePairs);

            //Execute HTTP Post
            OutputStream outputStream = connection.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            writer.write(postParams);
            writer.flush();
            writer.close();
            outputStream.close();
            connection.connect();

            //Read response
            int responseCode = connection.getResponseCode();
            StringBuilder response = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;

            //provided there's still content to iterate through..
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

                         //HTTP secure connection (SSL) > return message securely...
            if (responseCode == HttpsURLConnection.HTTP_OK) {
                return response.toString();
            }


            return "Error: " + responseCode + " " + connection.getResponseMessage();

        } catch (IOException ex){
            return ex.getMessage();
        }
    }

    /**
     * Iterate through pulled dataset...
     * @param params
     * @return
     * @throws UnsupportedEncodingException
     */
    private String buildPostDataString(Map<String, String> params) throws UnsupportedEncodingException {

        StringBuilder result = new StringBuilder();
        boolean first = true;
        for (Map.Entry<String, String> entry: params.entrySet()) {

            if (first) {
                first = false;
            } else {
                result.append("&");
            }

            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));

        }

        return result.toString();
    }

    /**
     * Executed/ displayed as soon as doInBackground concludes...
     * @param result
     */
    @Override
    protected void onPostExecute(final String result){
        Toast.makeText(this.context, result, Toast.LENGTH_LONG).show();
    }

}
