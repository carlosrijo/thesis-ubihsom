package micro.entity;

import io.vertx.core.json.JsonObject;
import micro.utils.UrlBuilder;

public class DataStreamChannel {

    private String inputUrl;
    private String outputUrl;

    public DataStreamChannel(String baseUrl){
        this.inputUrl = UrlBuilder.createInUrl(baseUrl);
        this.outputUrl = UrlBuilder.createOutUrl(baseUrl);
    }

    public DataStreamChannel(JsonObject o){
        this.inputUrl = o.getString("in");
        this.outputUrl = o.getString("out");
    }

    public String in() {
        return inputUrl;
    }

    public String out() {
        return outputUrl;
    }

    public JsonObject toJson(){
        return new JsonObject()
                .put("in", this.inputUrl)
                .put("out", this.outputUrl);
    }

    @Override
    public String toString() {
        return this.toJson().encode();
    }
}
