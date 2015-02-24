package thahn.java.agui.test.view;

import thahn.java.agui.app.Activity;
import thahn.java.agui.app.Bundle;
import thahn.java.agui.test.R;
import thahn.java.agui.test.R.id;
import thahn.java.agui.test.R.layout;
import thahn.java.agui.utils.Log;
import thahn.java.agui.widget.LinearLayout;
import thahn.java.agui.widget.TextView;

public class ScrollViewTestActivity extends Activity {

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
//		RelativeLayout layout = new RelativeLayout(this);
//		TextView text = new TextView(this);
//		layout.addView(text);
//		text.setText("12");
//		setContentView(layout);
		setContentView(R.layout.scrollview1);//"scrollview1.xml");
		LinearLayout layout = (LinearLayout) findViewById(R.id.root);
		layout.setOrientation(LinearLayout.VERTICAL);
		// FIXME : if add 1000 child, so slow
		for(int i=0;i<45;++i) {//200;++i) {
			TextView text = new TextView(this);
			text.setText(""+i);
			text.setPaddingTop(10);
			layout.addView(text);
			Log.e(""+i);
		}
	}
}