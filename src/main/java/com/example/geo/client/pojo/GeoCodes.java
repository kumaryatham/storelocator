package com.example.geo.client.pojo;

import java.util.List;

public class GeoCodes {

	private List<Results> results;

	public List<Results> getResults() {
		return results;
	}

	public void setResults(List<Results> results) {
		this.results = results;
	}

	public static class Results {
		private Geometry geometry;

		public Geometry getGeometry() {
			return geometry;
		}

		public void setGeometry(Geometry geometry) {
			this.geometry = geometry;
		}

	}

	public static class Geometry {
		private double lat;
		private double lng;

		public double getLat() {
			return lat;
		}

		public void setLat(double lat) {
			this.lat = lat;
		}

		public double getLng() {
			return lng;
		}

		public void setLng(double lng) {
			this.lng = lng;
		}

		@Override
		public String toString() {
			return "Geometry [lat=" + lat + ", lng=" + lng + "]";
		}

	}

}
