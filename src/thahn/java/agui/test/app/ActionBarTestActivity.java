package thahn.java.agui.test.app;



import thahn.java.agui.app.Activity;
import thahn.java.agui.app.Bundle;
import thahn.java.agui.app.Menu;
import thahn.java.agui.app.Toast;
import thahn.java.agui.test.R;
import thahn.java.agui.utils.Log;
import thahn.java.agui.view.MenuItem;
import thahn.java.agui.view.View;
import thahn.java.agui.view.View.OnClickListener;

 // TODO : addinternalview에서 mContext.arrangeview()를 하지 않으면 제대로 작동하지 않는다.
public class ActionBarTestActivity extends Activity {

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		// hide action bar
//		ActionBar actionBar = getActionBar();
//		actionBar.hide();
		// set custom action bar
//		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE); // before setContentView
//		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.actionbar_custom);
		// 
		setContentView(R.layout.progressbar1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		Log.i("onCreateOptionsMenu");
		getMenuInflater().inflate(R.menu.actionbar, menu);
		menu.findItem(R.id.menu_refresh).getActionView().setOnClickListener(onClickListener);
		return true;
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

	OnClickListener onClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Log.i("title action bar menu clicked");
			Toast.makeText(getApplicationContext(), "title action bar menu clicked", 1000).show();
		}
	};
}