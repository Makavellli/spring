package com.shady.community.provider;

import com.alibaba.fastjson.JSON;
import com.shady.community.dto.AccessTokenDto;
import com.shady.community.dto.GitHubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GitHubProvider {
    public  String getAccessToken(AccessTokenDto accessTokenDto){
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDto));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String responseString = response.body().string();
            System.out.print("获取到的返回字符串是："+responseString+"\n");
            String token = responseString.split("&")[0].split("=")[1];
            System.out.print("解析获取的Token是："+token+"\n");
            return token;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public GitHubUser getGitHubUser(String accessToken){
        OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("https://api.github.com/user")
                    .header("Authorization","token "+accessToken)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                String responseString = response.body().string();
                GitHubUser gitHubUser = JSON.parseObject(responseString, GitHubUser.class);
                System.out.print("获取的UserName是："+gitHubUser.getName()+"\n");
                return  gitHubUser;
            } catch (IOException e) {
            }
        return null;
    }
}

