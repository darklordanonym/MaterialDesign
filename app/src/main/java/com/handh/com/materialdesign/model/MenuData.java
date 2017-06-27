package com.handh.com.materialdesign.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fallag113 on 6/24/17.
 */

public class MenuData implements MenuDataInterface
{
    /*****************Variables*******************/
    private List<MenuModel> items=new ArrayList<>();
    private String[] MenuText;
    private Integer[] MenuIconResourses;
    /*********************************************/

    /***************counstructor*****************/
    public MenuData(String[] menuText, Integer[] menuIconResourses)
    {
        this.MenuText = menuText;
        this.MenuIconResourses = menuIconResourses;
    }
    /********************************************/

    /***************Setters**********************/
    public void setMenuText(String[] menuText) {
        MenuText = menuText;
    }

    public void setMenuIconResourses(Integer[] menuIconResourses) {
        MenuIconResourses = menuIconResourses;
    }
    /********************************************/

    /*******************Getters******************/
    public String[] getMenuText() {
        return MenuText;
    }

    public Integer[] getMenuIconResourses() {
        return MenuIconResourses;
    }

    @Override
    public List<MenuModel> getMenuItem()
    {
        for(int i=0;i<MenuText.length && i<MenuIconResourses.length;i++)
        {
            MenuModel menuModel =new MenuModel(MenuText[i],MenuIconResourses[i]);
            this.items.add(menuModel);
        }
        return this.items;
    }
}
