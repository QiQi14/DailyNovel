package main.dailynovel;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import main.dailynovel.Objects.Crawler;

public class NovelChapterListActivity extends AppCompatActivity {
    ListView lvChapters;
    String itemID;
    int itemChapter;
    ArrayList<String> title = new ArrayList<>();
    ImageButton imbSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novel_chapter_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        itemID = intent.getExtras().getString("itemID");
        itemChapter = intent.getExtras().getInt("itemChapter");

        Preload novelTask = new Preload(NovelChapterListActivity.this);
        novelTask.execute();

        imbSearch = (ImageButton)findViewById(R.id.imbSearch);
        imbSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(NovelChapterListActivity.this, SearchActivity.class);
                startActivity(i);
            }
        });


    }

    class Preload extends AsyncTask<String, Integer, List<String>> {
        Activity activity;
        ListView lvChapters;
        ArrayAdapter<String> adapter;
        ArrayList<String> title = new ArrayList<>();

        public Preload(Activity activity) {
            this.activity = activity;
            lvChapters = (ListView) activity.findViewById(R.id.lvChapters);
            adapter = new ArrayAdapter<String>(activity, android.R.layout.simple_expandable_list_item_1, title);
            lvChapters.setAdapter(adapter);

            lvChapters.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(NovelChapterListActivity.this, NovelReader.class);
                    intent.putExtra("itemID", itemID);
                    intent.putExtra("itemChapter", i);
                    intent.putExtra("itemName", title.get(i));
                    startActivity(intent);
                }
            });
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(List<String> strings) {
            super.onPostExecute(strings);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            int i = values[0];
            adapter.notifyDataSetChanged();
        }

        @Override
        protected List<String> doInBackground(String... strings) {
            for (int i = 1; i <= itemChapter; i++) {
                SystemClock.sleep(10);
                try {
                    title.add(Crawler.getChapterTitle(itemID, i));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                publishProgress(i);
            }
            return null;
        }
    }
}
