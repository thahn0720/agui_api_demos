package thahn.java.agui.test.view;

import thahn.java.agui.app.Activity;
import thahn.java.agui.app.Bundle;
import thahn.java.agui.app.Window;
import thahn.java.agui.test.R;

public class PaddingTestActivity extends Activity {

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.padding);
//		getWindow().requestFeature(Window.FEATURE_NO_TITLE);
	}
}
