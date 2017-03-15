package com.example.filip.fragtester.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
//import android.support.v4.app.Fragment;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.filip.fragtester.R;


public class Frag3 extends Fragment {


    private OnFrag3Listener mListener;

    public Frag3() {
        // Required empty public constructor
    }

    public static Frag3 newInstance() {
        Frag3 frag = new Frag3();

        return frag;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_frag3, container, false);

        /****************************
         * Codigo aqui no meio
         */


        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.goToFrag3Fragment();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFrag3Listener) {
            mListener = (OnFrag3Listener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFrag3Listener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFrag3Listener {
        // TODO: Update argument type and name
        void goToFrag3Fragment();
    }
}
