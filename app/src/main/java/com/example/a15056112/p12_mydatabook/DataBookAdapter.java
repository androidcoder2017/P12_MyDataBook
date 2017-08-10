package com.example.a15056112.p12_mydatabook;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 15056112 on 10/8/2017.
 */

public class DataBookAdapter extends ArrayAdapter<DataBook> {

    private Context context;
    private int resource;
    private TextView tvTitle;
    private ImageView ivLogo;
    private ArrayList<DataBook> drawerlist;

    public DataBookAdapter(Context context, int resource , ArrayList<DataBook> lists) {
        super(context, resource ,lists);
        this.context = context;
        this.resource = resource;
        drawerlist = lists;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.row, parent, false);

        tvTitle = (TextView)view.findViewById(R.id.tvTitle);
        ivLogo = (ImageView)view.findViewById(R.id.ivIcon);

        DataBook dataBooks = drawerlist.get(position);

        tvTitle.setText(dataBooks.getTitle());

        if (dataBooks.getIcons() == 0) {
            ivLogo.setImageResource(R.drawable.infos);
        } else if(dataBooks.getIcons() == 1) {
            ivLogo.setImageResource(R.drawable.write);
        } else if(dataBooks.getIcons() == 2) {
            ivLogo.setImageResource(R.drawable.date);
        } else if(dataBooks.getIcons() == 3) {
            ivLogo.setImageResource(R.drawable.infos);
        }

        return view;
    }
}
