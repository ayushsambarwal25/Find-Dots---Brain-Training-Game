package com.tankarsolutions.finddotsbraintraininggame.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.google.android.gms.ads.MobileAds
import com.tankarsolutions.finddotsbraintraininggame.BuildConfig
import com.tankarsolutions.finddotsbraintraininggame.MasterConfig
import com.tankarsolutions.finddotsbraintraininggame.R
import com.tankarsolutions.finddotsbraintraininggame.utils.createAlertDialogCustom
import kotlinx.android.synthetic.main.exit_dialog.view.*


class MainActivity : AppCompatActivity() {

    private lateinit var currentNavController: NavController
    private var onBackDialog: AlertDialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        currentNavController = this.findNavController(R.id.nav_host_fragment)
        MobileAds.initialize(this) {}
        onBackDialog = AlertDialog.Builder(this).create()
    }

    override fun onSupportNavigateUp(): Boolean {
        currentNavController.navigateUp()
        return false
    }


    override fun onBackPressed() {

        this.createAlertDialogCustom(R.layout.exit_dialog, true) { view, alertDialog ->
            val intent = Intent()

            view.share.setOnClickListener {
                intent.action = Intent.ACTION_SEND
                intent.putExtra(
                    Intent.EXTRA_TEXT,
                    "Improve Your Visual Memory With Find Dots - Brain Training Game\nDownload Now\nhttps://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID
                )
                intent.type = "text/plain"
                startActivity(intent)
                alertDialog.dismiss()
            }

            view.rate.setOnClickListener {
                intent.action = Intent.ACTION_VIEW
                intent.data =
                    Uri.parse("https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID)
                startActivity(intent)
                alertDialog.dismiss()
            }

            view.more.setOnClickListener {
                intent.action = Intent.ACTION_VIEW
                intent.data =
                    Uri.parse("https://play.google.com/store/apps/developer?id=${MasterConfig.DEV_ID}")
                startActivity(intent)
                alertDialog.dismiss()
            }

            view.exit.setOnClickListener {
                super.onBackPressed()
            }

        }.show()


    }

    override fun onDestroy() {
        super.onDestroy()
        onBackDialog?.dismiss()
    }
}
