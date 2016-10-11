package com.tomasky.fqxz.interceptor;


public class PostgresqlDialect extends Dialect {

    @Override
    public String getLimitString(String sql, int offset, int limit) {
        sql = sql.trim();
        StringBuffer sb = new StringBuffer();
        sb.append(sql);
        if (sql.toUpperCase().indexOf("SELECT COUNT") == -1) {
            sb.append(" limit " + limit);
            sb.append(" offset " + offset);
        }
        return sb.toString();
    }

}
