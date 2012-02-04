package de.merksoft.wishlist;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Valuelist extends Activity{

	private ListView elementsList; 
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.values);

        this.elementsList = (ListView)this.findViewById(R.id.valuelist);
        
        // Hole die Liste der Elemente der gewählten Person.
        int pos = Wishlist.getSelectedPerson();
        List<Element> eList = Wishlist.getPeopleList().get(pos).getElementList();
        
        this.elementsList.setAdapter(new ValueAdapter(Valuelist.this, new ArrayList<String>(), eList));
        this.elementsList.setOnItemClickListener(new OnItemClickListener() {
			
        	public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

				//TODO: 
				// Lade das Element in dem createEdit Dialog um es zu editieren oder anzusehen.
				Toast.makeText( Valuelist.this, (String)elementsList.getAdapter().getItem(position), Toast.LENGTH_SHORT ).show();
			}
        	
        });
        
        final Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	
            	// Lade den createEdit Dialog um ein neues Element zu erstellen.
				Intent intent = new Intent(Valuelist.this, CreateEditElement.class);
				startActivity(intent);
				
            }
        });
        
    }
    
    
}
