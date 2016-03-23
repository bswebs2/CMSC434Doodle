package com.example.brandon.doodleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;

import com.pes.androidmaterialcolorpickerdialog.ColorPicker;

public class MainActivity extends AppCompatActivity {

    private com.example.brandon.doodleapp.DoodleView dv;
    private Button clear;
    private Button changeColor;
    private SeekBar opacity;
    private SeekBar size;
    private CheckBox quad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ColorPicker cp = new ColorPicker(MainActivity.this, 255, 0, 0);

        dv = (com.example.brandon.doodleapp.DoodleView) findViewById(R.id.doodleview);
        clear = (Button) findViewById(R.id.clearButton);
        clear.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dv.clear();
            }
        });

        /* Show color picker dialog */
        changeColor = (Button) findViewById(R.id.changeColorButton);
        changeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* Show color picker dialog */
                cp.show();

            /* On Click listener for the dialog, when the user select the color */
                Button okColor = (Button) cp.findViewById(R.id.okColorButton);
                okColor.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                /* The android RGB Color (see the android Color class reference) */
                        int selectedColorRGB = cp.getColor();
                        dv.setColor(selectedColorRGB);

                        cp.dismiss();
                    }
                });
            }
        });

        opacity = (SeekBar) findViewById(R.id.opacityBar);
        opacity.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                dv.setOpacity(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        size = (SeekBar) findViewById(R.id.sizeBar);
        size.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                dv.setSize(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        quad = (CheckBox) findViewById(R.id.checkbox);
        quad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dv.setQuad();
            }
        });
    }
}
