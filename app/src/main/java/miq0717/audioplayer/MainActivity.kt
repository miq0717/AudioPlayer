package miq0717.audioplayer

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var mediaPlayer: MediaPlayer? = null
    private var currPos: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPlay.setOnClickListener(this)
        btnStop.setOnClickListener(this)
        btnPause.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnPlay -> {
                if (mediaPlayer == null) {
                    mediaPlayer = MediaPlayer.create(applicationContext, R.raw.hello)
                    mediaPlayer?.start()
                } else if (!mediaPlayer?.isPlaying!!) {
                    mediaPlayer?.seekTo(currPos)
                    mediaPlayer?.start()
                }


            }
            R.id.btnPause -> {
                mediaPlayer?.pause()
                mediaPlayer?.currentPosition?.let { currPos = it }
            }
            R.id.btnStop -> {
                mediaPlayer?.stop()
                mediaPlayer = null
                currPos = 0
            }
        }
    }
}
