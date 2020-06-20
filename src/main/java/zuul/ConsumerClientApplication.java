package zuul;

import fallbackProvider.ServiceFallbackProvider;
import filter.ServiceFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@RefreshScope
public class ConsumerClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerClientApplication.class, args);
    }

    @Bean
    public ServiceFilter serviceFilter() {
        return new ServiceFilter();
    }

    @Bean
    public ServiceFallbackProvider serviceFallbackProvider() {
        return new ServiceFallbackProvider();
    }

}
