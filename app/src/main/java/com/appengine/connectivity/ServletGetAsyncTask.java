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
public class ServletGetAsyncTask {
        //extends AsyncTask<Pair<Context, String>, Void, String> {

    private Context context;

//    @Override
//    protected String doInBackground(Pair<Context, String> ...params){
//        context = params[0].first;
//        String name = params[0].second;
//
//        try {
//            // Set up the request
//            URL url = new URL("http://10.0.2.2:8080/hello");
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("POST");
//            connection.setDoInput(true);
//            connection.setDoOutput(true);
//
//            // Build name data request params
//            Map<String, String> nameValuePairs = new HashMap<>();
//            nameValuePairs.put("name", name);
//            String postParams = buildPostDataString(nameValuePairs);
//
//            // Execute HTTP Post
//            OutputStream outputStream = connection.getOutputStream();
//            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
//            writer.write(postParams);
//            writer.flush();
//            writer.close();
//            outputStream.close();
//            connection.connect();
//
//            // Read response
//            int responseCode = connection.getResponseCode();
//            StringBuilder response = new StringBuilder();
//            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//            String line;
//            while ((line = reader.readLine()) != null) {
//                response.append(line);
//            }
//            reader.close();
//
//            if (responseCode == HttpsURLConnection.HTTP_OK) {
//                return response.toString();
//            }
//            return "Error: " + responseCode + " " + connection.getResponseMessage();
//
//        } catch (IOException e) {
//            return e.getMessage();
//        }
//
//
//    }

}
