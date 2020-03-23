package com.example.ebook;


import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.example.ebook.bottomnavi.FavoritesFragment;
import com.example.ebook.bottomnavi.SearchFragment;
import com.example.ebook.ui.home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends MyActivity {
    private static int numberOfBackPressed = 0;
    private AppBarConfiguration mAppBarConfiguration;
   // private FirebaseAuth mFirebaseAuth;
   // private FirebaseAuth.AuthStateListener mAuthStateListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    /**--> Start of block code icon message*/
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    /**<-- Start of block code icon message*/



    /**--> Start of block code  Left navigation*/
       DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,R.id.nav_aboutme)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    /**<-- End of block code  Left navigation*/



    /**--> Start of block code bottom navigation*/
        //for button Navigation View (add this line on 03/13/2020)
           BottomNavigationView bottomNaviView = findViewById(R.id.bottom_nav_view);
           bottomNaviView.setOnNavigationItemSelectedListener(navlistener);
           getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                new HomeFragment()).commit();

    } // this braces '}' for close protected void onCreate(Bundle savedInstanceState) method.

            BottomNavigationView.OnNavigationItemSelectedListener navlistener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment=null;
                    switch (item.getItemId()){
                        case R.id.bottom_navi_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.bottom_navi_favorite:
                            selectedFragment = new FavoritesFragment();
                            break;
                        case R.id.bottom_navi_search:
                            selectedFragment = new SearchFragment();
                            break;
                    }
                   getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                            selectedFragment).commit();
                    return true;
                }
            };
    /**<-- End of block code bottom navigation*/


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();

    }


    /**--> Start of block code right menu */
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }
        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {

    //            case R.id.action_aboutme: {
    //               startActivity(new Intent(MainActivity.this, AboutmeFragment.class));
    //               break;
    //            }

                case R.id.action_exit: {

                    if(numberOfBackPressed >= 1) {
                        numberOfBackPressed = 0;
                        finish();
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Press again to exit", Toast.LENGTH_SHORT).show();
                        ++numberOfBackPressed;
                    }

                    }
                    break;

                }

                return super.onOptionsItemSelected(item);
        }










    /**<-- End of block code right menu */




}
