package com.example.school;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class RegStudent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button register;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_student);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        String[] roles = {"Класс","1","2","3","4","5","6","7","8","9","10","11",};
        register = (Button)findViewById(R.id.reg_button_s);
        register.setOnClickListener(clickListener);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, roles);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }

    public View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v){
            Intent intent1 = new Intent(RegStudent.this, EnterActivity.class);
            startActivity(intent1);
        }
    };
}
