package protoshade.com.chat.chathub.endpoints;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.appengine.connectivity.ServletPostAsyncTask;
import com.appengine.connectivity.SimpleHttpRequest;
import com.appengine.connectivity.SimpleHttpRequestAsynk;
import com.httpupdateholders.HttpGetResultHolder;

public class MainActivity extends ActionBarActivity {

    private TextView textview;
    private Button httpsButton;
    private Button updateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.textview = (TextView) findViewById(R.id.textViewUpdate);
        this.httpsButton = (Button) findViewById(R.id.rest_get_button);
        this.updateTextView = (Button) findViewById(R.id.rest_update_textview);
        
        this.buttonListener();

        this.buttonUpdateListener();
        
    }

    private void buttonUpdateListener() {

        this.updateTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity.this.updateCurrentTextView(HttpGetResultHolder.httpGetResultHolder);

            }
        });

    }

    private void updateCurrentTextView(final String currentContent) {


        if (currentContent == null){

            this.textview.setText("New content not yet pulled....");

        } else {

            this.textview.setText(currentContent);

        }


    }

    /**
     *
     */
    private void buttonListener() {

        this.httpsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity.this.invokeHttpsGetRequest();

            }
        });

    }


    private void invokeHttpsGetRequest() {

        //new ServletPostAsyncTask().execute(new Pair<Context, String>(this, "Manfred"));

        final String urlPath1 = "http://noted-bliss-125121.appspot.com/hello";
        //final String urlPath1 = "http://hmkcode.com/examples/index.php";
        final String urlPath2 = "http://noted-bliss-125121.appspot.com/hello";


        new SimpleHttpRequestAsynk().execute(urlPath1);

        //SimpleHttpRequest simpleHttpRequest = new SimpleHttpRequest(this);
        //simpleHttpRequest.executeHttpGetRequest();

    }
}
