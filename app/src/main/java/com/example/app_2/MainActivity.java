package com.example.app_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView text = findViewById(R.id.text_view);
        Button button = findViewById(R.id.enter_button);
        TextView textSign = findViewById(R.id.text_signin);
        EditText editEmail = findViewById(R.id.edit_text);
        EditText editPassword = findViewById(R.id.edit_text2);
        LinearLayout container = findViewById(R.id.container);
        LinearLayout containerText = findViewById(R.id.container_text);

        int colorAllow = ContextCompat.getColor(this, R.color.Allow);
        int colorNotAllow = ContextCompat.getColor(this, R.color.NotAllow);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
                if (editEmail.getText().length() > 0 && editPassword.getText().length() > 0) {
                    button.setBackgroundColor(colorAllow);
                } else {
                    button.setBackgroundColor(colorNotAllow);
                }

            }
        };

        editEmail.addTextChangedListener(textWatcher);
        editPassword.addTextChangedListener(textWatcher);


        button.setOnClickListener(view -> {
            String email = editEmail.getText().toString();
            String password = editPassword.getText().toString();

            if (email.equals("admin") && password.equals("admin")) {
                Toast.makeText(MainActivity.this, "Successfully sing in", Toast.LENGTH_SHORT).show();
                textSign.setVisibility(View.GONE);
                container.setVisibility(View.GONE);
                containerText.setVisibility(View.GONE);
                text.setVisibility(View.GONE);
            } else {
                Toast.makeText(MainActivity.this, "Wrong login or password", Toast.LENGTH_SHORT).show();
            }
        });
    }
}