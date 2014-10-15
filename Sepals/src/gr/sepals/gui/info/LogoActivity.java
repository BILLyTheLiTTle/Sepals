package gr.sepals.gui.info;

import android.app.Activity;
import android.os.Bundle;

import com.espian.showcaseview.ShowcaseView;
import com.espian.showcaseview.ShowcaseView.ConfigOptions;
import com.espian.showcaseview.ShowcaseViewBuilder;

public class LogoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_logo);
	
	ConfigOptions svConfig = new ShowcaseView.ConfigOptions();
	svConfig.hideOnClickOutside = false;
	svConfig.showcaseId = 1;
	ShowcaseViewBuilder svBuilder = new ShowcaseViewBuilder(this);
	svBuilder.setConfigOptions(svConfig);
	svBuilder.animateGesture(0.0f, 0.0f, 200.0f, 200.0f);
	svBuilder.build();
    }
}
