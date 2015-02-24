package thahn.java.agui.test.view;

import java.awt.Button;

import thahn.java.agui.app.Activity;
import thahn.java.agui.app.Bundle;
import thahn.java.agui.test.R;
import thahn.java.agui.test.R.id;
import thahn.java.agui.test.R.layout;
import thahn.java.agui.widget.ShellView;

public class ShellViewTestActivity extends Activity {

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.shellview);
		Button component = new Button("awt button");
//		Label component = new Label("component");
		((ShellView)findViewById(R.id.view2)).setComponent(component);
	}
}
