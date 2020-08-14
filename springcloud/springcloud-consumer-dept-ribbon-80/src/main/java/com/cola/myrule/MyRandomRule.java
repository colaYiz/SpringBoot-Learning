package com.cola.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MyRandomRule extends AbstractLoadBalancerRule {

    public MyRandomRule() {
    }

    // 每个服务，访问5次~，换下一个服务（3个）

    // total=0, 默认=0，如果=5，我们指向下一个服务节点
    // index=0，默认0，如果total=5，index+1，

//    @SuppressWarnings({"RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE"})

    private int total = 0;  //被调用的次数
    private int currentIndex = 0;   //当前是谁在提供服务

    //ILoadBalancer选择的随机算法
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        } else {
            Server server = null;

            while(server == null) {
                //查看线程是否中断
                if (Thread.interrupted()) {
                    return null;
                }

                List<Server> upList = lb.getReachableServers();//获取活着的服务
                List<Server> allList = lb.getAllServers();  //获取所有服务
                int serverCount = allList.size();
                if (serverCount == 0) {
                    return null;
                }

//                int index = this.chooseRandomInt(serverCount);  //生成区间随机数
//                server = (Server)upList.get(index); //从活着的服务中取出随机数对应的服务

                if(total < 5){
                    server = upList.get(currentIndex);
                    total++;
                }else {
                    total = 0;
                    currentIndex++;
                    if(currentIndex>=upList.size()){
                        currentIndex=0;
                    }
                    server = upList.get(currentIndex);  //从活着的服务中，获取指定的服务来进行操作
                }

                if (server == null) {
                    Thread.yield();
                } else {
                    if (server.isAlive()) {
                        return server;
                    }

                    server = null;
                    Thread.yield();
                }

            }

            return server;
        }
    }

    //随机
    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }

    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }
}
