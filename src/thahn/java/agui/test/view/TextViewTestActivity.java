package thahn.java.agui.test.view;

import thahn.java.agui.app.Activity;
import thahn.java.agui.app.Bundle;
import thahn.java.agui.test.R;
import thahn.java.agui.utils.Log;
import thahn.java.agui.widget.TextView;

public class TextViewTestActivity extends Activity {

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.textview);
		final TextView textView = (TextView) findViewById(R.id.view1);
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 50; i++) {
			builder.append(i).append("        \n");
		}
		textView.setText(builder.toString());
				//"text\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntexttexttexttexttexttexttexttexttexttexttext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext");
		
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				Log.i("pre");
//				try {
//					Thread.sleep(2000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				Log.i("go");
//				textView.setText("123123");
//			}
//		}).start();
	}
}
