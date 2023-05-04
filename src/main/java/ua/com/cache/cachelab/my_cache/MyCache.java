package ua.com.cache.cachelab.my_cache;


public interface MyCache <K,V>{
    V getCache(K key);
    V putCache(K key, V value);
}