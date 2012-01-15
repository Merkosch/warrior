package de.merksoft.wishlist;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ValueAdapter extends ArrayAdapter<String>{
		
		private ArrayList<Element> elements;
		private ArrayList<String> stringElements;
		private final Context context;
	
		public ValueAdapter(Context context, ArrayList<String> stringList, List<Element> list){
			super(context, R.layout.valuelayout, stringList);
			
			this.context = context; 
			
			// Das ist nen echt blöder Workaround. Der Arrayadapter will unbedingt eine String liste haben
			// ich will aber eigene Elemente. Vielleicht sollte man hier lieber der baseadapter nehmen und alle selber machen!
			this.stringElements = stringList;
			this.elements = (ArrayList<Element>) list;
			for (Element element : this.elements) {
				this.stringElements.add(element.getName()+"Dummy");
			}
			
		}
		
		@Override
		public View getView(int position, View ConverView, ViewGroup parent){
			
			LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View rowView = inflater.inflate(R.layout.valuelayout, parent, false);
			TextView textView 	= (TextView)  rowView.findViewById(R.id.itemlabel);
			TextView undertextView 	= (TextView)  rowView.findViewById(R.id.timelabel);
			ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
			
			textView.setText(elements.get(position).getName());
			undertextView.setText(elements.get(position).getDescription());
			imageView.setImageResource(R.drawable.icon);
			
			return rowView;
		}

	}
