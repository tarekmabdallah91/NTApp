package com.nextasksolution.activities.loginActivity;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.core.content.res.ResourcesCompat;

import com.nextasksolution.R;

public class LangSpinner extends ArrayAdapter<String> {
    Typeface font ;

    LangSpinner(Context context, int resource, String[] items) {
        super(context, resource, items);
        font = ResourcesCompat.getFont(context, R.font.cairo_regular);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView view = (TextView) super.getView(position, convertView, parent);
        view.setTypeface(font);
        return view;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView view = (TextView) super.getDropDownView(position, convertView, parent);
        view.setTypeface(font);
        return view;
    }
}


