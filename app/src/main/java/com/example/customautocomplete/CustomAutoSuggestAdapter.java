package com.example.customautocomplete;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAutoSuggestAdapter extends ArrayAdapter<UserDetails> {

    ArrayList<UserDetails> userDetails, tempUserDetails, suggestions;

    CustomAutoSuggestAdapter(Context context, ArrayList<UserDetails> objects) {
        super(context, android.R.layout.simple_list_item_1, objects);
        this.userDetails = objects;
        this.tempUserDetails = new ArrayList<UserDetails>(objects);
        this.suggestions = new ArrayList<UserDetails>(objects);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        UserDetails currentUserDetails = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.user_details, parent, false);
        }
        TextView tvUserName = convertView.findViewById(R.id.tvUserName);
        TextView tvUserNumber = convertView.findViewById(R.id.tvUserNumber);

        if (currentUserDetails != null) {
            if (tvUserName != null) {
                tvUserName.setText(currentUserDetails.getName());
            }

            if (tvUserNumber != null) {
                tvUserNumber.setText(currentUserDetails.getNumber());
            }
        }


        return convertView;
    }

    @Override
    public Filter getFilter() {
        return myFilter;
    }


    Filter myFilter = new Filter() {
        @Override
        public CharSequence convertResultToString(Object resultValue) {
            UserDetails userDetails = (UserDetails) resultValue;
            return userDetails.getName();
        }

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            if (constraint != null) {
                suggestions.clear();
                for (UserDetails userDetails : tempUserDetails) {
                    if (userDetails.getName().toLowerCase().contains(constraint.toString().toLowerCase())
                            || userDetails.getNumber().toLowerCase().contains(constraint.toString().toLowerCase())) {
                        suggestions.add(userDetails);
                    }
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = suggestions;
                filterResults.count = suggestions.size();
                return filterResults;
            } else {
                return new FilterResults();
            }
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            ArrayList<UserDetails> c = (ArrayList<UserDetails>) results.values;
            if (results != null && results.count > 0) {
                clear();
                for (UserDetails cust : c) {
                    add(cust);
                    notifyDataSetChanged();
                }
            }
        }
    };
}
