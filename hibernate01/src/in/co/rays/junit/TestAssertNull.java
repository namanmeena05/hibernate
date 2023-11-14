package in.co.rays.junit;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Test;

import junit.framework.TestCase;

public class TestAssertNull extends TestCase {

	@Test
	public void testFindByPk() throws Exception {

		UserDTO bean = UserModel.findByPk(8);

		// assertNull("user is null", bean);
		assertTrue(bean == null);

	}
}