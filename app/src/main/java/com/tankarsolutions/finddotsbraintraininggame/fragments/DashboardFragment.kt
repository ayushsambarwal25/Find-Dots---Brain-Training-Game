package com.tankarsolutions.finddotsbraintraininggame.fragments


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.tankarsolutions.finddotsbraintraininggame.MasterConfig
import com.tankarsolutions.finddotsbraintraininggame.R
import com.tankarsolutions.finddotsbraintraininggame.entity.MasterDashboardDB
import com.tankarsolutions.finddotsbraintraininggame.utils.GameCalculation
import com.tankarsolutions.finddotsbraintraininggame.utils.timeConverter
import com.tankarsolutions.finddotsbraintraininggame.viewmodel.GameViewModel
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class DashboardFragment : Fragment() {
    private val gameViewModel: GameViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_dashboard,
            container,
            false
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        easy.setOnClickListener {
            findNavController().navigate(
                R.id.action_dashboardFragment_to_gameActivity,
                Bundle().also {
                    it.putInt("dots", MasterConfig.EasyModeDotsToFind)
                })
        }

        medium.setOnClickListener {
            if (gamePlayed1.text.toString().toInt() < MasterConfig.PlayEasyAtLeastToUnlockMedium) {
                Snackbar.make(
                    cons,
                    "To Unlock, Complete ${MasterConfig.PlayEasyAtLeastToUnlockMedium} Games Of Easy Level",
                    Snackbar.LENGTH_LONG
                ).also {
                    it.view.setBackgroundColor(
                        ContextCompat.getColor(
                            requireContext(),
                            R.color.black
                        )
                    )
                }.show()
                return@setOnClickListener
            }
            findNavController().navigate(
                R.id.action_dashboardFragment_to_gameActivity,
                Bundle().also {
                    it.putInt("dots", MasterConfig.MediumModeDotsToFind)
                })
        }

        hard.setOnClickListener {
            if (gamePlayed2.text.toString().toInt() < MasterConfig.PlayMediumAtLeastToUnlockHard) {
                Snackbar.make(
                    cons,
                    "To Unlock, Complete ${MasterConfig.PlayMediumAtLeastToUnlockHard} Games Of Medium Level",
                    Snackbar.LENGTH_LONG
                ).also {
                    it.view.setBackgroundColor(
                        ContextCompat.getColor(
                            requireContext(),
                            R.color.black
                        )
                    )
                }.show()
                return@setOnClickListener
            }


            findNavController().navigate(
                R.id.action_dashboardFragment_to_gameActivity,
                Bundle().also {
                    it.putInt("dots", MasterConfig.HardModeDotsToFind)
                })
        }

        expert.setOnClickListener {
            if (gamePlayed3.text.toString().toInt() < MasterConfig.PlayHardAtLeastToUnlockExpert) {
                Snackbar.make(
                    cons,
                    "To Unlock, Complete ${MasterConfig.PlayHardAtLeastToUnlockExpert} Games Of Hard Level",
                    Snackbar.LENGTH_LONG
                ).also {
                    it.view.setBackgroundColor(
                        ContextCompat.getColor(
                            requireContext(),
                            R.color.black
                        )
                    )
                }.show()
                return@setOnClickListener
            }
            findNavController().navigate(
                R.id.action_dashboardFragment_to_gameActivity,
                Bundle().also {
                    it.putInt("dots", MasterConfig.ExpertModeDotsToFind)
                })
        }

        gameViewModel.getAllData().observe(viewLifecycleOwner, Observer {
            val prepareData = GlobalScope.async(IO) {
                GameCalculation.calculateForDashBoard(it)
            }
            CoroutineScope(Dispatchers.Main).launch {
                val preparedData = prepareData.await()
                updateViews(preparedData)

            }
        })
    }


    @SuppressLint("SetTextI18n")
    private fun updateViews(masterDashboardDB: MasterDashboardDB) {
        masterDashboardDB.also { db ->
            db.gameType1DB.also {
                gamePlayed1.text = it.gamePlayed.toString()
                gamePlayed1_acc.text = "${it.totalAccuracy}%"
                gamePlayed1_progress.progress = it.totalAccuracy
                if (it.gamePlayed >= MasterConfig.PlayEasyAtLeastToUnlockMedium) {
                    mlock.visibility = View.GONE
                }else{
                    mlock.visibility = View.VISIBLE
                }
            }

            db.gameType2DB.also {
                gamePlayed2.text = it.gamePlayed.toString()
                gamePlayed2_acc.text = "${it.totalAccuracy}%"
                gamePlayed2_progress.progress = it.totalAccuracy
                if (it.gamePlayed >= MasterConfig.PlayMediumAtLeastToUnlockHard) {
                    hlock.visibility = View.GONE
                }else{
                    hlock.visibility = View.VISIBLE
                }
            }


            db.gameType3DB.also {
                gamePlayed3.text = it.gamePlayed.toString()
                gamePlayed3_acc.text = "${it.totalAccuracy}%"
                gamePlayed3_progress.progress = it.totalAccuracy
                if (it.gamePlayed >= MasterConfig.PlayHardAtLeastToUnlockExpert) {
                    elock.visibility = View.GONE
                }else{
                    elock.visibility = View.VISIBLE
                }
            }


            db.gameType4DB.also {
                gamePlayed4.text = it.gamePlayed.toString()
                gamePlayed4_acc.text = "${it.totalAccuracy}%"
                gamePlayed4_progress.progress = it.totalAccuracy
            }

            val totalGamePlayed =
                db.gameType1DB.gamePlayed + db.gameType2DB.gamePlayed + db.gameType3DB.gamePlayed + db.gameType4DB.gamePlayed

            val totalAccuracy = calculateTotalAccuracy(
                db.gameType1DB.totalAccuracy
                , db.gameType2DB.totalAccuracy
                , db.gameType3DB.totalAccuracy
                , db.gameType4DB.totalAccuracy
            )

            val totalTime =
                db.gameType1DB.time + db.gameType2DB.time + db.gameType3DB.time + db.gameType4DB.time

            total_time.text = timeConverter(totalTime)
            games_played.text = totalGamePlayed.toString()
            accuracy.text = "$totalAccuracy %"


        }
    }

    private fun calculateTotalAccuracy(vararg divider: Int): Int {
        val nonZero = divider.filter {
            it != 0
        }
        val sum = nonZero.sum()
        return if (sum != 0) {
            sum / nonZero.size
        } else
            0
    }


}
