package com.tomasky.fqxz.interceptor;


public abstract class Dialect {    
    
    public static enum Type {    
        MYSQL,    
        ORACLE,
        POSTGRESQL
    }    
        
    public abstract String getLimitString(String sql, int offset, int limit);
}