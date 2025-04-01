package configutil;

public class Config {

    private String api_key;

    public Config() {
        this.api_key = "";
    }

    public Config(String api_key) {
        this.api_key = api_key;
    }
    public String getApiKey() {
        return api_key;
    }

    public void setApi_key(String api_key) {
        this.api_key = api_key;
    }

}
