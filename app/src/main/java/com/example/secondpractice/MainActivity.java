package com.example.secondpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.secondpractice.databinding.ActivityMainBinding;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // Инициализация TextView строковым ресурсом с помощью ViewBinding
        tv = binding.textView3;
        String textBookshelf = getString(R.string.infAboutOwl);
        tv.setText(textBookshelf);

        // Инициализация ImageView картинкой с помощью ViewBinding
        ImageView imageViewBook1 = binding.imageView2;
        Drawable drawableImageBook1 = getDrawable(R.drawable.owl);
        imageViewBook1.setImageDrawable(drawableImageBook1);

        // Программное задание обработчика событий
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Нажали информация!");
            }
        });
    }
    // Декларативное задание метода обработчика событий
    public void buttonSaveClickHandler(View view) {
        Log.d(TAG, "Нажали информация");
    }
}