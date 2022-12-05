/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.android_me.ui;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

// This activity is responsible for displaying the master list of all images
// Implement the MasterListFragment callback, OnImageClickListener
public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener{

    private int headIndex;
    private int bodyIndex;
    private int legIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Create a new head BodyPartFragment
        MasterListFragment masterListFragment = new MasterListFragment();

        // Add the fragment to its container using a FragmentManager and a Transaction
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.master_list_fragment, masterListFragment)
                .commit();

    }

    // Define the behavior for onImageSelected
    public void onImageSelected(int position) {
        // Create a Toast that displays the position that was clicked
        Toast.makeText(this, "Position clicked = " + position, Toast.LENGTH_SHORT).show();

        // TODO (2) Based on where a user has clicked, store the selected list index for the head, body, and leg BodyPartFragments
        int bodyPartNumber=position/12;
        int listIndex=position-12*bodyPartNumber;

        switch (bodyPartNumber){
            case 0:headIndex=listIndex;
                break;
            case 1:bodyIndex=listIndex;
                break;
            case 2:legIndex=listIndex;
                break;
            default:break;
        }
        // TODO (3) Put this information in a Bundle and attach it to an Intent that will launch an AndroidMeActivity
        Bundle bundle=new Bundle();
        bundle.putInt("headIndex",headIndex);
        bundle.putInt("bodyIndex",bodyIndex);
        bundle.putInt("legIndex",legIndex);

        final Intent androidMe=new Intent(this,AndroidMeActivity.class);
        androidMe.putExtras(bundle);
        // TODO (4) Get a reference to the "Next" button and launch the intent when this button is clicked
        Button nextBtn;
        nextBtn=(Button) findViewById(R.id.next_btn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(androidMe);
            }
        });
    }

}
