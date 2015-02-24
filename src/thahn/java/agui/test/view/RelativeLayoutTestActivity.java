package thahn.java.agui.test.view;


import thahn.java.agui.app.Activity;
import thahn.java.agui.app.Bundle;
import thahn.java.agui.test.R;
import thahn.java.agui.test.R.id;
import thahn.java.agui.test.R.layout;
import thahn.java.agui.utils.Log;
import thahn.java.agui.view.View;
import thahn.java.agui.view.View.OnClickListener;
import thahn.java.agui.view.ViewGroup;
import thahn.java.agui.widget.Button;
import thahn.java.agui.widget.RelativeLayout;
import thahn.java.agui.widget.TextView;

public class RelativeLayoutTestActivity extends Activity {

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		if(true) {
			setContentView(R.layout.relativelayout);
			RelativeLayout layout = (RelativeLayout) findViewById(R.id.root2);
			
			RelativeLayout.LayoutParams rlParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			rlParams.addRule(RelativeLayout.BELOW, thahn.java.agui.test.R.id.view5);
			Button btn = new Button(this);
			btn.setText("temp");
			btn.setLayoutParams(rlParams);
			layout.addView(btn);
		} else {
			setContentView(R.layout.listview_item2);
			((TextView)findViewById(R.id.view2)).setText("1test\ntest\ntest\ntest\ntest\ntesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest");
		}
	}
	
	OnClickListener onClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Log.e("click : " + v.getId());
		}
	};
}
