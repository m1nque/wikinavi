package khc.wikinavi;

import java.util.ArrayList;

import android.app.Activity;
import android.app.TabActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import khc.wikinavi.components.ListViewItem;
import khc.wikinavi.components.MapListAdapter;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		int testcode = 0;

		TabHost tabHost = getTabHost();

		TabSpec tabSelectMap = tabHost.newTabSpec("TAB1").setIndicator("지도선택");
		tabSelectMap.setContent(R.id.selectMap);
		tabHost.addTab(tabSelectMap);

		TabSpec tabViewMap = tabHost.newTabSpec("TAB2").setIndicator("지도보기");
		tabViewMap.setContent(R.id.viewMap);
		tabHost.addTab(tabViewMap);

		TabSpec tabFindRoute = tabHost.newTabSpec("TAB3").setIndicator("길찾기");
		tabFindRoute.setContent(R.id.findRoute);
		tabHost.addTab(tabFindRoute);

		TabSpec tabMoreView = tabHost.newTabSpec("TAB4").setIndicator("더보기");
		tabMoreView.setContent(R.id.moreView);
		tabHost.addTab(tabMoreView);

		tabHost.setCurrentTab(0);

		ListView selectMapList = (ListView) findViewById(R.id.mapListView);
		ArrayList<ListViewItem> data = new ArrayList();
		ListViewItem newEngineering = new ListViewItem("신공 4층"), wonHeung = new ListViewItem("원흥 3층"),
				sangRok = new ListViewItem("상록원 1층");

		data.add(newEngineering);
		data.add(wonHeung);
		data.add(sangRok);
		
		MapListAdapter mla = new MapListAdapter(this, R.layout.item, data);
		selectMapList.setAdapter(mla);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
