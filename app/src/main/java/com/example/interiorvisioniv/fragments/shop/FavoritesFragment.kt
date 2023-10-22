package com.example.interiorvisioniv.fragments.shop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentFactory
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.interiorvisioniv.R
import com.example.interiorvisioniv.adapters.FavoritesAdapter
import com.example.interiorvisioniv.adapters.FurnitureAdapter
import com.example.interiorvisioniv.data.FavItem
import com.example.interiorvisioniv.data.Furnitures
import com.example.interiorvisioniv.databinding.FragmentFavoritesBinding
import com.example.interiorvisioniv.helper.COL_FAV_STATUS
import com.example.interiorvisioniv.helper.COL_FURNITURE_ID
import com.example.interiorvisioniv.helper.COL_FURNITURE_NAME
import com.example.interiorvisioniv.helper.COL_IMAGE_PATH
import com.example.interiorvisioniv.helper.COL_PRICE
import com.example.interiorvisioniv.helper.DBHelper


class FavoritesFragment : Fragment(R.layout.fragment_favorites) {

    public lateinit var binding : FragmentFavoritesBinding

    private lateinit var adapter : FavoritesAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var myDB: DBHelper
    private var favoritesArrayList = ArrayList<FavItem>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentFavoritesBinding.inflate(inflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(context)

        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        myDB = DBHelper(requireContext())

        loadData()

    }

    private fun loadData() {
        if (favoritesArrayList != null) {
            favoritesArrayList.clear()
        }
        var db = myDB.readableDatabase
        var cursor = myDB.selectAllFaves()
        try {
            while (cursor.moveToNext()) {
                var itemName = cursor.getString(cursor.getColumnIndexOrThrow(COL_FURNITURE_NAME))
                var id = cursor.getString(cursor.getColumnIndexOrThrow(COL_FURNITURE_ID))
                var image = Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(COL_IMAGE_PATH)))
                var price = cursor.getString(cursor.getColumnIndexOrThrow(COL_PRICE)).toDouble()
                var status = cursor.getString(cursor.getColumnIndexOrThrow(COL_FAV_STATUS))
                var favItem = FavItem(itemName, id, image, price, status)
                favoritesArrayList.add(favItem)
            }
        } finally {
            if (cursor != null && cursor.isClosed) {
                cursor.close()
                db.close()
            }
        }

        var favoritesAdapter = FavoritesAdapter(favoritesArrayList, requireContext())

        recyclerView.adapter = favoritesAdapter
    }


}