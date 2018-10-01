package com.example.vlad.asl;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class base extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    List<Books> booksList;
    BooksAdapter adapter;
    RecyclerView recyclerView;
    Double rate;
    private View navHeader;
    private TextView txtName, txtMail;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        booksList = new ArrayList<>();
        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            rate = bundle.getDouble("rating");
        }

        booksList.add(
                new Books(
                        1,
                        "Горе от Ума/А.С. Грибоедов/класс 10",
                        3.5
                        ));

        booksList.add(
                new Books(
                        2,
                        "Война и мир/Л.Н. Толстой/класс 10",
                        5.0
                        ));

        booksList.add(
                new Books(
                        3,
                        "Герои нашего времени/М.Ю. Лермонтов/класс 10",
                        4.5
                        ));
        booksList.add(
                new Books(
                        4,
                        "Мертвые души/Н.В. Гоголь/класс 10",
                        5.0
                ));

        adapter = new BooksAdapter(this, booksList);
        recyclerView.setAdapter(adapter);


        //-----------------------------------------------------------------------------
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navHeader = navigationView.getHeaderView(0);
        txtName = (TextView) navHeader.findViewById(R.id.name);
        txtMail = (TextView) navHeader.findViewById(R.id.mail);

        loadNavHeader();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.base, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.books) {

        } else if (id == R.id.exit) {
            Intent intentlog = new Intent(base.this,
                    login.class);
            startActivity(intentlog);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void loadNavHeader() {
        if (signup.gmail.getText().toString().equals(""))
        {
            txtName.setText(login.log.getText().toString());
            txtMail.setText("You have no mail");
        }
        else {
            txtName.setText(login.log.getText().toString());
            txtMail.setText(signup.gmail.getText().toString());
        }
    }
}

