package thahn.java.agui.test.app;

import thahn.java.agui.app.Activity;
import thahn.java.agui.app.Bundle;
import thahn.java.agui.app.Intent;
import thahn.java.agui.app.Toast;
import thahn.java.agui.test.R;
import thahn.java.agui.test.R.anim;
import thahn.java.agui.test.R.id;
import thahn.java.agui.test.R.layout;
import thahn.java.agui.utils.Log;
import thahn.java.agui.view.View;
import thahn.java.agui.view.View.OnClickListener;

// FIXME : 만들어짐과 동시에 startactivity를 실행하면 실행되지 않는다.
public class StartActivityTestActivity extends Activity {

	public static final int										REQUEST_CODE 		= 1;
	
	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.layout3);//"layout3.xml");
//		findViewById(R.id.text1).setOnClickListener(onClickListener);
//		findViewById(R.id.text2).setOnClickListener(onClickListener);
//		findViewById(R.id.text3).setOnClickListener(onClickListener);
		findViewById(R.id.view1).setOnClickListener(onClickListener);
		findViewById(R.id.view2).setOnClickListener(onClickListener);
		findViewById(R.id.view3).setOnClickListener(onClickListener);
	}
	
	OnClickListener onClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Log.e("click : " + v.getId());
			// start anim, exit anim
			Intent intent = new Intent(StartActivityTestActivity.this, SetResultTestActivity.class);
			overridePendingTransition(R.anim.hold, R.anim.layout_slide_right);
//			overridePendingTransition(R.anim.layout_animation_row_left_slide, R.anim.cycle_7);
//			startActivityForResult(intent, REQUEST_CODE);
//			sendIntent("new", intent);
			startActivityInNewWIndow("new123", intent);
		}
	};

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(resultCode == RESULT_OK) {
			switch (requestCode) {
			case REQUEST_CODE:
				Log.e("onActivityResult");
				Toast.makeText(StartActivityTestActivity.this, "onActivityResult", 2000).show();
				break;
			}
		}
	}
}
