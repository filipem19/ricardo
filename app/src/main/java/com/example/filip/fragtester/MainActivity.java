package com.example.filip.fragtester;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.filip.fragtester.helpers.Util;
import com.example.filip.fragtester.fragments.Frag1;
import com.example.filip.fragtester.fragments.Frag2;
import com.example.filip.fragtester.fragments.Frag3;

public class MainActivity extends AppCompatActivity
        implements Frag1.OnFrag1Listener,
        Frag2.OnFrag2Listener,
        Frag3.OnFrag3Listener
        {
            int numbCond;

            public int getNumbCond() {
                return numbCond;
            }

            public void setNumbCond(int numbCond) {
                this.numbCond = numbCond;
            }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goToFrag1Fragment();



    }

    @Override
    public void goToFrag1Fragment() {
        Util.switchFragment(getFragmentManager(), "FRAG_1", Frag1.newInstance());
    }

     @Override
     public void goToFrag2Fragment() {
         Util.switchFragment(getFragmentManager(), "FRAG_2", Frag2.newInstance());
     }

     @Override
            public void goToFrag3Fragment() {
                Util.switchFragment(getFragmentManager(), "FRAG_3", Frag3.newInstance());
            }
        }
