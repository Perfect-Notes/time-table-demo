package com.perfectnotes.timetable;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnClicked;

    int clicked;
    android.support.v7.widget.GridLayout gridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         gridLayout = findViewById(R.id.gridLayout);
        int child = gridLayout.getChildCount();
        for (int i = 0; i < child; i++) {

            View view = gridLayout.getChildAt(i);
            if (view instanceof Button) {
                btnClicked = (Button) view;
                final int finalI = i;
                btnClicked.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        clicked= finalI;
                        Intent i = new Intent(MainActivity.this, EnterActivity.class);
                        startActivityForResult(i, 1);
                    }
                });
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String s = data.getStringExtra("heading");
                Button btn=(Button) gridLayout.getChildAt(clicked);
                btn.setText(s);

            }
        }
    }
}
