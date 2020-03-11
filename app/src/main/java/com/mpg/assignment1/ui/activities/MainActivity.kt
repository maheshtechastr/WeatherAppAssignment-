package com.mpg.assignment1.ui.activities

import android.view.Menu
import android.view.MenuItem
import com.mpg.assignment1.R
import com.mpg.assignment1.base.BaseActivity
import com.mpg.assignment1.databinding.ActivityMainBinding
import com.mpg.assignment1.extentions.showToast
import com.mpg.assignment1.viewmodel.MainActivityViewModel

class MainActivity : BaseActivity<MainActivityViewModel, ActivityMainBinding>() {

    override fun viewLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun viewModel(): Class<MainActivityViewModel> {
        return MainActivityViewModel::class.java
    }
    override fun onCreate() {
        setSupportActionBar(viewBinding.toolbar)

        viewBinding.viewModel = viewModelActivity
        viewBinding.lifecycleOwner = this
//        viewModelActivity.pageTitle.postValue("")
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> {
                showToast("Settings....")
//                baseViewModel.pageTitle.value = "Setting"
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
