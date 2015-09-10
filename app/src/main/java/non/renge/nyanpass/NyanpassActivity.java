package non.renge.nyanpass;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class NyanpassActivity extends Activity {
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nyanpass);

        //initialize the count
        SharedPreferences sharedPref = NyanpassActivity.this.getPreferences(Context.MODE_PRIVATE);
        count = sharedPref.getInt(getString(R.string.nyanpass_count), 0);
        TextView countView = (TextView) findViewById(R.id.nyanpass_count);
        countView.setText(Integer.toString(count));
    }

    public void nyanpassButton(View view){
        //play the audio
        new Thread(new Runnable() {
            @Override
            public void run() {
                //create & play
                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.nyanpass);
                mediaPlayer.start();
                //wait for it to finish
                try {
                    Thread.sleep(1500)             ;
                }catch(Exception e){}
                //release & delete it
                mediaPlayer.release();
                mediaPlayer = null;
            }
        }).start();
        //increment
        incrementCount();
    }

    private void incrementCount(){
        count++;
        //update display
        TextView countView = (TextView) findViewById(R.id.nyanpass_count);
        countView.setText(Integer.toString(count));
        //save new count
        SharedPreferences sharedPref = NyanpassActivity.this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(getString(R.string.nyanpass_count),count);
        editor.commit();
    }
}
