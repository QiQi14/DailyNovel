package main.dailynovel;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import main.dailynovel.Fragment.BookFragment;
import main.dailynovel.Fragment.LibraryFragment;
import main.dailynovel.Fragment.UserFragment;
import main.dailynovel.Fragment.ViewPagerFragement;

public class MainActivity extends AppCompatActivity {
    ViewGroup viewGroup;
    View view;
    ViewPager viewPager;
    BottomNavigationView bottomNavigationView;
    MenuItem prevMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // CODE OF FRAGMENT
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomnavigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

//        set Hide status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        viewPager = (ViewPager)findViewById(R.id.content);
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottomnavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_library:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.navigation_book:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.navigation_wall:
                        break;
                    case R.id.navigation_user:
                        viewPager.setCurrentItem(2);
                        break;
                }
                return true;
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                }
                else
                {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                Log.d("page", "onPageSelected: " + position);
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        setUpViewPagerFragment(viewPager);
    }

    public void setUpViewPagerFragment(ViewPager viewPager){
        ViewPagerFragement viewPagerFragement = new ViewPagerFragement(getSupportFragmentManager());
        LibraryFragment libraryFragment= new LibraryFragment();
        BookFragment bookFragment = new BookFragment();
        UserFragment userFragment = new UserFragment();
        viewPagerFragement.addFragment(libraryFragment);
        viewPagerFragement.addFragment(bookFragment);
        viewPagerFragement.addFragment(userFragment);
        viewPager.setAdapter(viewPagerFragement);
    }

}
