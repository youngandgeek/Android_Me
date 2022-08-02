package com.example.android.android_me.ui;

import android.app.Fragment;
import android.content.Context;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

public class BodyPartFragment extends Fragment {

    //mandatory constructor
    public BodyPartFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.fragment_body_part,container,false);

        //get a reference of the image view in the layout
        ImageView imageView= (ImageView) rootView.findViewById(R.id.body_part_image_view);
        //set the image resource to display
        imageView.setImageResource(AndroidImageAssets.getHeads().get(0));
        return rootView;

    }
}
