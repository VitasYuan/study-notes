clientIP = ngx.req.get_headers()["X-Real-IP"]
if clientIP == nil then
    clientIP = ngx.req.get_headers()["x_forwarded_for"]
end
if clientIP == nil then
    clientIP = ngx.var.remote_addr
end
    local memcached = require "resty.memcached"
    local memc, err = memcached:new()
    if not memc then
        ngx.say("failed to instantiate memc: ", err)
        return
    end
    local ok, err = memc:connect("127.0.0.1", 11211)
    if not ok then
        ngx.say("failed to connect: ", err)
        return
    end
    local res, flags, err = memc:get(clientIP)
    ngx.say("value key: ",res,clientIP)
    if err then
        ngx.say("failed to get clientIP ", err)
        return
    end
    if  res == "1" then
        ngx.exec("@server_test")
        return
    end
    ngx.exec("@server")