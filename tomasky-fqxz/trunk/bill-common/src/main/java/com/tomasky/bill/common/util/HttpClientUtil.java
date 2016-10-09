package com.tomasky.bill.common.util;

import com.tomasky.bill.common.cons.Constants;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.*;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieSpecProvider;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HttpClientUtil {

    protected static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

    public static BasicCookieStore setBasicCookieStore(Map<String, String> requestHeader) {
        BasicCookieStore cookieStore = new BasicCookieStore();
        return cookieStore;
    }

    private static RequestConfig setRequestConfig(String proxyIp, int proxyPort) {
        RequestConfig requestConfig = null;
        if (StringUtils.isNotBlank(proxyIp) && 0 != proxyPort) {
            HttpHost proxy = new HttpHost(proxyIp, proxyPort);
            //配置请求时的参数设置  
            requestConfig = RequestConfig.custom()
                    .setConnectionRequestTimeout(40000)
                    .setConnectTimeout(50000)
                    .setSocketTimeout(60000)
                    .setProxy(proxy)
                    .setCookieSpec("mySpec")
                    .build();
        } else {
            //配置请求时的参数设置
            requestConfig = RequestConfig.custom()
                    .setConnectionRequestTimeout(40000)
                    .setConnectTimeout(50000)
                    .setSocketTimeout(60000)
                    .setCookieSpec("mySpec")
                    .build();
        }
        return requestConfig;
    }

    public static CloseableHttpClient setHttpClient(BasicCookieStore cookieStore, String proxyIp, int proxyPort) {
        Registry<CookieSpecProvider> registry = RegistryBuilder.<CookieSpecProvider>create().build();
        CloseableHttpClient httpClient = HttpClients.custom()
                .setDefaultCookieSpecRegistry(registry)
                .setDefaultRequestConfig(setRequestConfig(proxyIp, proxyPort))
                .setDefaultCookieStore(cookieStore)
                .build();
        return httpClient;
    }

    public static HttpGet setHttpGet(String url) {
        HttpGet httpget = new HttpGet(url);
        httpget.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/34.0.1847.131 Safari/537.36");
        httpget.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        httpget.setHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.6,en;q=0.4");
        httpget.setHeader("Accept-Charset", "GB2312,UTF-8;q=0.7,*;q=0.7");
        return httpget;
    }

    private static HttpPost setHttpPost(String url) {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/34.0.1847.131 Safari/537.36");
        httpPost.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        httpPost.setHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.6,en;q=0.4");
        httpPost.setHeader("Accept-Charset", "GB2312,UTF-8;q=0.7,*;q=0.7");
        return httpPost;
    }

    private static Map<String, String> getHttpResponseMap(String type, CloseableHttpClient httpClient, BasicCookieStore cookieStore, CloseableHttpResponse response, String beginStr, String endStr) throws ParseException, IOException {
        Map<String, String> responseStrAndCookies = Maps.newHashMap();
        if (StringUtils.isNotBlank(type)) {
            if (Constants.HTTP_GET_TYPE_ALL.equals(type) || Constants.HTTP_GET_TYPE_STRING.equals(type)) {
                String content = EntityUtils.toString(response.getEntity(), Consts.UTF_8);
                if (StringUtils.isNotBlank(beginStr)) {
                    content = StringUtils.substringAfter(content, beginStr);
                }
                if (StringUtils.isNotBlank(endStr)) {
                    content = content.substring(0, content.indexOf(endStr));
                }
                responseStrAndCookies.put(Constants.HTTP_GET_TYPE_STRING, content);
            }
            if (Constants.HTTP_GET_TYPE_ALL.equals(type) || Constants.HTTP_GET_TYPE_COOKIES.equals(type)) {
                //取出服务器返回的cookies信息，里面保存了服务器端给的“临时证”
                List<Cookie> cookies = cookieStore.getCookies();
                String tmpcookies = "";
                for (Cookie c : cookies) {
                    tmpcookies = tmpcookies + c.getName() + "=" + c.getValue() + "; ";
                }
                responseStrAndCookies.put(Constants.HTTP_GET_TYPE_COOKIES, tmpcookies);
            }
        }
        return responseStrAndCookies;
    }

    public static String getResponseInfoByGet(String url) {
        return getResponseInfoByGet(Constants.HTTP_GET_TYPE_STRING, url);
    }

    //-----------------get方式根据请求类型无代理获取网页信息或者Cookies---------------------
    public static String getResponseInfoByGet(String type, String url) {
        return getResponseInfoByGet(type, url, null);
    }

    public static String getResponseInfoByGet(String type, String url, Map<String, String> requestHeader) {
        return getResponseInfoByGet(type, url, requestHeader, null, null);
    }

    public static String getResponseInfoByGet(String type, String url, Map<String, String> requestHeader, String beginStr, String endStr) {
        Map<String, String> responseStrAndCookies = getResponseStrAndCookiesByGet(type, url, null, 0, requestHeader, beginStr, endStr);
        return responseStrAndCookies.get(type);
    }

    //-----------------get方式根据请求类型通过代理获取网页信息或者Cookies---------------------
    public static String getResponseInfoByGet(String type, String url, String proxyIp, int proxyPort) {
        return getResponseInfoByGet(type, url, proxyIp, proxyPort, null);
    }

    public static String getResponseInfoByGet(String type, String url, String proxyIp, int proxyPort, Map<String, String> requestHeader) {
        return getResponseInfoByGet(type, url, proxyIp, proxyPort, requestHeader, null, null);
    }

    public static String getResponseInfoByGet(String type, String url, String proxyIp, int proxyPort, Map<String, String> requestHeader, String beginStr, String endStr) {
        Map<String, String> responseStrAndCookies = getResponseStrAndCookiesByGet(type, url, proxyIp, proxyPort, requestHeader, beginStr, endStr);
        return responseStrAndCookies.get(type);
    }

    //-----------------get方式无代理获取网页信息以及Cookies---------------------
    public static Map<String, String> getResponseStrAndCookiesByGet(String url) {
        return getResponseStrAndCookiesByGet(url, null);
    }

    public static Map<String, String> getResponseStrAndCookiesByGet(String url, Map<String, String> requestHeader) {
        return getResponseStrAndCookiesByGet(url, requestHeader, null, null);
    }

    public static Map<String, String> getResponseStrAndCookiesByGet(String url, Map<String, String> requestHeader, String beginStr, String endStr) {
        return getResponseStrAndCookiesByGet(Constants.HTTP_GET_TYPE_ALL, url, null, 0, requestHeader, beginStr, endStr);
    }

    //-----------------get方式通过代理获取网页信息以及Cookies---------------------
    public static Map<String, String> getResponseStrAndCookiesByGet(String url, String proxyIp, int proxyPort) {
        return getResponseStrAndCookiesByGet(url, proxyIp, proxyPort, null);
    }

    public static Map<String, String> getResponseStrAndCookiesByGet(String url, String proxyIp, int proxyPort, Map<String, String> requestHeader) {
        return getResponseStrAndCookiesByGet(Constants.HTTP_GET_TYPE_ALL, url, proxyIp, proxyPort, requestHeader, null, null);
    }

    public static Map<String, String> getResponseStrAndCookiesByGet(String type, String url, String proxyIp, int proxyPort, Map<String, String> requestHeader, String beginStr, String endStr) {
        Map<String, String> responseStrAndCookies = Maps.newHashMap();
        try {
            responseStrAndCookies = getResponseByGet(type, url, proxyIp, proxyPort, requestHeader, beginStr, endStr);
        } catch (Exception e) {
        }
        return responseStrAndCookies;
    }

    private static Map<String, String> getResponseByGet(String type, String url, String proxyIp, int proxyPort, Map<String, String> requestHeader, String beginStr, String endStr) throws Exception {
        Map<String, String> responseStrAndCookies = Maps.newHashMap();
        BasicCookieStore cookieStore = setBasicCookieStore(requestHeader);
        CloseableHttpClient httpClient = setHttpClient(cookieStore, proxyIp, proxyPort);
        HttpGet httpget = setHttpGet(url);
        if (requestHeader != null && requestHeader.size() > 0) {
            for (Entry<String, String> entry : requestHeader.entrySet()) {
                httpget.setHeader(entry.getKey(), entry.getValue());
            }
        }
        CloseableHttpResponse response = httpClient.execute(httpget);
        responseStrAndCookies = getHttpResponseMap(type, httpClient, cookieStore, response, beginStr, endStr);
        return responseStrAndCookies;
    }

    public static String getResponseInfoByPost(String url, List<NameValuePair> params) {
        return getResponseInfoByPost(Constants.HTTP_GET_TYPE_STRING, url, params);
    }

    //-----------------post方式根据请求类型无代理获取网页信息或者Cookies---------------------
    public static String getResponseInfoByPost(String type, String url, List<NameValuePair> params) {
        return getResponseInfoByPost(type, url, params, null);
    }

    public static String getResponseInfoByPost(String type, String url, List<NameValuePair> params, Map<String, String> requestHeader) {
        return getResponseInfoByPost(type, url, params, requestHeader, null, null);
    }

    public static String getResponseInfoByPost(String type, String url, List<NameValuePair> params, Map<String, String> requestHeader, String beginStr, String endStr) {
        Map<String, String> responseStrAndCookies = getResponseStrAndCookiesByPost(type, url, null, 0, params, null, requestHeader, beginStr, endStr);
        return responseStrAndCookies.get(type);
    }

    public static String getResponseInfoByPost(String type, String url, String stringEntity) {
        return getResponseInfoByPost(type, url, stringEntity, null);
    }

    public static String getResponseInfoByPost(String type, String url, String stringEntity, Map<String, String> requestHeader) {
        return getResponseInfoByPost(type, url, stringEntity, requestHeader, null, null);
    }

    public static String getResponseInfoByPost(String type, String url, String stringEntity, Map<String, String> requestHeader, String beginStr, String endStr) {
        Map<String, String> responseStrAndCookies = getResponseStrAndCookiesByPost(type, url, null, 0, null, stringEntity, requestHeader, beginStr, endStr);
        return responseStrAndCookies.get(type);
    }

    //-----------------post方式根据请求类型通过代理获取网页信息或者Cookies---------------------
    public static String getResponseInfoByPost(String type, String url, String proxyIp, int proxyPort, List<NameValuePair> params) {
        return getResponseInfoByPost(type, url, proxyIp, proxyPort, params, null);
    }

    public static String getResponseInfoByPost(String type, String url, String proxyIp, int proxyPort, List<NameValuePair> params, Map<String, String> requestHeader) {
        return getResponseInfoByPost(type, url, proxyIp, proxyPort, params, requestHeader, null, null);
    }

    public static String getResponseInfoByPost(String type, String url, String proxyIp, int proxyPort, List<NameValuePair> params, Map<String, String> requestHeader, String beginStr, String endStr) {
        Map<String, String> responseStrAndCookies = getResponseStrAndCookiesByPost(type, url, proxyIp, proxyPort, params, null, requestHeader, beginStr, endStr);
        return responseStrAndCookies.get(type);
    }

    public static String getResponseInfoByPost(String type, String url, String proxyIp, int proxyPort, String stringEntity) {
        return getResponseInfoByPost(type, url, proxyIp, proxyPort, stringEntity, null);
    }

    public static String getResponseInfoByPost(String type, String url, String proxyIp, int proxyPort, String stringEntity, Map<String, String> requestHeader) {
        return getResponseInfoByPost(type, url, proxyIp, proxyPort, stringEntity, requestHeader, null, null);
    }

    public static String getResponseInfoByPost(String type, String url, String proxyIp, int proxyPort, String stringEntity, Map<String, String> requestHeader, String beginStr, String endStr) {
        Map<String, String> responseStrAndCookies = getResponseStrAndCookiesByPost(type, url, proxyIp, proxyPort, null, stringEntity, requestHeader, beginStr, endStr);
        return responseStrAndCookies.get(type);
    }

    //-----------------post方式无代理获取网页信息以及Cookies---------------------
    public static Map<String, String> getResponseStrAndCookiesByPost(String url, List<NameValuePair> params) {
        return getResponseStrAndCookiesByPost(url, params, null);
    }

    public static Map<String, String> getResponseStrAndCookiesByPost(String url, List<NameValuePair> params, Map<String, String> requestHeader) {
        return getResponseStrAndCookiesByPost(url, params, requestHeader, null, null);
    }

    public static Map<String, String> getResponseStrAndCookiesByPost(String url, List<NameValuePair> params, Map<String, String> requestHeader, String beginStr, String endStr) {
        return getResponseStrAndCookiesByPost(Constants.HTTP_GET_TYPE_ALL, url, null, 0, params, null, requestHeader, beginStr, endStr);
    }

    public static Map<String, String> getResponseStrAndCookiesByPost(String url, String stringEntity) {
        return getResponseStrAndCookiesByPost(url, stringEntity, null);
    }

    public static Map<String, String> getResponseStrAndCookiesByPost(String url, String stringEntity, Map<String, String> requestHeader) {
        return getResponseStrAndCookiesByPost(url, stringEntity, requestHeader, null, null);
    }

    public static Map<String, String> getResponseStrAndCookiesByPost(String url, String stringEntity, Map<String, String> requestHeader, String beginStr, String endStr) {
        return getResponseStrAndCookiesByPost(Constants.HTTP_GET_TYPE_ALL, url, null, 0, null, stringEntity, requestHeader, beginStr, endStr);
    }

    //-----------------post方式通过代理获取网页信息以及Cookies---------------------
    public static Map<String, String> getResponseStrAndCookiesByPost(String url, String proxyIp, int proxyPort, List<NameValuePair> params) {
        return getResponseStrAndCookiesByPost(url, proxyIp, proxyPort, params, null);
    }

    public static Map<String, String> getResponseStrAndCookiesByPost(String url, String proxyIp, int proxyPort, List<NameValuePair> params, Map<String, String> requestHeader) {
        return getResponseStrAndCookiesByPost(url, proxyIp, proxyPort, params, requestHeader, null, null);
    }

    public static Map<String, String> getResponseStrAndCookiesByPost(String url, String proxyIp, int proxyPort, List<NameValuePair> params, Map<String, String> requestHeader, String beginStr, String endStr) {
        return getResponseStrAndCookiesByPost(Constants.HTTP_GET_TYPE_ALL, url, proxyIp, proxyPort, params, null, requestHeader, beginStr, endStr);
    }

    public static Map<String, String> getResponseStrAndCookiesByPost(String url, String proxyIp, int proxyPort, String stringEntity) {
        return getResponseStrAndCookiesByPost(url, proxyIp, proxyPort, stringEntity, null);
    }

    public static Map<String, String> getResponseStrAndCookiesByPost(String url, String proxyIp, int proxyPort, String stringEntity, Map<String, String> requestHeader) {
        return getResponseStrAndCookiesByPost(url, proxyIp, proxyPort, stringEntity, requestHeader, null, null);
    }

    public static Map<String, String> getResponseStrAndCookiesByPost(String url, String proxyIp, int proxyPort, String stringEntity, Map<String, String> requestHeader, String beginStr, String endStr) {
        return getResponseStrAndCookiesByPost(Constants.HTTP_GET_TYPE_ALL, url, proxyIp, proxyPort, null, stringEntity, requestHeader, beginStr, endStr);
    }

    public static Map<String, String> getResponseStrAndCookiesByPost(String type, String url, String proxyIp, int proxyPort, List<NameValuePair> params
            , String stringEntity, Map<String, String> requestHeader, String beginStr, String endStr) {
        Map<String, String> responseStrAndCookies = Maps.newHashMap();
        try {
            responseStrAndCookies = getResponseByPost(type, url, proxyIp, proxyPort, params, stringEntity, requestHeader, beginStr, endStr);
        } catch (Exception e) {
        }
        return responseStrAndCookies;
    }

    @SuppressWarnings("unused")
    private static Map<String, String> getResponseByPost(String type, String url, String proxyIp, int proxyPort, List<NameValuePair> params, String stringEntity, Map<String, String> requestHeader, String beginStr, String endStr) throws Exception {
        Map<String, String> responseStrAndCookies = Maps.newHashMap();
        BasicCookieStore cookieStore = setBasicCookieStore(requestHeader);
        CloseableHttpClient httpClient = setHttpClient(cookieStore, proxyIp, proxyPort);
        try {
            HttpPost httpPost = setHttpPost(url);
            if (requestHeader != null && requestHeader.size() > 0) {
                for (Entry<String, String> entry : requestHeader.entrySet()) {
                    httpPost.setHeader(entry.getKey(), entry.getValue());
                }
            }
            if (params != null) {
                httpPost.setEntity(new UrlEncodedFormEntity(params, Consts.UTF_8));
            } else if (StringUtils.isNotBlank(stringEntity)) {
                httpPost.setEntity(new StringEntity(stringEntity, Consts.UTF_8));
            }
            CloseableHttpResponse response = httpClient.execute(httpPost);
            responseStrAndCookies = getHttpResponseMap(type, httpClient, cookieStore, response, beginStr, endStr);
        } catch (SocketTimeoutException | ConnectTimeoutException | ConnectException e) {
            logger.info("post方式获取网页:" + url + "信息超时,代理:" + proxyIp + " " + proxyPort, e);
        } catch (Exception e) {
            logger.error("post方式获取网页:" + url + "信息异常", e);
        } finally {
            try {
                //关闭连接
                httpClient.close();
            } catch (IOException e) {
                logger.error("关闭连接 失败", e);
            }
        }
        return responseStrAndCookies;
    }

    /**
     * Soap请求
     *
     * @param url
     * @param soapRequestData
     * @param requestHeader
     * @return
     */
    public static String getWebserviceResponseStrByPost(String url, String soapRequestData, Map<String, String> requestHeader) {
        String result = "";
        BasicCookieStore cookieStore = setBasicCookieStore(requestHeader);
        CloseableHttpClient httpClient = setHttpClient(cookieStore, null, 0);
        try {
            HttpPost httpPost = setHttpPost(url);
            if (requestHeader != null && requestHeader.size() > 0) {
                for (Entry<String, String> entry : requestHeader.entrySet()) {
                    httpPost.setHeader(entry.getKey(), entry.getValue());
                }
            }
            /*把Soap请求数据添加到PostMethod*/
            byte[] b = soapRequestData.getBytes(Consts.UTF_8);
            InputStream is = new ByteArrayInputStream(b, 0, b.length);
            InputStreamEntity requestEntity = new InputStreamEntity(is, b.length);
            httpPost.setEntity(requestEntity);
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity);
        } catch (Exception e) {
            logger.error("getSoapWebserviceResponseStrByPost获取网页:" + url + "信息失败,参数:" + soapRequestData, e);
        } finally {
            try {
                //关闭连接
                httpClient.close();
            } catch (IOException e) {
                logger.error("关闭连接 失败", e);
            }
        }
        return result;
    }

}
