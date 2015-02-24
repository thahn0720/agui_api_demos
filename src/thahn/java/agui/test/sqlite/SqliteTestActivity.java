package thahn.java.agui.test.sqlite;

import java.util.List;

import thahn.java.agui.app.Activity;
import thahn.java.agui.app.Bundle;
import thahn.java.agui.test.R;
import thahn.java.agui.utils.Log;

public class SqliteTestActivity extends Activity {

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.layout3);
		LocationDBHelper db = new LocationDBHelper(this);
		db.insert("1", 123.123, 123.123, "t1");		
		db.insert("2", 123.123, 123.123, "t2");
		db.insert("3", 123.123, 123.123, "t3");
		db.delete(1);
		db.update(3, "update", 321, 321, "update");
		List<LocationData> locationData = db.select();
		for(LocationData data : locationData) {
			Log.d(data.toString());
		}
	}
}
