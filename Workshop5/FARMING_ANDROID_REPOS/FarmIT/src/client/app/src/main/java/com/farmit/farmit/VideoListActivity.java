package com.farmit.farmit;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.volokh.danylo.video_player_manager.manager.PlayerItemChangeListener;
import com.volokh.danylo.video_player_manager.manager.SingleVideoPlayerManager;
import com.volokh.danylo.video_player_manager.manager.VideoPlayerManager;
import com.volokh.danylo.video_player_manager.meta.MetaData;
import com.volokh.danylo.video_player_manager.ui.SimpleMainThreadMediaPlayerListener;
import com.volokh.danylo.video_player_manager.ui.VideoPlayerView;

public class VideoListActivity extends Activity {

    private VideoPlayerView player;
    private ImageView cover;
    private VideoPlayerManager<MetaData> videoPlayer;
    private static String TAG = VideoListActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list);

        player = findViewById(R.id.video_player_1);
        cover = findViewById(R.id.video_cover_1);
        cover.setVisibility(View.INVISIBLE);

        videoPlayer = new SingleVideoPlayerManager(new PlayerItemChangeListener() {
            @Override
            public void onPlayerItemChanged(MetaData metaData) {
            }
        });

        player.addMediaPlayerListener(new SimpleMainThreadMediaPlayerListener(){
            @Override
            public void onVideoPreparedMainThread() {
                // We hide the cover when video is prepared. Playback is about to start
                cover.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onVideoStoppedMainThread() {
                // We show the cover when video is stopped
                cover.setVisibility(View.VISIBLE);
            }

            @Override
            public void onVideoCompletionMainThread() {
                // We show the cover when video is completed
                cover.setVisibility(View.VISIBLE);
            }
        });

        cover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.video_cover_1:
                        videoPlayer.playNewVideo(null, player, "https://www.youtube.com/watch?v=SJ_tpbriGpE&list=RDSJ_tpbriGpE");
                        break;
                    case R.id.video_cover_2:
                        // videoPlayer.playNewVideo(null, mVideoPlayer_2, "http:\\url_to_you_video_2_source");
                        break;
                }
            }
        });
    }
}
