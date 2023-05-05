package com.tankarsolutions.finddotsbraintraininggame.activity


import android.annotation.SuppressLint
import android.media.AudioAttributes
import android.media.SoundPool
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.ads.*
import com.google.android.gms.ads.rewarded.RewardItem
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdCallback
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import com.tankarsolutions.finddotsbraintraininggame.MasterConfig
import com.tankarsolutions.finddotsbraintraininggame.R
import com.tankarsolutions.finddotsbraintraininggame.adapter.DotAdapter
import com.tankarsolutions.finddotsbraintraininggame.entity.GameDB
import com.tankarsolutions.finddotsbraintraininggame.utils.*
import com.tankarsolutions.finddotsbraintraininggame.viewmodel.GameViewModel
import kotlinx.android.synthetic.main.fragment_game.*
import kotlinx.android.synthetic.main.game_info_dialog.view.*
import kotlinx.android.synthetic.main.game_info_dialog.view.exit
import kotlinx.android.synthetic.main.game_info_dialog.view.info_text
import kotlinx.android.synthetic.main.game_info_dialog.view.info_text2
import kotlinx.android.synthetic.main.game_result_dialog.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.androidx.viewmodel.ext.android.viewModel


class GameActivity : AppCompatActivity() {
    private lateinit var callback: RewardedAdCallback
    private var stopTimerSoundPool: Int? = null
    private var rightAnswer: Int? = null
    private var wrongAnswer: Int? = null
    private var soundPool: SoundPool? = null
    private var timer: CountDownTimer? = null
    private val randomNumbers = ArrayList<Int>()
    private lateinit var adapter: DotAdapter
    private var tStart: Long = 0
    private var tEnd: Long = 0
    private val gameViewModel: GameViewModel by viewModel()
    private lateinit var mInterstitialAd: InterstitialAd
    private lateinit var rewardedAd: RewardedAd
    private var rewardId = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_game)
        mInterstitialAd = InterstitialAd(this)

        adapter = DotAdapter(onDotClick)

        val layoutManager =
            SpanningGridLayoutManager(
                this,
                5,
                LinearLayoutManager.VERTICAL,
                false
            )

        game_board.layoutManager = layoutManager
        game_board.adapter = adapter
        soundPool = SoundPool.Builder()
            .setAudioAttributes(AudioAttributes.Builder().setUsage(AudioAttributes.USAGE_GAME).build())
            .setMaxStreams(5)
            .build()
        stopTimerSoundPool = soundPool?.load(
            this,
            R.raw.stoptimers, 1
        )
        rightAnswer = soundPool?.load(
            this,
            R.raw.rightanswer, 1
        )
        wrongAnswer = soundPool?.load(
            this,
            R.raw.wronganswer, 1
        )


        intent.extras?.let { it ->
            CoroutineScope(Dispatchers.Main).launch {
                val dots = it.getInt("dots")
                withContext(Dispatchers.Default) {
                    val visibleItem = dots * 5
                    val arrayList = ArrayList<Int>().also {
                        for (i in 0 until visibleItem) {
                            it.add(i)
                        }
                    }
                    generateRandom(arrayList, dots)
                }
                showGameInfoDialog(dots)
            }
        }

        val adView = AdView(this)
        adView.adSize = AdSize.BANNER
        adView.adUnitId = getString(R.string.common_banner)
        adView_frame.addView(adView)
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
    }


    var pressCounter = 0
    var rightCounter = 0
    var extra = 0
    private val onDotClick = object :
        DotAdapter.OnDotClick {
        @SuppressLint("SetTextI18n")
        override fun onclick(isRight: Boolean, totalPressAllowed: Int) {
            pressCounter++
            total_attempts.text =
                " ${((total_attempts.text.toString().trim().toInt()) - 1)}"
            if (isRight) {
                rightCounter++
                soundPool?.play(rightAnswer!!, 1f, 1f, 1, 0, 1f)
            } else {
                soundPool?.play(wrongAnswer!!, 1f, 1f, 1, 0, 1f)
            }

            if (rightCounter == totalPressAllowed || pressCounter == totalPressAllowed + extra) {
                adapter.gameStarts = false
                adapter.notifyDataSetChanged()
                showResultDialog(totalPressAllowed, rightCounter)
            }
        }
    }

    private fun generateRandom(
        arrayList: ArrayList<Int>,
        mode: Int
    ) {
        tStart = System.currentTimeMillis() + (mode * 1000)
        for (i in 0 until mode) {
            val randomInt = arrayList.random()
            randomNumbers.add(randomInt)
            arrayList.remove(element = randomInt)
        }
    }

    private val constraintSet by lazy {
        ConstraintSet().also {
            it.clone(cons)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun showGameInfoDialog(dots: Int) {
        this.createAlertDialogCustom(R.layout.game_info_dialog) { view, alertDialog ->
            view.info_text.text = "Find $dots Dotes"
            when (dots) {
                MasterConfig.EasyModeDotsToFind -> {
                    view.info_text.color(R.color.easy_card)
                    total_attempts.color(R.color.easy_card)
                    constraintSet.setDimensionRatio(game_board.id, "1:1")
                    constraintSet.applyTo(cons)
                    mInterstitialAd.adUnitId = getString(R.string.game_1_ads_full)
                    rewardId = getString(R.string.game_1_ads_full_reward)
                }
                MasterConfig.MediumModeDotsToFind -> {
                    view.info_text.color(R.color.medium_card)
                    total_attempts.color(R.color.medium_card)

                    constraintSet.setDimensionRatio(game_board.id, "4:5")
                    constraintSet.applyTo(cons)
                    mInterstitialAd.adUnitId = getString(R.string.game_2_ads_full)
                    rewardId = getString(R.string.game_2_ads_full_reward)

                }
              MasterConfig.HardModeDotsToFind -> {
                    view.info_text.color(R.color.hard_card)
                    total_attempts.color(R.color.hard_card)

                    constraintSet.setDimensionRatio(game_board.id, "4:5")
                    constraintSet.applyTo(cons)
                    mInterstitialAd.adUnitId = getString(R.string.game_3_ads_full)
                    rewardId = getString(R.string.game_3_ads_full_reward)

                }
                MasterConfig.ExpertModeDotsToFind -> {
                    view.info_text.color(R.color.expert_card)
                    total_attempts.color(R.color.expert_card)
                    mInterstitialAd.adUnitId = getString(R.string.game_4_ads_full)
                    rewardId = getString(R.string.game_4_ads_full_reward)

                }
            }

            rewardedAd = createAndLoadRewardedAd(rewardId)

            callback = object : RewardedAdCallback() {
                @SuppressLint("SetTextI18n")
                override fun onUserEarnedReward(p0: RewardItem) {
                    extra = 1
                    total_attempts.text =
                        " ${((total_attempts.text.toString().trim().toInt() + extra))}"

                    plus_taps.visibility = View.GONE
                }


                override fun onRewardedAdClosed() {
                    super.onRewardedAdClosed()
                    rewardedAd = createAndLoadRewardedAd(rewardId)
                }
            }


            plus_taps.setOnClickListener {
                if (rewardedAd.isLoaded) {
                    rewardedAd.show(this, callback)
                } else {
                    Toast.makeText(this, "Tap, Not Available Yet!", Toast.LENGTH_SHORT).show()
                    Log.d("TAG", "Not Available Yet!")
                }
            }


            mInterstitialAd.adListener = object : AdListener() {
                override fun onAdClosed() {
                    mInterstitialAd.loadAd(AdRequest.Builder().build())
                }
            }

            view.info_text2.text = "Remember the position of all the dots in just a $dots second."

            view.exit.setOnClickListener {
                alertDialog.dismiss()
                this.onBackPressed()
            }

            view.play.setOnClickListener {
                alertDialog.dismiss()
                progress_frame.visibility = View.VISIBLE
                stats.visibility = View.VISIBLE
                adapter.dotList = randomNumbers
                progress_text.text = "${dots}s"
                total_attempts.text = " $dots"

                var i = 0
                timer = object : CountDownTimer((dots * 1000).toLong(), 1000) {
                    override fun onFinish() {
                        progress_frame.visibility = View.GONE
                        plus_taps.visibility = View.VISIBLE
                        soundPool?.play(stopTimerSoundPool!!, 1f, 1f, 1, 0, 1f)
                        adapter.gameStarts = true
                        adapter.notifyDataSetChanged()
                    }

                    @SuppressLint("SetTextI18n")
                    override fun onTick(millisUntilFinished: Long) {
                        i++
                        game_progress.progress = i * 100 / ((dots * 1000) / 1000)
                        progress_text.text = "${(millisUntilFinished / 1000).toInt()}s"
                    }

                }
                timer?.start()
                mInterstitialAd.loadAd(AdRequest.Builder().build())
            }

        }.show()

    }

    @SuppressLint("SetTextI18n")
    private fun showResultDialog(dots: Int, rightAnswers: Int) {
        tEnd = System.currentTimeMillis()
        this.createAlertDialogCustom(R.layout.game_result_dialog) { view, alertDialog ->
            val accuracy = (rightAnswers * 100) / (pressCounter)
            var gameType: Int = -1
            when (dots) {
                MasterConfig.EasyModeDotsToFind -> {
                    view.info_text.color(R.color.easy_card)
                    gameType = 1
                }
                MasterConfig.MediumModeDotsToFind -> {
                    view.info_text.color(R.color.medium_card)
                    gameType = 2
                }
                MasterConfig.HardModeDotsToFind -> {
                    view.info_text.color(R.color.hard_card)
                    gameType = 3
                }
                MasterConfig.ExpertModeDotsToFind -> {
                    view.info_text.color(R.color.expert_card)
                    gameType = 4
                }
            }

            view.info_text.text = findResultEnum(accuracy).name
            view.info_text2.text = "Your Accuracy : ${accuracy}%"
            view.total_time.text = "Time : ${timeConverter(tEnd - tStart)}"

            // Insert Data
            gameViewModel.insertData(GameDB(gameType, accuracy, (tEnd - tStart)))

            view.exit.setOnClickListener {
                alertDialog.dismiss()
                if (mInterstitialAd.isLoaded) {
                    mInterstitialAd.show()
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.")
                }
                this.onBackPressed()
            }
            view.retry.setOnClickListener {
                progress_frame.visibility = View.VISIBLE
                plus_taps.visibility = View.GONE
                alertDialog.dismiss()
                retry()
            }
        }.show()
    }


    private fun findResultEnum(percentage: Int): ResultEnum {
        return when (percentage) {
            in 0..31 -> ResultEnum.VeryBad
            in 31..61 -> ResultEnum.Bad
            in 61..91 -> ResultEnum.Good
            else -> ResultEnum.Excellent
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        timer?.cancel()
    }

    @SuppressLint("SetTextI18n")
    private fun retry() {
        intent.extras?.let { it ->
            CoroutineScope(Dispatchers.Main).launch {
                val dots = it.getInt("dots")
                withContext(Dispatchers.Default) {
                    val visibleItem = dots * 5
                    val arrayList = ArrayList<Int>().also {
                        for (i in 0 until visibleItem) {
                            it.add(i)
                        }
                    }

                    randomNumbers.clear()
                    adapter.dotList.clear()
                    generateRandom(arrayList, dots)
                    pressCounter = 0
                    rightCounter = 0
                    extra = 0
                }

                stats.visibility = View.VISIBLE
                adapter.dotList = randomNumbers
                progress_text.text = "${dots}s"
                total_attempts.text = " $dots"

                var i = 0
                timer = object : CountDownTimer((dots * 1000).toLong(), 1000) {
                    override fun onFinish() {
                        progress_frame.visibility = View.GONE
                        plus_taps.visibility = View.VISIBLE
                        soundPool?.play(stopTimerSoundPool!!, 1f, 1f, 1, 0, 1f)
                        adapter.gameStarts = true
                        adapter.notifyDataSetChanged()
                    }

                    @SuppressLint("SetTextI18n")
                    override fun onTick(millisUntilFinished: Long) {
                        i++
                        game_progress.progress = i * 100 / ((dots * 1000) / 1000)
                        progress_text.text = "${(millisUntilFinished / 1000).toInt()}s"
                    }

                }
                timer?.start()
            }
        }
    }

    fun createAndLoadRewardedAd(id: String): RewardedAd {
        val rewardedAd = RewardedAd(this, id)
        val adLoadCallback = object : RewardedAdLoadCallback() {
            override fun onRewardedAdLoaded() {
                // Ad successfully loaded.
                Log.d("TAG", "Loaded")
            }

            override fun onRewardedAdFailedToLoad(errorCode: Int) {
                // Ad failed to load.
                Log.d("TAG", "Error $errorCode")

            }
        }
        rewardedAd.loadAd(AdRequest.Builder().build(), adLoadCallback)
        return rewardedAd
    }

}
