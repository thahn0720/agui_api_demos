package thahn.java.agui.test.view;




import thahn.java.agui.app.Activity;
import thahn.java.agui.app.Bundle;
import thahn.java.agui.app.Context;
import thahn.java.agui.test.R;
import thahn.java.agui.utils.Log;
import thahn.java.agui.view.LayoutInflater;
import thahn.java.agui.view.View;
import thahn.java.agui.view.View.OnClickListener;
import thahn.java.agui.view.ViewGroup;
import thahn.java.agui.view.ViewGroup.LayoutParams;
import thahn.java.agui.widget.BaseAdapter;
import thahn.java.agui.widget.Button;
import thahn.java.agui.widget.CheckBox;
import thahn.java.agui.widget.EditText;
import thahn.java.agui.widget.GridView;
import thahn.java.agui.widget.ImageView;
import thahn.java.agui.widget.LinearLayout;
import thahn.java.agui.widget.ListView;
import thahn.java.agui.widget.RadioButton;
import thahn.java.agui.widget.RadioGroup;
import thahn.java.agui.widget.ShellView;
import thahn.java.agui.widget.TextView;

public class CodeViewTestActivity extends Activity {

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		// linearlayout
		LinearLayout linear = new LinearLayout(this);
		linear.setOrientation(LinearLayout.VERTICAL);
		// textview
		TextView textView = new TextView(this);
		textView.setText("textView");
		linear.addView(textView);
		// edittext
		EditText editText = new EditText(this);
		editText.setText("editText");
		linear.addView(editText);
		// button
		Button button = new Button(this);
		button.setText("button");
		linear.addView(button);
		// imageview
		ImageView imageView = new ImageView(this);
		imageView.setImageResource(R.drawable.progressbar0);
		linear.addView(imageView);
		// checkbox
		CheckBox checkbox = new CheckBox(this);
		checkbox.setText("checkbox");
		linear.addView(checkbox);
		// progressbar
//		ProgressBar progressbar = new ProgressBar(this);
//		linear.addView(progressbar);
		// radiogroup
		RadioGroup radiogroup = new RadioGroup(this);
		RadioButton radiobutton1 = new RadioButton(this);
		RadioButton radiobutton2 = new RadioButton(this);
		radiobutton1.setText("radiobutton1");
		radiobutton2.setText("radiobutton2");
		radiogroup.addView(radiobutton1);
		radiogroup.addView(radiobutton2);
		linear.addView(radiogroup);
		// shellview
		java.awt.Button awtButton = new java.awt.Button("awt button");
		ShellView shellView = new ShellView(this, awtButton, 200, 50);
		shellView.setLayoutParams(new LayoutParams(300, 50));
		shellView.setComponent(awtButton);
		linear.addView(shellView);
		// gridview
		GridView gridView = new GridView(this);
		gridView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		gridView.setAdapter(new GridTestAdapter(this));
		gridView.setNumColumns(4);
		linear.addView(gridView);
		// listview
		ListView listView = new ListView(this);
		listView.setLayoutParams(new LayoutParams(400, LayoutParams.WRAP_CONTENT));
		listView.setAdapter(new ListTestAdapter(this));
		linear.addView(listView);
		// FIXME : add view 를 먼저 해야 하는 문제 
		// scrollview
		// horizontalscrollview
		// relativelayout
		// framelayout
		// 
		setContentView(linear);
	}
	
	class ListTestAdapter extends BaseAdapter {
    	
		Context mContext;
		int count = 0;
		
        public ListTestAdapter(Context context) {
            mContext = context;
        }
        
        public int getCount() {
//        	return 45;
            return 15;
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
            	convertView = LayoutInflater.inflate(CodeViewTestActivity.this, R.layout.listview_item2, null);
            	convertView.findViewById(R.id.view1).setOnClickListener(onClickListener);
            } else {
            	
            }
            ((TextView)convertView.findViewById(R.id.view2)).setText(""+position);
            
            return convertView;
        }
        
        OnClickListener onClickListener = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.e("clicked");
			}
		};
    }
	
	class GridTestAdapter extends BaseAdapter {
    	
		Context mContext;
		int count = 0;
		
        public GridTestAdapter(Context context) {
            mContext = context;
        }
        
        public int getCount() {
//        	return 45;
            return 10;
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
            	convertView = new TextView(CodeViewTestActivity.this);
            } else {
            	
            }
            ((TextView)convertView).setText(""+position);
            
            return convertView;
        }
        
        OnClickListener onClickListener = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.e("clicked");
			}
		};
    }
}
