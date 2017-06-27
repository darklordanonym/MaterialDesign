package com.handh.com.materialdesign.model;

import java.io.Serializable;

/**
 * Created by fallag113 on 6/24/17.
 */

public class MenuModel implements Serializable
{
    /***************Variable***********/
    private String MenuText;
    private Integer MenuIcon;
    /**********************************/

    /*************Constructor*********/
    public MenuModel(String menuText, Integer menuIcon)
    {
        MenuText = menuText;
        MenuIcon = menuIcon;
    }

    public MenuModel()
    {
    }
    /*********************************/

    /**************Setters************/

    public void setMenuText(String menuText)
    {
        MenuText = menuText;
    }

    public void setMenuIcon(Integer menuIcon)
    {
        MenuIcon = menuIcon;
    }
    /**********************************/

    /************Getters***************/
    public String getMenuText()
    {
        return MenuText;
    }

    public Integer getMenuIcon()
    {
        return MenuIcon;
    }
    /***********************************/
}
