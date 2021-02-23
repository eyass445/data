package com.example.sqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class UserAdapter extends BaseAdapter {

    List<User> users;
    Context context;

    public UserAdapter(List<User> users, Context context) {
        this.users = users;
        this.context = context;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int i) {
        return users.get(i);
    }

    @Override
    public long getItemId(int i) {
        return users.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;

        if (v==null){
            v= LayoutInflater.from(context).inflate(R.layout.userview,viewGroup,false);

        }

        User u = (User) getItem(i);
        TextView tv3 = v.findViewById(R.id.tv3);

        tv3.setText(u.getName());

        return v;
    }


//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        View v = convertView;
//
//        if (v==null){
//            v= LayoutInflater.from(getContext()).inflate(R.layout.userview,parent,false);
//        }
//
//        User u = getItem(position);
//        TextView tv3 = v.findViewById(R.id.tv3);
//
//        tv3.setText(u.getName());
//
//        return v;
//    }

}
