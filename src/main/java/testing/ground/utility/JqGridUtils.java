package testing.ground.utility;

import java.util.Iterator;
import java.util.List;
import javax.ws.rs.core.MultivaluedMap;
import org.springframework.stereotype.Component;
import testing.ground.model.JqGridBean;

@Component
public class JqGridUtils {
	public JqGridBean jqBeanBuilder(MultivaluedMap<String, String> map){
		JqGridBean jqGridBean = new JqGridBean();
		jqGridBean.setSort(map.getFirst("sord"));
		jqGridBean.setSid(map.getFirst("sidx"));
		jqGridBean.setCurrentPage(Integer.parseInt(map.getFirst("page")));
		jqGridBean.setRows(Integer.parseInt(map.getFirst("rows")));
		jqGridBean.setSearch(Boolean.parseBoolean(map.getFirst("_search")));
		return jqGridBean;
	}
	
	public String constructToolbarQuery(MultivaluedMap<String, String> map, List<String> keyList){
		StringBuilder builder = new StringBuilder();
		Iterator<String> iterator = keyList.iterator();
		while (iterator.hasNext()) {
			String parameter = (String) iterator.next();
			if(map.getFirst(parameter)!= null){
				if(builder.length()> 0){
					builder.append(" and ");
				}
				builder.append(parameter+" like '%"+map.getFirst(parameter)+"%' ");
			}
		}
		return builder.toString();
	}
	
	public void setPageNumber(JqGridBean bean){
		int page = (bean.getCount() /bean.getRows())+1;
		bean.setTotalPages(page);
	}
	
	public void setStartLimit(JqGridBean bean){
		int start = bean.getCurrentPage() * bean.getRows() - bean.getRows();
		bean.setStart(start);
	}
}
