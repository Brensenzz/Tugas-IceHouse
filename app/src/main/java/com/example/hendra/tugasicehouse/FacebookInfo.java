package com.example.hendra.tugasicehouse;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by Hendra on 4/16/2016.
 */
public class FacebookInfo extends FragmentActivity {
    public FacebookInfo()
    {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Bundle inBundle = getIntent().getExtras();
        String name = inBundle.get("name").toString();
        String surname = inBundle.get("surname").toString();
        String imageurl = inBundle.get("imageurl").toString();

        TextView nameView = (TextView)findViewById(R.id.nameAndSurname);
        nameView.setText("" + name + "" + surname);
        new DownloadImage((ImageView)findViewById(R.id.profileImage)).execute(imageurl);
    }

    public class DownloadImage extends AsyncTask<String,Void,Bitmap>
    {
        ImageView bmImage;

        public DownloadImage(ImageView bmImage)
        {
            this.bmImage = bmImage;
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            String urldisplay = params[0];
            Bitmap mIcon = null;
            try
            {
                InputStream in = new URL(urldisplay).openStream();
                mIcon = BitmapFactory.decodeStream(in);
            } catch (Exception e)
            {
                Log.e("Error",e.getMessage());
                e.printStackTrace();
            }
            return mIcon;
        }

        protected void onPostExecute(Bitmap result)
        {
            bmImage.setImageBitmap(result);
        }

    }
}
