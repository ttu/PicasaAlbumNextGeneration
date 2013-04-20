package com.ttu.picasaalbumnextgeneration;

import android.os.Bundle;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.SubMenu;

public class GalleryActivity extends SherlockFragmentActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gallery);
		
		// Show the Up button in the action bar.
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		
		if (savedInstanceState == null) {
			GalleryFragment fragment = new GalleryFragment();
			getSupportFragmentManager().beginTransaction()
					.add(R.id.gallery_container, fragment).commit();
		}
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
				return false;
			case android.R.id.home:
				finish();
				return true;
			default:
				moveTaskToBack(true);
				return true;
		}
    }
}
