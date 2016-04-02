package ant.com.fragmentsapp.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ant.com.fragmentsapp.R;
import ant.com.fragmentsapp.models.Item;

/**
 * Created by Murager on 02.04.2016.
 */
public class ItemAdapter extends
        RecyclerView.Adapter <ItemAdapter.ItemViewHolder> {


    List<Item> itemList;

    public ItemAdapter(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_row_layout,
                                parent,
                                false);

        ItemViewHolder viewHolder = new ItemViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        Item item = itemList.get(position);

        holder.tvName.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ItemViewHolder
            extends RecyclerView.ViewHolder {

        Context context;
        CardView cardView;
        ImageView imageView;
        TextView tvName;

        public ItemViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            cardView = (CardView)itemView.findViewById(R.id.cardView);
            imageView = (ImageView)itemView.findViewById(R.id.ivUrl);
            tvName = (TextView)itemView.findViewById(R.id.tvName);
        }
    }

}
