package org.basketball;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class BasketRecord extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket_record);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_basket_record, menu);
        return true;
    }
}
