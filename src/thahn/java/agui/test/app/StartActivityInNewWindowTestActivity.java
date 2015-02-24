package thahn.java.agui.test.app;

import thahn.java.agui.app.Activity;
import thahn.java.agui.app.Bundle;
import thahn.java.agui.app.Intent;
import thahn.java.agui.app.WindowPosition;
import thahn.java.agui.test.R;
import thahn.java.agui.test.R.id;
import thahn.java.agui.test.R.layout;
import thahn.java.agui.utils.Log;
import thahn.java.agui.view.View;
import thahn.java.agui.view.View.OnClickListener;

// FIXME : 만들어짐과 동시에 startactivity를 실행하면 실행되지 않는다.
public class StartActivityInNewWindowTestActivity extends Activity {

	public static final int										REQUEST_CODE 		= 1;
	
	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.layout3);//"layout3.xml");
		findViewById(R.id.text1).setOnClickListener(onClickListener);
		findViewById(R.id.text2).setOnClickListener(onClickListener);
		findViewById(R.id.text3).setOnClickListener(onClickListener);
		findViewById(R.id.view1).setOnClickListener(onClickListener);
		findViewById(R.id.view2).setOnClickListener(onClickListener);
		findViewById(R.id.view3).setOnClickListener(onClickListener);
	}
	
	OnClickListener onClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Log.e("click : " + v.getId());
			Intent intent = new Intent(StartActivityInNewWindowTestActivity.this, SetResultTestActivity.class);
			//
//			intent.putIntExtra(Intent.EXTRA_POSITION_RELATIVE_SCREEN, Position.CENTER | Position.MID);
			//
			intent.putIntExtra(Intent.EXTRA_POSITION_RELATIVE_WINDOW_HORIZONTAL, WindowPosition.RIGHT | WindowPosition.OUT);
			intent.putIntExtra(Intent.EXTRA_POSITION_RELATIVE_WINDOW_VERTICAL, WindowPosition.BOTTOM | WindowPosition.IN);
			intent.putObjectExtra(Intent.EXTRA_POSITION_RELATIVE_WINDOW_INSTANCE, StartActivityInNewWindowTestActivity.this);
			//
//			intent.putIntExtra(Intent.EXTRA_POSITION_X, 300);
//			intent.putIntExtra(Intent.EXTRA_POSITION_Y, 300);
			startActivityInNewWIndow("thahn", intent);
		}
	};
}
