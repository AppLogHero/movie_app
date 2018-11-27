package com.example.applog.movielist.Fragment

import android.content.Context
import android.graphics.drawable.Drawable
import android.media.Image
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.applog.movielist.Adapter.NewMovieAdapter
import com.example.applog.movielist.Adapter.RecommendedMovieAdapter
import com.example.applog.movielist.DataBase.MovieDataBase

import com.example.applog.movielist.R
import com.example.applog.movielist.Services.MovieApiInterface
import com.example.applog.movielist.Services.MovieApiService
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.w3c.dom.Text
import retrofit2.Retrofit
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [HomeFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var listener: OnFragmentInteractionListener? = null

    val moviesRecommended: ArrayList<String> = ArrayList()
    val newMovies: ArrayList<String> = ArrayList()
    val moviePhotos: ArrayList<Image> = ArrayList()

    private lateinit var recommendedMovieRecyclerView: RecyclerView
    private lateinit var recommendedMovieViewAdapter: RecyclerView.Adapter<*>
    private lateinit var recommendedMovieViewManager: RecyclerView.LayoutManager

    private lateinit var newMovieRecyclerView: RecyclerView
    private lateinit var newMovieViewAdapter: RecyclerView.Adapter<*>
    private lateinit var newMovieViewManager: RecyclerView.LayoutManager

    private lateinit var atTheMomentImageView: ImageView
    private lateinit var movieTitle: TextView
    private lateinit var runtime: TextView
    private lateinit var released: TextView
    private lateinit var genre: TextView
    private lateinit var year: TextView
    private lateinit var description: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //sendGet()

        val rootView = inflater.inflate(R.layout.fragment_home, container, false)

        recommendedMovieViewManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        recommendedMovieViewAdapter = RecommendedMovieAdapter(MovieApiService().getSFMovies())

        recommendedMovieRecyclerView = rootView.findViewById<RecyclerView>(R.id.recommended_movie_rc) as RecyclerView
        recommendedMovieRecyclerView.layoutManager = recommendedMovieViewManager
        recommendedMovieRecyclerView.adapter = recommendedMovieViewAdapter

        newMovieViewManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        newMovieViewAdapter = NewMovieAdapter(MovieApiService().getActionMovies())

        newMovieRecyclerView = rootView.findViewById<RecyclerView>(R.id.new_movie_rc) as RecyclerView
        newMovieRecyclerView.layoutManager = newMovieViewManager
        newMovieRecyclerView.adapter = newMovieViewAdapter

        val recommendedMovies = MovieApiService().getSFMovies()

        atTheMomentImageView = rootView.findViewById<ImageView>(R.id.imageViewAtThMoment)

        //Glide.with(this).load(URL("http://image.tmdb.org/t/p/w185//adw6Lq9FiC9zjYEpOqfq03ituwp.jpg")).into(atTheMomentImageView)

        Glide.with(this)
            .load( recommendedMovies[0].poster)
            .into(atTheMomentImageView)

        movieTitle = rootView.findViewById<TextView>(R.id.at_the_moment_title)
        runtime = rootView.findViewById<TextView>(R.id.at_the_moment_runtime)
        released = rootView.findViewById<TextView>(R.id.at_the_released)
        genre = rootView.findViewById<TextView>(R.id.at_the_moment_year)
        description = rootView.findViewById<TextView>(R.id.at_the_moment_description)

        movieTitle.text = recommendedMovies[0].title
        runtime.text = recommendedMovies[0].runtime
        released.text = recommendedMovies[0].released
        genre.text = recommendedMovies[0].genre
        //year.text = recommendedMovies[0].year
        description.text = recommendedMovies[0].description

        //AsyncTask
        doAsync {

            uiThread {
                //Update the UI thread here
                Toast.makeText(context, "Welcome back", Toast.LENGTH_LONG).show()
            }

        }

        return rootView
    }

    private fun sendGet() {
        val url = "http://www.omdbapi.com/?i=tt3896198&apikey=13e569"
        val obj = URL(url)

        with(obj.openConnection() as HttpURLConnection) {
            // optional default is GET
            requestMethod = "GET"


            println("\nSending 'GET' request to URL : $url")
            println("Response Code : $responseCode")

            BufferedReader(InputStreamReader(inputStream)).use {
                val response = StringBuffer()

                var inputLine = it.readLine()
                while (inputLine != null) {
                    response.append(inputLine)
                    inputLine = it.readLine()
                }
                println(response.toString())
            }
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
