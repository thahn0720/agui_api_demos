package thahn.java.agui.test.view;

import thahn.java.agui.app.Activity;
import thahn.java.agui.app.Bundle;
import thahn.java.agui.app.Context;
import thahn.java.agui.test.R;
import thahn.java.agui.view.LayoutInflater;
import thahn.java.agui.view.View;
import thahn.java.agui.view.ViewGroup;
import thahn.java.agui.widget.BaseAdapter;
import thahn.java.agui.widget.Button;
import thahn.java.agui.widget.ListView;
import thahn.java.agui.widget.TextView;

public class ListViewHeaderFooterTestActivity extends Activity {

	TextView mTextView;
	TestAdapter mAdapter;
	
	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.listview);//"listview.xml");
		ListView list = (ListView) findViewById(R.id.listview);
		Button header = new Button(this);
		header.setText("headerheaderheaderheaderheaderheaderheaderheaderheaderheaderheaderheaderheaderheaderheaderheaderheaderheaderheaderheader");
		list.addHeaderView(header);
		Button footer = new Button(this);
		footer.setText("footerfooterfooterfooterfooterfooterfooterfooterfooterfooterfooterfooterfooterfooterfooterfooterfooterfooterfooterfooter");
		list.addFooterView(footer);
		//
		mAdapter = new TestAdapter(this);
		list.setAdapter(mAdapter);
	}
	
	class TestAdapter extends BaseAdapter {
		String[] mText = {"1test\ntest\ntest\ntest\ntest\ntesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest"
						 , "2testtesttesttesttesttesttest\ntest\ntesttest\ntesttesttesttesttesttesttesttesttesttesttesttesttesttest"
						 , "3testtesttesttesttesttesttesttesttesttesttest\ntesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest"
						 , "4test\ntest"
						 , "5test\ntest\ntesttesttesttesttesttesttesttesttesttesttest"
						 , "6testtesttesttest\n\ntest\ntesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest"
						 , "7testtesttesttesttesttest\n\n\n\n\ntesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest"
						 , "8testtesttesttesttesttesttest\n\n\n\ntesttesttesttesttesttesttest\ntesttesttesttesttesttesttesttesttesttesttesttesttesttesttest"
						 , "9test"
						 , "10testtesttesttesttesttesttesttesttesttesttesttesttesttesttesttest\ntesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest"
		};
    	
		Context mContext;
		int count = 10;
		
        public TestAdapter(Context context) {
            mContext = context;
        }
        
        public void setCount(int num) {
        	count = num;
        }
        
        public int getCount() {
//        	return 45;
            return count;
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
        	View view = null;
            if (convertView == null) {
//            	convertView = LayoutInflater.inflate(ListViewTestActivity.this, R.layout.listview_item2//Global.layoutPath+"listview_item2.xml"
            	view = LayoutInflater.inflate(ListViewHeaderFooterTestActivity.this, R.layout.listview_item2, null); 
//					
//					@Override
//					public void onClick(View v) {
//						Log.e("clicked "+v.getTag());
//					}
//				});
            } else {
            	view = convertView;
            }
            ((TextView)view.findViewById(R.id.view2)).setText(mText[position%count]);
            
            return view;
        }
    }
}
