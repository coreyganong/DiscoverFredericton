package com.coreyganong.discoverfredericton;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity2 extends AppCompatActivity
        implements  InfoFragment2.OnFragmentInteractionListener,
                    FakeMapFragment.OnFragmentInteractionListener,
                    PlaceFragment.OnFragmentInteractionListener,
                    PassportFragment.OnFragmentInteractionListener,
                    OnMapReadyCallback
{

    private ServerSocket serverSocket;
    Handler handler;
    Thread serverThread = null;
    public static final int SERVERPORT = 8080;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        InfoFragment2 fragment = new InfoFragment2();
        getSupportFragmentManager().beginTransaction().replace(R.id.main_container, fragment).commit();


        Button endButton = (Button) findViewById(R.id.end_button);
        endButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context c = v.getContext();
                Intent intent = new Intent(c,ChooseActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                c.startActivity(intent);
                finish();
            }
        });


    }
    @Override
    public void onMapReady(GoogleMap map) {
        map.addMarker(new MarkerOptions().position(new LatLng(45.9635,66.6432)).title("City Hall"));
    }
    public void onFragmentInteraction (Uri uri) {

    }





}
