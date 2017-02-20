package cn.qiditu.guet.android.musicplayerserver;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

public class MusicPlayerService extends Service {

    private MediaPlayer mediaPlayer;

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this, R.raw.music);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
    }

    private IBinder localServerBinder = new LocalServerBinder();
    @Override
    public IBinder onBind(Intent intent) {
        return localServerBinder;
    }

    public class LocalServerBinder extends Binder {

        @SuppressWarnings("unused")
        public MusicPlayerService getServer() {
            return MusicPlayerService.this;
        }

    }

}
