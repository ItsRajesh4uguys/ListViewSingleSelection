package com.rajesh.ListViewSingleSelection;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RelativeLayout;
public class MainActivity extends Activity {
	
	
	//============ 
	static List<LazyAdapter.MyDat> MyViewedMeItemList; 


	
	ListView list;
    LazyAdapter adapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		list=(ListView)findViewById(R.id.list);
		list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);	
        adapter=new LazyAdapter(this);        
        list.setAdapter(adapter);
        list.setItemChecked(2, true);


        // Click event for single list row
        list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
							
				

			}
		});	
        
        MyViewedMeItemList=new ArrayList<LazyAdapter.MyDat>();
        
	}	
	
	public class LazyAdapter extends BaseAdapter {
	    
		
	
		//=========
	    private Activity activity;
	
	    private LayoutInflater inflater=null;	  
	    Context context;
	    public LazyAdapter(Activity a) {
	        activity = a;
	       
	        context=a;
	        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	       
	    }

	    public int getCount() {
	        return 25;
	    }

	    public Object getItem(int position) {
	        return position;
	    }

	    public long getItemId(int position) {
	        return position;
	    }
	    
	    public View getView(final int position, View convertView, ViewGroup parent) {
	        View vi=convertView;
	        if(convertView==null)
	            vi = inflater.inflate(R.layout.row, null);

	    	 final MyDat mydat;// = new MyDat();
	        if (position >= MyViewedMeItemList.size()) {
				mydat = new MyDat();

			} 
	        else
			{
				mydat = MyViewedMeItemList.get(position);
			}        
	       
	        mydat.rajesh=(CheckBox)vi.findViewById(R.id.rajesh);        
	        mydat.rajesh.setVisibility(View.VISIBLE);
	        mydat.rajesh.setText(" Position" + position);
	        
	        
	        if (mydat.myCheckStatus) {
				// Toast.makeText(MessageInboxDelete.this, "true --->" +// position,// Toast.LENGTH_SHORT).show();
				mydat.rajesh.setChecked(true);
			} else {
				/*
				 * Toast.makeText(MessageInboxDelete.this, "false --->" +* position, Toast.LENGTH_SHORT).show();
				 */
				mydat.rajesh.setChecked(false);
			}	     
	        
	       mydat.rajesh.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View paramView) {
					// TODO Auto-generated method stub
					//Toast.makeText(context, "Rajesh", Toast.LENGTH_SHORT).show();
					
					
					
					
					int gridchild;
					gridchild = list.getChildCount();
					for (int j = 0; j < gridchild; j++) {
						// DrawArea_Steptwo.gridview.getChildAt(j);
						
					//Toast.makeText(context, "Rajesh", Toast.LENGTH_SHORT).show();
						RelativeLayout gridchildlayout = (RelativeLayout) list
								.getChildAt(j);

						CheckBox tempRadioToggle = (CheckBox) gridchildlayout
								.findViewById(R.id.rajesh);

						tempRadioToggle.setChecked(false);                    
					
						MyDat tempViewholder = MyViewedMeItemList.get(j);
						tempViewholder.myCheckStatus = false;
					}
					
					for(int j = 0; j < MyViewedMeItemList.size(); j++) {
						MyDat tempViewholder = MyViewedMeItemList.get(j);
						tempViewholder.myCheckStatus = false;
					}
					CheckBox tempRadioToggle = (CheckBox) paramView.findViewById(R.id.rajesh);    	
					tempRadioToggle.setChecked(true);
					
					MyDat tempViewholder = MyViewedMeItemList.get(position);
							
							if (tempViewholder.myCheckStatus == false) {
								tempViewholder.myCheckStatus = true;
								// tempViewholder.deleteRadioButton.setChecked(true);
								
            
							} else {
								tempViewholder.myCheckStatus = false;
								// tempViewholder.deleteRadioButton.setChecked(false);

							}
							
					
				}
			});	            
	        
	        if (MyViewedMeItemList.size() <= position) {
				MyViewedMeItemList.add(mydat);
			}
			
	        
	        
	        return vi;
	    }
	    
	 public  class MyDat{
		   
		   Boolean myCheckStatus=false;		   
		   CheckBox rajesh;
		   
	   }
	    
	}
}
