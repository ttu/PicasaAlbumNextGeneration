package com.ttu.picasaalbumnextgeneration;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.SubMenu;

import android.content.Intent;
import android.os.Bundle;
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
	}

	@Override
	public void onItemSelected(String id) {

		Intent detailIntent = null;
			
		if (id == "1"){
			detailIntent = new Intent(this, LoginActivity.class);
		}
		else if (id == "2"){
			detailIntent = new Intent(this, CameraActivity.class);
		}
		else if (id == "3"){
			detailIntent = new Intent(this, GalleryActivity.class);
		}
			
		startActivity(detailIntent);
	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
			SubMenu sub = menu.addSubMenu(getString(R.string.menu_title));
	        sub.add(0, 6, 0, getString(R.string.menu_exit));       
	        sub.getItem().setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
	        return true;
    }
	
	 @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
		   		
			switch(item.getItemId()){
				case 0:
				case android.R.id.home:
					return false;
				case 6:
				default:
					moveTaskToBack(true);
					return true;
			}
	    }
}
