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
import android.widget.AdapterView.OnItemClickListener;


public class Wishlist extends Activity {
	
	private ListView     peopleListView; 
	private static List<Person> peopleList;
	private static int selectedPerson = 0;
	

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        this.peopleListView = (ListView)this.findViewById(R.id.peoplelist);
        this.peopleListView.setAdapter(new PeopleAdapter(Wishlist.this, new ArrayList<String>(),this.restoreData()));
        this.peopleListView.setOnItemClickListener(new OnItemClickListener() {
			
        	public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        		
				// Lade die Elemente der gewählten Person in einer neuen Liste
				selectedPerson = position;
				Intent intent = new Intent(Wishlist.this, Valuelist.class);
				startActivity(intent);
			}
        	
		});
        
        final Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {

            	// Öffne den Erstelle neue Person Dialog
            	Intent intent = new Intent(Wishlist.this, CreateEditPerson.class);
				startActivity(intent);
				
            }
        });

    }

	public static List<Person> getPeopleList() {
    	return peopleList;
    }
	
	public static int getSelectedPerson() {
		return selectedPerson;
	}
   
    public static void saveData(){
    	// TODO: 
    	// Serialisiere die Personen und Elemente und schreibe sie auf die SD Karte!
    	// Immer dann wenn die App beendet wird
    }
    
    public static List<Person> restoreData(){
    	// TODO:
    	// Deserialisiere die Personen und Elemente, bei einem Neustart der App.
        peopleList = new ArrayList<Person>();
        
        
    	// Erzeuge Testdaten
    	Person pers0 = new Person("Ulli");
    	pers0.addElement(new Element("Lieblingsblumen", "Gänseblümchen, Rosen, Alpenveilchen"));
    	pers0.addElement(new Element("Lieblingsfarbe", "Lila"));
    	pers0.addElement(new Element("Equiphone SG400", "Gibts bei Musik Produktiv für 200 Euro"));
    	pers0.addElement(new Element("Eiscreme", "Schoko, Vanille, Erdbeer"));
    	Person pers1 = new Person("Jonas");
    	pers1.addElement(new Element("Lieblingsblumen", "Gänseblümchen, Rosen, Alpenveilchen"));
    	pers1.addElement(new Element("Lieblingsfarbe", "Lila"));
    	pers1.addElement(new Element("Equiphone SG400", "Gibts bei Musik Produktiv für 200 Euro"));
    	pers1.addElement(new Element("Eiscreme", "Schoko, Vanille, Erdbeer"));
    	pers1.addElement(new Element("Eiscreme", "Schoko, Vanille, Erdbeer"));
    	pers1.addElement(new Element("Eiscreme", "Schoko, Vanille, Erdbeer"));
    	pers1.addElement(new Element("Eiscreme", "Schoko, Vanille, Erdbeer"));
    	Person pers2 = new Person("johanna");
    	pers2.addElement(new Element("Lieblingsblumen", "Gänseblümchen, Rosen, Alpenveilchen"));
    	pers2.addElement(new Element("Lieblingsfarbe", "Lila"));
    	Person pers3 = new Person("Ich selber");
    	pers3.addElement(new Element("Lieblingsblumen", "Gänseblümchen, Rosen, Alpenveilchen"));
    	pers3.addElement(new Element("Lieblingsfarbe", "Lila"));
    	pers3.addElement(new Element("Equiphone SG400", "Gibts bei Musik Produktiv für 200 Euro"));
    	pers3.addElement(new Element("ESP Eclipse", "Gibts bei Musik Produktiv für 200 Euro"));
    	pers3.addElement(new Element("Jackson Randy Rhoads RR24Jackson Randy Rhoads RR24Jackson Randy Rhoads RR24", "Gibts bei Musik Produktiv für 200 Euro"));
    	pers3.addElement(new Element("Gibson Les Paul", "Gibts bei Musik Produktiv für 200 Euro"));
    	pers3.addElement(new Element("Fender Stratocaster", "Gibts bei Musik Produktiv für 200 Euro"));
    	pers3.addElement(new Element("ESP V Black", "Gibts bei Musik Produktiv für 200 Euro"));
    	pers3.addElement(new Element("LTD EC 400", "Gibts bei Musik Produktiv für 200 Euro"));
    	pers3.addElement(new Element("Sheckter Damien Vintage", "Gibts bei Musik Produktiv für 200 EuroGibts bei Musik Produktiv für 200 EuroGibts bei Musik Produktiv für 200 EuroGibts bei Musik Produktiv für 200 EuroGibts bei Musik Produktiv für 200 Euro"));
    	pers3.addElement(new Element("Eiscreme", "Schoko, Vanille, Erdbeer"));
    	Person pers4 = new Person("Prof. Dr. Albert Einstein");
    	peopleList.add(pers0);
    	peopleList.add(pers1);
    	peopleList.add(pers2);
    	peopleList.add(pers3);
    	peopleList.add(pers4);
    	
    	
    	return peopleList;
    }
}