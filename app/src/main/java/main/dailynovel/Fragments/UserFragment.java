package main.dailynovel.Fragments;


import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

import main.dailynovel.MainActivity;
import main.dailynovel.NovelReader;
import main.dailynovel.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends Fragment {


    Dialog dialog;
    View view;
    MainActivity mainActivity;
    Button btnAbout, btnPolicy, btnContact;
    public UserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        mainActivity = new MainActivity();

        btnAbout = view.findViewById(R.id.btnAbout);
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSettingDialog("about");
            }
        });

        btnPolicy = view.findViewById(R.id.btnPolicy);
        btnPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSettingDialog("policy");
            }
        });
        return view;
    }

    private void getSettingDialog(String s) {
        dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        switch (s){
            case "about": dialog.setContentView(R.layout.dialog_setting_info);
            break;

            case "policy": dialog.setContentView(R.layout.dialog_setting_policy);
                break;
        }

        dialog.setCancelable(false);
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

        dialog.show();
    }

}
