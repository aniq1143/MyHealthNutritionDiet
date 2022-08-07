package com.example.myhealthnutritiondiet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Foods extends AppCompatActivity {

    ListView listView1, listView2, listView3, listView4, listView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods);

        listView1 = (ListView)  findViewById(R.id.listView1);

        String[] values = new String[]{

              "Almonds",
              "Apricot",
              "Barley",
              "Bok Choy",
              "Cashews",
              "Chia Seeds",
              "Cherry",
               "Chamomile tea",
               "Hake",
               "Manila Clams",
               "Olive Oil" ,

        };
        listView2 = (ListView)  findViewById(R.id.listView2);

        String[] values1 = new String[]{

                "Anchivoes",
                "Apples",
                "Black plums",
                "Black Raspberries",
                "Bottarga",
                "Caviar",
                "Celery",
                "Ginseng",
                "Halibut",
                "Peanuts",
                "Salmon",
        };

        listView3 = (ListView)  findViewById(R.id.listView3);

        String[] values2 = new String[]{

                "Asparagus",
                "Black Beans",
                "Cabbage",
                "Carrots",
                "Coffee",
                "Enoki Mushroom",
                "Lychee",
                "Oyster Mushroom",
                "Pomegranate Juice",
                "Sesame Seeds",
                "Walnuts",

        };

        listView4 = (ListView)  findViewById(R.id.listView4);

        String[] values3 = new String[]{

                "Acerola",
                "Apple peel",
                "Cauliflowers",
                "Chile Peppers",
                "Eggplant",
                "Dark Chocolate",
                "Grapefruit",
                "Kimchi",
                "Onions",
                "Peppermint",
                "Saffron",
        };

        listView5 = (ListView)  findViewById(R.id.listView5);

        String[] values4 = new String[]{

                "Almond Butter",
                "Basil",
                "Bigeye Tuna",
                "Cockles",
                "Flax Seeds",
                "Gray Mullet",
                "Hazelnuts",
                "John Dory (Fish)",
                "Mangoes",
                "Pecans",
                "Sage",
                "Turnips",

        };


        ArrayAdapter<String> adapter = new ArrayAdapter<> (this, android.R.layout.simple_expandable_list_item_1, android.R.id.text1,values);
        listView1.setAdapter(adapter);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<> (this, android.R.layout.simple_expandable_list_item_1, android.R.id.text1,values1);
        listView2.setAdapter(adapter1);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<> (this, android.R.layout.simple_expandable_list_item_1, android.R.id.text1,values2);
        listView3.setAdapter(adapter2);

        ArrayAdapter<String> adapter3 = new ArrayAdapter<> (this, android.R.layout.simple_expandable_list_item_1, android.R.id.text1,values3);
        listView4.setAdapter(adapter3);

        ArrayAdapter<String> adapter4 = new ArrayAdapter<> (this, android.R.layout.simple_expandable_list_item_1, android.R.id.text1,values4);
        listView5.setAdapter(adapter4);

    }

    public void backfood (View view) {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        finish();
    }
}