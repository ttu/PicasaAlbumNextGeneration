package com.ttu.picasaalbumnextgeneration;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
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
			Bundle arguments = new Bundle();
			arguments.putString(LoginFragment.ARG_ITEM_ID, getIntent()
					.getStringExtra(LoginFragment.ARG_ITEM_ID));
			LoginFragment fragment = new LoginFragment();
			fragment.setArguments(arguments);
			getSupportFragmentManager().beginTransaction()
					.add(R.id.login_container, fragment).commit();
		}
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	
	      switch (item.getItemId()) {
	        case android.R.id.home:
	        	Toast.makeText(this, "Item Id \"" + item.getItemId() + "\"", Toast.LENGTH_SHORT).show();
	        	 finish();
	          return(true);

	      // more code here for other cases
		    }
			return false;
    }
}
