package com.akbarprojec.retrofithttp;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PhotoAdaptor extends RecyclerView.Adapter<PhotoAdaptor.PhotoViewHolder> {

    private List<PhotoData> allPhoto;
    private Context context;

    public PhotoAdaptor(List<PhotoData> allPhoto, Context context) {
        this.allPhoto = allPhoto;
        this.context = context;
    }


    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_view_photo, parent, false);
        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoAdaptor.PhotoViewHolder holder, int position) {
        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(allPhoto.get(position).getTubnailUrl())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(holder.converImageView);
        holder.tvID.setText(allPhoto.get(position).getId() + "\n" + allPhoto.get(position).getTitle() + "\n" + allPhoto.get(position).getUrl());
    }

    @Override
    public int getItemCount() {
        return allPhoto.size();
    }

    public class PhotoViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        private ImageView converImageView;
        private TextView tvID;


        public PhotoViewHolder(@NonNull View itemView) {
            super(itemView);

            mView = itemView;
            converImageView = mView.findViewById(R.id.coverImage);
            tvID = (TextView) itemView.findViewById(R.id.tvID);
        }

    }
}
