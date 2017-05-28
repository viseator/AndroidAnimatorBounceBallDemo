package com.viseator.viewtest;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "@vir MainActivity";
    private RadioGroup mRadioGroup;
    private BasketView mBasketView;
    private SeekBar mSeekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRadioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        mBasketView = (BasketView)findViewById(R.id.basketView);
        mSeekBar = (SeekBar) findViewById(R.id.seekBar);
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                RadioButton radioButton = (RadioButton)
                        findViewById(mRadioGroup.getCheckedRadioButtonId());
                mBasketView.setAlpha(Integer.valueOf(radioButton.getText().toString())-1,progress);
                mBasketView.postInvalidate();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                RadioButton radioButton = (RadioButton)
                        findViewById(checkedId);

                mSeekBar.setProgress(mBasketView.getAlpha(Integer.valueOf(radioButton.getText().toString()) - 1));
            }
        });

    }
}
