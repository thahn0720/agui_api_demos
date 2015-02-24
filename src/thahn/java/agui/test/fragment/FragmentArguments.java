package thahn.java.agui.test.fragment;

import thahn.java.agui.app.Activity;
import thahn.java.agui.app.Bundle;
import thahn.java.agui.app.Fragment;
import thahn.java.agui.app.FragmentTransaction;
import thahn.java.agui.test.R;
import thahn.java.agui.view.AttributeSet;
import thahn.java.agui.view.LayoutInflater;
import thahn.java.agui.view.View;
import thahn.java.agui.view.ViewGroup;
import thahn.java.agui.widget.TextView;

/**
 * Demonstrates a fragment that can be configured through both Bundle arguments
 * and layout attributes.
 */
public class FragmentArguments extends Activity {

    @Override 
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_arguments);

        if (savedInstanceState == null) {
            // First-time init; create fragment to embed in activity.
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            Fragment newFragment = MyFragment.newInstance("From Arguments");
            ft.add(R.id.created, newFragment);
            ft.commit();
        }
    }

    public static class MyFragment extends Fragment {
        CharSequence mLabel;

        public MyFragment() {
			super();
		}

		/**
         * Create a new instance of MyFragment that will be initialized
         * with the given arguments.
         */
        static MyFragment newInstance(String label) {
            MyFragment f = new MyFragment();
            Bundle b = new Bundle();
            b.putString("label", label);
            f.setArguments(b);
            return f;
        }

        /**
         * Parse attributes during inflation from a view hierarchy into the
         * arguments we handle.
         */
        @Override 
        public void onInflate(Activity activity, AttributeSet attrs,
                Bundle savedInstanceState) {
            super.onInflate(activity, attrs, savedInstanceState);

//            TypedArray a = activity.obtainStyledAttributes(attrs,
//                    R.styleable.FragmentArguments);
            mLabel = attrs.getString(thahn.java.agui.R.attr.fragment_label, "label"); 
//            		a.getText(R.styleable.FragmentArguments_android_label);
//            a.recycle();
        }

        /**
         * During creation, if arguments have been supplied to the fragment
         * then parse those out.
         */
        @Override 
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            Bundle args = getArguments();
            if (args != null) {
                mLabel =// "onCreate mLabel"; 
                		args.getString("label");//, mLabel);
            }
        }

        /**
         * Create the view for this fragment, using the arguments given to it.
         */
        @Override 
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.hello_world, container, false);
            View tv = v.findViewById(R.id.text);
            ((TextView)tv).setText(mLabel != null ? mLabel : "(no label)");
//            tv.setBackgroundDrawable(getResources().getDrawable(android.R.drawable.gallery_thumb));
            return v;
        }
    }

}
