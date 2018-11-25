package tk.alltrue.orientation;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Surface;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        TextView or = (TextView) findViewById(R.id.textViewOrient);
        or.setText(orient);
    }

    public void onClickRotateButton (View view) {
        String rotation = getRotationOrientation();
        TextView or = (TextView) findViewById(R.id.textViewOrient);
        or.setText(rotation);
    }

}
