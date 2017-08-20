package adapters;


import android.app.Service;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import Models.Services;
import codepath.fayberapp.R;

import static codepath.fayberapp.R.id.imageView;

public class ServiceArrayAdapter {
   /* public static class ViewHolder{
        TextView tvTitle;
        TextView tvDétails;
    }

    public ServiceArrayAdapter(Context context, List<Services> service) {
        super(context, android.R.layout.simple_list_item_1, service);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Services service = getItem(position);
        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_service, parent, false);
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            viewHolder.tvDétails = (TextView) convertView.findViewById(R.id.tvDetails);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        ImageView ivImage = (ImageView) convertView.findViewById(R.id.ivImage);
        ivImage.setImageResource(0);


        viewHolder.tvTitle.setText(service.getTitle());
        viewHolder.tvDétails.setText(service.getDetails());

        String image = null;
        Picasso.with(getContext()).load(image).error(R.mipmap.ic_service).into(ivImage);

        return convertView;
    }*/
}
