package thahn.java.agui.test.app;

import thahn.java.agui.app.Activity;
import thahn.java.agui.app.Bundle;
import thahn.java.agui.app.Intent;
import thahn.java.agui.test.R;
import thahn.java.agui.test.R.id;
import thahn.java.agui.test.R.layout;
import thahn.java.agui.view.View;
import thahn.java.agui.view.View.OnClickListener;

public class SendBroadcastTestActivity extends Activity {

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.textview);
		findViewById(R.id.view1).setOnClickListener(onClickListener);
	}
	
	OnClickListener onClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			// receiver
//			intent.setAction("com.google.agui.c2dm.intent.RECEIVE");
//			SendBroadcastTestActivity.this.sendBroadcast(intent);
			// activity
			intent.setAction("agui.intent.action.MAIN");
			SendBroadcastTestActivity.this.sendBroadcast(intent);
		}
	};
}
