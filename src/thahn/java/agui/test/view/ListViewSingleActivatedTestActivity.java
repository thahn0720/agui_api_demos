package thahn.java.agui.test.view;

import thahn.java.agui.app.Bundle;
import thahn.java.agui.app.ListActivity;
import thahn.java.agui.view.View;
import thahn.java.agui.widget.ArrayAdapter;
import thahn.java.agui.widget.ListView;

/**
 * A list view where the last item the user clicked is placed in
 * the "activated" state, causing its background to highlight.
 */
public class ListViewSingleActivatedTestActivity extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Use the built-in layout for showing a list item with a single
        // line of text whose background is changes when activated.
        setListAdapter(new ArrayAdapter<String>(this,
                thahn.java.agui.R.layout.simple_list_item_activated_1, mStrings));
//        getListView().setTextFilterEnabled(true);
        
        // Tell the list view to show one checked/activated item at a time.
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        
        // Start with first item activated.
        // Make the newly clicked item the currently selected one.
        getListView().setItemChecked(0, true);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        // Make the newly clicked item the currently selected one.
        getListView().setItemChecked(position, true);
    }

    private String[] mStrings = Cheeses.sCheeseStrings;
}
