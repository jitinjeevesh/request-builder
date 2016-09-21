import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import java.util.Map;

public class RequestBuilderDTO {
    private HttpHeaders httpHeaders = ApiRequestUtil.getHttpHeaders();
    private HttpMethod httpMethod = HttpMethod.GET;
    private Map<String, Object> requestBody = ApiRequestUtil.getRequestBody();
    private String url;

    public HttpHeaders getHttpHeaders() {
        return httpHeaders;
    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public Map<String, Object> getRequestBody() {
        return requestBody;
    }

    public String getUrl() {
        return url;
    }

    public void setHttpHeaders(HttpHeaders httpHeaders) {
        this.httpHeaders = httpHeaders;
    }

    public void setHttpMethod(HttpMethod httpMethod) {
        this.httpMethod = httpMethod;
    }

    public void setRequestBody(Map<String, Object> requestBody) {
        this.requestBody = requestBody;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
