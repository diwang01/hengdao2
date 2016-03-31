package me.hengdao.demo.shard;

import me.hengdao.ShardParam;
import me.hengdao.strategy.ShardStrategy;

import javax.sql.DataSource;
import java.util.Map;



/**
 * 
 * @author wangdi5
 */
public class UserShardStrategy extends ShardStrategy {

	@Override
	public DataSource getTargetDataSource() {
		ShardParam shardParam = getShardParam();
		//
		Long param = (Long) shardParam.getShardValue();
		Map<String, DataSource> map = this.getShardDataSources();
		if (param > 100) {
			return map.get("dataSourceSlave");
		}
		return getMainDataSource();
	}

	@Override
	public String getTargetSql() {
		String targetSql = getSql();
		ShardParam shardParam = getShardParam();
		//
		Long param = (Long) shardParam.getShardValue();
		String tableName = "user_" + (param % 2);
		targetSql = targetSql.replaceAll("\\$\\[user\\]\\$", tableName);
		return targetSql;
	}

}
