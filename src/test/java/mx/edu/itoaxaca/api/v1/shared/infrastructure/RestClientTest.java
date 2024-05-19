package mx.edu.itoaxaca.api.v1.shared.infrastructure;

import mx.edu.itoaxaca.api.v1.shared.JsonParse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import lombok.Getter;

public class RestClientTest<T> {

    @MockBean
    @Getter
    private T repo;

    @Autowired
    private MockMvc client;

    public ResultActions get(String url) throws Exception {
        return this.client.perform(
                MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON)
            );
    }

    public <Request> ResultActions post(String url, Request request) throws Exception {
        String body = JsonParse.toJson(request); 
        return this.client.perform(
                MockMvcRequestBuilders.post(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(body)
            );
    }
    
    public <Request> ResultActions put(String url, Request request) throws Exception {
        String body = JsonParse.toJson(request); 
        return this.client.perform(
                MockMvcRequestBuilders.put(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(body)
            );
    }

    public <Request> ResultActions delete(String url) throws Exception {
        return this.client.perform(
                MockMvcRequestBuilders.delete(url)
                    .contentType(MediaType.APPLICATION_JSON)
            );
    }
}
