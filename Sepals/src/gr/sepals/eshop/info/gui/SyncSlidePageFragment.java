
package gr.sepals.eshop.info.gui;

import gr.sepals.eshop.R;
import gr.sepals.eshop.persistence.InternalDatabaseKeys;
import gr.sepals.eshop.persistence.InternalDatabasePredefinedValues;
import gr.sepals.eshop.util.db.Settings;
import gr.sepals.eshop.util.device.DeviceOptionsHandler;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class SyncSlidePageFragment extends Fragment implements OnClickListener {

    private RadioGroup memoryOption;
    private RadioButton internal, embedded, removable;
    private Button sync, exit;
    private TextView title, desc;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_info_sync, container, false);
        if (getResources().getBoolean(R.bool.isTablet)){
            title = (TextView) rootView.findViewById(R.id.info_sync_title_textview);
            Typeface titleFont = Typeface.createFromAsset(getActivity().getAssets(), "fonts/GFS_Pyrsos.otf");
            title.setTypeface(titleFont, Typeface.BOLD);
        }
        desc = (TextView) rootView.findViewById(R.id.info_sync_description_textview);
        Typeface descFont = Typeface.createFromAsset(getActivity().getAssets(), "fonts/GFS_Goschen-Italic.otf");
        desc.setTypeface(descFont);

        memoryOption = (RadioGroup) rootView.findViewById(R.id.memory_radioGroup);
        internal = (RadioButton) rootView.findViewById(R.id.internal_memory_radiobutton);
        internal.setTypeface(descFont);
        internal.setOnClickListener(this);
        embedded = (RadioButton) rootView.findViewById(R.id.embedded_memory_radiobutton);
        embedded.setTypeface(descFont);
        embedded.setOnClickListener(this);
        removable = (RadioButton) rootView.findViewById(R.id.removable_memory_radiobutton);
        removable.setTypeface(descFont);
        removable.setOnClickListener(this);

        sync = (Button) rootView.findViewById(R.id.sync_button);
        sync.setOnClickListener(this);
        exit = (Button) rootView.findViewById(R.id.exit_button);
        exit.setOnClickListener(this);

        // update the fragment content
        String selectedStorage = Settings.getString(getActivity(),
                InternalDatabaseKeys.PRODUCTS_DB_STORAGE_OPTION,
                InternalDatabasePredefinedValues.PRODUCTS_DB_NONE_STORAGE);
        if (selectedStorage.equals(InternalDatabasePredefinedValues.PRODUCTS_DB_INTERNAL_STORAGE)) {
            memoryOption.check(R.id.internal_memory_radiobutton);
            sync.setEnabled(true);
        }
        else if (selectedStorage
                .equals(InternalDatabasePredefinedValues.PRODUCTS_DB_EMBEDDED_STORAGE)) {
            memoryOption.check(R.id.embedded_memory_radiobutton);
            sync.setEnabled(true);
        }
        else if (selectedStorage
                .equals(InternalDatabasePredefinedValues.PRODUCTS_DB_REMOVABLE_STORAGE)) {
            memoryOption.check(R.id.removable_memory_radiobutton);
            sync.setEnabled(true);
        }
        else {
            sync.setEnabled(false);
        }
        return rootView;
    }

    @Override
    public void onClick(View v) {
        if (v == sync) {
            //start syncing
        }
        else if (v == exit) {
            getActivity().finish();
        }
        else if (v instanceof RadioButton) {
            if (v == internal) {
                Toast.makeText(
                        getActivity(),
                        String.format(getString(R.string.free_internal_memory),
                                DeviceOptionsHandler.ByteToGB(DeviceOptionsHandler
                                        .checkAvailableInternalMemory(getActivity()))),
                        Toast.LENGTH_LONG).show();
                Settings.setString(getActivity(), InternalDatabaseKeys.PRODUCTS_DB_STORAGE_OPTION,
                        InternalDatabasePredefinedValues.PRODUCTS_DB_INTERNAL_STORAGE);
            }
            else if (v == embedded) {
                Toast.makeText(
                        getActivity(),
                        String.format(
                                getString(R.string.free_embedded_memory),
                                DeviceOptionsHandler.ByteToGB(DeviceOptionsHandler
                                        .checkAvailableEmbeddedExternalMemory(getActivity()))),
                        Toast.LENGTH_LONG).show();
                Settings.setString(getActivity(), InternalDatabaseKeys.PRODUCTS_DB_STORAGE_OPTION,
                        InternalDatabasePredefinedValues.PRODUCTS_DB_EMBEDDED_STORAGE);
            }
            else if (v == removable) {
                Toast.makeText(
                        getActivity(),
                        String.format(getString(R.string.free_removable_memory),
                                DeviceOptionsHandler.ByteToGB(DeviceOptionsHandler
                                        .checkAvailableExternalMemory(getActivity()))),
                        Toast.LENGTH_LONG).show();
                Settings.setString(getActivity(), InternalDatabaseKeys.PRODUCTS_DB_STORAGE_OPTION,
                        InternalDatabasePredefinedValues.PRODUCTS_DB_REMOVABLE_STORAGE);
            }
            sync.setEnabled(true);
        }
    }
}
