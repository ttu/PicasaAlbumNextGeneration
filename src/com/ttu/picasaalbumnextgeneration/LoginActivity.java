package com.ttu.picasaalbumnextgeneration;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.SubMenu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class LoginActivity extends SherlockFragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
	
		// Show the Up button in the action bar.
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		
		if (savedInstanceState == null) {
			LoginFragment fragment = new LoginFragment();
			getSupportFragmentManager().beginTransaction()
					.add(R.id.login_container, fragment).commit();
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
				Intent intent = new Intent(this, MenuActivity.class);            
		        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
		        startActivity(intent);            
				//finish();
				return true;
			case 6:
			default:
				moveTaskToBack(true);
				return true;
		}
    }
}
