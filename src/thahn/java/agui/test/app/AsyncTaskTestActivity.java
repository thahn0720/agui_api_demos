package thahn.java.agui.test.app;

import thahn.java.agui.app.Activity;
import thahn.java.agui.app.AsyncTask;
import thahn.java.agui.app.Bundle;
import thahn.java.agui.test.R;
import thahn.java.agui.test.R.id;
import thahn.java.agui.test.R.layout;
import thahn.java.agui.utils.Log;
import thahn.java.agui.widget.ProgressBar;

public class AsyncTaskTestActivity extends Activity {

	boolean isFirst = true;
	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.progressbar1);//"progressbar1.xml");
		ProgressBar progressbar = (ProgressBar)findViewById(R.id.view1);
		progressbar.setBackgroundfade(true);
		
		for(int i=0;i<12;++i) {
			async = new AsyncTaskTest();
			async.execute();
		}
	}
	
	AsyncTaskTest async;
	
	class AsyncTaskTest extends AsyncTask<Integer, Integer, Integer> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			Log.e("onPreExecute");
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			super.onProgressUpdate(values);
			Log.e("onProgressUpdate");
		}

		@Override
		protected Integer doInBackground(Integer... params) {
			Log.e("doInBackground");
			return null;
		}
		
		@Override
		protected void onPostExecute(Integer result) {
			super.onPostExecute(result);
			Log.e("onPostExecute");
		}
		
		@Override
		protected void onCancelled() {
			super.onCancelled();
			Log.e("onCancelled");
		}
	}
}