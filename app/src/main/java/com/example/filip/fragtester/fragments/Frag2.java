package com.example.filip.fragtester.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.filip.fragtester.MainActivity;
import com.example.filip.fragtester.R;



public class Frag2 extends Fragment {

    private OnFrag2Listener mListener;
    MainActivity parentActivity;

    public Frag2() {
        // Required empty public constructor
    }


    public static Frag2 newInstance() {
        Frag2 frag = new Frag2();

        return frag;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        parentActivity = (MainActivity) this.getActivity();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_frag2, container, false);
        Button btn2 = (Button) v.findViewById(R.id.btnFrag2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parentActivity.goToFrag1Fragment();
            }
        });

        Button btnNumCond = (Button) v.findViewById(R.id.btnokNCon);
        final EditText etNumCond = (EditText) v.findViewById(R.id.eTNumCond);

        btnNumCond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parentActivity.setNumbCond(Integer.parseInt(String.valueOf(etNumCond.getText())));
                LinearLayout ll = (LinearLayout) parentActivity.findViewById(R.id.llRadio);
                ll.removeAllViews();
                for (int x=1; x<=parentActivity.getNumbCond(); x++){
                    RadioGroup rg = new RadioGroup(parentActivity);
                    rg.setOrientation(LinearLayout.HORIZONTAL);
                    rg.setId(x);

                    RadioButton rdbtn0 = new RadioButton(parentActivity);
                    rdbtn0.setId(Integer.parseInt(x+"0"));
                    rdbtn0.setText("Masculino");
                    rg.addView(rdbtn0);

                    RadioButton rdbtn1 = new RadioButton(parentActivity);
                    rdbtn1.setId(Integer.parseInt(x+"1"));
                    rdbtn1.setText("Feminino");
                    rg.addView(rdbtn1);

                    ll.addView(rg);

                  }
            }
        });

        Button btnResult = (Button) v.findViewById(R.id.btnGetResult);
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // RadioGroup rd1 = (RadioGroup) v.findViewById(R.id.);
            }
        });





        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.goToFrag2Fragment();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFrag2Listener) {
            mListener = (OnFrag2Listener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFrag2Listener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFrag2Listener {
        // TODO: Update argument type and name
        void goToFrag2Fragment();
    }
}
