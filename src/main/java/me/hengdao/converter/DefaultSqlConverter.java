package me.hengdao.converter;

import org.apache.ibatis.executor.statement.StatementHandler;
import me.hengdao.support.StrategyHolder;
import me.hengdao.strategy.NoShardStrategy;
import me.hengdao.strategy.ShardStrategy;

public class DefaultSqlConverter implements SqlConverter {

	public String convert(String sql, StatementHandler statementHandler) {
		ShardStrategy strategy = StrategyHolder.getShardStrategy();
		if (strategy == null || strategy instanceof NoShardStrategy) {
			return sql;
		}
		return strategy.getTargetSql();
	}

}
