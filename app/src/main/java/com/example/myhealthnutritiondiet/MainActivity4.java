package com.example.myhealthnutritiondiet;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity4 extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    public static final String URL = "http://192.168.35.204/LoginRegister/getproducts.php";
    ListView list;
    SwipeRefreshLayout swipe;
    List<Data> itemList = new ArrayList<Data>();
    VAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        swipe = (SwipeRefreshLayout) findViewById(R.id.swipe);
        list = (ListView) findViewById(R.id.list);

        adapter = new VAdapter(MainActivity4.this, itemList);
        list.setAdapter(adapter);

        swipe.setOnRefreshListener(this);

        swipe.post(new Runnable() {
            @Override
            public void run() {
                swipe.setRefreshing(true);
                itemList.clear();
                adapter.notifyDataSetChanged();
                callVolley();

            }
        });



    }
            @Override
            public void onRefresh(){
                itemList.clear();
                adapter.notifyDataSetChanged();
                callVolley();

            }
            private void callVolley() {
                itemList.clear();
                adapter.notifyDataSetChanged();
                swipe.setRefreshing(true);


                JsonArrayRequest jArr = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        for (int i = 0; i < response.length(); i++){
                            try{
                                JSONObject obj = response.getJSONObject(i);

                                Data item = new Data();

                                item.setDate(obj.getString("date"));
                                item.setAngiogenesis1(obj.getString("angiogenesis"));
                                item.setRegeneration1(obj.getString("regeneration"));
                                item.setMicrobiome1(obj.getString("microbiome"));
                                item.setImmunity1(obj.getString("immunity"));
                                item.setDna1(obj.getString("dna"));

                                itemList.add(item);


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        adapter.notifyDataSetChanged();
                        swipe.setRefreshing(false);

                    }
                }, new Response.ErrorListener(){
                    @Override
                        public void onErrorResponse(VolleyError error){
                        VolleyLog.d(TAG, "Error:" + error.getMessage());
                }
                });


                RequestQueue mRequestQueue = Volley.newRequestQueue(getApplicationContext());
                mRequestQueue.add(jArr);


    }
    public void backdisplay (View view) {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        finish();
    }
}