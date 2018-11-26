package com.example.applog.movielist.Activitys

import android.media.Image
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.MenuItem
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.applog.movielist.Adapter.NewMovieAdapter
import com.example.applog.movielist.Adapter.RecommendedMovieAdapter
import com.example.applog.movielist.Fragment.*
import com.example.applog.movielist.R
import kotlinx.android.synthetic.main.activity_navigation_drawer.*
import kotlinx.android.synthetic.main.app_bar_navigation_drawer.*

class NavigationDrawerActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, HomeFragment.OnFragmentInteractionListener, ActionFragment.OnFragmentInteractionListener, AdventureFragment.OnFragmentInteractionListener, RomanceFragment.OnFragmentInteractionListener, HorrorFragment.OnFragmentInteractionListener, SFFragment.OnFragmentInteractionListener
{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_drawer)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        replaceFragement(R.id.home_activity, HomeFragment())
    }

    private fun replaceFragement(id: Int, fragment: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
        transaction.replace(id, fragment)
        transaction.commitNowAllowingStateLoss()
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()

        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.

        when (item.itemId) {
            R.id.nav_home -> {
                title = "Home"
                replaceFragement(R.id.home_activity, HomeFragment())
            }
            R.id.nav_action -> {
                title = "Action"
                replaceFragement(R.id.home_activity, ActionFragment())
            }
            R.id.nav_adventure -> {
                title = "Adventure"
                replaceFragement(R.id.home_activity, AdventureFragment())
            }
            R.id.nav_romance -> {
                title = "Romance"
                replaceFragement(R.id.home_activity, RomanceFragment())
            }
            R.id.nav_horror -> {
                title = "Horror"
                replaceFragement(R.id.home_activity, HorrorFragment())
            }
            R.id.nav_SF -> {
                title = "SF"
                replaceFragement(R.id.home_activity, SFFragment())
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onFragmentInteraction(uri: Uri) {
        //
    }

}

