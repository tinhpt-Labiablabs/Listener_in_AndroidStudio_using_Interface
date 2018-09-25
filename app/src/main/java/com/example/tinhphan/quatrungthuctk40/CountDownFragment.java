package com.example.tinhphan.quatrungthuctk40;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class CountDownFragment extends Fragment {

    //region SYSTEM EVENT
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        autoCountDown();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_count_down, container, false);
        view.setBackgroundColor(Color.RED);
        this.mtvCountDown = view.findViewById(R.id.text_count_down);
        return  view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.listenerCountDownFinish = null;
        this.countDownTimer.cancel();
    }
    //endregion


    //region UTILS
    private  void autoCountDown(){
        mNumberCountDown = 10;
        countDownTimer = new CountDownTimer(10000,1000) {
            @Override
        public void onTick(long millisUntilFinished) {
            mtvCountDown.setText("" + mNumberCountDown);
            mNumberCountDown --;
        }

        @Override
        public void onFinish() {
            listenerCountDownFinish.onCountDownFinish();
            autoCountDown();

        }
    };
        countDownTimer.start();
    }

    //endregion

    //region INTERFACE
    public interface ListenerCountDownFinish{
        void onCountDownFinish();
    }

    public void setListenerCountDownFinish(ListenerCountDownFinish listener){
        this.listenerCountDownFinish = listener;
    }

    public  void removeListenerCountDownFinish(){
        this.listenerCountDownFinish = null;
        this.countDownTimer.cancel();
    }
    //endregion

    //region VARS
    private TextView mtvCountDown;
    private int mNumberCountDown;
    private CountDownTimer countDownTimer;


    private ListenerCountDownFinish listenerCountDownFinish;
    //endregion
}
