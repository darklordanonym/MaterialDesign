package com.handh.com.materialdesign.view;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.handh.com.materialdesign.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class NavigationDrawerFragment extends Fragment {

    public static final String PERF_FILE_NAME="PREFERENCES";

    public static final String PREF_KEY="PERF_KEY";

    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private DrawerLayout mDrawerLayout;

    private boolean mUserLearnedDrawer;
    private boolean mFromSavedInstance;

    public NavigationDrawerFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.mUserLearnedDrawer=Boolean.valueOf(readFromPreference(getActivity(),PREF_KEY,"false"));
        if(savedInstanceState!=null)
        {
            this.mFromSavedInstance=true;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View layout=inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        return layout;
    }


    public void setUp(int drawerId,DrawerLayout drawerLayout, Toolbar toolbar)
    {
        View view=getActivity().findViewById(drawerId);
        this.mDrawerLayout=drawerLayout;
        this.mActionBarDrawerToggle=new ActionBarDrawerToggle(getActivity(),this.mDrawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close)
        {
            @Override
            public void onDrawerOpened(View drawerView)
            {
                super.onDrawerOpened(drawerView);
                if(!mUserLearnedDrawer)
                {
                    mUserLearnedDrawer=true;
                    saveToPreference(getActivity(),PREF_KEY,""+mUserLearnedDrawer);
                }
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();
            }
        };
        if(!mUserLearnedDrawer && !mFromSavedInstance)
        {
            mDrawerLayout.openDrawer(view);
        }
        this.mDrawerLayout.addDrawerListener(this.mActionBarDrawerToggle);
        this.mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mActionBarDrawerToggle.syncState();
            }
        });
    }

    public static void saveToPreference(Context context,String preferenceName, String preferenceValue)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences(PERF_FILE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(preferenceName,preferenceValue);
        editor.apply();
    }

    public static String readFromPreference(Context context,String preferenceName, String defaultValue)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences(PERF_FILE_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(preferenceName,defaultValue);
    }
}
