package ar.edu.unq.circuito;

import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
//@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CircuitoDelUnderBackendApplicationTests {
    
    @Autowired
    protected EntityManager em;
    
}