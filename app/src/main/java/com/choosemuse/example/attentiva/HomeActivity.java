package com.choosemuse.example.attentiva;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;


public class HomeActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    //public User currentUser;
    private String currentDeviceID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);


        ImageButton runsButton = findViewById(R.id.menu_icon);
        Button startButton = findViewById(R.id.start_button);

        Intent runsIntent = new Intent(HomeActivity.this, MuseRuns.class); //class where you are, then class where you wanan go
        switchActivityButton(runsButton, runsIntent);

        Intent startMuseIntent = new Intent(HomeActivity.this, MainActivity.class);
        switchStartActivityButton(startButton, startMuseIntent);


    }

    public void switchActivityButton(ImageButton button, Intent intent){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
    }
    public void switchStartActivityButton(Button button, Intent intent){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}