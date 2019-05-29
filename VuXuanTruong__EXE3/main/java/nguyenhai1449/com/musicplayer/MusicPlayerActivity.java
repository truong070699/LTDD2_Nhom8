package nguyenhai1449.com.musicplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MusicPlayerActivity extends AppCompatActivity {

    private PlayMusicViewControl musicViewControl;
    //private CustomProgressBar progressBar;
    private MusicPlayerFunctions musicPlayerFunctions = new MusicPlayerFunctions() {
        @Override
        public void onPreviousClicked() {
            Toast.makeText(MusicPlayerActivity.this, "onPreviousClicked() called", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onPlayClicked() {
            Toast.makeText(MusicPlayerActivity.this, "onPlayClicked() called", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onPauseClicked() {
            Toast.makeText(MusicPlayerActivity.this, "onPauseClicked() called", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onStopClicked() {
            Toast.makeText(MusicPlayerActivity.this, "onStopClicked() called", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNextClicked() {
            Toast.makeText(MusicPlayerActivity.this, "onNextClicked() called", Toast.LENGTH_SHORT).show();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_player_layout);
        musicViewControl = (PlayMusicViewControl)findViewById(R.id.player);
        musicViewControl.setFunctionsOfMusicControl(musicPlayerFunctions);
    }
}
