package thahn.java.agui.test.view;

import thahn.java.agui.app.Activity;
import thahn.java.agui.app.Bundle;
import thahn.java.agui.test.R;
import thahn.java.agui.test.R.id;
import thahn.java.agui.test.R.layout;
import thahn.java.agui.view.ViewGroup;
import thahn.java.agui.widget.TextView;

public class HorizontalScrollViewTestActivity extends Activity {

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.horizontalscrollview);
		StringBuilder temp2 = new StringBuilder();
		for(int i=0;i<100;++i) {
			temp2.append(i);
		}
		TextView temp = new TextView(this);
		temp.setSingleLine(true);
		temp.setText(temp2.toString());
		//
		((ViewGroup)findViewById(R.id.scrollview)).addView(temp);
//		FrameLayout layout = (FrameLayout) findViewById(R.id.root);
//		layout.addView(temp);
		//
//		LinearLayout layout = (LinearLayout) findViewById(R.id.root);
//		layout.setOrientation(LinearLayout.HORIZONTAL);
//		for(int i=0;i<100;++i) {
//			TextView text = new TextView(this);
//			text.setText(""+i);
//			layout.addView(text);
//			Log.e(""+i);
//		}
	}
}
