package com.handh.com.materialdesign.view;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.handh.com.materialdesign.R;

public class secondActivity extends AppCompatActivity {

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        toolbar=(Toolbar) findViewById(R.id.appBar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.app_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id=item.getItemId();

        if(id==android.R.id.home)
        {
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
