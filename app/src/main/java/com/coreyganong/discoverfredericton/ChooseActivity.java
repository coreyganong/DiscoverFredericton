package com.coreyganong.discoverfredericton;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toolbar;

public class ChooseActivity extends AppCompatActivity {
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setActionBar(toolbar);
        Button tourButton = (Button) findViewById(R.id.tour_btn);
        tourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseActivity.this, MainActivity.class);
                startActivity(intent);
                System.gc();
                finish();
            }
        });
        Button kidsButton = (Button) findViewById(R.id.child_btn);
        kidsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseActivity.this,MainActivity2.class);
                startActivity(intent);
                System.gc();
                finish();
            }
        });
    }
}
