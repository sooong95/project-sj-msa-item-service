package song.sj.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "sj-shop-service")
public interface ShopServiceFeign {


}
