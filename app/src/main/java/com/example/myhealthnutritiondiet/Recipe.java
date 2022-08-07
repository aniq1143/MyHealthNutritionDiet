package com.example.myhealthnutritiondiet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

public class Recipe extends AppCompatActivity {


    private GridView gridView;
    int [] pic={R.drawable.recipe1,R.drawable.recipe2,R.drawable.recipe3,R.drawable.recipe4,R.drawable.recipe5,R.drawable.recipe6,R.drawable.recipe7,R.drawable.recipe8,R.drawable.recipe9,R.drawable.recipe10};

    String[] foodNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        foodNames=getResources().getStringArray(R.array.food);
        gridView=(GridView)findViewById(R.id.gridViewId);



        CustomAdapter adapter=new CustomAdapter(this,foodNames,pic);
        gridView.setAdapter(adapter);


    }
    public void back (View view) {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        finish();
}}