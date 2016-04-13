package org.seekay.kv.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class KvClient {

    private String path;

    private ObjectMapper objectMapper = new ObjectMapper();

    private CloseableHttpClient httpclient = HttpClients.createDefault();

    public KvClient(String path) {
        this.path = path;
    }

    public Pair create(Pair pair) {
        Pair createdPair = null;
        try {
            String payload  = objectMapper.writeValueAsString(pair);
            String url = path + "/pair";
            HttpPost post = new HttpPost(url);
            post.addHeader("Content-Type","application/json");
            post.setEntity(new StringEntity(payload));
            HttpResponse response = httpclient.execute(post);
            String responseBody = EntityUtils.toString(response.getEntity());
            return objectMapper.readValue(responseBody.getBytes(), Pair.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return createdPair;
    }

	public Pair read(String key) {
		Pair readPair = null;
		try {
			String url = path + "/pair/" + key;
			HttpGet get = new HttpGet(url);
			HttpResponse response = httpclient.execute(get);
			String responseBody = EntityUtils.toString(response.getEntity());
			return objectMapper.readValue(responseBody.getBytes(), Pair.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return readPair;
	}
}
