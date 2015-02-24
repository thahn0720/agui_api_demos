package thahn.java.agui.test.app;

import thahn.java.agui.app.Activity;
import thahn.java.agui.app.Bundle;
import thahn.java.agui.app.Context;
import thahn.java.agui.app.SharedPreferences;
import thahn.java.agui.utils.Log;

public class SharedPreferencesTestActivity extends Activity {

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		SharedPreferences shared = getSharedPreferences("abc", Context.MODE_PRIVATE);
		String a = shared.getString("a", "");
		String b = shared.getString("b", "");
		String c = shared.getString("c", "");
		//
		Log.i("SharedPreferencesTestActivity", "a = " + a);
		Log.i("SharedPreferencesTestActivity", "b = " + b);
		Log.i("SharedPreferencesTestActivity", "c = " + c);
		//
		SharedPreferences.Editor editor = getSharedPreferences("abc", Context.MODE_PRIVATE).edit();
		editor.putString("a", "a");
		editor.putString("b", "b");
		editor.putString("c", "c");
		editor.commit();
		//
		shared = getSharedPreferences("abc", Context.MODE_PRIVATE);
		a = shared.getString("a", "");
		b = shared.getString("b", "");
		c = shared.getString("c", "");
		//
		Log.i("SharedPreferencesTestActivity", "a = " + a);
		Log.i("SharedPreferencesTestActivity", "b = " + b);
		Log.i("SharedPreferencesTestActivity", "c = " + c);
	}
}
