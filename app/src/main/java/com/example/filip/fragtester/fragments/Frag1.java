package com.example.filip.fragtester.fragments;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
//tens de por o seguinte frag
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.filip.fragtester.MainActivity;
import com.example.filip.fragtester.R;

import java.util.Calendar;

public class Frag1 extends Fragment {

    MainActivity parentActivity;
    private OnFrag1Listener mListener;

    public Frag1() {
        // Required empty public constructor
    }


    public static Frag1 newInstance() {
        Frag1 frag = new Frag1();
        return frag;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        parentActivity = (MainActivity) this.getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_frag1, container, false);

        Button btn1 = (Button) v.findViewById(R.id.btnFrag1);
        Button btnChangeDate = (Button) v.findViewById(R.id.btnDate);
        final EditText eTextDia = (EditText) v.findViewById(R.id.eTDia);
        final EditText eTextMes = (EditText) v.findViewById(R.id.eTMes);
        final EditText eTextAno = (EditText) v.findViewById(R.id.eTAno);
        final EditText eTHora  = (EditText) v.findViewById(R.id.eTHora);
        final EditText eTMin = (EditText) v.findViewById(R.id.eTMin);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parentActivity.goToFrag2Fragment();
            }
        });

        btnChangeDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code to open fragment
                final Dialog dateDialog = new Dialog(v.getContext());
                dateDialog.setContentView(R.layout.date_picker);
                dateDialog.show();

                Button btnDateCancel = (Button) dateDialog.findViewById(R.id.btnDateCancel);
                Button btnDateOk = (Button) dateDialog.findViewById(R.id.btnDateOk);
                final DatePicker dP = (DatePicker) dateDialog.findViewById(R.id.datePicker);

                btnDateCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dateDialog.dismiss();
                    }
                });

                btnDateOk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dateDialog.dismiss();
                        eTextDia.setText(Integer.toString(dP.getDayOfMonth()));
                        eTextMes.setText(Integer.toString(dP.getMonth()+1));
                        eTextAno.setText(Integer.toString(dP.getYear()));

                    }
                });

            }
        });

        Button btnTime = (Button) v.findViewById(R.id.btnTime);
        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog timeDialog = new Dialog(v.getContext());
                timeDialog.setContentView(R.layout.time_picker);
                final TimePicker timeP = (TimePicker) timeDialog.findViewById(R.id.timePicker);

                timeP.setIs24HourView(true);

                timeDialog.show();

                Button btnTimeCancel = (Button) timeDialog.findViewById(R.id.btnTimeCancel);
                Button btnTimeOk = (Button) timeDialog.findViewById(R.id.btnTimeOk);

                btnTimeCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        timeDialog.dismiss();
                    }
                });

                btnTimeOk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        timeDialog.dismiss();
                        eTHora.setVisibility(View.VISIBLE);
                        eTMin.setVisibility(View.VISIBLE);
                        eTHora.setText(Integer.toString(timeP.getCurrentHour()));
                        eTMin.setText(Integer.toString(timeP.getCurrentMinute()));

                    }
                });


            }
        });

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.goToFrag1Fragment();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFrag1Listener) {
            mListener = (OnFrag1Listener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFrag1Listener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFrag1Listener {
        // TODO: Update argument type and name
        void goToFrag1Fragment();
    }
}
