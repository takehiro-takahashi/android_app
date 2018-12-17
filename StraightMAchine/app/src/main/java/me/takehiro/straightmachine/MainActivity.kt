package me.takehiro.straightmachine

import android.media.AudioAttributes
import android.media.AudioManager
import android.media.SoundPool
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var soundPool: SoundPool

    var soundFail: Int = 0
    var buttonFight: Int = 0
    var buttonPassed: Int = 0
    var buttonCongratulations: Int = 0
    var buttonNice: Int = 0
    var buttonBad: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_fail.setOnClickListener {
            soundPool.play(soundFail, 1.0f, 1.0f, 0,0,1.0f)
        }

        button_fight.setOnClickListener {
            soundPool.play(buttonFight, 1.0f, 1.0f, 0,0,1.0f)
        }

        button_passed.setOnClickListener {
            soundPool.play(buttonPassed, 1.0f, 1.0f, 0,0,1.0f)
        }

        button_congratulations.setOnClickListener {
            soundPool.play(buttonCongratulations, 1.0f, 1.0f, 0,0,1.0f)
        }

        button_nice.setOnClickListener {
            soundPool.play(buttonNice, 1.0f, 1.0f, 0,0,1.0f)
        }

        button_bad.setOnClickListener {
            soundPool.play(buttonBad, 1.0f, 1.0f, 0,0,1.0f)
        }
    }

    override fun onResume() {
        super.onResume()

        //  効果音を出す
        val soundPoolMax = 1

        val attr: AudioAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_MEDIA)
            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
            .build()

        soundPool = SoundPool.Builder()
            .setAudioAttributes(attr)
            .setMaxStreams(soundPoolMax)
            .build()

        //  各効果音ファイルを読み込み
        soundFail = soundPool.load(this, R.raw.info_lady1_info_lady1_fugoukakudesu1, 1)
        buttonFight = soundPool.load(this, R.raw.info_lady1_info_lady1_ganbarimasyou1, 1)
        buttonPassed = soundPool.load(this, R.raw.info_lady1_info_lady1_goukakudesu1, 1)
        buttonCongratulations = soundPool.load(this, R.raw.info_lady1_info_lady1_omedetougozaimasu1, 1)
        buttonNice = soundPool.load(this, R.raw.info_lady1_info_lady1_yokudekimashita1, 1)
        buttonBad = soundPool.load(this, R.raw.info_lady1_info_lady1_zannendeshita1, 1)
    }

    override fun onPause() {
        super.onPause()

        //  使い終わった音ファイルをメモリ解放する
        soundPool.release()
    }
}
