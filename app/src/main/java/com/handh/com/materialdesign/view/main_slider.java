package com.handh.com.materialdesign.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.handh.com.materialdesign.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class main_slider extends Fragment {

    private static final String POSITION="POSITION";

    private TextView content;

    public static main_slider getInstance(int position)
    {
        main_slider mainSlider=new main_slider();
        Bundle arg=new Bundle();
        arg.putInt(POSITION,position);
        mainSlider.setArguments(arg);
        return mainSlider;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_sliding_tabs, container, false);
        this.content=(TextView) view.findViewById(R.id.tab_content);
        Bundle bundle=getArguments();
        if(bundle!=null)
        {
            this.content.setText("tab num  " + bundle.getInt(POSITION));
        }
        return view;

    }

}
