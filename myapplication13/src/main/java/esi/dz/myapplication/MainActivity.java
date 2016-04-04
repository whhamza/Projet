package esi.dz.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private DrawerLayout drawer;
    NavigationView navigationView;
    ArrayAdapter adapter;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
         navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                filtrer(position, spinner.getSelectedItem().toString());
               /* if(navigationView.getMenu().findItem(R.id.nav_camera).isChecked()) {
                    filtrer(position, "OReilly");
                }
                if(navigationView.getMenu().findItem(R.id.nav_gallery).isChecked()) {
                    filtrer(position, "Microsoft Press");
                }
                if(navigationView.getMenu().findItem(R.id.nav_manage).isChecked()) {
                    filtrer(position, "Toutes");
                }

                if(navigationView.getMenu().findItem(R.id.nav_slideshow).isChecked()) {
                    filtrer(position, "Peachpit Press");
                }*/
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

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



    public void filtrer ( int position,String editor) {
    ListView listView = null;
    if(position==0) {
     listView = (ListView) findViewById(R.id.listView);
    }
    if(mViewPager.getCurrentItem()==1) {
        listView = (ListView) findViewById(R.id.listView1);
    }
    if(mViewPager.getCurrentItem()==2) {
        listView = (ListView) findViewById(R.id.listView3);
    }
    CutomAdapter cutomAdapter = (CutomAdapter) listView.getAdapter();
    cutomAdapter.getFilter().filter(editor);


}
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                int id = item.getItemId();
                ListView listView ;

                if (id == R.id.nav_camera) {
                        filtrer(mViewPager.getCurrentItem(), "OReilly");

                }
                else if (id == R.id.nav_gallery) {
                        filtrer (mViewPager.getCurrentItem(),"Microsoft Press");



                } else if (id == R.id.nav_slideshow) {
                    filtrer (mViewPager.getCurrentItem(),"Peachpit Press");

                } else if (id == R.id.nav_manage) {
                    filtrer (mViewPager.getCurrentItem(),"Toutes");

                } else if (id == R.id.nav_share) {

                } else if (id == R.id.nav_send) {

                }
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        MenuItem item = menu.findItem(R.id.spinner);
        spinner = (Spinner) item.getActionView();
        String[] tab =
                {"Toutes","Addison-Wesley","OReilly","Microsoft Press","Peachpit Press"};
        adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,tab);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                filtrer(mViewPager.getCurrentItem(),adapter.getItem(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

        }




