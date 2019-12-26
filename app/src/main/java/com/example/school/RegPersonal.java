package com.example.school;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegPersonal extends AppCompatActivity {

    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_personal);
        register = (Button)findViewById(R.id.reg_button_p);
        register.setOnClickListener(clickListener);

    }
    public View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v){
            Intent intent1 = new Intent(RegPersonal.this, EnterActivity.class);
            startActivity(intent1);
        }
    };
}
