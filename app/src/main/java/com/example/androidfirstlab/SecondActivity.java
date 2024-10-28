package com.example.androidfirstlab;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        EditText editText = findViewById(R.id.editText);
        Button button = findViewById(R.id.button);

        // Получаем приветствие от первой Activity
        String greeting = getIntent().getStringExtra("greeting");
        editText.setHint(greeting);

        button.setOnClickListener(view -> {
            // Передаем введенное имя назад в MainActivity
            String name = editText.getText().toString();
            Intent resultIntent = new Intent();
            resultIntent.putExtra("name", name);
            setResult(RESULT_OK, resultIntent);
            finish(); // Закрываем SecondActivity
        });
    }
}