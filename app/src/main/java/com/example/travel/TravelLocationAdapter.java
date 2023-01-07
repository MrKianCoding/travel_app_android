package com.example.travel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.flaviofaria.kenburnsview.KenBurnsView;

import org.w3c.dom.Text;

import java.util.List;

public class TravelLocationAdapter extends RecyclerView.Adapter<TravelLocationAdapter.travelLocationViewHolder> {

    private List<TravelLocationModel> travelLocationModelList;

    public TravelLocationAdapter(List<TravelLocationModel> travelLocationModelList) {
        this.travelLocationModelList = travelLocationModelList;
    }

    @NonNull
    @Override
    public travelLocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new travelLocationViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_location,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull travelLocationViewHolder holder, int position) {

        holder.setTravelLocationData(travelLocationModelList.get(position));

    }

    @Override
    public int getItemCount() {
        return travelLocationModelList.size();
    }

    static class travelLocationViewHolder extends RecyclerView.ViewHolder {

        KenBurnsView imageViewPhoto;
        TextView textViewTitle, textViewDescription, textViewStarRating;

        public travelLocationViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewPhoto = itemView.findViewById(R.id.imageViewPhoto);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
            textViewStarRating = itemView.findViewById(R.id.textViewStarRating);
        }

        void setTravelLocationData(TravelLocationModel travelLocationData){
            Glide.with(itemView.getContext()).load(travelLocationData.photo).into(imageViewPhoto);
            textViewTitle.setText(travelLocationData.title);;
            textViewDescription.setText(travelLocationData.description);
            textViewStarRating.setText(String.valueOf(travelLocationData.starRating));
        }
    }
}
