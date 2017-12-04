package main.dailynovel;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;

import main.dailynovel.Objects.Crawler;

public class NovelReader extends AppCompatActivity {
    ImageButton imbSetting;
    TextView txtTitle, txtContent;
    Dialog dialog;
    String itemID, itemName, content;
    int itemChapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novel_reader);
        Intent intent = getIntent();
        itemID = intent.getExtras().getString("itemID");
        itemChapter = intent.getExtras().getInt("itemChapter");
        itemName = intent.getExtras().getString("itemName");

        imbSetting = (ImageButton) findViewById(R.id.imbSetting);
        imbSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSettingDialog();
            }
        });

        txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtContent = (TextView) findViewById(R.id.txtContent);

        txtTitle.setText(itemName);
        try {
            txtContent.setText(Crawler.getChapterContent(itemID, itemChapter));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getSettingDialog() {
        dialog = new Dialog(NovelReader.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_reader_setting);
        dialog.setCancelable(false);

        ImageButton imbCancel = (ImageButton)dialog.findViewById(R.id.imbCancel);
        imbCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        ImageButton imbDecrease = (ImageButton) dialog.findViewById(R.id.imbDecrease);
        imbDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        ImageButton imbIncrease = (ImageButton) dialog.findViewById(R.id.imbIncrease);
        imbIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        ImageButton imbColorPicker = (ImageButton) dialog.findViewById(R.id.imbColorPicker);
        imbIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        dialog.show();
    }
}
