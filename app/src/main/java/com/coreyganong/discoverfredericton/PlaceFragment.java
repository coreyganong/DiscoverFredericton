package com.coreyganong.discoverfredericton;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PlaceFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PlaceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlaceFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String ARG_PARAM1 = "id";


    // TODO: Rename and change types of parameters
    private String mParam1;


    private OnFragmentInteractionListener mListener;

    public PlaceFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment PlaceFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PlaceFragment newInstance(String param1, String param2) {
        PlaceFragment fragment = new PlaceFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_place, container, false);

        ImageView imageView = (ImageView) rootView.findViewById(R.id.place_img);
        TextView textView = (TextView) rootView.findViewById(R.id.place_title);
        TextView placeText = (TextView) rootView.findViewById(R.id.place_text);
        switch (mParam1) {
            case "button1":
                imageView.setImageResource(R.drawable.place1);
                textView.setText(R.string.title1);
                placeText.setText(R.string.text1);
                break;
            case "button2":
                imageView.setImageResource(R.drawable.place2);
                textView.setText(R.string.title2);
                placeText.setText(R.string.text2);
                break;
            case "button3":
                imageView.setImageResource(R.drawable.place3);
                textView.setText(R.string.title3);
                placeText.setText(R.string.text3);
                break;
            case "button4":
                imageView.setImageResource(R.drawable.place4);
                textView.setText(R.string.title4);
                placeText.setText(R.string.text4);
                break;
            case "button5":
                imageView.setImageResource(R.drawable.place5);
                textView.setText(R.string.title5);
                placeText.setText(R.string.text5);
                break;
            case "button6":
                imageView.setImageResource(R.drawable.place6);
                textView.setText(R.string.title6);
                placeText.setText(R.string.text6);
                break;
            case "button7":
                imageView.setImageResource(R.drawable.place7);
                textView.setText(R.string.title7);
                placeText.setText(R.string.text7);
                break;
            case "button8":
                imageView.setImageResource(R.drawable.place8);
                textView.setText(R.string.title8);
                placeText.setText(R.string.text8);
                break;
            case "button9":
                imageView.setImageResource(R.drawable.place9);
                textView.setText(R.string.title9);
                placeText.setText(R.string.text9);
                break;
            case "button10":
                imageView.setImageResource(R.drawable.place10);
                textView.setText(R.string.title10);
                placeText.setText(R.string.text10);
                break;

        }


        return rootView;
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
