package com.ttu.picasaalbumnextgeneration;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class MenuActivity extends FragmentActivity implements
		MenuFragment.Callbacks {

	private boolean mTwoPane;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);

		if (findViewById(R.id.item_detail_container) != null) {
			mTwoPane = true;

			// In two-pane mode, list items should be given the 'activated' state when touched.
			((MenuFragment) getSupportFragmentManager().findFragmentById(
					R.id.item_list)).setActivateOnItemClick(true);
		}

		// TODO: If exposing deep links into your app, handle intents here.
	}

	@Override
	public void onItemSelected(String id) {
		if (mTwoPane) {
			Bundle arguments = new Bundle();
			arguments.putString(ItemDetailFragment.ARG_ITEM_ID, id);
			ItemDetailFragment fragment = new ItemDetailFragment();
			fragment.setArguments(arguments);
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.item_detail_container, fragment).commit();

		} else {
			// TODO: Could class come from MenuItem?
			
			Intent detailIntent = null;
			
			if (id == "1"){
				detailIntent = new Intent(this, LoginActivity.class);
			}
			else if (id == "2"){
				detailIntent = new Intent(this, CameraActivity.class);
			}
			else if (id == "3"){
				detailIntent = new Intent(this, MenuActivity.class);
			}
			
			detailIntent.putExtra(ItemDetailFragment.ARG_ITEM_ID, id);
			startActivity(detailIntent);
		}
	}
}
