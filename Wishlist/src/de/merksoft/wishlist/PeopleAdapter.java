package de.merksoft.wishlist;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PeopleAdapter extends ArrayAdapter<String>{
		
		private ArrayList<Person> elements;
		private ArrayList<String> stringElements;
		private final Context context;
	
		public PeopleAdapter(Context context, ArrayList<String> stringList, List<Person> list){
			super(context, R.layout.peoplelayout, stringList);
						
			this.context = context; 
			
			// Das ist nen echt blöder Workaround. Der Arrayadapter will unbedingt eine String liste haben
			// ich will aber eigene Elemente. Vielleicht sollte man hier lieber der baseadapter nehmen und alle selber machen!
			this.stringElements = stringList;
			this.elements = (ArrayList<Person>) list;
			for (Person person : this.elements) {
				this.stringElements.add(person.getName()+"Dummy");
			}
			
		}
		
		@Override
		public View getView(int position, View ConverView, ViewGroup parent){
			
			LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View rowView = inflater.inflate(R.layout.peoplelayout, parent, false);
			TextView textView 	= (TextView)  rowView.findViewById(R.id.label);
			TextView undertextView 	= (TextView)  rowView.findViewById(R.id.underlabel);
			ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
			
			// Text
			textView.setText(elements.get(position).getName());
			// Untertext
			Date ts = elements.get(position).getLastChange();
			String under = ts.toLocaleString(); 
			undertextView.setText(under);
			// Icon
			imageView.setImageResource(R.drawable.icon);
			
			return rowView;
		}

	}
