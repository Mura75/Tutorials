package ant.com.fragmentsapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ant.com.fragmentsapp.R;
import ant.com.fragmentsapp.adapters.ItemAdapter;
import ant.com.fragmentsapp.models.Item;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerFragment extends Fragment {

    RecyclerView recyclerView;

    List<Item> itemList;

    public RecyclerFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater
                .inflate(R.layout.fragment_recycler,
                        container,
                        false);

        recyclerView = (RecyclerView)
                view.findViewById(R.id.recyclerView);


        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        itemList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            Item item = new Item("Item " + i);
            itemList.add(item);
        }

        ItemAdapter itemAdapter = new ItemAdapter(itemList);

        recyclerView.setAdapter(itemAdapter);

        return view;
    }

}
