package database;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;
import org.junit.Test;

public class DatabaseRepositoryTest {
	private final String driver = "org.apache.derby.jdbc.EmbeddedDriver";
	private final String protocol = "jdbc:derby:";
	private final String dbName = "shopdb";
	
	private IDatabaseTester databaseTester;
	@Before
	public void setUp() throws Exception {
		databaseTester = new JdbcDatabaseTester(driver, protocol+dbName);
		
		try {
			IDataSet dataSet = new FlatXmlDataSetBuilder().build
					(new File("src/dataSetTest.xml"));
			DatabaseOperation.CLEAN_INSERT.
			execute(databaseTester.getConnection(),dataSet);
		} finally {
			databaseTester.getConnection().close();
		}
	}
	@Test
	public void testFindById() throws Exception {
		Seller expectedSeller = new Seller("horichoi","최승호","megaseller@hatmail.com");
		
		Repository repository = new DatabaseRepository();
		Seller actualSeller = repository.findById("buymore");
		System.out.println(actualSeller.getEmail());
		assertEquals(expectedSeller.getId(), actualSeller.getId());
		assertEquals(expectedSeller.getName(), actualSeller.getName());
		assertEquals(expectedSeller.getEmail(), actualSeller.getEmail());
	}
}
