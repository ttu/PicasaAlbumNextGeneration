package com.ttu.picasaalbumnextgeneration;

import java.io.File;
import java.util.Date;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.SubMenu;
import com.microsoft.live.LiveOperation;
import com.microsoft.live.LiveOperationException;
import com.microsoft.live.LiveUploadOperationListener;

public class ImageActivity extends SherlockActivity{

	String mUri = "";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image);

		// Show the Up button in the action bar.
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);

		Bundle extras = getIntent().getExtras();
		String uriString = extras.getString("ImageUri");
		mUri = uriString;
		
		Toast.makeText(this, uriString, Toast.LENGTH_LONG).show();
		//Uri selectedImage = Uri.parse("file://" + uriString);
		//getContentResolver().notifyChange(selectedImage, null);
		ImageView imageView = (ImageView) findViewById(R.id.image_container);
		imageView.setScaleType(ScaleType.FIT_CENTER);
		//ContentResolver cr = getContentResolver();
		Bitmap bitmap;
		try {
			bitmap = BitmapHelper.ShrinkBitmap(uriString, 1000, 1000);
			//bitmap = android.provider.MediaStore.Images.Media.getBitmap(cr, selectedImage);
			imageView.setImageBitmap(bitmap);
			Toast.makeText(this, uriString,Toast.LENGTH_LONG).show();
		} catch (Exception e) {
			Toast.makeText(this, "Failed to load", Toast.LENGTH_SHORT)
			.show();
			Log.e("Camera", e.toString());
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		SubMenu sub = menu.addSubMenu(getString(R.string.menu_title));
		
		if (((PicasaNGApplication)getApplication()).IsUserLoggedIn()){
			sub.add(0, 10, 0, getString(R.string.btn_upload)); 
		}
		
		sub.add(1, 11, 0, getString(R.string.menu_exit));    
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
			return true;
		case 10:
			Toast.makeText(this, "Upload", Toast.LENGTH_SHORT).show();
			
			File toUpload = new File(mUri);
			String fileName = String.valueOf(new Date().getTime()) + ".jpg";		
			
			PicasaNGApplication mApp = (PicasaNGApplication) getApplication();
			mApp.getConnectClient().uploadAsync(
					"me/skydrive", fileName, toUpload, new LiveUploadOperationListener() {
						@Override
						public void onUploadCompleted(LiveOperation arg0) {
							// TODO: Show message			
						}

						@Override
						public void onUploadFailed(LiveOperationException arg0,
								LiveOperation arg1) {
							// TODO: Show message					
						}

						@Override
						public void onUploadProgress(int arg0, int arg1,
								LiveOperation arg2) {
							// TODO: Show progress
							
						}});
			return false;
		case 11:
		default:
			moveTaskToBack(true);
			return true;
		}
	}
}
