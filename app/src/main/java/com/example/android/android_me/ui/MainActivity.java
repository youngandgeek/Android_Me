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

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import org.w3c.dom.Text;

// This activity is responsible for displaying the master list of all images
// TODO (4) Implement the MasterListFragment callback, OnImageClickListener
public class MainActivity extends AppCompatActivity  implements MasterListFragment.OnImageClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a new head MasterListFragment
        MasterListFragment masterListFragment = new MasterListFragment();
        // Add the fragment to its container using a FragmentManager and a Transaction
        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .add(R.id.master_list_fragment, masterListFragment)
                .commit();

        // Create and display the body and leg BodyPartFragments

    }
    // TODO (5) Define the behavior for onImageSelected; create a Toast that displays the position clicked

    @Override
    public void onImageSelected(int position) {
        Toast.makeText(this,"position clicked"+position, Toast.LENGTH_LONG).show();
    }


}
