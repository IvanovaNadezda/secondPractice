package com.example.secondpractice;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.secondpractice.databinding.ActivityMainBinding;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn2, btn4;
    private EditText ed;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(this);
        ed = findViewById(R.id.editText);
        tv = findViewById(R.id.textView4);


    }

    ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == InfoActivity.INFOACTIVITY_CODE) {
                        tv.setText(result.getData().getStringExtra("ppp"));
                    }
                }
            }
    );

    @Override
    public void onClick(View v) {
        //Явное намерение
        //Переход на другую активность
        Intent intent = new Intent(getApplicationContext(),InfoActivity.class);
        intent.putExtra("ccc",ed.getText().toString());
        //startActivity(intent);
        someActivityResultLauncher.launch(intent);
    }
}