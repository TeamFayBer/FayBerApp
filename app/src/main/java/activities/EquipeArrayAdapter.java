package activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import Models.Equipe;
import Models.Equipe;
import codepath.fayberapp.R;

import static java.security.AccessController.getContext;


public class EquipeArrayAdapter  extends ArrayAdapter<Equipe> {
    public EquipeArrayAdapter(Context context, ArrayList<Equipe> equipe) {
        super(context, android.R.layout.simple_list_item_1, equipe);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // get the data item for position
        Equipe equipe = getItem(position);

        // check the existing view being reused
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.fayber_equipe, parent, false);
        }


        // find the image view
        ImageView ivImage1 = (ImageView) convertView.findViewById(R.id.ivProfil);
        // clear out image from convertView
        // ivImage1.setImageResource(0);

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvName);
        TextView tvOverview = (TextView) convertView.findViewById(R.id.tvProfil);

        tvTitle.setText(equipe.getTitle());
        tvOverview.setText(equipe.getDetails());

        ivImage1.setImageResource(equipe.getImage());
        //Picasso.with(getContext()).load(equipe.getImage()).into(ivImage1);
        return convertView;
    }
}
   /* public static class ViewHolder{
        TextView tvTitle;
        TextView tvDétails;
    }

    public EquipeArrayAdapter(Context context, List<Equipe> equipe) {
        super(context, android.R.layout.simple_list_item_1, equipe);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Equipe equipe = getItem(position);
        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_equipe, parent, false);
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            viewHolder.tvDétails = (TextView) convertView.findViewById(R.id.tvDetails);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        ImageView ivImage = (ImageView) convertView.findViewById(R.id.ivImage);
        ivImage.setImageResource(0);


        viewHolder.tvTitle.setText(equipe.getTitle());
        viewHolder.tvDétails.setText(equipe.getDetails());

        String image = null;
        Picasso.with(getContext()).load(image).error(R.mipmap.ic_equipe).into(ivImage);

        return convertView;
    }*/

