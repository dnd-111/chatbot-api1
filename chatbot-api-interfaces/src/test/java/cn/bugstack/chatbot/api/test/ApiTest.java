package cn.bugstack.chatbot.api.test;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author 小傅哥，微信：fustack
 * @description 单元测试
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class ApiTest {

   @Test
    public void  queery_unanswered_questions() throws IOException {
       CloseableHttpClient client = HttpClientBuilder.create().build();
       HttpGet httpGet = new HttpGet("https://api.zsxq.com/v2/groups/48885122815818/topics?scope=all&count=1");
       httpGet.addHeader("cookie","_c_WBKFRo=dDMYoUIYgcq3EA3R4SokVTGvl4LEWu43QZUqEdW6; _nb_ioWEgULi=; abtest_env=product; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22412815824224228%22%2C%22first_id%22%3A%2219e1fbef4fbcd4-0cd3e4bfe089188-4c657b58-1327104-19e1fbef4fc1095%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%A4%BE%E4%BA%A4%E7%BD%91%E7%AB%99%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC%22%2C%22%24latest_referrer%22%3A%22https%3A%2F%2Fopen.weixin.qq.com%2F%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTllMWZiZWY0ZmJjZDQtMGNkM2U0YmZlMDg5MTg4LTRjNjU3YjU4LTEzMjcxMDQtMTllMWZiZWY0ZmMxMDk1IiwiJGlkZW50aXR5X2xvZ2luX2lkIjoiNDEyODE1ODI0MjI0MjI4In0%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22412815824224228%22%7D%2C%22%24device_id%22%3A%2219e1fbef4fbcd4-0cd3e4bfe089188-4c657b58-1327104-19e1fbef4fc1095%22%7D; zsxq_access_token=793E0D71-8F0B-43E1-99AF-E5D24F874B50_8E9AF26977CD7AD1");

       httpGet.addHeader("Content-Type", "application/json;charset=utf8");
       CloseableHttpResponse response = client.execute(httpGet);
       if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
           String result = EntityUtils.toString(response.getEntity());
           System.out.println(result);

       }
       else {
           System.out.println(response.getStatusLine().getStatusCode());
       }
   }
@Test
   public void  answer_question() throws IOException {
         CloseableHttpClient client = HttpClientBuilder.create().build();
         HttpPost Post = new HttpPost("https://api.zsxq.com/v2/topics/45544825128851118/answer");
    Post.addHeader("cookie","_c_WBKFRo=dDMYoUIYgcq3EA3R4SokVTGvl4LEWu43QZUqEdW6; _nb_ioWEgULi=; abtest_env=product; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22412815824224228%22%2C%22first_id%22%3A%2219e1fbef4fbcd4-0cd3e4bfe089188-4c657b58-1327104-19e1fbef4fc1095%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%A4%BE%E4%BA%A4%E7%BD%91%E7%AB%99%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC%22%2C%22%24latest_referrer%22%3A%22https%3A%2F%2Fopen.weixin.qq.com%2F%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTllMWZiZWY0ZmJjZDQtMGNkM2U0YmZlMDg5MTg4LTRjNjU3YjU4LTEzMjcxMDQtMTllMWZiZWY0ZmMxMDk1IiwiJGlkZW50aXR5X2xvZ2luX2lkIjoiNDEyODE1ODI0MjI0MjI4In0%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22412815824224228%22%7D%2C%22%24device_id%22%3A%2219e1fbef4fbcd4-0cd3e4bfe089188-4c657b58-1327104-19e1fbef4fc1095%22%7D; zsxq_access_token=793E0D71-8F0B-43E1-99AF-E5D24F874B50_8E9AF26977CD7AD1");
       Post.addHeader("Content-Type", "application/json;charset=utf8");
       String paramjson = "{\"req_data\": {\"text\": \"我YE不会\\n\", \"image_ids\": [], \"mentioned_user_ids\": []}}";
   StringEntity entity = new StringEntity(paramjson, ContentType.create("text/json", StandardCharsets.UTF_8));
      Post.setEntity(entity);
       CloseableHttpResponse execute = client.execute(Post);
       if (execute.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
           String result = EntityUtils.toString(execute.getEntity());
           System.out.println(result);

       }
       else {
           System.out.println(execute.getStatusLine().getStatusCode());
       }
   }

}
