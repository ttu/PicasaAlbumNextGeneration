package com.ttu.picasaalbumnextgeneration;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;

public class GalleryFragment extends SherlockFragment{
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_gallery, container, false);
		//View rootView = inflater.inflate(R.layout.fragment_login, container, false);
		((TextView)rootView.findViewById(R.id.textView_gallery)).setText("Gallery will be here");		

		return rootView;
	}
}
