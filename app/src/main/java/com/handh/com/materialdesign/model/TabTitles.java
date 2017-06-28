package com.handh.com.materialdesign.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fallag113 on 6/28/17.
 */

public class TabTitles implements  TabTitleInterface {

    /****************variable**************/
    private String titles[];
    private Integer icons[];
    private TabTitle tabTitle;
    private List<TabTitle> tabTitleList;


    /*************constructor**************/
    public TabTitles(String[] titles, Integer icons[]) {
        this.titles = titles;
        this.icons = icons;
    }

    @Override
    public List<TabTitle> getTitlesData(String titles, Integer icon) {

        this.tabTitleList=new ArrayList<>();
        for(int i=0;i<titles.length() && i<icons.length;i++)
        {
            this.tabTitle=new TabTitle(this.icons[i],this.titles[i]);
            this.tabTitleList.add(tabTitle);
        }
        return this.tabTitleList;
    }
}
