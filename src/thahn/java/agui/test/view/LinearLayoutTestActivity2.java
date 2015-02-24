package thahn.java.agui.test.view;

import thahn.java.agui.app.Activity;
import thahn.java.agui.app.Bundle;
import thahn.java.agui.test.R;
import thahn.java.agui.test.R.layout;

// FIXME : 만들어짐과 동시에 startactivity를 실행하면 실행되지 않는다.
public class LinearLayoutTestActivity2 extends Activity {

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.linearlayout2);
	}
}
