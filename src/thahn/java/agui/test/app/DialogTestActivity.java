package thahn.java.agui.test.app;

import thahn.java.agui.app.Activity;
import thahn.java.agui.app.Bundle;
import thahn.java.agui.app.Dialog;
import thahn.java.agui.app.controller.Handler;
import thahn.java.agui.app.controller.Message;
import thahn.java.agui.test.R;
import thahn.java.agui.test.R.id;
import thahn.java.agui.test.R.layout;
import thahn.java.agui.utils.Log;
import thahn.java.agui.view.View;
import thahn.java.agui.widget.ProgressBar;

public class DialogTestActivity extends Activity {

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
				Log.e("DialogTestActivity", "show Dialog");
			// how to create dialog 
			// first.
//				Dialog dialog = new Dialog(DialogTestActivity.this);
//				dialog.setContentView(R.layout.dialog);
//				dialog.show();
//				dialog.dismiss();
				
			// second.
				showDialog(0);
			// third
			}
		});
		
		mHandler.sendEmptyMessageDelayed(0, 2000);
	}
	
	@Override
	public Dialog onCreateDialog(int i) {
		Dialog dialog = new Dialog(DialogTestActivity.this);
		dialog.setContentView(R.layout.dialog);
		return dialog;
	}
	
	Handler mHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
//			dismissDialog(0);
		}
	};
}