package com.coreyganong.discoverfredericton;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;

import java.util.TimerTask;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PassportFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PassportFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PassportFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public PassportFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static PassportFragment newInstance(String param1, String param2) {
        PassportFragment fragment = new PassportFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_passport, container, false);
        int[] STAMP_LOCS = {R.drawable.city_hall_stamps,R.drawable.justice_stamp,R.drawable.barracks_stamp,R.drawable.officers_square_stamp,R.drawable.playhouse_stamp};
        final GridLayout gridLayout = (GridLayout) view.findViewById(R.id.passport_stamps);
        for (int i = 0; i < MainActivity.STAMPS.length; i++) {
            if (MainActivity.STAMPS[i]==true) {
                ImageView imageView = new ImageView(view.getContext());
                imageView.setImageResource(STAMP_LOCS[i]);
                imageView.setPadding(15,15,15,15);
                gridLayout.addView(imageView);
            }
        }
        ImageView fbIcon = (ImageView)view.findViewById(R.id.facebook_icon);
        fbIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = (LayoutInflater)v.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View popupView = layoutInflater.inflate(R.layout.login_popup,null,false);
                final PopupWindow popupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT,true);
                final Handler handler = new Handler();
                popupWindow.showAtLocation(gridLayout, Gravity.CENTER, 0, 0);
                Button cancelButton = (Button) popupView.findViewById(R.id.cancel_button);
                cancelButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });
            }
        });
        ImageView instaIcon = (ImageView)view.findViewById(R.id.instagram_icon);
        instaIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = (LayoutInflater)v.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View popupView = layoutInflater.inflate(R.layout.login_popup,null,false);
                final PopupWindow popupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT,true);
                final Handler handler = new Handler();
                popupWindow.showAtLocation(gridLayout, Gravity.CENTER, 0, 0);
                Button cancelButton = (Button) popupView.findViewById(R.id.cancel_button);
                cancelButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });
            }
        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
