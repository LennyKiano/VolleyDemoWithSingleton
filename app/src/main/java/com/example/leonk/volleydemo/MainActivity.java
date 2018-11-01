package com.example.leonk.volleydemo;

import android.icu.text.IDNA;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HttpStack;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textView;

    String url="http://192.168.100.8/greetings.php";        //put in your own URL here 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=(Button) findViewById(R.id.button1);
        textView=(TextView) findViewById(R.id.responseTextView);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringRequest stringRequest=new StringRequest(Request.Method.POST, url,

                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                textView.setText(response);

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
                        error.printStackTrace();

                    }
                });

                MySingleton.getInstance(getApplicationContext()).addToRequest(stringRequest);
            }
        });

    }
}
