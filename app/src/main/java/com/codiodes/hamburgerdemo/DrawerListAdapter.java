package com.codiodes.hamburgerdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Salman on 6/9/2015.
 */
public class DrawerListAdapter extends BaseAdapter {

    Context mContext;
    ArrayList<NavigationItem> mNavigationItems;

    public DrawerListAdapter(Context context, ArrayList<NavigationItem> navigationItems) {
        mContext = context;
        mNavigationItems = navigationItems;
    }

    @Override
    public int getCount() {
        return mNavigationItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mNavigationItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.drawer_item, null);
        } else {
            view = convertView;
        }
        TextView titleView = (TextView) view.findViewById(R.id.title);
        TextView subTitleView = (TextView) view.findViewById(R.id.subtitle);

        titleView.setText( mNavigationItems.get(position).getTitle());
        subTitleView.setText(mNavigationItems.get(position).getSubTitle());

        return view;
    }

}
