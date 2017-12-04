package main.dailynovel;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import main.dailynovel.Objects.Crawler;
import main.dailynovel.Objects.Novel;

public class NovelActivity extends AppCompatActivity {
    Button btnChapterList, btnReading;
    TextView txtName, txtAuthor, txtStatus, txtChapter, txtType, txtPreface;
    ImageView imgCover;
    CollapsingToolbarLayout collapsingToolbarLayout;
    Bitmap bm = null;
    Novel novel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novel);

        Intent intent = getIntent();
        novel = (Novel) intent.getSerializableExtra("Object");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        collapsingToolbarLayout = findViewById(R.id.toolbar_layout);
        imgCover = (ImageView) findViewById(R.id.imgCover);
        txtName = (TextView) findViewById(R.id.txtName);
        txtAuthor = (TextView) findViewById(R.id.txtAuthor);
        txtStatus = (TextView) findViewById(R.id.txtStatus);
        txtChapter = (TextView) findViewById(R.id.txtChapter);
        txtType = (TextView) findViewById(R.id.txtGenre);

        collapsingToolbarLayout.setTitle(novel.getNovelName());
        txtName.setText(novel.getNovelName());
        txtAuthor.setText(novel.getNovelAuthors());
        txtStatus.setText(novel.getNovelStatus());
        txtChapter.setText(String.valueOf(novel.getNovelChapter()));
        txtType.setText(novel.getNovelType());

        String coverURL = novel.getNovelCover();
        if(coverURL.substring(coverURL.indexOf("images/story/")).equalsIgnoreCase("images/story/.jpg")){
            imgCover.setImageResource(R.drawable.cover);
        } else {
            try {
                InputStream in = new java.net.URL(novel.getNovelCover()).openStream();
                bm = BitmapFactory.decodeStream(in);
            } catch (IOException e) {
                e.printStackTrace();
            }
            imgCover.setImageBitmap(bm);
        }
        //       adding transparency
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));

        //      SET HIDE STATUS BAR
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //     ADD BACK BUTTON
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        btnChapterList = (Button) findViewById(R.id.btnChapterList);
        btnChapterList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NovelActivity.this, NovelChapterListActivity.class);
                intent.putExtra("itemID", novel.getNovelID());
                intent.putExtra("itemChapter", novel.getNovelChapter());
                startActivity(intent);
            }
        });

        txtPreface = (TextView) findViewById(R.id.txtPreface);
        try {
            txtPreface.setText(Crawler.getNovelDesc(novel.getNovelID()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        btnReading = (Button) findViewById(R.id.btnReading);
        btnReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(NovelActivity.this, NovelReader.class);
                    intent.putExtra("itemID", novel.getNovelID());
                    intent.putExtra("itemChapter", 1);
                    intent.putExtra("itemName", Crawler.getChapterTitle(novel.getNovelID(), 1));
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
