package thahn.java.agui.test.app;

import thahn.java.agui.app.Activity;
import thahn.java.agui.app.Bundle;
import thahn.java.agui.app.Intent;
import thahn.java.agui.test.R;
import thahn.java.agui.test.R.id;
import thahn.java.agui.test.R.layout;
import thahn.java.agui.utils.Log;
import thahn.java.agui.view.View;
import thahn.java.agui.view.View.OnClickListener;

/**
 * first, start aguios<br>
 * second, start AGUI_ApiDemo2<br>
 * third, start this activity<br>
 * @author thAhn
 *
 */
public class SendIntentTestActivity extends Activity {

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
			
			Intent intent = new Intent(
					"thahn.java.agui.test2.TestActivity"
//					"thahn.java.agui.test2.SendIntentTestActivity"
					);
//			sendIntent("AGUI", intent);
			sendIntent(intent);
		}
	};
}
