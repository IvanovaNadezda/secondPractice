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
import android.widget.Toast;

import com.example.secondpractice.databinding.ActivityMainBinding;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = this.getClass().getSimpleName();
    private Button btn2, btn4;
    private EditText ed;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setContentView(R.layout.activity_main);
        btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(this);
        ed = findViewById(R.id.editText);
        tv = findViewById(R.id.textView4);

        /*TextView usernameTextView = (TextView) findViewById(R.id.textView3); // Информация о совах
        usernameTextView.setText(R.string.infAboutOwl);
        ImageView myImage = (ImageView) findViewById(R.id.imageView3); // Картинка совы на стартовом экране
        myImage.setImageResource(R.drawable.owl);*/
        /*// Инициализация TextView строковым ресурсом с помощью ViewBinding
        TextView textViewBookshelf = binding.textView;
        // main_activity__textView_bookshelf
        String textBookshelf = getString(R.string.infAboutOwl);
        textViewBookshelf.setText(textBookshelf);

        // Инициализация ImageView картинкой с помощью ViewBinding
        ImageView imageViewBook1 = binding.imageView3;
        Drawable drawableImageBook1 = getDrawable(R.drawable.owl);
        imageViewBook1.setImageDrawable(drawableImageBook1);*/


        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("kkk", "Программный метод");
            }
        };

        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getApplicationContext(), "Ну, нажали", Toast.LENGTH_SHORT);
                toast.show();

                Log.i(TAG, "нажали программно");
                // передача объекта с ключом "name" и значением "именя"
            }
        });

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

    public void buttonSaveClickHandler(View view) {
        Log.i("kkk", "Декларативный метод");
    }
}