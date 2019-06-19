package com.example.basicactivity;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Snackbar mSnackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSnackbar = Snackbar.make(view,getResources().getString(R.string.snackbar_text),
                        Snackbar.LENGTH_INDEFINITE).setAction("ПокАрмил", snackbarOnClickListener).setActionTextColor(Color.GREEN);

                View snackbarView = mSnackbar.getView();
                snackbarView.setBackgroundColor(Color.BLUE);
                TextView snackTextView = snackbarView.findViewById(com.google.android.material.R.id.snackbar_text);
                snackTextView.setTextColor(Color.WHITE);
                snackTextView.setTextSize(18);

                mSnackbar.show();
                mSnackbar.addCallback(new Snackbar.Callback() {
                    @Override
                    public void onDismissed(Snackbar snackbar, int event) {
                        switch(event){
                            case Snackbar.Callback.DISMISS_EVENT_ACTION:
                                Log.i("Snackbar", "Закрыт по DISMISS_EVENT_ACTION.");
                                break;
                            case Snackbar.Callback.DISMISS_EVENT_CONSECUTIVE:
                                Log.i("Snackbar", "Закрыт по DISMISS_EVENT_CONSECUTIVE.");
                                break;
                            case Snackbar.Callback.DISMISS_EVENT_MANUAL:
                                Log.i("Snackbar", "Закрыт по DISMISS_EVENT_MANUAL.");
                                break;
                            case Snackbar.Callback.DISMISS_EVENT_SWIPE:
                                Log.i("Snackbar", "Закрыт по DISMISS_EVENT_SWIPE.");
                                break;
                            case Snackbar.Callback.DISMISS_EVENT_TIMEOUT:
                                Log.i("Snackbar", "Закрыт по DISMISS_EVENT_TIMEOUT.");
                                break;
                        }
                    }
                    @Override
                    public void onShown(Snackbar snackbar){
                        Log.i("SnackBar", "onShown");
                    }
                });
            }
        });

        Button dismissButton = findViewById(R.id.button_dismiss);
        dismissButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if(mSnackbar != null) mSnackbar.dismiss();
            }
        });
    }

    View.OnClickListener snackbarOnClickListener = new View.OnClickListener() {
      @Override
      public void onClick(View view){
          Toast.makeText(getApplicationContext(), "Ну и молодец!", Toast.LENGTH_LONG).show();
      }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
