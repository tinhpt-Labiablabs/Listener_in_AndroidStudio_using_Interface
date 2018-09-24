package com.example.tinhphan.quatrungthuctk40;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


public class ChangeColorFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_change_color, container, false);
        textChangeColor = view.findViewById(R.id.text_change_color);
        return view;
    }

    //region PUBLIC UTILS
    public void changeColor(int color){
        textChangeColor.setBackgroundColor(color);
    }

    //endregion

    //region VAR
    private TextView textChangeColor;

}
