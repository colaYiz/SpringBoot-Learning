package com.cola.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    //注入RestTemplate组件
    //IRule
    //RoundRobinRule    轮询，默认算法
    //RandomRule    随机
    //AvailabilityFilteringRule 会先过滤掉，跳闸、访问故障的服务，还有并发的连接数量超过阈值的服务，对剩下的进行轮询
    //WeightedResponseTimeRule  根据平均响应时间计算所有服务的权重，响应时间越快的服务权重越大，被选中的概率越高，刚启动时如果统计信息不足则使用RoundRobinRule策略，等待统计信息足够会切换到WeightedResponseTimeRule
    //RetryRule 会先按照轮询获取服务，如果获取失败，则会在指定时间内重试
    //BestAvailableRule //会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，然后选择一个并发量最小的服务
    //ZoneAvoidanceRule //默认规则，复合判断server所在区域的性能和server的可用性选择服务器
    @Bean
    @LoadBalanced   //springcloud ribbon是基于netflix ribbon实现的一套客户端负载均衡工具
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

//    @Bean
//    public IRule myRandomRule(){
//        //使用重新选择的随机算法替代默认的轮询
//        return new RandomRule();
//    }

//    @Bean
//    public IRule myRetryRule(){
//        return new RetryRule();
//    }
}
