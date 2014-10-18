
package gr.sepals.gui.info;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.espian.showcaseview.ShowcaseView;
import com.espian.showcaseview.ShowcaseView.ConfigOptions;
import com.espian.showcaseview.targets.ViewTarget;

public class LogoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
        
        showHandGesture();
    }
    
    private void showHandGesture(){
        ImageView logo = (ImageView) findViewById(R.id.logo_imageView);
        final float startX = getResources().getDimension(R.dimen.hand_start_X);
        final float startY = getResources().getDimension(R.dimen.hand_start_Y);
        final float endX = getResources().getDimension(R.dimen.hand_end_X);
        final float endY = getResources().getDimension(R.dimen.hand_end_Y);
        ConfigOptions co = new ShowcaseView.ConfigOptions();
        co.hideOnClickOutside = true;
        ViewTarget target = new ViewTarget(logo);
        ShowcaseView sv = ShowcaseView.insertShowcaseView(target, this, R.string.slide_left_title,
                R.string.slide_left_description, co);
        sv.setScaleMultiplier(0);
        sv.animateGesture(startX, startY, endX, endY, true);
    }
}
