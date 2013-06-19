package th.ac.rru.csit.benjawan53023263010;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculator extends Activity {
	Button bback,bplus;
	EditText edt1,edt2;
	TextView tv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        
        bback = (Button)findViewById(R.id.BackCalculator);
        bplus = (Button)findViewById(R.id.plus);
        edt1 = (EditText)findViewById(R.id.editText1);
        edt2 = (EditText)findViewById(R.id.editText2);
        tv = (TextView)findViewById(R.id.textView2);
        
        bback.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent();
				i.setClass(Calculator.this, MainActivity.class);
				startActivity(i);
				
			}
		});
        
        bplus.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				tv.setText( Integer.parseInt(edt1.getText().toString())+
							Integer.parseInt(edt2.getText().toString())+ 
							"");
				
			}
		});
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_calculator, menu);
        return true;
    }
}
