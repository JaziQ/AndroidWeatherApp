package com.example.task6t;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HistoryActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_history);
    }

    public void onClick(View view) {
        Intent intent = new Intent(HistoryActivity.this, MapsActivity.class);
        startActivity(intent);
    }
}