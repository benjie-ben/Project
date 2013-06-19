package th.ac.rru.csit.benjawan53023263010;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
import android.os.Bundle;

import static android.provider.BaseColumns._ID;
import static th.ac.rru.csit.benjawan53023263010.Constants.*;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.format.DateFormat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Date;


public class Database extends Activity {
	Button bback1;
	private NotesHelper helper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        
        bback1 = (Button)findViewById(R.id.BackDatabase);
        
        bback1.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent();
				i.setClass(Database.this, MainActivity.class);
				startActivity(i);
				
			}
		});
        
        
        helper = new NotesHelper(this);
        try {
        	Cursor cursor = getAllNotes();
        	showNotes(cursor);
        }
        finally {
        	helper.close();
        }
        
        final EditText txtNewText = (EditText) findViewById(R.id.editText1);
        Button btnSave = (Button) findViewById(R.id.bsave);
        
        // กำหนด Listener ให้กับปุ่ม เมื่อปุ่มถูกคลิก
        btnSave.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
            	try {
                    addNote(txtNewText.getText().toString());
                	Cursor cursor = getAllNotes();
                	showNotes(cursor);
                	txtNewText.setText(null);
            	}
            	finally {
            		helper.close();
            	}
            }
        });
        
     }
    
    private void addNote(String str) {
    	SQLiteDatabase db = helper.getWritableDatabase();
    	ContentValues values = new ContentValues();
    	values.put(TIME, System.currentTimeMillis());
    	values.put(CONTENT, str);
    	db.insertOrThrow(TABLE_NAME, null, values);
    }
    
    private static String[] COLUMNS = { _ID, TIME, CONTENT };
    private static String ORDER_BY = TIME + " DESC";
    private Cursor getAllNotes() {
    	SQLiteDatabase db = helper.getReadableDatabase();
    	Cursor cursor = db.query(TABLE_NAME, COLUMNS, null, null, null, null, ORDER_BY);
    	startManagingCursor(cursor);
    	return cursor;
    }
    
    private void showNotes(Cursor cursor) {
    	StringBuilder builder = new StringBuilder("ข้อความที่บันทึกไว้:\n\n");
    	
    	while (cursor.moveToNext()) {
    		long id = cursor.getLong(0);          // อ่านข้อมูลจากคอลัมน์ _id
    		long time = cursor.getLong(1);        // อ่านข้อมูลจากคอลัมน์ time
    		String content = cursor.getString(2); // อ่านข้อมูลจากคอลัมน์ content

    		builder.append("ลำดับ ").append(id).append(": ");
            // แปลงค่า Timestamp เป็นออบเจ็ค Date แล้วจัดรูปแบบวันเวลาให้ดูง่าย
    		String strDate = (String) DateFormat.format("yyyy-MM-dd hh:mm:ss", new Date(time));
    		builder.append(strDate).append("\n");
    		builder.append("\t").append(content).append("\n");
    	}
    	
    	TextView tv = (TextView) findViewById(R.id.textView2);
    	tv.setText(builder);
    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_database, menu);
        return true;
    }
}
