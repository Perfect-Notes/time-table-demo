package com.perfectnotes.timetable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EnterActivity extends AppCompatActivity {
EditText etheead;
EditText etDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
        etheead=findViewById(R.id.etHeading);
        etDescription=findViewById(R.id.etDesscription);

        Button btnDone=findViewById(R.id.btnDone);
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent();
        i.putExtra("heading",etheead.getText().toString());
        i.putExtra("description",etDescription.getText().toString());
        setResult(RESULT_OK,i);
        finish();
            }
        });
    }
}
