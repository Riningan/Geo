package org.findmykids.sample

import org.findmykids.geo.api.extension.GeoExtension
import org.findmykids.geo.common.model.Geo


class SampleGeoExtension : GeoExtension {
    override fun extendGeo(geo: Geo) {
        geo.extensions["1"] = "1"
    }
}