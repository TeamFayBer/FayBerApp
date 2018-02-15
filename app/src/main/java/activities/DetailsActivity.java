package activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import Models.Services;
import codepath.fayberapp.R;

import static codepath.fayberapp.R.id.ivImage1;

public class DetailsActivity extends AppCompatActivity {
    TextView tvText;
    TextView titre;
    ImageView ImageItem;
    Button button;
    SharedPreferences sharedPreferences ;
    SharedPreferences.Editor editor ;
    Services serv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);

        //Display the Up button home
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Call a differents contenu,not the same in details page
        sharedPreferences = getSharedPreferences("PreferencesTAG", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        serv = (Services) getIntent().getSerializableExtra("services");
        getSupportActionBar().setTitle("Fiche "+serv.getTitle());

        tvText = (TextView) findViewById(R.id.tvDetails);
        tvText.setText(serv.getDetails().toString());
        titre = (TextView) findViewById(R.id.tvtitle4detail);
        titre.setText(serv.getTitle().toString());
        ImageItem = (ImageView) findViewById(ivImage1);
    //    String imageUri = "http://fayberagency.com/v1/app/image_service/"+serv.getImage();
       // Picasso.with(getApplicationContext()).load(imageUri).into(ImageItem);
        // ImageItem.setImageResource(Integer.parseInt(serv.getImage()));

        button = (Button) findViewById(R.id.btnRegister);

        changeImage(getIntent().getIntExtra("position",0));
    }
    //Find the different image in the details not the same in fayactivity
    public void changeImage(int position){
        switch (position) {
            case 0:
                ImageItem.setImageResource(R.drawable.blood); //blood fitness
                break;
            case 1:
                ImageItem.setImageResource(R.drawable.bandage); //bandage blood
                break;
            case 2:
                ImageItem.setImageResource(R.drawable.diabetes);//diabetes diab
                break;
            case 3:
                ImageItem.setImageResource(R.drawable.diab);//diab diabetes
                break;
            case 4:
                ImageItem.setImageResource(R.drawable.fitness);//fitness diete
                break;
            case 5:
                ImageItem.setImageResource(R.drawable.ok);//ok
                break;
            case 6:
                ImageItem.setImageResource(R.drawable.mental);//mental walker
                break;
            case 7:
                ImageItem.setImageResource(R.drawable.diete);//diete bandage
                break;
            case 8:
                ImageItem.setImageResource(R.drawable.walker);//walker mental
                break;
            default:
        }
    }
    //private ShareActionProvider mShareActionProvider;
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.icon_share, menu);
        return true;
    }
    //navigate to SignIn activity
    public void onLogButton(View v) {
        if(sharedPreferences.getString("id_client", null)!=null){
            Intent i = new Intent(DetailsActivity.this, FicheDemandeActivity.class);
            i.putExtra("services",serv);
            startActivity(i);
        }else{
            Intent i = new Intent(DetailsActivity.this, SignInActivity.class);
            i.putExtra("services",serv);
            startActivity(i);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // Respond to the action bar's Up/Home button
                finish();
                return true;
            case R.id.miShare:
                shareInfo();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    //
    // To share via another apps
    public void shareInfo(){

        //add the message for sharing
        String messageToShare="Pour plus de detail et de contenu, visitez notre siteWeb- http://fayberagency.com/";

        messageToShare = "visitez notre site Web:- http://fayberagency.com/";

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Fayber Agency App");
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Pour plus de detail et de contenu vous pouvez télécharger l'application : https://play.google.com/store/apps/details?id=codepath.fayberapp ou \n visitez notre site Web : http://fayberagency.com/");
        /*sendIntent.putExtra(Intent.EXTRA_TEXT, titre.getText().toString() + " " + messageToShare);
        sendIntent.setType("text/plain");*/
        startActivity(sendIntent);
    }
}
