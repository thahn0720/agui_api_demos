package thahn.java.agui.test.app;

import thahn.java.agui.app.Activity;
import thahn.java.agui.app.Bundle;
import thahn.java.agui.app.controller.Handler;
import thahn.java.agui.app.controller.Message;
import thahn.java.agui.test.R;
import thahn.java.agui.test.R.id;
import thahn.java.agui.test.R.layout;
import thahn.java.agui.utils.Log;
import thahn.java.agui.widget.ProgressBar;

public class HandlerTestActivity extends Activity {

	boolean isFirst = true;
	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.progressbar1);//"progressbar1.xml");
		ProgressBar progressbar = (ProgressBar)findViewById(R.id.view1);
		progressbar.setBackgroundfade(true);
		Log.e("which thread? main? awt?");
		Message msg = new Message();
		mHandler.sendMessageAtTime(msg, 3000+System.currentTimeMillis());
	}
	
	Handler mHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			Log.e("arrive!!");
		}
	};
}