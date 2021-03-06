package com.bit.biteie;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{




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
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);




        final Button BtnEvents = (Button)findViewById(R.id.BtnEvents);
        final Button BtnMarks = (Button)findViewById(R.id.BtnMarks);
        final Button BtnAttn = (Button)findViewById(R.id.BtnAttn);
        final Button BtnTimeTable = (Button)findViewById(R.id.BtnTable);
        final Button BtnAssignment = (Button)findViewById(R.id.BtnAssign);
        final Button BtnSyllabus = (Button)findViewById(R.id.BtnSyllabus);
        final Button BtnNotes = (Button)findViewById(R.id.BtnNotes);
        final Button BtnFaculty = (Button)findViewById(R.id.BtnFaculty);
        final Button BtnCirculars = (Button)findViewById(R.id.BtnCircular);
        //final ImageButton info = (ImageButton)findViewById(R.id.BtnInfo);


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
                Intent intent2 = new Intent(MainActivity.this, SyllabusActivity.class);
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


    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_about_us) {

            Intent intent1 = new Intent(MainActivity.this, DepartmentActivity.class);
            startActivity(intent1);

        } else if (id == R.id.nav_gallery) {

            Intent intent2 = new Intent(MainActivity.this, GalleryActivity.class);
            startActivity(intent2);

        } else if (id == R.id.nav_credits) {
            Intent intent3 = new Intent(MainActivity.this, CreditsActivity.class);
            startActivity(intent3);

        } else if (id == R.id.nav_support) {
            Intent intent4 = new Intent(MainActivity.this, SupportActivity.class);
            startActivity(intent4);

        } else if (id == R.id.nav_share) {

            Intent share = new Intent(Intent.ACTION_SEND);
            share.setType("text/plain");
            StringBuilder sb = new StringBuilder();
            sb.append("Hi, I am using the BIT Electronics & Instrumentation Engg. Dept. Application. I like this and I want you to check it out.\n");
            sb.append("https://play.google.com/store/apps/details?id=" + "com.bit.biteie");
            //https://play.google.com/store/apps/details?id=com.google.android.apps.secrets
            share.putExtra(Intent.EXTRA_SUBJECT, "Test");
            share.putExtra(Intent.EXTRA_TEXT, sb.toString());
            startActivity(Intent.createChooser(share, "Share BIT E & IE app"));

        } else if (id == R.id.nav_feedback) {

            Intent intent5 = new Intent(MainActivity.this, FeedbackFormActivity.class);
            startActivity(intent5);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }




    public void shareText(View view) {
        Intent intent = new Intent(android.content.Intent.ACTION_SEND);
        intent.setType("text/plain");
        String shareBodyText = "Your sharing message goes here";
        intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject/Title");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, shareBodyText);
        startActivity(Intent.createChooser(intent, "Choose sharing method"));
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.share:

                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBodyText = "Check it out. Your message goes here";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,"Subject here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBodyText);
                startActivity(Intent.createChooser(sharingIntent, "Sharing Option"));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }




}



