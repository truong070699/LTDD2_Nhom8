package nguyenhai1449.com.musicplayer;

import android.content.Context;
import android.media.Image;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class PlayMusicViewControl  extends LinearLayout{
    private ViewGroup playerLayout;
    private ImageView btnNext;
    private ImageView btnPlay;
    private ImageView btnPause;
    private ImageView btnStop;
    private ImageView btnPrev;

    private MusicPlayerFunctions functionsOfMusicPlay = null;

    private OnClickListener onPlayMusicClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            int chirenCount = playerLayout.getChildCount();
            for(int i = 0; i < chirenCount; i++){
                ImageView btn = (ImageView) playerLayout.getChildAt(i);
                if(v.getId() == btn.getId()){
                    btn.setSelected(true);
                }
                else {
                    btn.setSelected(false);
                }
            }
            if(functionsOfMusicPlay == null){
                Log.d("test", "You must define the functions of this contro");
                return;
            }
            switch (v.getId()){
                case R.id.btnNext: functionsOfMusicPlay.onNextClicked();
                    break;
                case R.id.btnPause: functionsOfMusicPlay.onPauseClicked();
                    break;
                case R.id.btnPlay: functionsOfMusicPlay.onPlayClicked();
                    break;
                case R.id.btnPrev: functionsOfMusicPlay.onPreviousClicked();
                case R.id.btnStop: functionsOfMusicPlay.onStopClicked();
            }
        }
    };
    public PlayMusicViewControl(Context context) {
        super(context);
        init();
    }

    public PlayMusicViewControl(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PlayMusicViewControl(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setFunctionsOfMusicControl(MusicPlayerFunctions musicPlayerFunctions){
        this.functionsOfMusicPlay = musicPlayerFunctions;
    }
    public void init(){
        ViewGroup viewGroup = (ViewGroup) inflate(getContext(), R.layout.playmusic_layout, this);
        playerLayout = (ViewGroup) viewGroup.getChildAt(0);
        btnNext = (ImageView) playerLayout.findViewById(R.id.btnNext);
        btnNext.setOnClickListener(onPlayMusicClickListener);
        btnPause = (ImageView) playerLayout.findViewById(R.id.btnPause);
        btnPause.setOnClickListener(onPlayMusicClickListener);
        btnPlay = (ImageView) playerLayout.findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(onPlayMusicClickListener);
        btnPrev = (ImageView) playerLayout.findViewById(R.id.btnPrev);
        btnPrev.setOnClickListener(onPlayMusicClickListener);
        btnStop = (ImageView) playerLayout.findViewById(R.id.btnStop);
        btnStop.setOnClickListener(onPlayMusicClickListener);
    }
}
