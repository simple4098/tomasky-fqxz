package com.tomasky.bill.common.util;


import java.util.*;

/**
 * <h3>Class name</h3> 数组工具类 <h4>Description</h4> <h4>Special Notes</h4>
 *
 * @author mowei
 */
public class ListUtil {

    /**
     * 判断collection是否为空
     *
     * @param collection
     * @return
     */
    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     * 判断collection是否非空
     *
     * @param collection
     * @return
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    /**
     * 判断数组是否为空
     *
     * @param objects
     * @return
     */
    public static boolean isEmpty(Object[] objects) {
        return objects == null || objects.length == 0;
    }

    /**
     * 判断数组是否不为空
     *
     * @param objects
     * @return
     */
    public static boolean isNotEmpty(Object[] objects) {
        return !isEmpty(objects);
    }

    /**
     * 删除list集合中重复值
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static List removeDuplicateBySet(List source) {
        Set set = new HashSet();
        List distinctResult = new ArrayList();
        for (Iterator iter = source.iterator(); iter.hasNext(); ) {
            Object element = iter.next();
            if (set.add(element))
                distinctResult.add(element);
        }
        source.clear();
        source.addAll(distinctResult);
        return source;
    }
}
