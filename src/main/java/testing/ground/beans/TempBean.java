package testing.ground.beans;

import java.util.List;
import java.util.Map;

public class TempBean {
	private String date;
	private List<Map<String, Object>> data;
	@Override
	public String toString() {
		return "TempBean [date=" + date + ", data=" + data + "]";
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public List<Map<String, Object>> getData() {
		return data;
	}
	public void setData(List<Map<String, Object>> data) {
		this.data = data;
	}
}
