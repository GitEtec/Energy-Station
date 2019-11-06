package deb.px.com.example.energystation.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import deb.px.com.example.energystation.R;
import deb.px.com.example.energystation.config.Storage;

public class ImageViewerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_viewer);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String title = bundle.getString("title");
            int number = bundle.getInt("number");
            getSupportActionBar().setTitle(title);

            ImageView imageView = findViewById(R.id.imageView);
            Storage.download(this, imageView, title, number);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();

        return true;
    }
}
