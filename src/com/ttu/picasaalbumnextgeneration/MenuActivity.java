package com.ttu.picasaalbumnextgeneration;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.SubMenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

public class MenuActivity extends SherlockFragmentActivity implements
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
		Toast.makeText(this, "Menu item clicked", Toast.LENGTH_SHORT).show();
		
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
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
			SubMenu sub = menu.addSubMenu(getString(R.string.menu_title));
	        sub.add(0, R.style.Theme_Sherlock, 0, getString(R.string.menu_exit));       
	        sub.getItem().setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
	        return true;
    }
	
	 @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
		  	Toast.makeText(this, "Item Id \"" + item.getItemId() + "\"", Toast.LENGTH_SHORT).show();
	          
			 if (item.getItemId() == android.R.id.home || item.getItemId() == 0) {
		            return false;
		     }
		 
			 moveTaskToBack(true);
	       
			 return true;
	    }
}
