package com.handh.com.materialdesign.adapters;

/**
 * Created by fallag113 on 6/27/17.
 */
        import android.content.Context;
        import android.support.v4.app.Fragment;
        import android.support.v4.app.FragmentManager;
        import android.support.v4.app.FragmentPagerAdapter;

        import com.handh.com.materialdesign.R;
        import com.handh.com.materialdesign.view.main_slider;

/**
 * Created by Ujang Wahyu on 18/08/2016.
 */

public class SlingTabAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private String[] tabTitle;
    private int items;
    public SlingTabAdapter(FragmentManager fm, Context c,int Items)
    {
        super(fm);
        this.tabTitle=c.getResources().getStringArray(R.array.tabTitle);
        this.mContext = c;
        this.items=Items;
    }

    @Override
    public Fragment getItem(int position) {
        main_slider mainSlider=main_slider.getInstance(position+1);
        return mainSlider;
    }

    @Override
    public int getCount() {
        return this.items;
    }

    public CharSequence getPageTitle(int position){
        return this.tabTitle[position];
    }

}
