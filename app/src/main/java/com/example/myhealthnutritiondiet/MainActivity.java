package com.example.myhealthnutritiondiet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextInputEditText  textInputEditTextAngiogenesis, textInputEditTextRegeneration, textInputEditTextMicrobiome, textInputEditTextImmunity, textInputEditTextDna;
    Button buttonSubmit;
    private MediaPlayer mediaPlayer;
    private static final String BASE_URL = "http://192.168.35.204/LoginRegister/getdata.php";
    Spinner spinAngiogenesis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInputEditTextAngiogenesis = findViewById(R.id.angiogenesis);
        textInputEditTextRegeneration = findViewById(R.id.regeneration);
        textInputEditTextMicrobiome = findViewById(R.id.microbiome);
        textInputEditTextImmunity = findViewById(R.id.immunity);
        textInputEditTextDna = findViewById(R.id.dna);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.lagu);
        mediaPlayer.start();


        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String  angiogenesis, regenerartion, microbiome,immunity,dna;

                angiogenesis = String.valueOf(textInputEditTextAngiogenesis.getText());
                regenerartion = String.valueOf(textInputEditTextRegeneration.getText());
                microbiome = String.valueOf(textInputEditTextMicrobiome.getText());
                immunity = String.valueOf(textInputEditTextImmunity.getText());
                dna = String.valueOf(textInputEditTextDna.getText());


                if (!angiogenesis.equals("") && !regenerartion.equals("") && !microbiome.equals("") && !immunity.equals("") && !dna.equals("")) {


                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[5];
                            field[0] = "angiogenesis";
                            field[1] = "regeneration";
                            field[2] = "microbiome";
                            field[3] = "immunity";
                            field[4] = "dna";

                            //Creating array for data
                            String[] data = new String[5];
                            data[0] = angiogenesis;
                            data[1] = regenerartion;
                            data[2] = microbiome;
                            data[3] = immunity;
                            data[4] = dna;

                            PutData putData = new PutData("http://192.168.35.204/LoginRegister/diet.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                    if(result.equals("Submit Success For The Day")){
                                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                    else {
                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                    }
                                    //End ProgressBar (Set visibility to GONE)

                                }
                            }
                            //End Write and Read data with URL
                        }
                    });

                }


            }

        });
    }

    @Override
    protected void onResume(){
        super.onResume();
        mediaPlayer.start();
    }

    @Override
    protected void onPause(){
        super.onPause();
        mediaPlayer.pause();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        mediaPlayer.stop();
        mediaPlayer.release();
    }

    public void food (View view) {
        startActivity(new Intent(getApplicationContext(),Foods.class));
        mediaPlayer.stop();
        finish();
    }
    public void recipe (View view) {
        startActivity(new Intent(getApplicationContext(),Recipe.class));
        mediaPlayer.stop();
        finish();
    }

    public void view (View view) {
        startActivity(new Intent(getApplicationContext(),MainActivity4.class));
        mediaPlayer.stop();
        finish();
    }



    public void logout (View view) {

        startActivity(new Intent(getApplicationContext(),Login.class));
        mediaPlayer.stop();
        finish();


    }




}