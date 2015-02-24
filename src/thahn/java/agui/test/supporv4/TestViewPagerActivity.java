package thahn.java.agui.test.supporv4;

import thahn.java.agui.app.Activity;
import thahn.java.agui.app.Bundle;
import thahn.java.agui.app.Context;
import thahn.java.agui.app.Toast;
import thahn.java.agui.os.Parcelable;
import thahn.java.agui.test.R;
import thahn.java.agui.view.LayoutInflater;
import thahn.java.agui.view.View;
import thahn.java.agui.view.View.OnClickListener;
import thahn.java.agui.widget.Button;
import agui.support.v4.view.PagerAdapter;
import agui.support.v4.view.ViewPager;

public class TestViewPagerActivity extends Activity implements OnClickListener{
	
	private ViewPager mPager;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewpager_main);
		
		setLayout();
		
		mPager = (ViewPager)findViewById(R.id.pager);
		mPager.setAdapter(new PagerAdapterClass(getApplicationContext()));
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_one:
			setCurrentInflateItem(0);
			break;
		case R.id.btn_two:
			setCurrentInflateItem(1);
			break;
		case R.id.btn_three:
			setCurrentInflateItem(2);
			break;
		}
	}
	
	private void setCurrentInflateItem(int type){
		if(type==0){
			mPager.setCurrentItem(0);
		}else if(type==1){
			mPager.setCurrentItem(1);
		}else{
			mPager.setCurrentItem(2);
		}
	}
	
	private Button btn_one;
	private Button btn_two;
	private Button btn_three;
	
	/*
	 * Layout
	 */
	private void setLayout(){
		btn_one = (Button) findViewById(R.id.btn_one);
		btn_two = (Button) findViewById(R.id.btn_two);
		btn_three = (Button) findViewById(R.id.btn_three);
		
		btn_one.setOnClickListener(this);
		btn_two.setOnClickListener(this);
		btn_three.setOnClickListener(this);
	}
	
	private View.OnClickListener mPagerListener = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			String text = ((Button)v).getText().toString();
			Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
		}
	};
	
	/**
	 * PagerAdapter 
	 */
	private class PagerAdapterClass extends PagerAdapter{
		
		private LayoutInflater mInflater;

		public PagerAdapterClass(Context c){
			super();
			mInflater = LayoutInflater.from(c);
		}
		
		@Override
		public int getCount() {
			return 3;
		}

		@Override
		public Object instantiateItem(View pager, int position) {
			View v = null;
    		if(position==0){
    			v = mInflater.inflate(R.layout.inflate_one, null);
    			v.findViewById(R.id.iv_one);
    			v.findViewById(R.id.btn_click).setOnClickListener(mPagerListener);
    		}
    		else if(position==1){
    			v = mInflater.inflate(R.layout.inflate_two, null);
    			v.findViewById(R.id.iv_two);
    			v.findViewById(R.id.btn_click_2).setOnClickListener(mPagerListener);
    		}else{
    			v = mInflater.inflate(R.layout.inflate_three, null);
    			v.findViewById(R.id.iv_three); 
    			v.findViewById(R.id.btn_click_3).setOnClickListener(mPagerListener);
    		}
    		
    		((ViewPager)pager).addView(v, 0);
    		
    		return v; 
		}

		@Override
		public void destroyItem(View pager, int position, Object view) {	
			((ViewPager)pager).removeView((View)view);
		}
		
		@Override
		public boolean isViewFromObject(View pager, Object obj) {
			return pager == obj; 
		}

		@Override public void restoreState(Parcelable arg0, ClassLoader arg1) {}
		@Override public Parcelable saveState() { return null; }
		@Override public void startUpdate(View arg0) {}
		@Override public void finishUpdate(View arg0) {}
	}
}
