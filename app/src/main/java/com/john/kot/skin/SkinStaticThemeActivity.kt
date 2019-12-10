package com.john.kot.skin

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import com.john.kot.BaseActivity
import com.john.kot.R
import kotlinx.android.synthetic.main.activity_skin_theme.*

class SkinStaticThemeActivity : BaseActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btGreen ->
                sharedPreferences.edit().putInt(theme_type, THEME_GREEN).commit()
            R.id.btBlue ->
                sharedPreferences.edit().putInt(theme_type, ThEME_BLUE).commit()
            R.id.btPurple ->
                sharedPreferences.edit().putInt(theme_type, THEME_PURPLE).commit()
            R.id.btGrey ->
                sharedPreferences.edit().putInt(theme_type, THEME_GREY).commit()
        }
//        recreate()

        refreshRootView()
    }

    private fun refreshRootView() {
        val  rootView = window.decorView

    }

    private lateinit var sharedPreferences: SharedPreferences
    private val THEME_GREEN = 1
    private val ThEME_BLUE = 2
    private val THEME_GREY = 3
    private val THEME_PURPLE = 4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences(
            "SHARE_NAME", MODE_PRIVATE
        );
        setBaseTheme()
        setContentView(R.layout.activity_skin_theme)

        btGreen.setOnClickListener(this)
        btBlue.setOnClickListener(this)
        btPurple.setOnClickListener(this)
        btGrey.setOnClickListener(this)
    }

    override fun onResume() {
        super.onResume()
        setBaseTheme()
    }

    val theme_type = "theme_type"
    fun setBaseTheme() {

        val themeNew = sharedPreferences.getInt(theme_type, ThEME_BLUE);

        var themeId = 0
        when (themeNew) {
            THEME_GREEN ->
                themeId = R.style.AppThemeGreen;

            ThEME_BLUE ->
                themeId = R.style.AppThemeBlue;
            THEME_GREY ->
                themeId = R.style.AppThemeGrey;

            THEME_PURPLE ->
                themeId = R.style.AppThemePurple;
        }
        setTheme(themeId);
    }

}
