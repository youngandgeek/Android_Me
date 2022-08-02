package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChestPartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChestPartFragment extends android.app.Fragment {

    public ChestPartFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
View rootView= inflater.inflate(R.layout.fragment_chest_part,container,false);
        ImageView imageView=(ImageView) rootView.findViewById(R.id.chest_part_image_view);
        imageView.setImageResource(AndroidImageAssets.getBodies().get(0));
        return rootView;
    }
}