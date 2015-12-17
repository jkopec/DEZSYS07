package at.ernhofer.kopec.dezsys07;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import at.ernhofer.kopec.dezsys07.Dezsys07Application;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Dezsys07Application.class)
@WebAppConfiguration
public class Dezsys07ApplicationTests {

	@Test
	public void contextLoads() {
	}

}
