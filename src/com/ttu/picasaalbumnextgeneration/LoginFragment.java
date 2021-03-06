package com.ttu.picasaalbumnextgeneration;

import java.util.Arrays;

import com.actionbarsherlock.app.SherlockFragment;

import com.microsoft.live.LiveAuthClient;
import com.microsoft.live.LiveAuthException;
import com.microsoft.live.LiveAuthListener;
import com.microsoft.live.LiveConfig;
import com.microsoft.live.LiveConnectClient;
import com.microsoft.live.LiveConnectSession;
import com.microsoft.live.LiveStatus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginFragment extends SherlockFragment {

	public static final String ARG_ITEM_ID = "item_id";

	private PicasaNGApplication mApp;
	private LiveAuthClient mAuthClient;
	private TextView mSignInText;
	private Button mSignInButton;

	public LoginFragment() {
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Activity activity = getActivity();
		mApp = (PicasaNGApplication) activity.getApplication();
		mAuthClient = new LiveAuthClient(mApp, LiveConfig.CLIENT_ID);
		mApp.setAuthClient(mAuthClient);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_login, container, false);

		mSignInButton = (Button) rootView.findViewById(R.id.signInButton);
		mSignInText = (TextView) rootView.findViewById(R.id.beginTextView);
		
		if (mApp.IsUserLoggedIn()){
			mSignInText.setText(R.string.begin_out);
			mSignInButton.setText(R.string.sign_out);
		} else {
			mSignInText.setText(R.string.begin_in);
			mSignInButton.setText(R.string.sign_in);
		}
		
		mSignInButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Activity activity = getActivity();   
				
				if (mApp.IsUserLoggedIn() == false){
					mAuthClient.login(activity,
							Arrays.asList(LiveConfig.SCOPES),
							new LiveAuthListener() {
						@Override
						public void onAuthComplete(LiveStatus status,
								LiveConnectSession session,
								Object userState) {
							if (status == LiveStatus.CONNECTED) {
								showToast("Login completed");
								launchMainActivity(session);
							} else {
								showToast("Login did not connect. Status is " + status + ".");
							}
						}

						@Override
						public void onAuthError(LiveAuthException exception, Object userState) {
							showToast(exception.getMessage());
						}
					});
				} 
				else {       		
					mAuthClient.logout(new LiveAuthListener() {
						@Override
						public void onAuthComplete(LiveStatus status,
								LiveConnectSession session,
								Object userState) {
							mApp.setSession(null);
							mApp.setConnectClient(null);
							Activity activity = getActivity();
							startActivityForResult(new Intent(activity.getApplicationContext(), MenuActivity.class),0);
						}
						
						@Override
						public void onAuthError(LiveAuthException exception, Object userState) {
							showToast(exception.getMessage());
						}
					});
				}
			}
		});

		return rootView;
	}

	private void launchMainActivity(LiveConnectSession session) {
		assert session != null;
		mApp.setSession(session);
		mApp.setConnectClient(new LiveConnectClient(session));
		Activity activity = getActivity();
		startActivityForResult(new Intent(activity.getApplicationContext(), MenuActivity.class),0);
	}
	
	private void showToast(String message) {
		Activity activity = getActivity();
		Toast.makeText(activity, message, Toast.LENGTH_LONG).show();
	}
}
