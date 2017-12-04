package main.dailynovel;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
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

        //Hide status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

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
        dialog.setCancelable(true);
        dialog.getWindow().setGravity(Gravity.BOTTOM);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        Window window = dialog.getWindow();
        lp.copyFrom(window.getAttributes());
//This makes the dialog take up the full width
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);

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
                Float size = txtContent.getTextSize();
                txtContent.setTextSize(TypedValue.COMPLEX_UNIT_PX, (size-2f));

            }
        });

        ImageButton imbIncrease = (ImageButton)dialog.findViewById(R.id.imbIncrease);
        imbIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Float size = txtContent.getTextSize();
                txtContent.setTextSize(TypedValue.COMPLEX_UNIT_PX, (size+2f));
            }
        });

        ImageButton imbTheme1 = (ImageButton) dialog.findViewById(R.id.imbTheme1);
        imbTheme1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtContent.setBackgroundColor(getResources().getColor(R.color.white));
                txtContent.setTextColor(getResources().getColor(R.color.black));
            }
        });

        ImageButton imbTheme2 = (ImageButton) dialog.findViewById(R.id.imbTheme2);
        imbTheme2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtContent.setBackgroundColor(getResources().getColor(R.color.backbrown));
                txtContent.setTextColor(getResources().getColor(R.color.brown));
            }
        });

        ImageButton imbTheme3 = (ImageButton) dialog.findViewById(R.id.imbTheme3);
        imbTheme3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtContent.setBackgroundColor(getResources().getColor(R.color.black));
                txtContent.setTextColor(getResources().getColor(R.color.white));
            }
        });

        dialog.show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_righ);
    }
}
