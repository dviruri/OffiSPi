package com.example.offispi;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class EmployeeAdapter extends ArrayAdapter {

    Activity context;

    public EmployeeAdapter(Activity context)
    {
        super(context,R.layout.row_item,Employees.getDisplayNames());
        this.context = context;



    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row=convertView;
        LayoutInflater inflater = context.getLayoutInflater();
        if(convertView==null)
            row = inflater.inflate(R.layout.row_item, null, true);
        TextView Name = (TextView) row.findViewById(R.id.person_name);
        ImageView img = (ImageView) row.findViewById(R.id.person_image);

        Name.setText(Employees.employees.get(position).getDisplayName());
        String Identifier = Employees.employees.get(position).getName();
        if (Employees.employees.get(position).isPresent()) Identifier += "g";

        int res = context.getResources().getIdentifier(Identifier, "drawable", context.getPackageName());
        img.setImageResource(res);

        return  row;
    }
}
