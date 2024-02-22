package com.example.test2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("data");

        EditText editText = findViewById(R.id.editTextNumber);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String a = editText.getText().toString();
                 if(a.isEmpty()) {
                 Toast.makeText(MainActivity.this, "Please enter a valid number!", Toast.LENGTH_SHORT).show();
                 return;
                 }
                 int number = Integer.parseInt(a);
                 sendToFireBase(number);
            }
        });
    }  
    private void sendToFireBase(int number) {
        myRef.setValue(number);
    }
}