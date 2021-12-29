package com.koreait.myviewpager2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.koreait.myviewpager2.R;

import java.util.ArrayList;

public class ImageSliderAdapter extends RecyclerView.Adapter<ImageSliderAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<String> sliderImageUrl;

    public ImageSliderAdapter(Context context, ArrayList<String> sliderImageUrl) {
        this.context = context;
        this.sliderImageUrl = sliderImageUrl;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.item_image_slider, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageSliderAdapter.MyViewHolder holder, int position) {
        holder.bindSliderImage(sliderImageUrl.get(position)); // glide를 들고옴
    }

    @Override
    public int getItemCount() {
        return sliderImageUrl.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {  // alt+insert로 받기
            super(itemView);
            imageView = itemView.findViewById(R.id.imageSlider);
        }

        public void bindSliderImage(String imageURL) {
            Glide.with(context)
                    .load(imageURL)
                    .centerCrop()
                    .into(imageView);
        }
    }
}
