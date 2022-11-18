package br.com.texo.leituralista.config;

public class GreetingConfig {

    private final long id;
    private final String content;

    public GreetingConfig(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
