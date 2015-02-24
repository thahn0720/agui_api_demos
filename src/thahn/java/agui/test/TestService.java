package thahn.java.agui.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import thahn.java.agui.ContextMenu;
import thahn.java.agui.Global;
import thahn.java.agui.app.Dialog;
import thahn.java.agui.app.Intent;
import thahn.java.agui.app.Service;
import thahn.java.agui.media.MediaPlayer;
import thahn.java.agui.utils.Log;

public class TestService extends Service {
	
	private MediaPlayer 																mMp = new MediaPlayer();
	
	@Override
	public void onCreate() {
		super.onCreate();
//		PopupMenu menu = new PopupMenu("test");
//		menu.add("1");
//		menu.add("2");
		ContextMenu menu = new ContextMenu("test");
		menu.add("1");
		menu.add("2");
		setTray(this, "test", R.drawable.test, menu, mActionListener);
	}
	
	ActionListener mActionListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
		}
	};

	@Override	
	public int onStartCommand(Intent intent, int flags, int startId) {
		try {
			//
//			showDialog(0);			// non-blocking
//			showDialog(0, true);	// blocking
			//
			Log.i("start music");
			mMp = new MediaPlayer();
			mMp.setDataSource(Global.projectPath+"/res/raw/test.mp3");
			mMp.prepare();
			mMp.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.onStartCommand(intent, flags, startId);
	}
	
	@Override
	public Dialog onCreateDialog(int i) {
		Dialog dialog = new Dialog(getApplicationContext());
		dialog.setContentView(R.layout.dialog);
		return dialog;
	}

	@Override
	public void stopSelf() {
		Log.i("stop music");
		mMp.stop();
		super.stopSelf();
	}
}
