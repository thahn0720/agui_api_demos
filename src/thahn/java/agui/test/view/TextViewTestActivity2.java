package thahn.java.agui.test.view;

import thahn.java.agui.app.Activity;
import thahn.java.agui.app.Bundle;
import thahn.java.agui.test.R;
import thahn.java.agui.utils.Log;
import thahn.java.agui.widget.TextView;

public class TextViewTestActivity2 extends Activity {

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.textview2);
		final TextView textView = (TextView) findViewById(R.id.view1);
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 50; i++) {
			builder.append(i).append("        \n");
		}
		textView.setText(builder.toString());
				//"text\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntexttexttexttexttexttexttexttexttexttexttext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext\ntext");
	}
}
