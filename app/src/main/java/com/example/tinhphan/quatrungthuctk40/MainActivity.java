package com.example.tinhphan.quatrungthuctk40;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CountDownFragment.ListenerCountDownFinish {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addFragmentInMain();
        setupButtonRemoveListener();
        countDownFragment.setListenerCountDownFinish(this);
        setupButtonExitApp();
    }

    @Override
    public void onCountDownFinish() {
        if (isGreen){
            changeColorFragment.changeColor(Color.GREEN);
        }else {
            changeColorFragment.changeColor(Color.YELLOW);
        }
        isGreen = !isGreen;
    }

    private void addFragmentInMain(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        countDownFragment = new CountDownFragment();
        changeColorFragment = new ChangeColorFragment();
        fragmentTransaction.add(R.id.frame_container_count_down,countDownFragment);
        fragmentTransaction.add(R.id.frame_container_change_color, changeColorFragment);
        fragmentTransaction.commit();

    }
    
    private  void setupButtonRemoveListener(){
        this.btnRemoveListener = findViewById(R.id.button_remove_listener);
        btnRemoveListener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              countDownFragment.removeListenerCountDownFinish();
            }
        });
    }

    private void setupButtonExitApp(){
        this.btnExit = findViewById(R.id.finishActivity);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    //region VARS
    private  CountDownFragment countDownFragment;
    private  ChangeColorFragment changeColorFragment;
    private Button btnRemoveListener;
    private  Button btnExit;

    private Boolean isGreen = false;

    //endregion
}
