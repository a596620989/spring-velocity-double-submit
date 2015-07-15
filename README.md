##启动 eclipse debug-as -> mvn -> jetty:run

1. http://127.0.0.1:8080/demo?path=ajax-post-multi
2. http://127.0.0.1:8080/demo?path=ajax-get
3. http://127.0.0.1:8080/demo?path=ajax-post-single
4. http://127.0.0.1:8080/demo?path=form-multi-form
5. http://127.0.0.1:8080/demo?path=form-multipart

##重复提交检测机制

计算两次相同请求的间隔.
每次请求会sleep 1秒, 如果我们检测到两次相同请求的间隔时间小于1秒, 则判定为重复提交.
同时打开两个相同的窗口并提交请求不在考虑范围内.
请不要在一秒内快速刷新页面多次, 不然会误报.

如果检测到重复提交, 会在控制台看到如下的信息:
logger.error("detect double submit" + servletPath);
 
