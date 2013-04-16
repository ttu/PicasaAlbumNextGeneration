package com.ttu.picasaalbumnextgeneration;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapHelper {

	public static Bitmap GetFile(String strUrl) throws IOException{
		
		URL url = new URL(strUrl);
		URLConnection connection = url.openConnection();
		connection.setUseCaches(true);
		Object response = connection.getContent();

		if (response instanceof Bitmap) {
			return (Bitmap)response;
		}   

		return null;
	}

	public static Bitmap ShrinkBitmap(String file, int width, int height) {

		BitmapFactory.Options bmpFactoryOptions = new BitmapFactory.Options();
		bmpFactoryOptions.inJustDecodeBounds = true;
		Bitmap bitmap = BitmapFactory.decodeFile(file, bmpFactoryOptions);

		int heightRatio = (int)Math.ceil(bmpFactoryOptions.outHeight/(float)height);
		int widthRatio = (int)Math.ceil(bmpFactoryOptions.outWidth/(float)width);

		if (heightRatio > 1 || widthRatio > 1)
		{
			if (heightRatio > widthRatio)
			{
				bmpFactoryOptions.inSampleSize = heightRatio;
			} else {
				bmpFactoryOptions.inSampleSize = widthRatio;
			}
		}

		bmpFactoryOptions.inJustDecodeBounds = false;
		bitmap = BitmapFactory.decodeFile(file, bmpFactoryOptions);
		return bitmap;
	}
}
