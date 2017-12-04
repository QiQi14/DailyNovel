package main.dailynovel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckedTextView;

public class FilterActivity extends AppCompatActivity {
    Toolbar toolbar;
    CheckedTextView checkedTextView1,checkedTextView2,checkedTextView3,checkedTextView4,checkedTextView5,checkedTextView6,checkedTextView7,checkedTextView8,checkedTextView9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

        //      SET HIDE STATUS BAR
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //      SET TOOLBAR
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //      ADD BACK BUTTON
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        checkedTextView1 = (CheckedTextView)findViewById(R.id.checkedTextView1);
        checkedTextView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkedTextView1.toggle();
            }
        });

        checkedTextView2 = (CheckedTextView)findViewById(R.id.checkedTextView2);
        checkedTextView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkedTextView2.toggle();
            }
        });

        checkedTextView3 = (CheckedTextView)findViewById(R.id.checkedTextView3);
        checkedTextView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkedTextView3.toggle();
            }
        });

        checkedTextView4 = (CheckedTextView)findViewById(R.id.checkedTextView4);
        checkedTextView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkedTextView4.toggle();
            }
        });

        checkedTextView5 = (CheckedTextView)findViewById(R.id.checkedTextView5);
        checkedTextView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkedTextView5.toggle();
            }
        });

        checkedTextView6 = (CheckedTextView)findViewById(R.id.checkedTextView6);
        checkedTextView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkedTextView6.toggle();
            }
        });

        checkedTextView7 = (CheckedTextView)findViewById(R.id.checkedTextView7);
        checkedTextView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkedTextView7.toggle();
            }
        });

        checkedTextView8 = (CheckedTextView)findViewById(R.id.checkedTextView8);
        checkedTextView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkedTextView8.toggle();
            }
        });

        checkedTextView9 = (CheckedTextView)findViewById(R.id.checkedTextView9);
        checkedTextView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkedTextView9.toggle();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_righ);
    }
}
