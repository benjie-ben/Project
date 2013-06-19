package th.ac.rru.csit.benjawan53023263010;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class Video extends Activity {
	Button bback3;
	VideoView vd;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        bback3 = (Button)findViewById(R.id.BackVideo);
        vd = (VideoView)findViewById(R.id.videoView1);
        
        MediaController mc = new MediaController(this);
        mc.setAnchorView(vd);
        mc.setMediaPlayer(vd);
        
        vd.setMediaController(mc);
        vd.setVideoPath("http://ladyshoppingz.com/korkai.3gp");
        vd.start();
        
        bback3.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent();
				i.setClass(Video.this, MainActivity.class);
				startActivity(i);
				
			}
		});
        }
    
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_video, menu);
        return true;
    }
}
