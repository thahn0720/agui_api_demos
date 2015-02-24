package thahn.java.agui.test.view;

import thahn.java.agui.app.Activity;
import thahn.java.agui.app.AsyncTask;
import thahn.java.agui.app.Bundle;
import thahn.java.agui.app.Toast;
import thahn.java.agui.app.controller.Handler;
import thahn.java.agui.app.controller.Message;
import thahn.java.agui.test.R;
import thahn.java.agui.test.R.id;
import thahn.java.agui.test.R.layout;
import thahn.java.agui.utils.Log;
import thahn.java.agui.view.View;
import thahn.java.agui.view.View.OnClickListener;
import thahn.java.agui.widget.ProgressBar;

public class ProgressBarTestActivity extends Activity {

	boolean isFirst = true;
	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.progressbar1);//"progressbar1.xml");
		ProgressBar progressbar = (ProgressBar)findViewById(R.id.view1);
		progressbar.setBackgroundfade(true);
		progressbar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
//				if(isFirst) {
//					isFirst = false;
//					Log.e("first");
//					Intent intent = new Intent(ProgressBarTestActivity.this, ListViewTestActivity.class);
//					intent.setFlag(Intent.FLAG_ACTIVITY_NEW_TASK);
//					startActivity(intent);
//				}
				new Test().start();
//				Toast.makeText(ProgressBarTestActivity.this, "toast test ", 1000).show();
			}
		});
		
		Message msg = new Message();
		mHandler.sendMessageAtTime(msg, 3000 + System.currentTimeMillis());
		
		new AsyncTaskTest().execute();
	}
	
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

	Handler mHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			Log.e("arrive!!");
		}
	};
	
	class Test extends Thread {

		@Override
		public void run() {
//			long a = System.currentTimeMillis();
			for (int i = 0; i < 10000; i++) {
				int s = 1;
				Toast.makeText(ProgressBarTestActivity.this, "toast test " + i, s).show();
//				Log.e("added toast");
				try {
					Thread.sleep(s);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
//			Log.e(""+(a-System.currentTimeMillis()));
		}
	}
}