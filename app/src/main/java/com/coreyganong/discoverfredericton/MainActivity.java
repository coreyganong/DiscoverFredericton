package com.coreyganong.discoverfredericton;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

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

public class MainActivity extends AppCompatActivity
        implements  InfoFragment.OnFragmentInteractionListener,
                    FakeMapFragment.OnFragmentInteractionListener,
                    PlaceFragment.OnFragmentInteractionListener,
                    PassportFragment.OnFragmentInteractionListener,
                    OnMapReadyCallback
{

    private ServerSocket serverSocket;
    Handler handler;
    Thread serverThread = null;
    public static final int SERVERPORT = 8080;
    public static boolean[] STAMPS = new boolean[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InfoFragment fragment = new InfoFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.main_container, fragment).commit();
        Button infoButton = (Button) findViewById(R.id.info_button);
        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InfoFragment fragment = new InfoFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.main_container, fragment).commit();
            }
        });

        Button mapButton = (Button) findViewById(R.id.map_button);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*MapFragment mapFragment = new MapFragment();
                mapFragment.getMapAsync(MainActivity.this);
                getFragmentManager().beginTransaction().replace(R.id.main_container, mapFragment).commit();*/
                FakeMapFragment fragment = new FakeMapFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.main_container, fragment).commit();
            }
        });

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

        Button passportButton = (Button) findViewById(R.id.passport_button);
        passportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PassportFragment fragment = new PassportFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.main_container, fragment).commit();
            }
        });

        ImageButton button1 = (ImageButton) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle arguments = new Bundle();
                arguments.putString(PlaceFragment.ARG_PARAM1, "button1");
                PlaceFragment fragment = new PlaceFragment();
                fragment.setArguments(arguments);
                getSupportFragmentManager().beginTransaction().replace(R.id.main_container, fragment).commit();
            }
        });

        ImageButton button2 = (ImageButton) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle arguments = new Bundle();
                arguments.putString(PlaceFragment.ARG_PARAM1,"button2");
                PlaceFragment fragment = new PlaceFragment();
                fragment.setArguments(arguments);
                getSupportFragmentManager().beginTransaction().replace(R.id.main_container, fragment).commit();
            }
        });

        ImageButton button3 = (ImageButton) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle arguments = new Bundle();
                arguments.putString(PlaceFragment.ARG_PARAM1,"button3");
                PlaceFragment fragment = new PlaceFragment();
                fragment.setArguments(arguments);
                getSupportFragmentManager().beginTransaction().replace(R.id.main_container, fragment).commit();
            }
        });

        ImageButton button4 = (ImageButton) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle arguments = new Bundle();
                arguments.putString(PlaceFragment.ARG_PARAM1,"button4");
                PlaceFragment fragment = new PlaceFragment();
                fragment.setArguments(arguments);
                getSupportFragmentManager().beginTransaction().replace(R.id.main_container, fragment).commit();
            }
        });

        ImageButton button5 = (ImageButton) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle arguments = new Bundle();
                arguments.putString(PlaceFragment.ARG_PARAM1,"button5");
                PlaceFragment fragment = new PlaceFragment();
                fragment.setArguments(arguments);
                getSupportFragmentManager().beginTransaction().replace(R.id.main_container, fragment).commit();
            }
        });

        ImageButton button6 = (ImageButton) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle arguments = new Bundle();
                arguments.putString(PlaceFragment.ARG_PARAM1,"button6");
                PlaceFragment fragment = new PlaceFragment();
                fragment.setArguments(arguments);
                getSupportFragmentManager().beginTransaction().replace(R.id.main_container, fragment).commit();
            }
        });

        ImageButton button7 = (ImageButton) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle arguments = new Bundle();
                arguments.putString(PlaceFragment.ARG_PARAM1,"button7");
                PlaceFragment fragment = new PlaceFragment();
                fragment.setArguments(arguments);
                getSupportFragmentManager().beginTransaction().replace(R.id.main_container, fragment).commit();
            }
        });

        ImageButton button8 = (ImageButton) findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle arguments = new Bundle();
                arguments.putString(PlaceFragment.ARG_PARAM1,"button8");
                PlaceFragment fragment = new PlaceFragment();
                fragment.setArguments(arguments);
                getSupportFragmentManager().beginTransaction().replace(R.id.main_container, fragment).commit();
            }
        });

        ImageButton button9 = (ImageButton) findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle arguments = new Bundle();
                arguments.putString(PlaceFragment.ARG_PARAM1,"button9");
                PlaceFragment fragment = new PlaceFragment();
                fragment.setArguments(arguments);
                getSupportFragmentManager().beginTransaction().replace(R.id.main_container, fragment).commit();
            }
        });

        ImageButton button10 = (ImageButton) findViewById(R.id.button10);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle arguments = new Bundle();
                arguments.putString(PlaceFragment.ARG_PARAM1,"button10");
                PlaceFragment fragment = new PlaceFragment();
                fragment.setArguments(arguments);
                getSupportFragmentManager().beginTransaction().replace(R.id.main_container, fragment).commit();
            }
        });

        handler = new Handler();

        this.serverThread = new Thread(new ServerThread());
        this.serverThread.start();
    }
    @Override
    public void onMapReady(GoogleMap map) {
        map.addMarker(new MarkerOptions().position(new LatLng(45.9635,66.6432)).title("City Hall"));
    }
    public void onFragmentInteraction (Uri uri) {

    }

    @Override
    protected void onPause() {
        super.onPause();
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class ServerThread implements Runnable {

        public void run() {
            Socket socket = null;
            try {
                serverSocket = new ServerSocket(SERVERPORT);
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (!Thread.currentThread().isInterrupted()) {

                try {

                    socket = serverSocket.accept();

                    CommunicationThread commThread = new CommunicationThread(socket);
                    new Thread(commThread).start();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class CommunicationThread implements Runnable {

        private Socket clientSocket;

        private BufferedReader input;

        public CommunicationThread(Socket clientSocket) {

            this.clientSocket = clientSocket;

            try {

                this.input = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {


            while (!Thread.currentThread().isInterrupted()) {

                try {

                    String read = input.readLine();

                    if (read == null ){
                        Thread.currentThread().interrupt();
                    }else{
                        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                        out.write("TstMsg");
                        handler.post(new updateUIThread(read));

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    class updateUIThread implements Runnable {
        private String msg;

        public updateUIThread(String str) {
            this.msg = str;
        }

        @Override
        public void run() {
            LayoutInflater layoutInflater = (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
            View popupView = layoutInflater.inflate(R.layout.popup,null,false);
            TextView popupText = (TextView)popupView.findViewById(R.id.popup_text);
            ImageView imageView = (ImageView)popupView.findViewById(R.id.popup_stamp);
            switch(msg) {
                case "1":
                    popupText.setText("You found: City Hall");
                    imageView.setImageResource(R.drawable.city_hall_stamps);
                    STAMPS[0] = true;
                    break;
                case "2":
                    popupText.setText("You found: Justice Building");
                    imageView.setImageResource(R.drawable.justice_stamp);
                    STAMPS[1] = true;
                    break;
                case "3":
                    popupText.setText("You found: Soldiers' Barracks");
                    imageView.setImageResource(R.drawable.barracks_stamp);
                    STAMPS[2] = true;
                    break;
                case "4":
                    popupText.setText("You found: Officers' Square");
                    imageView.setImageResource(R.drawable.officers_square_stamp);
                    STAMPS[3] = true;
                    break;
                default:
                    Log.i("TCP", "null");
                    break;
            }
            final PopupWindow popupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT,true);

            popupWindow.showAtLocation(getWindow().findViewById(R.id.main_container), Gravity.CENTER, 0, 0);
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            popupWindow.dismiss();
                        }
                    });
                }
            };
            new Timer().schedule(timerTask, 7000);

        }

    }
}
