package com.ttu.picasaalbumnextgeneration;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
	/** The parent context */
	private Context myContext;
	private String[] myFiles;
	
	/** Simple Constructor saving the 'parent' context. */
	public ImageAdapter(Context c, String[] files) {
		this.myContext = c;
		this.myFiles = files;
	}

	// inherited abstract methods - must be implemented
	// Returns count of images, and individual IDs
	public int getCount() {
		return this.myFiles.length;
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}
	// Returns a new ImageView to be displayed,
	public View getView(int position, View convertView, 
			ViewGroup parent) {

		String url = this.myFiles[position];
		Bitmap bitmap = BitmapHelper.ShrinkBitmap(url, 300, 300);
		
		ImageView iv = new ImageView(this.myContext);
		iv.setImageBitmap(bitmap);
		iv.setScaleType(ImageView.ScaleType.FIT_END);
		
		OnClickListener listener = new ImageListener(url);              
        iv.setOnClickListener(listener);
          
		// Set the Width & Height of the individual images
		iv.setLayoutParams(new Gallery.LayoutParams(300, 300));

		return iv;
	}
}