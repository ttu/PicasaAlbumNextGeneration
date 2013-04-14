package com.ttu.picasaalbumnextgeneration;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.SubMenu;

public class ImageActivity extends SherlockActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image);
		
		// Show the Up button in the action bar.
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);

		Bundle extras = getIntent().getExtras();
		String uriString = extras.getString("ImageUri");
		Toast.makeText(this, uriString, Toast.LENGTH_LONG).show();
		Uri selectedImage = Uri.parse(uriString);
		
		getContentResolver().notifyChange(selectedImage, null);
        ImageView imageView = (ImageView) findViewById(R.id.image_container);
        
        ContentResolver cr = getContentResolver();
        Bitmap bitmap;
        try {
            bitmap = android.provider.MediaStore.Images.Media.getBitmap(cr, selectedImage);
            imageView.setImageBitmap(bitmap);
            Toast.makeText(this, selectedImage.toString(),
                    Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(this, "Failed to load", Toast.LENGTH_SHORT)
                    .show();
            Log.e("Camera", e.toString());
        }
	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
		SubMenu sub = menu.addSubMenu(getString(R.string.menu_title));
		sub.add(0, R.style.Theme_Sherlock, 0, getString(R.string.menu_exit));       
		sub.getItem().setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
		return true;
    }
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {	
		Toast.makeText(this, "Item Id \"" + item.getItemId() + "\"", Toast.LENGTH_SHORT).show();
       		
		switch(item.getItemId()){
			case 0:
				return false;
			case android.R.id.home:
				Intent intent = new Intent(this, MenuActivity.class);            
		        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
		        startActivity(intent);  
				return true;
			default:
				moveTaskToBack(true);
				return true;
		}
    }
}
