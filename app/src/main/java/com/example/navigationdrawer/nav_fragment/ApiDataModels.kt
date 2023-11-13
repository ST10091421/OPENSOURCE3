package com.example.navigationdrawer.nav_fragment

data class HotspotResponse(val hotspots: List<Hotspot>)

data class Hotspot(
    val locId: String,
    val locName: String,
    val countryCode: String,
    val subnational1Code: String,
    val lat: Double,
    val lng: Double,
    val latestObsDt: String,
    val numSpeciesAllTime: Int
)