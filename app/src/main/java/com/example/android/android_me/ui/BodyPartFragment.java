package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.List;

public class BodyPartFragment extends android.app.Fragment {

    private List<Integer> bodyImageId;
    private int bodyImageIndex;
    public BodyPartFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_body_part,container,false);
        ImageView imageView=(ImageView) rootView.findViewById(R.id.body_part_image_view);
        if (bodyImageId!=null){
            imageView.setImageResource(bodyImageId.get(bodyImageIndex));

        }
        else {
            Toast.makeText(getActivity(),"image id list is null",Toast.LENGTH_SHORT).show();
        }
        return rootView;
    }

    public void setBodyImageId(List<Integer> bodyImageId) {
        this.bodyImageId = bodyImageId;
    }

    public void setBodyImageIndex(int bodyImageIndex) {
        this.bodyImageIndex = bodyImageIndex;
    }
}