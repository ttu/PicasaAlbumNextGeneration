package com.ttu.picasaalbumnextgeneration;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class LoginActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		// Show the Up button in the action bar.
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
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
}
