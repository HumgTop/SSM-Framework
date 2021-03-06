package top.humg.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.humg.domain.Account;
import top.humg.service.AccountService;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AOPTest {
    @Autowired
    private AccountService service;

    @Test
    public void test1() {
        List<Account> all = service.findAll();
        for (Account account : all) {
            System.out.println(account);
        }
    }
}
