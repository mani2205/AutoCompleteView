package com.example.autocompleteview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    ListView lv;
    EditText Name;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=findViewById(R.id.list);
        Name=findViewById(R.id.name);

        ArrayList product;

        String arr[]={"apple","orange","mango","pinapple"};
        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.list_item,R.id.listTv,arr);

//        Name.setThreshold(2);
        lv.setAdapter(adapter);

        Name.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                MainActivity.this.lv.setFilterText(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });



    }
}
