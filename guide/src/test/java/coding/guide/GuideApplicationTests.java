package coding.guide;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
class GuideApplicationTests {

	@Autowired
	private DataSource dataSource;

	@Test
	@Transactional
	public void connectionTest() {
		try (Connection connection = dataSource.getConnection()) {
			log.info("Lets Do It");
		} catch (Exception e) {
			log.info("Your Connection Is Not Ok");
		}
	}
}
