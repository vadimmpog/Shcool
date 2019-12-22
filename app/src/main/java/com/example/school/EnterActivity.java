package com.example.school;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class EnterActivity extends Activity {

    School school = new School();
    Button work,journal,list,listofteacher,listofpupil;



    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenue);

        work = (Button)findViewById(R.id.work);
        list = (Button)findViewById(R.id.list);
        journal = (Button)findViewById(R.id.journal);
        listofteacher = (Button)findViewById(R.id.listofteacher);
        listofpupil = (Button)findViewById(R.id.listofpupil);

        work.setOnClickListener(clickListener);
        list.setOnClickListener(clickListener);
        journal.setOnClickListener(clickListener);
        listofteacher.setOnClickListener(clickListener);
        listofpupil.setOnClickListener(clickListener);

    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.journal:{
                    school.getElectronicJournal();
                    break;
                }
                case R.id.work:{
                    school.getParticipant();
                    break;
                }
                case R.id.list:{
                    school.getListEmployees();
                    break;
                }
                case R.id.listofteacher:{
                    school.getListTeachers();
                    break;
                }
                case R.id.listofpupil:{
                    school.getListLearners();
                    break;
                }
            }
        }
    };




}
