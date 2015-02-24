package thahn.java.agui.test.anim;

import thahn.java.agui.animation.Animation;
import thahn.java.agui.animation.AnimationUtils;
import thahn.java.agui.app.Activity;
import thahn.java.agui.app.Bundle;
import thahn.java.agui.test.R;
import thahn.java.agui.view.View;
import thahn.java.agui.view.View.OnClickListener;

public class InterpolatorTestActivity extends Activity {

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.interpolator);
		
        findViewById(R.id.text1).setOnClickListener(onClickListener);
        findViewById(R.id.accelerate_decelerate).setOnClickListener(onClickListener);
        findViewById(R.id.accelerate).setOnClickListener(onClickListener);
        findViewById(R.id.anticipate).setOnClickListener(onClickListener);
        findViewById(R.id.anticipate_overshoot).setOnClickListener(onClickListener);
        findViewById(R.id.bounce).setOnClickListener(onClickListener);
        findViewById(R.id.cycle).setOnClickListener(onClickListener);
        findViewById(R.id.decelerate).setOnClickListener(onClickListener);
        findViewById(R.id.linear).setOnClickListener(onClickListener);
        findViewById(R.id.overshoot).setOnClickListener(onClickListener);
	}
	
	OnClickListener onClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Animation shake = AnimationUtils.loadAnimation(InterpolatorTestActivity.this, R.anim.hold);
			switch (v.getId()) {
			case R.id.accelerate_decelerate:
				shake.setInterpolator(InterpolatorTestActivity.this, thahn.java.agui.R.anim.accelerate_decelerate_interpolator);
				break;
			case R.id.accelerate:
				shake.setInterpolator(InterpolatorTestActivity.this, thahn.java.agui.R.anim.accelerate_interpolator);
				break;
			case R.id.anticipate:
				shake.setInterpolator(InterpolatorTestActivity.this, thahn.java.agui.R.anim.anticipate_interpolator);
				break;
			case R.id.anticipate_overshoot:
				shake.setInterpolator(InterpolatorTestActivity.this, thahn.java.agui.R.anim.anticipate_overshoot_interpolator);
				break;
			case R.id.bounce:
				shake.setInterpolator(InterpolatorTestActivity.this, thahn.java.agui.R.anim.bounce_interpolator);
				break;
			case R.id.cycle:
				shake.setInterpolator(InterpolatorTestActivity.this, thahn.java.agui.R.anim.cycle_interpolator);
				break;
			case R.id.decelerate:
				shake.setInterpolator(InterpolatorTestActivity.this, thahn.java.agui.R.anim.decelerate_interpolator);
				break;
			case R.id.linear:
				shake.setInterpolator(InterpolatorTestActivity.this, thahn.java.agui.R.anim.linear_interpolator);
				break;
			case R.id.overshoot:
				shake.setInterpolator(InterpolatorTestActivity.this, thahn.java.agui.R.anim.overshoot_interpolator);
				break;
			}
			shake.setDuration(2000);
	        findViewById(R.id.text1).startAnimation(shake);
	        invalidate();
		}
	};
}
