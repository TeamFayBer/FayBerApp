package adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import Models.Historic_demande;
import codepath.fayberapp.R;

public class HistoricArrayAdapter extends ArrayAdapter<Historic_demande> {
    public HistoricArrayAdapter(Context context, ArrayList<Historic_demande> historic) {
        super(context, android.R.layout.simple_list_item_1, historic);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // get the data item for position
        Historic_demande historic = getItem(position);

        // check the existing view being reused
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_historic, parent, false);
        }

        TextView tvNom = convertView.findViewById(R.id.tvNom);
        TextView tvService =  convertView.findViewById(R.id.tvService);
        TextView tvDate =  convertView.findViewById(R.id.tvDate);
        tvNom.setText(historic.getNom_client());
        tvService.setText(historic.getTit_liste());
        tvDate.setText(historic.getCreated());

        return convertView;
    }
}

