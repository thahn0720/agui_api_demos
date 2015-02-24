package thahn.java.agui.test.view;

import thahn.java.agui.app.Activity;
import thahn.java.agui.app.Bundle;
import thahn.java.agui.test.R;
import thahn.java.agui.test.R.id;
import thahn.java.agui.test.R.layout;
import thahn.java.agui.utils.Log;
import thahn.java.agui.widget.CompoundButton;
import thahn.java.agui.widget.RadioGroup;
import thahn.java.agui.widget.RadioGroup.OnCheckedChangeListener;

public class RadioGroupTestActivity extends Activity {

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.radio_group);
		RadioGroup radioGroup = (RadioGroup) findViewById(R.id.root);
		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				if(checkedId != -1) {
					CompoundButton button = (CompoundButton) group.findViewById(checkedId);
					boolean checked = button.isChecked();
					Log.e("RadioGroupTestActivity", checkedId + " " + checked);
				} else {
					Log.e("RadioGroupTestActivity", "all clear");
				}
			}
		});
		
		radioGroup.check(R.id.radio1);
	}
}
