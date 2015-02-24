package thahn.java.agui.test.app;

import thahn.java.agui.app.Activity;
import thahn.java.agui.app.Bundle;
import thahn.java.agui.test.R;
import thahn.java.agui.utils.Log;
import thahn.java.agui.view.View;
import thahn.java.agui.view.View.OnClickListener;
import thahn.java.agui.widget.ProgressBar;

public class ToastTestActivity extends Activity {

	boolean isFirst = true;
	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.progressbar1);//"progressbar1.xml");
//		setContentView("transient_notification.xml");
		
		ProgressBar progressbar = (ProgressBar)findViewById(R.id.view1);
		progressbar.setBackgroundfade(true);
		progressbar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new Test().start();
//				Toast.makeText(ToastTestActivity.this, "toast test ", 1000).show();
			}
		});
	}
	
	class Test extends Thread {

		@Override
		public void run() {
//			long a = System.currentTimeMillis();
			MyToast.init(ToastTestActivity.this);
			for (int i = 0; i < 10000; i++) {
				int s = 1000;
				MyToast.show("toast test " + i, MyToast.TYPE_NORMAL);
				Log.e("toast test " + i);
//				Toast.makeText(ToastTestActivity.this, "toast test " + i, s).show();
//				try {
//					Thread.sleep(s);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
			}
//			Log.e(""+(a-System.currentTimeMillis()));
		}
	}
}