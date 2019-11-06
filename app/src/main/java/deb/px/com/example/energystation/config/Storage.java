package deb.px.com.example.energystation.config;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.storage.StorageReference;

import java.security.SecureRandom;

public class Storage {

    private static void download(Context context, StorageReference imageReference, ImageView imageView) {
        Glide.with(context)
                .using(new FirebaseImageLoader())
                .load(imageReference)
                .into(imageView);
    }

    public static void download(Context context, ImageView imageView, String stationName, int number) {
        StorageReference imageReference = ConfigFirebase.getStorage()
                .child("images")
                .child("locations")
                .child(stationName)
                .child(number + ".png");
        download(context, imageReference, imageView);
    }

}
