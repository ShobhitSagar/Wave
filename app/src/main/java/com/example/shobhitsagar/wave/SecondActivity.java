package com.example.shobhitsagar.wave;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    EditText editText;
    Button btnDone;

    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        editText = (EditText) findViewById(R.id.add_Text);
        btnDone = (Button) findViewById(R.id.button);


        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                text = editText.getText().toString();

                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                intent.putExtra("text", text);
                startActivity(intent);
            }
        });

    }
}
