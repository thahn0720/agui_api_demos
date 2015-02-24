package thahn.java.agui.test.anim;

import thahn.java.agui.animation.Animation;
import thahn.java.agui.animation.AnimationUtils;
import thahn.java.agui.app.Activity;
import thahn.java.agui.app.Bundle;
import thahn.java.agui.test.R;
import thahn.java.agui.utils.Log;
import thahn.java.agui.view.View;
import thahn.java.agui.view.View.OnClickListener;

public class AnimationSetTestActivity extends Activity {

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.translate_animation);
		
        findViewById(R.id.test1).setOnClickListener(onClickListener);
        findViewById(R.id.test2).setOnClickListener(onClickListener);
	}
	
	OnClickListener onClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Log.i("AnimationSetTestActivity", "start ani");
			Animation shake = AnimationUtils.loadAnimation(AnimationSetTestActivity.this, R.anim.slide_right);
			switch (v.getId()) {
			case R.id.test1:
		        findViewById(R.id.text2).startAnimation(shake);
				break;
			case R.id.test2:
		        findViewById(R.id.root).startAnimation(shake);
				break;
			}
			invalidate();
		}
	};
}
