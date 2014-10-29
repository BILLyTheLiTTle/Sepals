package gr.sepals.eshop.info.gui;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import gr.sepals.eshop.R;

public class OrderSlidePageFragment extends Fragment {

    private TextView title, desc;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_info_order, container, false);
        title = (TextView) rootView.findViewById(R.id.info_order_title_textview);
        desc = (TextView) rootView.findViewById(R.id.info_order_description_textview);
        Typeface titleFont = Typeface.createFromAsset(getActivity().getAssets(), "fonts/GFS_Pyrsos.otf");
        Typeface descFont = Typeface.createFromAsset(getActivity().getAssets(), "fonts/GFS_Goschen-Italic.otf");
        title.setTypeface(titleFont, Typeface.BOLD);
        desc.setTypeface(descFont);
        return rootView;
    }
}
