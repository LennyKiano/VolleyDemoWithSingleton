package com.example.leonk.volleydemo;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Leonk on 8/30/2017.
 */

public class MySingleton {

    private  static  MySingleton MInstance;   //instance of class
    private RequestQueue requestQueue;        //RequestQueue
    private static Context mCtx;              //Context


    private MySingleton(Context context){

        mCtx=context;
        requestQueue=getRequestQueue();


    }




    public RequestQueue getRequestQueue(){    //method that gets a request queue

        if(requestQueue==null){               //Checking if request queue instance is available or not

            requestQueue= Volley.newRequestQueue(mCtx.getApplicationContext());      //instance lasts life time of the app

        }

        return requestQueue;
    }


    public static  synchronized MySingleton getInstance(Context context){      //method returns instance of class

        if(MInstance==null){                                                    //checking if instance exists or not

            MInstance= new MySingleton(context);
        }
        return MInstance;
    }

    public<T> void  addToRequest(Request<T> request){                          //apparently thread synchronization

        requestQueue.add(request);

    }


}
