package com.coreyganong.discoverfredericton;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toolbar;

public class EntryActivity extends AppCompatActivity {
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setActionBar(toolbar);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,R.array.languages,R.layout.spinner_layout);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_layout);
        spinner.setAdapter(arrayAdapter);

        Button button = (Button) findViewById(R.id.start_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EntryActivity.this,ChooseActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
