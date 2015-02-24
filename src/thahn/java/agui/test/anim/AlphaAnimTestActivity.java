package thahn.java.agui.test.anim;

import thahn.java.agui.animation.Animation;
import thahn.java.agui.animation.AnimationUtils;
import thahn.java.agui.app.Activity;
import thahn.java.agui.app.Bundle;
import thahn.java.agui.test.R;
import thahn.java.agui.utils.Log;
import thahn.java.agui.view.View;
import thahn.java.agui.view.View.OnClickListener;
import thahn.java.agui.view.View.OnLongClickListener;

public class AlphaAnimTestActivity extends Activity {

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.layout3);
		
        findViewById(R.id.view1).setOnClickListener(onClickListener);
        findViewById(R.id.view2).setOnClickListener(onClickListener);
        findViewById(R.id.view3).setOnClickListener(onClickListener);
        findViewById(R.id.view3).setOnLongClickListener(onLongClickListener);
	}
	
	OnClickListener onClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Log.i("AlphaAnimTestActivity", "start ani");
			Animation fade = AnimationUtils.loadAnimation(AlphaAnimTestActivity.this, R.anim.fade);
	        findViewById(R.id.text1).startAnimation(fade);
	        invalidate();
		}
	};
	
	OnLongClickListener onLongClickListener = new OnLongClickListener() {
		
		@Override
		public boolean onLongClick(View v) {
			Log.i("AlphaAnimTestActivity", "long click");
			return false;
		}
	};
}
