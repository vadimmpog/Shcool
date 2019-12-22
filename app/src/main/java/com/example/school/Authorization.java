package com.example.school;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Authorization extends AppCompatActivity {

    EditText login_entered,password_entered;
    String login,password;
    Button enter,bteach,bpupil,parent;
    static int flag = 0;
    boolean special = false;//параметр админа;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.choosevar);

        bteach = (Button)findViewById(R.id.teacher);
        bpupil = (Button)findViewById(R.id.pupil);
        parent = (Button)findViewById(R.id.parent_);

        bteach.setOnClickListener(chooseEnter);
        bpupil.setOnClickListener(chooseEnter);
        parent.setOnClickListener(chooseEnter);


    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            login = login_entered.getText().toString();
            password = password_entered.getText().toString();
            Intent i = new Intent(Authorization.this,EnterActivity.class);
            switch (flag){
                case 1:{
                    //проверка
                    if(special){
                        i.putExtra("special",special);
                        i.putExtra("who",1);
                        startActivity(i);
                    }
                    else{
                        i.putExtra("who",1);
                        startActivity(i);
                    }
                    break;
                }
                case 2:{
                    //проверка
                    i.putExtra("who",2);
                    startActivity(i);
                    break;
                }
                case 3:{
                    //проверка
                    i.putExtra("who",3);
                    startActivity(i);
                    break;
                }
            }
        }
    };

    View.OnClickListener chooseEnter = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.teacher:{
                    flag = 1;
                    setContentView(R.layout.authorization);
                    break;
                }
                case R.id.pupil:{
                    flag = 2;
                    setContentView(R.layout.authorization);
                    break;
                }
                case R.id.parent_:{
                    flag = 3;
                    setContentView(R.layout.authorization);
                    break;
                }
            }
            login_entered = (EditText)findViewById(R.id.login_);
            password_entered = (EditText)findViewById(R.id.password_);
            enter = (Button)findViewById(R.id.enter);
            enter.setOnClickListener(clickListener);
        }
    };
}

