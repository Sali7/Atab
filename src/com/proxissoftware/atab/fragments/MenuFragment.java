package com.proxissoftware.atab.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.proxissoftware.atab.R;
import com.proxissoftware.atab.MainActivity;

public class MenuFragment extends ListFragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.list, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		String[] tabs = getResources().getStringArray(R.array.tabs);
		ArrayAdapter<String> colorAdapter = new ArrayAdapter<String>(getActivity(), 
				android.R.layout.simple_list_item_1, android.R.id.text1, tabs);
		setListAdapter(colorAdapter);
	}
	
	@Override
	public void onListItemClick(ListView lv, View v, int position, long id) {
		    Fragment newContent = null;
		    String title        = null;
		if(position == 0){
			newContent = new NewsFragment(0);
			title      = "Nouveautés";
		} else if(position == 1){
			newContent = new PhotosFragment(0);
			title      = "Photos";
		} else if(position == 2){
			newContent = new EventsFragment(0);
			title      = "Evènements";
		} else if(position == 3){
			newContent = new ContactFragment(0);
			title      = "Contact";
		} else if(position == 4){
			newContent = new AboutFragment(0);
			title      = "Informations";
		}
		
		if (newContent != null)
			switchFragment(newContent, title);
	}
	
	// the meat of switching the above fragment
	private void switchFragment(Fragment fragment, String title) {
		if (getActivity() == null)
			return;

		if (getActivity() instanceof MainActivity) {
			MainActivity ra = (MainActivity) getActivity();
			ra.switchContent(fragment, title);
		}
	}
}
