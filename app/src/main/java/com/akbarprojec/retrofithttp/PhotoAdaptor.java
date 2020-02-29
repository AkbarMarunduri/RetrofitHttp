package com.akbarprojec.retrofithttp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PhotoAdaptor extends RecyclerView.Adapter<PhotoAdaptor.PhotoViewHolder> {

    private List<PhotoAdaptor> allPhoto;
    private Context context;

    public PhotoAdaptor(List<PhotoAdaptor> allPhoto, Context context) {
        this.allPhoto = allPhoto;
        this.context = context;
    }

    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_view_photo, parent, false);
        return new PhotoAdaptor(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoAdaptor.PhotoViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return allPhoto.size();
    }

    public class PhotoViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        private ImageView converImageView;

        public PhotoViewHolder(@NonNull View itemView) {
            super(itemView);

            mView = itemView;
            converImageView = mView.findViewById(R.id.coverImage);
        }

    }
}
