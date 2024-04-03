import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JUnit_Testing {
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws Exception {
		LibraryDatabase database = LibraryDatabase.getInstance();
		LibraryHomePage homePage = new LibraryHomePage();
		database.loadPhysItems(database.physItemsDB, null);
		database.loadDigItems(database.digItemsDB, null);
		database.loadCourses(database.coursesDB, null);
		database.loadAccounts();
		database.purgeFinishedCourses();
	}
}
