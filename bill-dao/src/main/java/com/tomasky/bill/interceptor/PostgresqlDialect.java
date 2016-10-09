package com.tomasky.bill.interceptor;


public class PostgresqlDialect extends Dialect {

	@Override
	public String getLimitString(String sql, int offset, int limit) {
		sql = sql.trim();
		StringBuffer sb = new StringBuffer();
		sb.append(sql);
		sb.append(" limit " + limit);
		sb.append(" offset " + offset);
		return sb.toString();
	}

}
