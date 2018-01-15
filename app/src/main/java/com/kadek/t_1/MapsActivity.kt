package com.kadek.t_1

import android.support.v4.app.FragmentActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : FragmentActivity(), OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {

    private var mMap: GoogleMap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap!!.setOnInfoWindowClickListener(this)
        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-5.364546, 105.243503)

        mMap!!.addMarker(MarkerOptions().position(sydney).title("Univertias Lampung"))
        mMap!!.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 10f))
        mMap!!.setInfoWindowAdapter(object : GoogleMap.InfoWindowAdapter {
            override fun getInfoWindow(marker: Marker): View? {
                return null
            }

            override fun getInfoContents(marker: Marker): View {
                val v = layoutInflater.inflate(R.layout.info_maps, null)
                val tvl = v.findViewById<TextView>(R.id.titlemap)
                val lat = v.findViewById<TextView>(R.id.lat)
                val longi = v.findViewById<TextView>(R.id.longi)

                val ll = marker.position
                tvl.text = marker.title
                lat.text = "Latitude: " + ll.latitude
                longi.text = "Longitude: " + ll.longitude
                return v

            }
        })


    }

    override fun onInfoWindowClick(marker: Marker) {
        Toast.makeText(this, "Info window clicked",
                Toast.LENGTH_SHORT).show()
    }
}
