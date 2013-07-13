package testing.ground.model;

public class JqGridBean {
	private int currentPage;
	private int rows;
	private int totalPages;
	private int count;
	private int start;
	private String sort;
	private String sid;
	private String toolbarSearchQuery;
	private boolean search;
	@Override
	public String toString() {
		return "JqGridBean [currentPage=" + currentPage + ", rows=" + rows
				+ ", totalPages=" + totalPages + ", count=" + count
				+ ", start=" + start + ", sort=" + sort + ", sid=" + sid
				+ ", toolbarSearchQuery=" + toolbarSearchQuery + ", search="
				+ search + "]";
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
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
