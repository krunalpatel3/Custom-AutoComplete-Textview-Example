package com.example.customautocomplete;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<UserDetails> userDetailsList = new ArrayList<>();
    CustomAutoSuggestAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AutoCompleteTextView autotext = findViewById(R.id.autoCompleteTextView);

        userDetailsList.add(new UserDetails("Jay","2393939494"));
        userDetailsList.add(new UserDetails("Karan","3323939494"));
        userDetailsList.add(new UserDetails("Kush","3232393444"));
        userDetailsList.add(new UserDetails("Meel","3232303444"));
        userDetailsList.add(new UserDetails("Neel","3272203444"));


        adapter = new CustomAutoSuggestAdapter(MainActivity.this,
                 (ArrayList<UserDetails>) userDetailsList);

        autotext.setAdapter(adapter);


    }
}
