package edu.xalead;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("consumer")
public class ConsumerController {
    @Resource
    private RestTemplate restTemplate;
    @RequestMapping("{id}")
    public User findUserByID(@PathVariable("id") Integer id){
        return restTemplate.getForObject(url,User.class);
    }
}
