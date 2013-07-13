package testing.ground.model;

public class JqGridBean {
	private int page;
	private int rows;
	private int total;
	private String sort;
	private String sid;
	private String toolbarSearchQuery;
	private boolean search;
	@Override
	public String toString() {
		return "JqGridBean [page=" + page + ", rows=" + rows + ", total="
				+ total + ", sort=" + sort + ", sid=" + sid
				+ ", toolbarSearchQuery=" + toolbarSearchQuery + ", search="
				+ search + "]";
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getToolbarSearchQuery() {
		return toolbarSearchQuery;
	}
	public void setToolbarSearchQuery(String toolbarSearchQuery) {
		this.toolbarSearchQuery = toolbarSearchQuery;
	}
	public boolean isSearch() {
		return search;
	}
	public void setSearch(boolean search) {
		this.search = search;
	}
}
