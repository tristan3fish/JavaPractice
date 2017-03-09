import static org.junit.Assert.*;
import java.util.Date;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import com.tristan3fish.revision.Answer;
import com.tristan3fish.revision.repository.HibernateWorkRepository;

public class HibernateWorkRepositoryTest {
	
	private HibernateWorkRepository hwr;
	private Random rand;
	
    @Before
    public void initialize() {
    	System.out.println("initialising work repository for test");
    	hwr = new HibernateWorkRepository();
    	rand = new Random(System.currentTimeMillis());
	}
   
	@Test
	public void canSaveAnswer() {
		Answer a = new Answer(new Date(), 0, false, rand.nextInt());
		hwr.saveAnswer(a);
	}
    
	@Test
	public void canGetAnswers() {
		//shove in an answer just to ensure the second step does not return empty
		hwr.saveAnswer(new Answer(new Date(), 0, false, rand.nextInt()));

		assertFalse(hwr.getAnswers().isEmpty());
	}
	
	@Test
	public void canSaveAndRetreiveAnswer() {
		Answer a = new Answer(new Date(), 0, false, rand.nextInt());
		hwr.saveAnswer(a);

		assertTrue(hwr.containsAnswer(a));
	}
}