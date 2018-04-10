package com.example.shobhitsagar.wave;

import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtView;
    String string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        txtView = (TextView) findViewById(R.id.textView);
        Intent intent = getIntent();
        string = intent.getStringExtra("text");
        txtView.setText(string);

        SensorManager sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);

        final RelativeLayout parent = (RelativeLayout) findViewById(R.id.main_layout);

        txtView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);

                return true;
            }
        });

        Sensor accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {

                float ax = sensorEvent.values[0];
                float ay = sensorEvent.values[1];
                float az = sensorEvent.values[2];

                parent.setBackgroundColor(Color.rgb(getColor(ax), getColor(ay), getColor(az)));
            }

            int getColor(float ax) {
                return (int) (ax + 12 * 255) % 255;
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        }, accelerometer, 50000);

    }
}
