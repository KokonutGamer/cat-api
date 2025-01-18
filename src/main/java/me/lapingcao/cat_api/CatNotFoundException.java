package me.lapingcao.cat_api;

public class CatNotFoundException extends RuntimeException {
    public CatNotFoundException(Long id) { super("Could not find cat with id " + id); }
}