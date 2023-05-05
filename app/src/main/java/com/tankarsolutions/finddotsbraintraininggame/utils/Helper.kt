package com.tankarsolutions.finddotsbraintraininggame.utils

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import java.util.concurrent.TimeUnit


fun Context.createAlertDialogCustom(
    @LayoutRes layout: Int, setCancelAble: Boolean = false,
    viewBlock: (view: View, alertDialog: AlertDialog) -> Unit
): AlertDialog {
    val alertDialog = AlertDialog.Builder(this).create()
    alertDialog.setCancelable(setCancelAble)
    val inflater = LayoutInflater.from(this)
    val dialogView = inflater.inflate(layout, null)
    alertDialog.setView(dialogView)
    return alertDialog.also { alert ->
        alert.window!!.setFlags(Window.FEATURE_NO_TITLE, 0)
        alert.window!!.setBackgroundDrawable(
            ColorDrawable(
                ContextCompat.getColor(
                    this,
                    android.R.color.transparent
                )
            )
        )
        viewBlock(dialogView, alertDialog)

    }
}


fun timeConverter(millis: Long) =
    String.format(
        "%02d : %02d : %02d", TimeUnit.MILLISECONDS.toHours(millis),
        TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(
            TimeUnit.MILLISECONDS.toHours(
                millis
            )
        ),
        TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(
            TimeUnit.MILLISECONDS.toMinutes(
                millis
            )
        )
    )

fun TextView.color(@ColorRes colorRes: Int) =
    this.setTextColor(ContextCompat.getColor(this.context, colorRes))
