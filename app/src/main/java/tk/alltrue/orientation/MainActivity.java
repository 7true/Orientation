package tk.alltrue.orientation;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Surface;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mButton;
    static final String ORIENTATION_PORTRAIT = "portrait";
    static final String ORIENTATION_LANDSCAPE = "landscape";
    static boolean mState = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = findViewById(R.id.button3);
        if (getScreenOrientation().equals("Portrait orientation")) {
            mButton.setText(ORIENTATION_LANDSCAPE);
        } else {
            mButton.setText(ORIENTATION_PORTRAIT);
        }
    }

    private String getScreenOrientation() {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
            return "Portrait orientation";
        else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
            return "Landscape orientation";
        return "";
    }

    private String getRotationOrientation() {
        int rotate = getWindowManager().getDefaultDisplay().getRotation();
        switch (rotate) {
            case Surface.ROTATION_0:
                return "didn't turn";
            case Surface.ROTATION_90:
                return "rotate 90 degrees";
            case Surface.ROTATION_180:
                return "rotate 180 degrees";
            case Surface.ROTATION_270:
                return "rotate 270 degrees";
            default:
                return "not clear";
        }
    }

    public void onClickOrientationButton(View view) {
        String orient = getScreenOrientation();
        TextView or = findViewById(R.id.textViewOrient);
        or.setText(orient);
    }

    public void onClickRotateButton (View view) {
        String rotation = getRotationOrientation();
        TextView or = findViewById(R.id.textViewOrient);
        or.setText(rotation);
    }

    public void onClick3(View view) {
        if(!mState) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            mButton.setText(ORIENTATION_PORTRAIT);
        }
        else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            mButton.setText(ORIENTATION_LANDSCAPE);
        }
        mState =  !mState;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Проверяем ориентацию экрана
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            recreate();
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            recreate();
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }
    }
}
