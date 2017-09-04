package adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import java.util.List;

import Models.Services;
import Models.servicesUser;
import codepath.fayberapp.R;

/**
 * Created by East Coast Pawn on 8/31/2017.
 */

public class serviceUserArrayAdapter extends ArrayAdapter<servicesUser> {
    public serviceUserArrayAdapter(Context context, List<servicesUser> serviceUser) {
        super(context, android.R.layout.simple_list_item_1, serviceUser);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // get the data item for position
        servicesUser servicesUser = getItem(position);

        // check the existing view being reused
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.activity_sign_up, parent, false);
        }

        EditText edT = (EditText) convertView.findViewById(R.id.etNomComplet);
        EditText edT1 = (EditText) convertView.findViewById(R.id.etPhone);
        EditText edT2 = (EditText) convertView.findViewById(R.id.etIdentif);
        EditText edT3 = (EditText) convertView.findViewById(R.id.etMail);
       // EditText edT4 = (EditText) convertView.findViewById(R.id.etPass);


        edT.setText(servicesUser.getNomCl());
        edT1.setText(servicesUser.getTelephone());
        edT2.setText(servicesUser.getUsername());
        edT3.setText(servicesUser.getEmail());
        //edT4.setText((CharSequence) servicesUser.g);
        return convertView;
    }
}


