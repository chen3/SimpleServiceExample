package cn.qiditu.guet.android.musicplayerserver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @SuppressWarnings("unused")
    @OnClick(R.id.btn_start_player)
    void onBtnStartClick() {
        this.startService(new Intent(this, MusicPlayerService.class));
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.btn_stop_player)
    void onBtnStopClick() {
        this.stopService(new Intent(this, MusicPlayerService.class));
    }

}
