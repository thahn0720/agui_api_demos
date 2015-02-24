package thahn.java.agui.test.app;

import thahn.java.agui.app.Activity;
import thahn.java.agui.app.Bundle;
import thahn.java.agui.app.Context;
import thahn.java.agui.app.controller.Handler;
import thahn.java.agui.app.controller.Message;
import thahn.java.agui.test.R;
import thahn.java.agui.test.R.id;
import thahn.java.agui.test.R.layout;
import thahn.java.agui.utils.Log;
import thahn.java.agui.view.LayoutInflater;
import thahn.java.agui.view.View;
import thahn.java.agui.view.View.OnClickListener;
import thahn.java.agui.view.ViewGroup;
import thahn.java.agui.widget.BaseAdapter;
import thahn.java.agui.widget.ListView;
import thahn.java.agui.widget.TextView;

public class SetResultTestActivity extends Activity {

	TextView mTextView;
	
	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.listview);
		ListView list = (ListView) findViewById(R.id.listview);
		list.setAdapter(new TestAdapter(this));
		
		mHandler.sendEmptyMessageDelayed(0, 4000);
	}
	
	Handler mHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			Log.e("message arrive.");
			setResult(RESULT_OK);
			finish();
		}
	};
	
	class TestAdapter extends BaseAdapter {
    	
		Context mContext;
		int count = 0;
		
        public TestAdapter(Context context) {
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
            	convertView = LayoutInflater.inflate(SetResultTestActivity.this, R.layout.listview_item2, null);
//            	convertView.findViewById(R.id.view1).setOnClickListener(onClickListener);
            } else {
            	
            }
//            ((TextView)convertView.findViewById(R.id.view2)).setText(""+position);
            
            return convertView;
        }
        
        OnClickListener onClickListener = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.e("clicked");
				mHandler.sendEmptyMessage(0);
			}
		};
    }
}
