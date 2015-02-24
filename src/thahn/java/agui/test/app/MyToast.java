package thahn.java.agui.test.app;

import thahn.java.agui.app.Context;
import thahn.java.agui.app.Toast;
import thahn.java.agui.app.controller.Handler;
import thahn.java.agui.graphics.Color;
import thahn.java.agui.test.R;
import thahn.java.agui.view.LayoutInflater;
import thahn.java.agui.widget.RelativeLayout;
import thahn.java.agui.widget.TextView;

/**
 * 
 * @author Tae-Hyoung Ahn
 *
 */
public class MyToast {
	private static Toast 						mToast;
	private static Context 						mContext;
	private static String 						mMseeage;
	private static boolean						isLoop = false;
	private static RelativeLayout 				myView;
	private static TextView						mText;
	private static int							mMode;
	
	public static void init(Context context) {
		mContext = context;
		mToast = new Toast(context);
	}
	
	public static void show(String msg) {
		mMode = TYPE_WHITE;
		setText(msg);
		updateToast();
	}
	
	public static void show(String msg, int mode) {
		mMode = mode;
		setText(msg);
		updateToast();
	}
	
	public static void show(String msg, boolean loop, int mode) {
		mMode = mode;
		isLoop = loop;
		setText(msg);
		updateToast();
	}

	private static void setText(String txt) {
		mMseeage = txt;
	}

	private static void updateToast() {
		hideToast();
		switch(mMode) {
		case TYPE_NORMAL:
			createToast();
			break;
		case TYPE_WHITE:
			createToast2();
			break;
		}
		mHandler.sendEmptyMessage(mMode);
	}

	private static void createToast() {
		if (mToast == null)
			mToast = new Toast(mContext);

		if(myView == null) {
			LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
			myView = (RelativeLayout)inflater.inflate(R.layout.listview_item2, null);
			mText = (TextView) myView.findViewById(R.id.view2);
		}
		
		mToast.setDuration(Toast.LENGTH_SHORT);
		mToast.setView(myView);
	}
	
	private static void createToast2() {
		if (mToast == null)
			mToast = new Toast(mContext);

		TextView lv = new TextView(mContext);
		lv.setTextColor(Color.WHITE);
//		lv.setTypeface(Typeface.DEFAULT_BOLD);
		lv.setTextSize(15);
		mToast.setView(lv);
	}

	public static void hideToast() {
		mHandler.removeMessages(TYPE_NORMAL);
		mHandler.removeMessages(TYPE_WHITE);
		if (mToast != null) {
			mToast.cancel();
		}
	}

	public final static int TYPE_NORMAL = 0;
	public final static int TYPE_WHITE = 1;
	static Handler mHandler = new Handler() {
		@Override
		public void handleMessage(thahn.java.agui.app.controller.Message msg) {
			switch (msg.what) {
			case TYPE_NORMAL:
				mText.setText(mMseeage);
				break;
			case TYPE_WHITE:
				TextView lv = (TextView) mToast.getView();
				lv.setText(mMseeage);
				break;
			}
			mToast.show();
			this.removeMessages(msg.what);
			if(isLoop) this.sendEmptyMessageDelayed(msg.what, 100);
		};
	};
	
	public static void setLoop(boolean loop) {
		isLoop = loop;
	}
}
