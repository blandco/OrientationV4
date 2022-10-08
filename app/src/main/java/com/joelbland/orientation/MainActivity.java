package com.joelbland.orientation;

import androidx.appcompat.app.AppCompatActivity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    public final static String MA = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.w( "MainActivity", "Inside onCreate" );
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
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
        Log.w( "MainActivity", "Inside modifyLayout" );
        if( newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE )
            setContentView( R.layout.activity_main_landscape );
        else if( newConfig.orientation == Configuration.ORIENTATION_PORTRAIT )
            setContentView( R.layout.activity_main );
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