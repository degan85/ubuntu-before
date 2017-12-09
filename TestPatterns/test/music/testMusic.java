package music;

import static org.junit.Assert.*;

import org.junit.Test;

public class testMusic {
	
	@Test
	public void testEquals_case1() throws Exception {
		Music musicA = new Music("Better in time", "Leona Lewis");
		Music musicB = musicA;
		
		assertEquals(musicA, musicB);
	}
	
	@Test
	public void testEquals_case2() throws Exception {
		Music musicA = new Music("Better in time", "Leona Lewis");
		Music musicB = new Music("Better in time", "Leona Lewis");
		
		assertEquals(musicA, musicB);
	}
	
	
}
