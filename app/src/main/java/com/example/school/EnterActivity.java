package com.example.school;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.school.Authorization.flag;


public class EnterActivity extends Activity {

    School school = new School();
    Button work,journal,listofteacher,listofpupil, addpupil;



    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenue);

        work = (Button)findViewById(R.id.work);
        addpupil = (Button)findViewById(R.id.addpupil);
        journal = (Button)findViewById(R.id.journal);
        listofteacher = (Button)findViewById(R.id.listofteacher);
        listofpupil = (Button)findViewById(R.id.listofpupil);

        work.setOnClickListener(clickListener);
        journal.setOnClickListener(clickListener);
        addpupil.setOnClickListener(clickListener);
        listofteacher.setOnClickListener(clickListener);
        listofpupil.setOnClickListener(clickListener);

        if (flag == 1){
            work.setVisibility(View.GONE);
            addpupil.setVisibility(View.GONE);
        }
        if (flag == 2 || flag == 3) {
            work.setVisibility(View.GONE);
            addpupil.setVisibility(View.GONE);
            listofpupil.setVisibility(View.GONE);
            listofteacher.setVisibility(View.GONE);
        }

    }

   public View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.journal:{
                    school.getElectronicJournal();
                    if (flag == 1 || flag == 4) {
                        Intent intent1 = new Intent(EnterActivity.this, TeacherJournal.class);
                        startActivity(intent1);
                    } else {
                        Intent intent1 = new Intent(EnterActivity.this, PupilsJournal.class);
                        startActivity(intent1);
                    }
                    break;
                }
                case R.id.work:{
                    Intent intent = new Intent(EnterActivity.this, RegPersonal.class);
                    startActivity(intent);
                    school.getParticipant();
                    break;
                }
                case R.id.addpupil:{
                    Intent intent = new Intent(EnterActivity.this, RegStudent.class);
                    startActivity(intent);
                    break;
                }
                case R.id.listofteacher:{
                    school.getListTeachers();
                        Intent intent1 = new Intent(EnterActivity.this, List.class);
                        startActivity(intent1);
                    break;
                }
                case R.id.listofpupil:{
                    Intent intent1 = new Intent(EnterActivity.this, StudentsList.class);
                    startActivity(intent1);
                    school.getListLearners();
                    break;
                }
            }
        }
    };
}
