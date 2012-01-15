package de.merksoft.wishlist;

import java.io.FileNotFoundException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class CreateEditPerson extends Activity {

	private static final int SELECT_PHOTO = 100;
	private Bitmap personImage;
	private Uri personImageUri;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createeditperson);
        
        final Button button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	
				Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
				photoPickerIntent.setType("image/*");
				startActivityForResult(photoPickerIntent, SELECT_PHOTO); 
				
				//TODO: Speichere die URL an der Person
		
            }
        });
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) { 
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent); 

        switch(requestCode) { 
        case SELECT_PHOTO:
            if(resultCode == RESULT_OK){  
				try {
					personImageUri = imageReturnedIntent.getData();
					InputStream imageStream;
					imageStream = getContentResolver().openInputStream(personImageUri);
					personImage = BitmapFactory.decodeStream(imageStream);
					
					Toast.makeText(CreateEditPerson.this, personImageUri.toString(), Toast.LENGTH_LONG).show();
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
            }
        }
    }
    
    // Alternatively, you can also downsample your image to avoid OutOfMemory errors.
    private Bitmap decodeUri(Uri selectedImage) throws FileNotFoundException {

        // Decode image size
        BitmapFactory.Options o = new BitmapFactory.Options();
        o.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(getContentResolver().openInputStream(selectedImage), null, o);

        // The new size we want to scale to
        final int REQUIRED_SIZE = 140;

        // Find the correct scale value. It should be the power of 2.
        int width_tmp = o.outWidth, height_tmp = o.outHeight;
        int scale = 1;
        while (true) {
            if (width_tmp / 2 < REQUIRED_SIZE
               || height_tmp / 2 < REQUIRED_SIZE) {
                break;
            }
            width_tmp /= 2;
            height_tmp /= 2;
            scale *= 2;
        }

        // Decode with inSampleSize
        BitmapFactory.Options o2 = new BitmapFactory.Options();
        o2.inSampleSize = scale;
        return BitmapFactory.decodeStream(getContentResolver().openInputStream(selectedImage), null, o2);

    }

}
