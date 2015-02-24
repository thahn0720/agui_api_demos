package thahn.java.agui.test.sqlite;

public class LocationData {
	public int rawId;
	public String name;
	public float longitude;
	public float latitude;
	public Object tag;
	@Override
	public String toString() {
		return new StringBuilder("rawId : ").append(rawId)
							.append(", name : ").append(name)
							.append(", longi : ").append(longitude)
							.append(", lati : ").append(latitude)
							.append(", tag : ").append(tag).toString()
							;
	}
}
