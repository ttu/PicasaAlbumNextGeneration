package com.ttu.picasaalbumnextgeneration;

import java.io.File;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Gallery;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockListFragment;

public class GalleryFragment extends SherlockListFragment{

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		// Keep this so can test with SkyDrive
		
		//String[] values = getFiles();

		//ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
		//		R.layout.gallery_item, values);
		//setListAdapter(adapter);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_gallery, container, false);
		((TextView)rootView.findViewById(R.id.textView_gallery)).setText("Local photos");		

		((TextView)rootView.findViewById(R.id.IAP_gallery)).setText("SkyDrive gallery avaialbe as In App purchase.");
		
		// TODO: Find better widget for gallaery
		Gallery myGallery = (Gallery) rootView.findViewById(R.id.myGallery_gallery);
		myGallery.setAdapter(new ImageAdapter(rootView.getContext(),getFiles()));
		
		return rootView;
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		Object item = l.getItemAtPosition(position);
		showToast(item.toString());
		
		Intent detailIntent = new Intent(v.getContext(), ImageActivity.class);
    	detailIntent.putExtra("ImageUri", item.toString());
    	v.getContext().startActivity(detailIntent);
	}

	private void showToast(String message) {
		Activity activity = getActivity();
		Toast.makeText(activity, message, Toast.LENGTH_LONG).show();
	}

	private String[] getFiles(){
		String path = getAlbumDir();

		File currentDirectory = new File(path);
		File[] files = currentDirectory.listFiles();

		ArrayList<String> fileNames = new ArrayList<String>();

		for(File f : files){
			if (f.isFile() && f.getName().toLowerCase().endsWith(".jpg"))
			{
				fileNames.add(f.getAbsolutePath());
			}
		}

		String[] retVal = new String[fileNames.size()];
		retVal = fileNames.toArray(retVal);
		return retVal;
	}

	private String getAlbumDir(){
		return Environment.getExternalStorageDirectory() + File.separator + "DCIM/Camera/";		
	}
}
