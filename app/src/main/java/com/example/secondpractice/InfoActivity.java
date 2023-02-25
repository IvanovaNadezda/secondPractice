package com.example.secondpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    private Button btn3;
    private TextView tv;
    public static final int INFOACTIVITY_CODE =300;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        btn3 = findViewById(R.id.button4);
        tv = findViewById(R.id.textView2);

        Bundle bundle = getIntent().getExtras(); // может быть null
        if(bundle != null){
            tv.setText(bundle.getString("ccc"));
        }

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("ppp",tv.getText().toString());
                setResult(INFOACTIVITY_CODE,intent);
                finish();

            }
        });
    }
}