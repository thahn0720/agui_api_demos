package thahn.java.agui.test.anim;

import thahn.java.agui.animation.Animation;
import thahn.java.agui.animation.AnimationUtils;
import thahn.java.agui.app.Activity;
import thahn.java.agui.app.Bundle;
import thahn.java.agui.test.R;
import thahn.java.agui.utils.Log;
import thahn.java.agui.view.View;
import thahn.java.agui.view.View.OnClickListener;

public class RotateAnimTestActivity extends Activity {

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.layout3);
		
        findViewById(R.id.view1).setOnClickListener(onClickListener);
        findViewById(R.id.view2).setOnClickListener(onClickListener);
        findViewById(R.id.view3).setOnClickListener(onClickListener);
	}
	
	OnClickListener onClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Log.i("RotateAnimTestActivity", "start ani");
			Animation fade = AnimationUtils.loadAnimation(RotateAnimTestActivity.this, R.anim.rotate);
	        findViewById(R.id.text1).startAnimation(fade);
	        invalidate();
		}
	};
}
