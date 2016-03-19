package com.appengine.connectivity;

import android.content.Context;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by aramide on 16/03/2016.
 */
public class SimpleHttpRequest {

    private Context cTx;

    public SimpleHttpRequest(final Context context){
        this.cTx = context;
    }

    public void executeHttpGetRequest(){

        try {

            URL url = new URL("http://noted-bliss-125121.appspot.com/hello");

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());

            /**
             * Method to read collected stuff...
             */
            readStream(in);

            urlConnection.disconnect();

        } catch (final IOException ex){

            Log.v("URL: ", ex.getMessage());

        }finally {

        }

    }

    /**
     * Do something with pulled data...
     * @param in
     */
    private void readStream(InputStream in) {

    }

    public void invokeRequestQueue(){

        //RequestQueue queue = Volley.newRequestQueue(this.cTx);

    }

}
