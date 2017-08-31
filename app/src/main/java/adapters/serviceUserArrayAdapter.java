package adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import Models.Services;
import Models.servicesUser;

/**
 * Created by East Coast Pawn on 8/31/2017.
 */

public class serviceUserArrayAdapter extends ArrayAdapter<servicesUser> {
    public serviceUserArrayAdapter(Context context, @LayoutRes int resource) {
        super(context, resource);
    }
}
