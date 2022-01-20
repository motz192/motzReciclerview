package com.example.recyclerlugares_mbca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.recyclerlugares_mbca.databinding.ActivityMapaReciclableBinding

class mapaReciclable : AppCompatActivity(), OnMapReadyCallback {
    private var recibido:String? = ""

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapaReciclableBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapaReciclableBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.extras?.let { bundle ->
            recibido = bundle.getString("Nombre")?: ""
        }
        Toast.makeText(this, recibido, Toast.LENGTH_SHORT)

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
        var lugar: LatLng = LatLng(10.22,10.21)
        when(recibido){
            "Tecnologico" -> lugar = LatLng(19.950419851167535, -96.84389641992085)
            "Terminal" -> lugar = LatLng(19.929322784390976, -96.85329816849573)
            "Mercado" -> lugar = LatLng(19.92747914629918, -96.85433471999352)
            "Soriana" -> lugar = LatLng(19.934119082033842, -96.85071084709212)
            "Bodegas" -> lugar = LatLng(19.932284980911184, -96.84888960045238)
            else -> lugar = LatLng(19.950419851167535, -96.84389641992085)
        }
        mMap.setMinZoomPreference(15.0f)
        mMap.addMarker(MarkerOptions().position(lugar).title("Marca en recibido"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(lugar))
        println(recibido)
    }
}