package org.seekay.kv.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.seekay.kv.client.model.Pair;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class KvClient {

    private String path;

    private ObjectMapper objectMapper = new ObjectMapper();

    private CloseableHttpClient httpclient = HttpClients.createDefault();

    public KvClient(String path) {
        this.path = path + "/kv";
    }

    public Pair create(Pair pair) {
        Pair createdPair = null;
        try {
            String payload  = objectMapper.writeValueAsString(pair);
            String url = path + "/pair";
            HttpPost post = new HttpPost(url);
            post.addHeader("Content-Type","application/json");
            post.setEntity(new StringEntity(payload));
			addMandatoryHeader(post);
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
            addMandatoryHeader(get);
            HttpResponse response = httpclient.execute(get);
            String responseBody = EntityUtils.toString(response.getEntity());
            System.out.println("Response received : " );
            return objectMapper.readValue(responseBody.getBytes(), Pair.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return readPair;
	}

    public Pair update(Pair pair) {
        Pair createdPair = null;
        try {
            String payload  = objectMapper.writeValueAsString(pair);
            String url = path + "/pair";
            HttpPut put = new HttpPut(url);
            put.addHeader("Content-Type", "application/json");
            put.setEntity(new StringEntity(payload));
			addMandatoryHeader(put);
            HttpResponse response = httpclient.execute(put);
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

    public boolean delete(String key) {
        try {
            String url = path + "/pair/" + key ;
            HttpDelete delete = new HttpDelete(url);
			addMandatoryHeader(delete);
            HttpResponse response = httpclient.execute(delete);
            return response.getStatusLine().getStatusCode() == 204;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public long requestTime() {
        long time = 0;
        try {
            String url = path + "/service/times";
            HttpGet get = new HttpGet(url);
			addMandatoryHeader(get);
            HttpResponse response = httpclient.execute(get);
            String responseBody = EntityUtils.toString(response.getEntity());
            return Long.valueOf(responseBody);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return time;
    }

    public List<Pair> search(String key) {
        List<Pair> results = null;
        try {
            String url = path + "/pair?key=" + key;
            HttpGet get = new HttpGet(url);
            HttpResponse response = httpclient.execute(get);
            addMandatoryHeader(get);
            String responseBody = EntityUtils.toString(response.getEntity());
            return objectMapper.readValue(responseBody.getBytes(), List.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return results;
    }

    private void addMandatoryHeader(HttpUriRequest request) {
        request.addHeader("source-app", "kvClient");
    }
}
