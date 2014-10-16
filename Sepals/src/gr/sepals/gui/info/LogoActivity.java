package gr.sepals.gui.info;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.espian.showcaseview.ShowcaseView;
import com.espian.showcaseview.targets.ViewTarget;

public class LogoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_logo);
	
	View showcasedView = findViewById(R.id.logo_imageView);
	ViewTarget target = new ViewTarget(showcasedView);
	ShowcaseView sv = ShowcaseView.insertShowcaseView(target, this, R.string.ok, R.string.ok);
	sv.setScaleMultiplier(0);
	sv.animateGesture(500, 500, 200, 500, true);
    }
}
