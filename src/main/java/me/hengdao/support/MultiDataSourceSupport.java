package me.hengdao.support;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @Description: 多数据库支持接口
 * @author Kolor
 * @date 2012-8-2 下午4:13:19
 */
public interface MultiDataSourceSupport {
	public DataSource getMainDataSource();

	public Map<String, DataSource> getShardDataSources();
}
