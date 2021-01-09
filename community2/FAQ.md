Question

* [@Autowired 和 @Resource的区别](https://blog.51cto.com/qiangmzsx/1359952)
* [@Component]()

* [Github API访问方式修改](更新官方推荐的使用access_token安全访问API的方式，用Authorization HTTP header代替query paramet，旧方式即将被废弃)
    
    Request request = new Request.Builder()
                    .url("https://api.github.com/user?access_token=" + accessToken)
                    .build();
    修改为
    Request request = new Request.Builder()
                    .url("https://api.github.com/user")
                    .header("Authorization","token "+accessToken)
                    .build();