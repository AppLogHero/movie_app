package com.example.applog.movielist.Fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.applog.movielist.Adapter.ActionMovieAdapter

import com.example.applog.movielist.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [RomanceFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [RomanceFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class RomanceFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var listener: OnFragmentInteractionListener? = null

    val movies: ArrayList<String> = ArrayList()

    private lateinit var romanceMovieRecyclerView: RecyclerView
    private lateinit var romanceMovieViewAdapter: RecyclerView.Adapter<*>
    private lateinit var romanceMovieViewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_romance, container, false)

        addMovie()

        romanceMovieViewManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        romanceMovieViewAdapter = ActionMovieAdapter(movies)

        romanceMovieRecyclerView = rootView.findViewById<RecyclerView>(R.id.romance_movie_rc) as RecyclerView
        romanceMovieRecyclerView.layoutManager = romanceMovieViewManager
        romanceMovieRecyclerView.adapter = romanceMovieViewAdapter

        return rootView
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
         * @return A new instance of fragment RomanceFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RomanceFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    fun addMovie() {

        movies.add("Movie Title yeah")
        movies.add("Movie Title")
        movies.add("Movie Title")
        movies.add("Movie Title")
        movies.add("Movie Title")
        movies.add("Movie Title")
        movies.add("Movie Title")
        movies.add("Movie Title")
        movies.add("Movie Title")
        movies.add("Movie Title")
        movies.add("Movie Title")
        movies.add("Movie Title")
        movies.add("Movie Title")

    }
}
