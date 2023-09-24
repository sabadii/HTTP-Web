import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Request {
    final String requestLine;
    public Request(String requestLine){
        this.requestLine = requestLine;
    }

    public String getQueryParam(String name){
        List<NameValuePair> params = URLEncodedUtils.parse(URI.create(requestLine), "UTF-8");
        for (NameValuePair param: params){
            if (param.getName().equals(name)){
                return param.getValue();
            }
        }
        return null;
    }
    public Map<String, String> getQueryParams(){
        List<NameValuePair> params = URLEncodedUtils.parse(URI.create(requestLine), "UTF-8");
        Map<String, String> queryParams = new HashMap<>();
        for (NameValuePair param : params){
            queryParams.put(param.getName(), param.getValue());
        }
        return queryParams;
    }
}
