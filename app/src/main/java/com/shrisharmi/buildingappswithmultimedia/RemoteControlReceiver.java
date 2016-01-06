package com.shrisharmi.buildingappswithmultimedia;

        import android.content.BroadcastReceiver;
        import android.content.Context;
        import android.content.Intent;
        import android.media.AudioManager;
        import android.view.KeyEvent;

/**
 * Created by shrisharmi on 1/4/2016.
 */
public class RemoteControlReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        if(Intent.ACTION_MEDIA_BUTTON.equals(intent.getAction()))
        {
            KeyEvent event = (KeyEvent)intent.getParcelableExtra(Intent.EXTRA_KEY_EVENT);
            if(KeyEvent.KEYCODE_MEDIA_PLAY == event.getKeyCode())
            {
                //Handles
            }
        }
    }
}
