package com.handh.com.materialdesign.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.handh.com.materialdesign.model.MenuModel;
import com.handh.com.materialdesign.R;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuHolder>
{
    private List<MenuModel> menuModelList;
    private LayoutInflater inflater;
    private onMenuClickedCallBack callBack;

    /******* bridge interface ********/
    public interface onMenuClickedCallBack
    {
        void setClickedItem(Integer position);
    }
    public MenuAdapter(List<MenuModel> menuModelList, Context context) {
        this.menuModelList = menuModelList;
        this.inflater=LayoutInflater.from(context);
    }

    public void setItemClickCallback(final onMenuClickedCallBack itemClickCallback)
    {
        this.callBack=itemClickCallback;
    }

    @Override
    public MenuHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=this.inflater.inflate(R.layout.menu_item,parent,false);
        return new MenuHolder(view);
    }

    @Override
    public void onBindViewHolder(MenuHolder holder, int position) {
        MenuModel current=this.menuModelList.get(position);
        holder.menuText.setText(current.getMenuText());
        holder.MenuIcon.setImageResource(current.getMenuIcon());
    }

    @Override
    public int getItemCount() {
        return this.menuModelList.size();
    }

    public class MenuHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private TextView menuText;
        private ImageView MenuIcon;
        private ViewGroup content;
        public MenuHolder(View itemView) {
            super(itemView);
            this.menuText=(TextView) itemView.findViewById(R.id.menu_item_text);
            this.MenuIcon=(ImageView) itemView.findViewById(R.id.menu_item_icon);
            this.content=(ViewGroup) itemView.findViewById(R.id.drawer_menu_root);
            this.content.setOnClickListener(this);
        }

        @Override
        public void onClick(View view)
        {
            callBack.setClickedItem(getAdapterPosition());
        }
    }
}
