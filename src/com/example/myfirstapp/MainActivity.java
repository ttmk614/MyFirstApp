package com.example.myfirstapp;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import com.newrelic.agent.android.NewRelic;

public class MainActivity extends ActionBarActivity {

	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // New relic
        NewRelic.withApplicationToken( "AA61f6704ac3c4797b8273ab0eeb0cc13ebaf903bf" ).start(this.getApplication());
        
//        // add up button for low-level activities
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
/*        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;*/
    	// Inflate the menu items for use in the action bar
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.main_activity_actions, menu);
    	return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
/*        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);*/
    	// Handle presses on the action bar item
    	switch (item.getItemId()){
    		case R.id.action_search:
    			openSearch();
    			return true;
    		case R.id.action_settings:
    			openSettings();
    			return true;
    		default:
    			return super.onOptionsItemSelected(item);
    	}
    	
    }
      
    //Call when the user clicks the Send button
    public void sendMessage(View view){
    	Intent intent = new Intent(this, DisplayMessageActivity.class);
    	EditText editText = (EditText) findViewById(R.id.edit_message);
    	String message = editText.getText().toString();
    	intent.putExtra(EXTRA_MESSAGE, message);
    	startActivity(intent);
    }
    
    public void openSearch(){
    	
    }
    
    public void openSettings() {
    	
    }
}
