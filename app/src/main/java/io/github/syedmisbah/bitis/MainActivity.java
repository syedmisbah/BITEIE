package io.github.syedmisbah.bitis;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(R.color.buttoncolordark));
            window.setNavigationBarColor(getResources().getColor(R.color.buttoncolordark));
        }



        setContentView(R.layout.activity_main);



        final Button BtnEvents = (Button)findViewById(R.id.BtnEvents);
        final Button BtnMarks = (Button)findViewById(R.id.BtnMarks);
        final Button BtnAttn = (Button)findViewById(R.id.BtnAttn);
        final Button BtnTimeTable = (Button)findViewById(R.id.BtnTable);
        final Button BtnAssignment = (Button)findViewById(R.id.BtnAssign);
        final Button BtnSyllabus = (Button)findViewById(R.id.BtnSyllabus);
        final Button BtnNotes = (Button)findViewById(R.id.BtnNotes);
        final Button BtnFaculty = (Button)findViewById(R.id.BtnFaculty);
        final Button BtnCirculars = (Button)findViewById(R.id.BtnCircular);
        final ImageButton info = (ImageButton)findViewById(R.id.BtnInfo);


        final AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.5F);

        BtnTimeTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                Intent intent1 = new Intent(MainActivity.this, SemSelTT.class);
                startActivity(intent1);}
        });


        BtnSyllabus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                Intent intent2 = new Intent(MainActivity.this, SemSelSyl.class);
                startActivity(intent2);}
        });


        BtnNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                Intent intent3 = new Intent(MainActivity.this, NotesActivity.class);
                startActivity(intent3);}
        });



        BtnMarks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                Intent intent4 = new Intent(MainActivity.this, SemSelMarks.class);
                startActivity(intent4);}
        });

        BtnAttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                Intent intent5 = new Intent(MainActivity.this, SemSelAttn.class);
                startActivity(intent5);}
        }
        );

        BtnEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
               Intent intent6 = new Intent(MainActivity.this, EventsActivity.class);
                startActivity(intent6);}
        }
        );




        BtnFaculty.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                Intent intent7 = new Intent(MainActivity.this, FacultyActivity.class);
                startActivity(intent7);}
        }
        );

        BtnAssignment.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                Intent intent8 = new Intent(MainActivity.this, SemSelAssignment.class);
                startActivity(intent8);}
        }
        );


        BtnCirculars.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                Intent intent9 = new Intent(MainActivity.this, ScannerActivity.class);
                startActivity(intent9);}
        }
        );

        info.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
            v.startAnimation(buttonClick);
            Intent intent10 = new Intent(MainActivity.this, InfoActivity.class);
            startActivity(intent10);}
                                        }
        );

 }
}



