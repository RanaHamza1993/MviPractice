package com.havelisolutions.mvipractice.utils

import android.text.Html
import android.text.Spanned
import android.text.SpannedString
import androidx.core.text.HtmlCompat

object StringUtil {

    //convert string to double in databinding
    fun convertIntToString(value: Int?): String? {
        if(value==null)
            return "0"
        else
        return value.toString()
    }
    //convertDouble to text in databinding
    fun convertDoubleToString(value: Double?): String? {
        if(value==null)
            return "0"
        else
            return value.toString()
    }

}