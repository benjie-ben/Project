package th.ac.rru.csit.benjawan53023263010;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Picture extends Activity {
	Button bback2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        bback2 = (Button)findViewById(R.id.BackPicture);
        
        bback2.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent();
				i.setClass(Picture.this, MainActivity.class);
				startActivity(i);
				
			}
		});
        }
    
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_picture, menu);
        return true;
    }
}
