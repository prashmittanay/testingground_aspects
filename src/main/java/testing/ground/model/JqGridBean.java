package testing.ground.model;

public class JqGridBean {
	private int page;
	private int limit;
	private String id;
	private String sort;
	private int total; 
	
	@Override
	public String toString() {
		return "JqGridBean [page=" + page + ", limit=" + limit + ", id="
				+ id + ", sort=" + sort + "]";
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
}
