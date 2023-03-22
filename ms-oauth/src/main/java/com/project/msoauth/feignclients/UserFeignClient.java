package com.project.msoauth.feignclients;

import com.project.msoauth.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@Component
@FeignClient(name = "ms-user", path = "/users")
public interface UserFeignClient {

    @GetMapping(value = "/search")
    @ResponseStatus(HttpStatus.OK)
    User findUserByEmail(@RequestParam String email);

}
