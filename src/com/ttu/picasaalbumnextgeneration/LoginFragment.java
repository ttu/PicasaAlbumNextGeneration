package com.ttu.picasaalbumnextgeneration;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class LoginFragment extends Fragment {

	public static final String ARG_ITEM_ID = "item_id";

	private String mContent;

	public LoginFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mContent = "Here will be login";
		
		//if (getArguments().containsKey(ARG_ITEM_ID)) {}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_login, container, false);

		if (mContent != null) {
			((TextView) rootView.findViewById(R.id.login_fragment))
					.setText(mContent);
		}

		return rootView;
	}
}
