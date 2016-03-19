package com.appengine.connectivity;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.httpupdateholders.HttpGetResultHolder;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by aramide on 16/03/2016.
 */
public class SimpleHttpRequestAsynk extends AsyncTask<String, Void, String>{

    @Override
    protected String doInBackground(String... urls) {

        String urlStr = urls[0];

        InputStream inputStream = null;
        String result = "";

        try {
            //create HTTP client
            HttpClient httpClient = new DefaultHttpClient();

            //make GET request to the given URL
            HttpResponse httpResponse = httpClient.execute(new HttpGet(urlStr));

            //recieve response as inputStream
            inputStream = httpResponse.getEntity().getContent();

            //convert input stream to string...
            if (inputStream != null) {
                result = this.converInputStreamToString(inputStream);
            }
            else {
                result = "Did not work!";
            }
        }
        catch (final Exception ex) {
            Log.v("InputStream", ex.getLocalizedMessage());
        }

        return result;



//        try {
//            URL url = new URL(urls[0]);
//
//            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//
//            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
//
//            /**
//             * Method to read collected stuff...
//             */
//            readStream(in);
//
//            urlConnection.disconnect();
//
//        } catch (final IOException ex){
//
//            Log.v("URL: ", ex.getMessage());
//
//        }finally {
//
//        }
//
//        return null;
    }

    private String converInputStreamToString(InputStream inputStream) throws IOException{

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = "";
        String result = "";

        while((line = bufferedReader.readLine()) != null){
            result += line;
        }
        inputStream.close();
        return result;
    }

    /**
     *
     * @param in
     */
    private void readStream(InputStream in) {

        Log.v("Outputted", "Content: " + in.toString());

    }

    @Override
    protected void onPostExecute(String result){

        Log.v("Outputted", "Content: " + result);

        HttpGetResultHolder.httpGetResultHolder = result;
    }
}
