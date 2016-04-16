package ant.com.fragmentsapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ant.com.fragmentsapp.R;
import ant.com.fragmentsapp.models.Cinema;

/**
 * Created by Murager on 09.04.2016.
 */
public class CinemaAdapter extends RecyclerView.Adapter<CinemaAdapter.CityViewHolder>{

    private List<Cinema> cinemaList;

    public CinemaAdapter(List<Cinema> cinemaList) {
        this.cinemaList = cinemaList;
    }

    @Override
    public CityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.cinema_item_row, parent, false);

        CityViewHolder cityViewHolder = new CityViewHolder(row);

        return cityViewHolder;
    }

    @Override
    public void onBindViewHolder(CityViewHolder holder, int position) {

        Cinema cinema = cinemaList.get(position);

        holder.tvCinemaName.setText(cinema.getFullName());
        holder.tvCinemaMall.setText(cinema.getMall());
        holder.tvCinemaBuilding.setText(cinema.getBuilding());

    }

    @Override
    public int getItemCount() {
        return cinemaList.size();
    }

    public class CityViewHolder extends RecyclerView.ViewHolder {

        Context context;
        TextView tvCinemaName;
        TextView tvCinemaMall;
        TextView tvCinemaBuilding;


        public CityViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            tvCinemaName = (TextView)itemView.findViewById(R.id.tvCinemaName);
            tvCinemaMall = (TextView)itemView.findViewById(R.id.tvCinemaMall);
            tvCinemaBuilding = (TextView)itemView.findViewById(R.id.tvCinemaBuilding);
        }
    }
}
