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
import android.widget.GridView;
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
    // TODO (3) Create a variable to track whether to display a two-pane or single-pane UI
    // A single-pane display refers to phone screens, and two-pane to larger tablet screens
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO (4) If you are making a two-pane display, add new BodyPartFragments to create an initial Android-Me image
        // Also, for the two-pane display, get rid of the "Next" button in the master list fragment
        if (findViewById(R.id.android_me_linear_layout) != null) {
            mTwoPane = true;

         /**   //more space in gridView
            GridView gridView = findViewById(R.id.grid_view_img);
            gridView.setNumColumns(2);

            //get rid of next button
            Button   nextBtn =(Button) findViewById(R.id.next_btn);
            nextBtn.setVisibility(View.GONE);
**/
            //populate fragments that in the androidMe activity
            if (savedInstanceState == null) {


                // Add the fragment to its container using a FragmentManager and a Transaction
                FragmentManager fragmentManager = getSupportFragmentManager();

                // TODO (5) Retrieve list index values that were sent through an intent; use them to display the desired Android-Me body part image
                // Use setListindex(int index) to set the list index for all BodyPartFragments

                // Create a new head BodyPartFragment
                BodyPartFragment headFragment = new BodyPartFragment();

                // Set the list of image id's for the head fragment and set the position to the second image in the list
                headFragment.setImageIds(AndroidImageAssets.getHeads());
                fragmentManager.beginTransaction()
                        .add(R.id.head_container, headFragment)
                        .commit();

                // Create and display the body and leg BodyPartFragments

                BodyPartFragment bodyFragment = new BodyPartFragment();
                bodyFragment.setImageIds(AndroidImageAssets.getBodies());
                fragmentManager.beginTransaction()
                        .add(R.id.body_container, bodyFragment)
                        .commit();

                BodyPartFragment legFragment = new BodyPartFragment();
                legFragment.setImageIds(AndroidImageAssets.getLegs());
                fragmentManager.beginTransaction()
                        .add(R.id.legs_container, legFragment)
                        .commit();
            }
        } else {
            mTwoPane = false;
        }
    }
  /**  //
    MasterListFragment masterListFragment = new MasterListFragment();

    // Add the fragment to its container using a FragmentManager and a Transaction
    FragmentManager fragmentManager = getSupportFragmentManager();
    fragmentManager.beginTransaction()
            .add(R.id.master_list_fragment, masterListFragment)
            .commit();

}
**/
    // Define the behavior for onImageSelected
    public void onImageSelected(int position) {
        // Create a Toast that displays the position that was clicked
        Toast.makeText(this, "Position clicked = " + position, Toast.LENGTH_SHORT).show();

        // TODO (5) Handle the two-pane case and replace existing fragments right when a new image is selected from the master list
        // The two-pane case will not need a Bundle or Intent since a new activity will not be started;
        // This is all happening in this MainActivity and one fragment will be replaced at a time

        // TODO (2) Based on where a user has clicked, store the selected list index for the head, body, and leg BodyPartFragments
        int bodyPartNumber = position / 12;
        int listIndex = position - 12 * bodyPartNumber;
        if (mTwoPane) {

            BodyPartFragment newFragment = new BodyPartFragment();
            switch (bodyPartNumber) {
                case 0: //a head image has been clicked
                    // set the correct listIndex
                    newFragment.setImageIds(AndroidImageAssets.getHeads());
                    newFragment.setListIndex(listIndex);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.head_container, newFragment)
                            .commit();
                    break;
                case 1: //a body image has been clicked
                    // set the correct listIndex
                    newFragment.setImageIds(AndroidImageAssets.getBodies());
                    newFragment.setListIndex(listIndex);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.body_container, newFragment)
                            .commit();
                    break;
                case 2: //a leg image has been clicked
                    // set the correct listIndex
                    newFragment.setImageIds(AndroidImageAssets.getLegs());
                    newFragment.setListIndex(listIndex);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.legs_container, newFragment)
                            .commit();
                    break;
                default:
                    break;

            }
        } else {
            switch (bodyPartNumber) {
                case 0:
                    headIndex = listIndex;
                    break;
                case 1:
                    bodyIndex = listIndex;
                    break;
                case 2:
                    legIndex = listIndex;
                    break;
                default:
                    break;
            }

            // TODO (3) Put this information in a Bundle and attach it to an Intent that will launch an AndroidMeActivity
            Bundle bundle = new Bundle();
            bundle.putInt("headIndex", headIndex);
            bundle.putInt("bodyIndex", bodyIndex);
            bundle.putInt("legIndex", legIndex);

            final Intent androidMe = new Intent(this, AndroidMeActivity.class);
            androidMe.putExtras(bundle);
            // TODO (4) Get a reference to the "Next" button and launch the intent when this button is clicked
            Button nextBtn;
            nextBtn = (Button) findViewById(R.id.next_btn);
            nextBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(androidMe);
                }
            });
        }
    }
}
