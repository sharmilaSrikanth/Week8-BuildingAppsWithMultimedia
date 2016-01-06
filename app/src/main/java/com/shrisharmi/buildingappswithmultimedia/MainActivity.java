package com.shrisharmi.buildingappswithmultimedia;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private File imageFile;
    Button button;
    ImageView imageView;
    static final int CAM_REQUEST =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // setVolumeControlStream(AudioManager.STREAM_MUSIC);
        Button playme = (Button)findViewById(R.id.button);

        final MediaPlayer sleepaway1 = MediaPlayer.create(MainActivity.this, R.raw.sleepaway);
        button = (Button) findViewById(R.id.button2);
        imageView = (ImageView) findViewById(R.id.image_view);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file = getFile();
                camera_intent.putExtra(MediaStore.EXTRA_OUTPUT,Uri.fromFile(file));
                startActivityForResult(camera_intent, CAM_REQUEST);



            }
        });
        playme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sleepaway1.isPlaying()) {
                    sleepaway1.seekTo(0);//go to the beginning if the audio file is playing
                } else {
                    sleepaway1.start();
                }

            }


        });

    }

    private File getFile()
    {
        File folder = new File("sdcard/camera_app");
        if(!folder.exists()) {
            folder.mkdir();
        }
        File image_file = new File(folder, "cam_image.jpg");

        return image_file;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        String path = "sdcard/camera_app/cam_image.jpg";
        imageView.setImageDrawable(Drawable.createFromPath(path));
    }








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
