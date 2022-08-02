package com.example.android.android_me.ui;

import android.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.List;

public class HeadPartFragment extends Fragment {

    //create two variables to store the ImageResourceId and the index of image displaying
    //to display the image dynamically
    // and add two setter method
    private List<Integer> headImageIds;
    private int headListIndex;


    //mandatory constructor
    public HeadPartFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.fragment_head_part,container,false);

        //get a reference of the image view in the layout
        ImageView imageView= (ImageView) rootView.findViewById(R.id.head_part_image_view);
        //set the image resource to display dynamically
        //first check if image id has been set or not if not
        if (headImageIds!=null){
            imageView.setImageResource(headImageIds.get(headListIndex));

        }
         else {
             //show message
            Toast.makeText(getActivity(),"This Fragment has null list of Image Id",Toast.LENGTH_SHORT).show();

        }
        return rootView;

    }
    public void setImageIds(List<Integer> mImageIds) {
        this.headImageIds = mImageIds;
    }

    public void setListIndex(int mListIndex) {
        this.headListIndex = mListIndex;
    }

}
