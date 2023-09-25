import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Request {
    final String requestLine;
    final Map<String, String> queryParams;

    public Request(String requestLine) {
        this.requestLine = requestLine;
        this.queryParams = parseQueryParams();
    }

    public String getQueryParam(String name) {
        return queryParams.get(name);
    }

    public Map<String, String> getQueryParams() {
        return queryParams;
    }

    private Map<String, String> parseQueryParams() {
        List<NameValuePair> params = URLEncodedUtils.parse(URI.create(requestLine), "UTF-8");
        Map<String, String> queryParams = new HashMap<>();
        for (NameValuePair param : params) {
            queryParams.put(param.getName(), param.getValue());
        }
        return queryParams;
    }
}
