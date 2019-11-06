package deb.px.com.example.energystation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import deb.px.com.example.energystation.R;
import deb.px.com.example.energystation.config.Storage;

public class AdapterImages extends RecyclerView.Adapter<AdapterImages.MyViewHolder> {
    private Context context;
    private String stationName;
    private int totalImages;

    public AdapterImages(Context context, String stationName, int totalImages) {
        this.context = context;
        this.stationName = stationName;
        this.totalImages = totalImages;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.adapter_image, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Storage.download(context, holder.imageView, stationName, position);
    }

    @Override
    public int getItemCount() {
        return totalImages;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
