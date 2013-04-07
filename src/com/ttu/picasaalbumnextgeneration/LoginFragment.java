package com.ttu.picasaalbumnextgeneration;

import com.microsoft.live.LiveAuthClient;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class LoginFragment extends Fragment {

	public static final String ARG_ITEM_ID = "item_id";

	//private LiveSdkSampleApplication mApp;
	
    private LiveAuthClient mAuthClient;
    private ProgressDialog mInitializeDialog;
    private Button mSignInButton;
    private TextView mBeginTextView;
    
	private String mContent;

	public LoginFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        //setContentView(R.layout.fragment_login);

        //mApp = (LiveSdkSampleApplication) getApplication();
        //mAuthClient = new LiveAuthClient(mApp, Config.CLIENT_ID);
        //mApp.setAuthClient(mAuthClient);

        //mInitializeDialog = ProgressDialog.show(this, "", "Initializing. Please wait...", true);
/*
        
        
        // Check to see if the CLIENT_ID has been changed.
        if (Config.CLIENT_ID.equals("YOUR CLIENT ID HERE")) {
            mSignInButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    showToast("In order to use the sample, you must first place your client id " + 
                              "in com.microsoft.live.sample.Config.CLIENT_ID. For more " +
                              "information see http://go.microsoft.com/fwlink/?LinkId=220871");
                }
            });
        } else {
            mSignInButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    mAuthClient.login(SignInActivity.this,
                                      Arrays.asList(Config.SCOPES),
                                      new LiveAuthListener() {
                        @Override
                        public void onAuthComplete(LiveStatus status,
                                                   LiveConnectSession session,
                                                   Object userState) {
                            if (status == LiveStatus.CONNECTED) {
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
            });*/
				
		//if (getArguments().containsKey(ARG_ITEM_ID)) {}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_login, container, false);

		mBeginTextView = (TextView) rootView.findViewById(R.id.btn_upload);
        mSignInButton = (Button) rootView.findViewById(R.id.signInButton);
        
        /*
		if (mContent != null) {
			((TextView) rootView.findViewById(R.id.login_fragment))
					.setText(mContent);
		}
		*/

		return rootView;
	}
}
