package com.joelbland.orientation;

import androidx.appcompat.app.AppCompatActivity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public final static String MA = "MainActivity";
    public final static int SPACING_VERTICAL = 50;
    public final static int SPACING_HORIZONTAL = 25;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.w( "MainActivity", "Inside onCreate" );
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Configuration config = getResources( ).getConfiguration( );
        modifyLayout( config );
    }

    // V1 code
    public void onConfigurationChanged( Configuration newConfig ) {
        Log.w( "MainActivity", "Inside onConfigurationChanged" );
        super.onConfigurationChanged( newConfig );
        modifyLayout( newConfig );
    }

    public void modifyLayout( Configuration newConfig ) {
        Button b2 = ( Button ) findViewById( R.id.button2 );
        ViewGroup.MarginLayoutParams params2
                = (ViewGroup.MarginLayoutParams) b2.getLayoutParams( );
        Button b3 = ( Button ) findViewById( R.id.button3 );
        ViewGroup.MarginLayoutParams params3
                = (ViewGroup.MarginLayoutParams) b3.getLayoutParams( );

        if( newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE ) {
            params2.setMargins( 0, SPACING_HORIZONTAL, 0, 0 );
            params3.setMargins( 0, SPACING_HORIZONTAL, 0, 0 );
        } else if( newConfig.orientation
                == Configuration.ORIENTATION_PORTRAIT ) {
            params2.setMargins( 0, SPACING_VERTICAL, 0, 0 );
            params3.setMargins( 0, SPACING_VERTICAL, 0, 0 );
        }
    }

    // V0 code
   /* public void onConfigurationChanged( Configuration newConfig ) {
        super.onConfigurationChanged( newConfig );
        System.out.println("From onConfigChanged Method!!!");
        Log.w( MA, "Height: " + newConfig.screenHeightDp );
        Log.w( MA, "Width: " + newConfig.screenWidthDp );

        Log.w( MA, "Orientation: " + newConfig.orientation );
        if( newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE )
            Log.w( MA, "Horizontal position" );
        else if( newConfig.orientation == Configuration.ORIENTATION_PORTRAIT )
            Log.w( MA, "Vertical position" );
        else
            Log.w( MA, "Undetermined position" );
    }*/

}