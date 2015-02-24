package thahn.java.agui.test;

import thahn.java.agui.app.Activity;
import thahn.java.agui.app.Bundle;
import thahn.java.agui.view.LayoutInflater;
import thahn.java.agui.view.View;
import thahn.java.agui.widget.Button;
import thahn.java.agui.widget.ImageView;
import thahn.java.agui.widget.LinearLayout;
import thahn.java.agui.widget.TextView;

public class TestActivity extends Activity {

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		
		int which = 6;
		
		switch (which) {
		case 0:
			setContentView(LayoutInflater.inflate(this, thahn.java.agui.R.layout.agui_actionbar, null));
			((TextView)findViewById(R.id.view2)).setText("1test\ntest\ntest\ntest\ntest\ntesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest");
			break;
		case 1:
			setContentView(thahn.java.agui.R.layout.agui_actionbar);//R.layout.listview_item2);
			LinearLayout container = (LinearLayout) findViewById(thahn.java.agui.R.id.item_container);
			Button btn = new Button(this);
			btn.setText("test1");
			Button btn2 = new Button(this);
			btn2.setText("test2");
			container.addView(btn);
			container.addView(btn2);
			//
			View itemView = LayoutInflater.inflate(this, thahn.java.agui.R.layout.agui_actionbar_item, null);
			((ImageView)itemView.findViewById(thahn.java.agui.R.id.item_icon)).setImageResource(R.drawable.test);
			container.addView(itemView);
			break;
		case 2:
			setContentView(R.layout.test);
			break;
		case 3:
			setContentView(R.layout.test2);
			break;
		case 4:
			setContentView(R.layout.test3);
			break;
		case 5:
			setContentView(R.layout.test4);
			break;
		case 6:
			setContentView(R.layout.dialog_friends_list);
			break;
		}
	}
}
