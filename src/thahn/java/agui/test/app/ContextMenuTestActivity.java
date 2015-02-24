package thahn.java.agui.test.app;

import thahn.java.agui.ContextMenu;
import thahn.java.agui.ContextMenu.ContextMenuInfo;
import thahn.java.agui.app.Activity;
import thahn.java.agui.app.Bundle;
import thahn.java.agui.app.Menu;
import thahn.java.agui.test.R;
import thahn.java.agui.test.R.id;
import thahn.java.agui.test.R.layout;
import thahn.java.agui.utils.Log;
import thahn.java.agui.view.MotionEvent;
import thahn.java.agui.view.MenuItem;
import thahn.java.agui.view.View;

public class ContextMenuTestActivity extends Activity {

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.layout3);
		View textView1 = findViewById(R.id.text1);
		View textView2 = findViewById(R.id.text2);
		View root = findViewById(R.id.root);
		registerForContextMenu(textView1, MotionEvent.BUTTON1);
		registerForContextMenu(textView2);
		registerForContextMenu(root);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo info) {
		super.onCreateContextMenu(menu, v, info);
		int id = v.getId();
		Log.e("ContextMenuTestActivity", "onCreateContextMenu : " + id);
		switch (id) {
		case R.id.text1:
			menu.add("text1");
			break;
		case R.id.text2:
			menu.add("text2");
			break;
		case R.id.root:
			menu.add("root");
			break;
		}
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		Log.i("onPrepareOptionsMenu");
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Log.i("onOptionsItemSelected");
		return super.onOptionsItemSelected(item);
	}
}

