package com.handh.com.materialdesign.view;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.handh.com.materialdesign.R;
import com.handh.com.materialdesign.adapters.MenuAdapter;
import com.handh.com.materialdesign.adapters.SlingTabAdapter;
import com.handh.com.materialdesign.model.MenuData;
import com.handh.com.materialdesign.model.MenuModel;
import com.handh.com.materialdesign.tabs.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MenuAdapter.onMenuClickedCallBack {

    /*************variables******************/
    private Toolbar toolbar;
    private DrawerLayout mDrawerLayout;
    private MenuData menuData;
    private List<MenuModel>  menuItemList=new ArrayList<>();
    private RecyclerView recyclerView;
    private MenuAdapter menuAdapter;
    private TextView drawerName,drawerEmail,drawerMenuText;
    private ViewPager mViewPager;
    private SlingTabAdapter mSlingTabAdapter;
    private SlidingTabLayout mSlidingTabLayout;

    /************Drawer Menu setting*********/
    private final static String[] menuText={"Profile","Setting"};
    private final static Integer[] menuIcons={R.drawable.ic_person_black_24dp,R.drawable.ic_settings_black_24dp};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /******set drawer text fonts******/
        this.drawerEmail=(TextView)findViewById(R.id.drawer_mail);
        this.drawerName=(TextView)findViewById(R.id.drawer_name);
        this.drawerMenuText=(TextView) findViewById(R.id.menu_item_text);
        Typeface RobotoMedium=Typeface.createFromAsset(getAssets(),"roboto/Roboto-Medium.ttf");
        Typeface  RobotoRegular=Typeface.createFromAsset(getAssets(),"roboto/Roboto-Regular.ttf");
        this.drawerEmail.setTypeface(RobotoRegular);
        this.drawerName.setTypeface(RobotoMedium);
        /***********ActionBar*************/
        this.toolbar=(Toolbar) findViewById(R.id.appBar);
        this.toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(this.toolbar);
        /***********Drawer***************/
        this.menuData=new MenuData(menuText,menuIcons);
        this.menuItemList=this.menuData.getMenuItem();

        this.recyclerView=(RecyclerView) findViewById(R.id.rec_drawer);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        this.menuAdapter=new MenuAdapter(this.menuItemList,this);
        this.menuAdapter.setItemClickCallback(this);
        this.recyclerView.setAdapter(this.menuAdapter);

        NavigationDrawerFragment drawerFragment=(NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.drawer_layout_fragment);
        this.mDrawerLayout=(DrawerLayout) findViewById(R.id.drawer_layout);
        drawerFragment.setUp(R.id.drawer_layout_fragment,this.mDrawerLayout,this.toolbar);

        /************SlidingTab***************/

        this.mViewPager=(ViewPager) findViewById(R.id.pager);
        this.mSlidingTabLayout=(SlidingTabLayout) findViewById(R.id.tabs);
        this.mSlingTabAdapter=new SlingTabAdapter(getSupportFragmentManager(),this,2);
        this.mViewPager.setAdapter(this.mSlingTabAdapter);
        this.mSlidingTabLayout.setViewPager(this.mViewPager);

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
        if(id==R.id.next)
        {
            Intent intent=new Intent(this,secondActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setClickedItem(Integer position) {
        MenuModel menuModel=this.menuItemList.get(position);
        Toast.makeText(this,menuModel.getMenuText().toString(),Toast.LENGTH_SHORT).show();
    }
}
