package com.gghenshin2;

public class SimpleMovieLister {

    private MovieFinder movieFinder;

    private String movieName;

    public void setMovieFinder(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }

    public void setMovieName(String movieName){
        this.movieName = movieName;
    }

    // 省略了实际使用注入的 MovieFinder 的业务逻辑...
}
